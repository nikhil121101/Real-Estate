DROP DATABASE Real_Estate;

CREATE DATABASE Real_Estate;

USE Real_Estate;

CREATE TABLE Estate(
Estate_Id INT AUTO_INCREMENT,
Apartment_No VARCHAR(8),
Street_Name VARCHAR(20) NOT NULL,
City VARCHAR(20) NOT NULL,
State VARCHAR(20) NOT NULL,
Country VARCHAR(20) NOT NULL,
Pincode INT,
Field_Size VARCHAR(10) NOT NULL,
No_Of_Bedrooms INT NOT NULL,
No_Of_Bathrooms INT,
Price INT NOT NULL,
Status ENUM('Sold', 'Rented', 'Available for Sale', 'Available for Rent'),
PRIMARY KEY(Estate_id)
);

CREATE TABLE Owner(
Owner_Id INT AUTO_INCREMENT,
Owner_Name VARCHAR(20) NOT NULL,
Owner_Contact_No VARCHAR(13) NOT NULL,
PRIMARY KEY(Owner_id)
);

CREATE TABLE Owned_By(
Estate_Id INT,
Owner_Id INT,
PRIMARY KEY(Estate_Id, Owner_Id),
FOREIGN KEY(Estate_Id) REFERENCES Estate(Estate_Id) ON DELETE CASCADE,
FOREIGN KEY(Owner_Id) REFERENCES Owner(Owner_Id)
);

CREATE TABLE Agent(
Agent_Id INT AUTO_INCREMENT,
First_Name VARCHAR(10) NOT NULL,
Last_Name VARCHAR(10) NOT NULL,
Agent_Contact_No VARCHAR(13) NOT NULL,
PRIMARY KEY(Agent_id)
);

CREATE TABLE In_Charge(
Estate_Id INT,
Agent_Id INT,
Date DATE,
PRIMARY KEY(Estate_Id, Agent_Id),
FOREIGN KEY(Estate_Id) REFERENCES Estate(Estate_Id) ON DELETE CASCADE,
FOREIGN KEY(Agent_Id) REFERENCES Agent(Agent_Id)
);

CREATE TABLE Customer(
Customer_Id INT AUTO_INCREMENT,
Customer_Name VARCHAR(20) NOT NULL,
Customer_Contact_No VARCHAR(13) NOT NULL,
PRIMARY KEY(Customer_Id)
);

CREATE TABLE Contract(
Contract_Id INT AUTO_INCREMENT,
Agent_Id INT,
Estate_Id INT,
Contract_Type ENUM('SOLD', 'RENTED'),
Date_Signed DATE,
PRIMARY KEY(Contract_Id),
FOREIGN KEY(Agent_Id) REFERENCES Agent(Agent_Id),
FOREIGN KEY(Estate_Id) REFERENCES Estate(Estate_Id) ON DELETE CASCADE
);

CREATE TABLE Contract_With(
Contract_Id INT,
Customer_Id INT,
PRIMARY KEY(Contract_Id, Customer_Id),
FOREIGN KEY(Contract_Id) REFERENCES Contract(Contract_Id) ON DELETE CASCADE,
FOREIGN KEY(Customer_Id) REFERENCES Customer(Customer_Id)
);


INSERT INTO Estate VALUES
(1,'A-94','Mall Road','Shimla','Himachal Pradesh','India',171001,'25m x 30m',2,1,2200000,'Sold'),
(2,'J-28','Mahatma Gandhi Road','Kochi','Kerala','India',682016,'80m x 120m',4,4,70000, 'Rented'),
(3,'K-267','Park Street','Kolkata','West Bengal','India',700016,'20m x 70m',3,1,15000,'Rented'),
(4,'MN-10','G.S. Road','Guwahati','Assam','India',781010,'44m x 60m',2,1,9000,'Available for Rent'),
(5,'S-727','Connaught Lane','Mumbai','Maharashtra','India',400059,'27m x 30m',3,1,27000,'Available for Rent'),
(6,'NG-14','G.S. Road','Guwahati','Assam','India',400002,'72m x 36m',4,2,4600000,'Available for Sale'),
(7,'LN-147','Bongara','Guwahati','Assam','India',781002,'60m x 60m',5,3,7000000,'Sold'),
(8,'RK-89','Gold Coast','Mumbai','Maharashtra','India',400006,'30m x 25m',2,2,2500000,'Available for Sale'),
(9,'E-47','MG Road','Guwahati','Assam','India',781001,'70m x 50m',2,1,30000,'Rented'),
(10,'SS-367','SN Road','Lucknow','Uttar Pradesh','India',226001,'80m x 40m',3,2,4000000,'Sold');

INSERT INTO Owner VALUES
(1,'Sanjay Sharma', '9856485623'),
(2,'Anant Jai','9564767388'),
(3,'Raman Nair','6358446789'),
(4,'Anju Regar','6839358597'),
(5,'Anuj Mehta','8368357495'),
(6,'Nitin Tamboli','7795845948'),
(7,'Ramdas Verma','8659485948'),
(8,'Preeti Vyas','9838457487'),
(9,'Sumit Shrivastav','9923848378'),
(10,'Arun Gaud','9437838839');


INSERT INTO Owned_by VALUES
(1,1),
(1,2),
(1,3),
(2,3),
(3,3),
(3,1),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(9,10),
(10,2);

INSERT INTO Agent VALUES
(1,'Harsh','Mehta','7234778989'),
(2,'Karan','Nyati','8232647899'),
(3,'Sushma','Rai','7242473478'),
(4,'Indra','Prakash','9527272889'),
(5,'Krish','Joshi','9232462728'),
(6,'Naman','Vyas','9456778272'),
(7,'Arvind','Vyas','9245778673'),
(8,'Alok','Sharma','6832748394'),
(9,'Naman','Soni','9384736478'),
(10,'Anita','Prajapat','9347364727');


INSERT INTO In_Charge VALUES
(1,1,'2017-08-10'),
(2,1,'2019-09-19'),
(3,2,'2019-09-20'),
(4,3,'2019-11-25'),
(5,4,'2020-06-26'),
(6,3,'2020-07-08'),
(7,7,'2020-07-10'),
(8,10,'2020-12-12'),
(9,10,'2021-01-01'),
(10,10,'2021-01-01');

INSERT INTO Customer VALUES
(1,'Akshay Sinha','8898490097'),
(2,'Seema Verma', '9487349900'),
(3,'Allu Swamy','7988798889'),
(4,'Ragvendra Sen','6989779899'),
(5,'Ranjit Desai','9927827828'),
(6,'Anant Das','8998786564'),
(7,'Amar Sharma','6998887880'),
(8,'Nitin Dogra','6898988890'),
(9,'Rishi Vyas','7898967889'),
(10,'Shravan Arya','8989867678'),
(11,'Sanjay Shastri','9839858998'),
(12,'Karan Bohra','9478983749');

INSERT INTO Contract VALUES
(1,1,1,'Sold','2018-01-02'),
(2,2,3,'Rented','2019-12-26'),
(3,7,7,'Sold','2021-01-18'),
(4,10,10,'Sold','2020-12-19'),
(5,10,9,'Rented','2020-04-02'),
(6,1,2,'Rented','2021-03-11');

INSERT INTO Contract_With VALUES
(1,1),
(2,1),
(3,5),
(3,6),
(4,4),
(5,5),
(5,8),
(6,1),
(6,9);