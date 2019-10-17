TRUNCATE TABLE supplier CASCADE;
TRUNCATE TABLE product_category CASCADE;
TRUNCATE TABLE product CASCADE;
TRUNCATE TABLE cart CASCADE;
TRUNCATE TABLE line_item CASCADE;



INSERT INTO supplier (id, name, description) VALUES (1, 'ELTE', 'Top hungarian University');
INSERT INTO supplier (id, name, description) VALUES (2, 'Codecool', 'Best private school for those who want to learn coding');
INSERT INTO supplier (id, name, description) VALUES (3, 'Corvinus', 'Accounting and business school');

INSERT INTO product_category (id, name, department, description) VALUES (1, 'Developer', 'IT', 'Responsible for generating code');
INSERT INTO product_category (id, name, department, description) VALUES (2, 'Backoffice', 'IT', 'Responsible for administration');



INSERT INTO product (category_id, supplier_id, name, def_price, def_currency, description)
    VALUES (1, 2, 'Full stack developer', 1000000, 'HUF', 'Best full stack developers on the market, with unit testing experience.');
INSERT INTO product (category_id, supplier_id, name, def_price, def_currency, description)
    VALUES (1, 1, 'PHP developer', 479000, 'HUF', 'Need any PHP developer? Here you can find the ultimate geniuses.');
INSERT INTO product (category_id, supplier_id, name, def_price, def_currency, description)
    VALUES (2, 3, 'Marketing Manager', 890000, 'HUF', 'Makes your company look fabololluos.');
INSERT INTO product (category_id, supplier_id, name, def_price, def_currency, description)
    VALUES (2, 3, 'Sales ', 990000, 'HUF', 'They can sell anything, even your awful product.');
INSERT INTO product (category_id, supplier_id, name, def_price, def_currency, description)
    VALUES (1, 2, 'Python developer', 300000, 'HUF', 'These scripting ninjas can and will do anything you need.');
INSERT INTO product (category_id, supplier_id, name, def_price, def_currency, description)
    VALUES (1, 2, 'Java developer', 500000, 'HUF', 'Java EE, Java SE, makes your system functional (or object-oriented).');
