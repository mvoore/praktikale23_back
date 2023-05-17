INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');

INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Kokandus');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Ehitus');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Infotehnoloogia');

INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'intern');

INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Harjumaa');

INSERT INTO public.address (id,region_id,city_id,street,street_number,postal_code,longitude,latitude) VALUES (DEFAULT,1,1,'Aia',7,123456,null,null);


INSERT INTO public.company (id, name,phone_number,email,address_id) VALUES (DEFAULT, 'BSC Koolitus',555666777,'bcs@valiit.ee',1);

INSERT INTO public.cover_letter (id, title) VALUES (DEFAULT, 'minu kaaskiri');

INSERT INTO public.cv (id, title) VALUES (DEFAULT, 'minu cv');


INSERT INTO public.user (id, status,username,password,company_id,role_id,cv_id,cover_letter_id) VALUES (DEFAULT,'A','admin','123',1,1,1,1);




INSERT INTO public.internship (id,status,category_id,title,company_id,image_id,description) VALUES (DEFAULT,'A',3,'Back-end arendaja',1,null,'otsime ilusat inimest');

INSERT INTO public.internship_address (id,address_id,internship_id) VALUES (DEFAULT,1,1);


INSERT INTO public.application (id,status,email,user_id,internship_id) VALUES (DEFAULT,'A','bcs@valiit.ee',1,1);