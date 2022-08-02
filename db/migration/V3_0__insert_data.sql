insert into product_category
values (1, 'IT', 'Product From IT Category Like Laptops,Phones, PCs and more');
insert into supplier
values (10, 'DELL'),
       (11, 'HP');
insert into product
values (100, 'Notebook Basic 15', 'Notebook Basic', 956, 2000, 1, 11,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1000.jpg'),
       (101, 'Dell', 'Dell Latitude', 500, 1500, 1, 10,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1000.jpg');
insert into location
values (1, 'Altex', 'Romania', 'Cluj-Napoca', 'Cluj', 'Memorandumului'),
       (2, 'Flanco', 'Romania', 'Piatra Neamt', 'Neamt', '9 Mai');
insert into stock
values (10, 100, 1, 3),
       (11, 100, 2, 10);
insert into customer
values (100, 'Andrei', 'Popescu', 'andreipop', 'gogosi', 'andrei.popescu@mail.com');
