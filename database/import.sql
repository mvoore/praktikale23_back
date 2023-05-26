INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kuressaare');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Viljani');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');

INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Kokandus');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Ehitus');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Infotehnoloogia');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Haridus');

INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'intern');

INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Harjumaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Saaremaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Viljandimaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Pärnumaa');

INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','admin','123',1);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','customer','123',2);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','intern','123',3);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'D','customer2','123',2);

INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,2,'BSC Koolitus Tallinn ',555666777,'bcs@valiit.ee');
INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,4,'BSC Koolitus Kuressaare',555666777,'bcs@valiit.ee');

INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude) VALUES (DEFAULT,1,2,1,'Aia Tallinn','Tallinn',7,123456,null,null);
INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude) VALUES (DEFAULT,2,1,1,'Aia Kuressaare','Kuressaare',7,123456,null,null);
INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude) VALUES (DEFAULT,3,4,2,'Aia Viljandi','Viljandi',7,123456,null,null);
INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude) VALUES (DEFAULT,4,5,2,'Aia Pärnu','Pärnu',7,123456,null,null);


INSERT INTO public.cover_letter (id, title,file,user_id) VALUES (DEFAULT, 'minu kaaskiri','see on fail',3);

INSERT INTO public.cv (id, title,file,user_id) VALUES (DEFAULT, 'minu cv','see on fail',3);

INSERT INTO public.internship (id,company_id,category_id,title,description,status,date_added) VALUES (DEFAULT,1,3,'Back-end arendaja','otsime inimest','A','2023-05-01');
INSERT INTO public.internship (id,company_id,category_id,title,description,status,date_added) VALUES (DEFAULT,2,3,'Back-end arendaja','otsime inimest','A','2023-04-11');
INSERT INTO public.internship (id,company_id,category_id,title,description,status,date_added) VALUES (DEFAULT,1,3,'Back-end arendaja','otsime inimest','A','2023-05-01');
INSERT INTO public.internship (id,company_id,category_id,title,description,status,date_added) VALUES (DEFAULT,2,3,'Back-end arendaja','otsime inimest','A','2023-05-01');

INSERT INTO public.internship_address (id,address_id,internship_id) VALUES (DEFAULT,1,1);
INSERT INTO public.internship_address (id,address_id,internship_id) VALUES (DEFAULT,2,2);
INSERT INTO public.internship_address (id,address_id,internship_id) VALUES (DEFAULT,3,3);
INSERT INTO public.internship_address (id,address_id,internship_id) VALUES (DEFAULT,4,4);


INSERT INTO public.application (id,internship_id,user_id,status) VALUES (DEFAULT,1,1,'A');