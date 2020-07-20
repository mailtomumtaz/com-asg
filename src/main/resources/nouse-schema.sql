DROP TABLE IF EXISTS USERTYPE;
DROP TABLE IF EXISTS SITEUSER;
DROP TABLE IF EXISTS ITEM;
DROP TABLE IF EXISTS INVOICE;
  
CREATE TABLE USERTYPE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  discount decimal
);

CREATE TABLE SITEUSER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  user_type varchar(10),
  joining_date date
);

CREATE TABLE ITEM (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  is_grocery bit,
  price decimal
);

CREATE TABLE INVOICE(
id INT AUTO_INCREMENT  PRIMARY KEY,
   invoice_no VARCHAR(250) NOT NULL,
   items  VARCHAR(250) NOT NULL,
   user_id int
);
