select Apartment_No, Street_Name, City, State, Country, Pincode from estate where city="Guwahati" and status like "%Rent%" and price between 20000 and 40000;

select Apartment_No, Street_Name, city, state, country, Pincode,
	Price, No_Of_Bedrooms, No_Of_Bathrooms, Field_Size,
	First_Name 'Agent First Name', Last_Name 'Agent First Name', Agent_contact_No 
    from (estate natural join in_charge) natural join agent 
    where status = 'Available for Rent'And price <= 10000 AND No_Of_Bedrooms >= 2 And Street_Name = 'G.S. Road';

with total_agent_sale as (select agent_id, first_name, last_name, sum(price) as total_sale from agent natural join contract natural join estate group by agent_id)
select * from total_agent_sale where total_sale in (select max(total_sale) from total_agent_sale);

select Apartment_No, Street_Name, city, state, country, Pincode,Price, No_Of_Bedrooms, No_Of_Bathrooms, Field_Size,First_Name 'Agent First Name', Last_Name 'Agent First Name',
 Agent_contact_No from estate natural join in_charge natural join agent where status like "%Sale" and city="Guwahati" and no_of_bedrooms>=2;

select * from estate where (status like "%Rent%" and price in (select max(price) from estate where status like "%Rent%")) or ((status like "%Sale" or status="Sold") and
 price in(select max(price) from estate where status="Sold" or status like "%Sale"));