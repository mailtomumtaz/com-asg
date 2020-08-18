
INSERT INTO USERTYPE(id, name, discount) values(1, 'STAFF', 30);
INSERT INTO USERTYPE(id, name, discount) values(2, 'AFFILIATE', 10);
INSERT INTO USERTYPE(id, name, discount) values(3, 'EXISTINGUSER', 0);

INSERT INTO SITEUSER(id, name, user_type, joining_date) values(1, 'staff', 1, '2019-1-4');
INSERT INTO SITEUSER(id, name, user_type, joining_date) values(2, 'affiliate', 2, '2019-1-4');
INSERT INTO SITEUSER(id, name, user_type, joining_date) values(3, 'customer1', 3, '2019-1-4');
INSERT INTO SITEUSER(id, name, user_type, joining_date) values(4, 'customer2', 3, '2014-1-4');

INSERT INTO ITEM(id, name, is_grocery, price) values(1,'P1', false, 10);
INSERT INTO ITEM(id, name, is_grocery, price) values(2,'P2', false, 20);
INSERT INTO ITEM(id, name, is_grocery, price) values(3,'P3', false, 30);
INSERT INTO ITEM(id, name, is_grocery, price) values(4,'P14', true, 100);

INSERT INTO INVOICE (id, invoice_no, user_id) values(1, '0001', 1);
INSERT INTO INVOICE_ITEMS (invoice_id, items_id) values(1, 2);

INSERT INTO INVOICE (id, invoice_no, user_id) values(2, '0002', 2);
INSERT INTO INVOICE_ITEMS (invoice_id, items_id) values(2, 2);

INSERT INTO INVOICE (id, invoice_no, user_id) values(3, '0003', 3);
INSERT INTO INVOICE_ITEMS (invoice_id, items_id) values(3, 2);

INSERT INTO INVOICE (id, invoice_no, user_id) values(4, '0004', 4);
INSERT INTO INVOICE_ITEMS (invoice_id, items_id) values(4, 2);

INSERT INTO INVOICE (id, invoice_no, user_id) values(5, '0005', 1);
INSERT INTO INVOICE_ITEMS (invoice_id, items_id) values(5, 4);
