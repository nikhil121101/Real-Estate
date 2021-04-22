
CREATE ROLE admin, office, agent;


GRANT ALL ON real_estate.* TO admin;


GRANT ALL ON real_estate.contract TO agent;
GRANT ALL ON real_estate.contract_with TO agent;
GRANT ALL ON real_estate.customer TO agent;
GRANT ALL ON real_estate.role TO agent;


GRANT SELECT ON real_estate.estate TO 'office';
GRANT SELECT ON real_estate.contract TO 'office';
GRANT SELECT ON real_estate.contract_with TO 'office';
GRANT SELECT ON real_estate.customer TO 'office';
GRANT SELECT ON real_estate.owned_by TO 'office';
GRANT SELECT ON real_estate.owner TO 'office';
GRANT ALL ON real_estate.role TO 'office';


CREATE USER admin_1@localhost IDENTIFIED BY 'admin_1$12345';
CREATE USER office_1@localhost IDENTIFIED BY 'office_1$12345';
CREATE USER agent_1@localhost IDENTIFIED BY 'agent_1$12345';


GRANT admin TO admin_1@localhost;
GRANT office TO office_1@localhost;
GRANT agent TO agent_1@localhost;

FLUSH PRIVILEGES;



