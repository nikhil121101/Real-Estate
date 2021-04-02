/*
Main program for the virtual memory project.
Make all of your modifications to this file.
You may add or rearrange any code or data as you need.
The header files page_table.h and disk.h explain
how to use the page table and disk interfaces.
*/

#include "page_table.h"
#include "disk.h"
#include "program.h"
#include "queue.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

struct disk* disk;

char* physmem;

char* virtmem;

int npages, nframes;

int replace_algo_code;

int page_faults = 0;
int writes = 0, reads = 0;

int* frame_table;

int* ref_bit;

Queue* page_queue;

int remove_page(struct page_table *pt, int rp) {
		int rf, rb; // frame and permisssion of replacing bit
		page_table_get_entry(pt, rp, &rf, &rb);
		if(rb & PROT_WRITE) {
			disk_write(disk, rp, physmem + rf * PAGE_SIZE);
			writes++;
		}
		page_table_set_entry(pt, rp, 0, 0); // restting the permission bits for replace frame
		return rf;
}

void addPage(struct page_table* pt, int page, int frame) {

	frame_table[frame] = page;
	disk_read(disk, page, physmem + frame * PAGE_SIZE);
	reads++;
	page_table_set_entry(pt, page, frame, PROT_READ|PROT_WRITE);

}

int getVictim() {
	int i = 0;
	while(1) {
		if(ref_bit[i] == 0) {
			return i;
		}
		else {
			ref_bit[i] = 0;
		}
		i = (i + 1) % nframes;
	}
}	

void resetReadBit(struct page_table* pt) {
	printf("resetting read bit\n");
	for(int i = 0 ; i < nframes ; i++) {
		int p = frame_table[i];
		int f, b; // frame and permisssion of replacing bit
		page_table_get_entry(pt, p, &f, &b);
		printf("before: b = %d, after: b = %d\n", b, b & (~PROT_READ));
		page_table_set_entry(pt, p, f, b & (~PROT_READ));	
	}
}

int getFrame(struct page_table* pt)  {
	int feeFrame = getFreeFrame();
	if(freeFrame != -1) {
		return freeFrame;
	}
	if(replace_algo_code == 0) {
		int rp = frame_table[lrand48() % nframes]; // page to be replaced
		int rf = remove_page(pt, rp);
		addPage(pt, rp, rf);
	}
	else if(replace_algo_code == 1){
		int rp = frame_table[dequeue(page_queue)];
		int rf = remove_page(pt, rp);	
		enqueue(page_queue, rf);
		addPage(pt, rp, rf);
	}
	else if(replace_algo_code == 2) {
		int victimFrame = getVictim();
		int victimPage = frame_table[victimFrame];
		remove_page(pt, victimPage);
		return frame;
	}
	return -1;
}

int get_free_frame() {
	for(int i = 0 ; i < nframes ; i++) {
		if(frame_table[i] == -1) {
			ref_bit[i] = 1;
			return i;
		}
	}
	return -1;
}


void printFrameTable() {
	for(int i = 0 ; i < nframes; i++) {
		printf("%d ", frame_table[i]);
	}
	printf("\n");
}

void page_fault_handler( struct page_table* pt, int page )
{
	//printQueue(page_queue);
	page_faults++;
	printf("demanded page: %d\n", page);
	int bit,frame;
	page_table_get_entry(pt, page, &frame, &bit);
	printf("frame: %d, bit: %d\n", frame, bit);
	if(bit == 0) {
		if(replace_algo_code == 2) {
			if(frame != 0 || (frame == 0 && page == frame_table[0])) {
				page_table_set_entry(pt, page, frame, bit | PROT_READ);	
				printFrameTable();
				return;
			}
		}
		int freeFrame = get_free_frame(pt, page);
		//printf("freeFrame: %d\n",  freeFrame);
		if(replace_algo_code == 2 && frame_table[nframes-1] != -1) {
			resetReadBit(pt);
		}
	}
	else {
		// we have to set write permission else
		page_table_set_entry(pt, page, frame, PROT_READ|PROT_WRITE);
	}
	printFrameTable();
}

int main( int argc, char *argv[])
{

	printf("PROT_READ: %d, PROT_WRITE: %d\n", PROT_READ, PROT_WRITE);

	if(argc!=5) {
		printf("use: virtmem <npages> <nframes> <rand|fifo|custom> <sort|scan|focus>\n");
		return 1;
	}
	npages = atoi(argv[1]);
	nframes = atoi(argv[2]);
	const char *program = argv[4];
	char replace_algo[20];
	strcpy(replace_algo, argv[3]);
	if(strcmp(replace_algo, "random") == 0) {
		
	}
	else if(strcmp(replace_algo, "fifo") == 0) {
		replace_algo_code = 1;
	}
	else if(strcmp(replace_algo, "custom") == 0) {
		replace_algo_code = 2;
	}
	else {
		printf("Invalid page replacemetn algorithm\n");
		exit(1);
	}

	disk = disk_open("myvirtualdisk",npages);
	if(!disk) {
		fprintf(stderr,"couldn't create virtual disk: %s\n",strerror(errno));
		return 1;
	}


	struct page_table* pt = page_table_create( npages, nframes, page_fault_handler );
	if(!pt) {
		fprintf(stderr,"couldn't create page table: %s\n",strerror(errno));
		return 1;
	}
		
	frame_table = (int*)calloc(nframes, 4);
	ref_bit = (int*)calloc(nframes, 4);
	for(int i = 0 ; i < nframes; i++)
		frame_table[i] = -1;

	page_queue = newQueue(nframes);

	virtmem = page_table_get_virtmem(pt);

	physmem = page_table_get_physmem(pt);

	if(!strcmp(program,"sort")) {
		sort_program(virtmem,npages*PAGE_SIZE);

	} else if(!strcmp(program,"scan")) {
		scan_program(virtmem,npages*PAGE_SIZE);

	} else if(!strcmp(program,"focus")) {
		focus_program(virtmem,npages*PAGE_SIZE);

	} else {
		fprintf(stderr,"unknown program: %s\n",argv[3]);

	}

	page_table_delete(pt);
	disk_close(disk);

	printf("page faults: %d\nreads: %d\nwrites: %d\n", page_faults, reads, writes);

	return 0;
}
