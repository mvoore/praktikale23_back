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




INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','admin','123',1);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','customer','123',2);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','intern','123',3);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'D','customer','123',2);

INSERT INTO public.company (id,user_id,name,phone_number,email,address_id) VALUES (DEFAULT,1,'BSC Koolitus',555666777,'bcs@valiit.ee',1);

INSERT INTO public.cover_letter (id, title,file,user_id) VALUES (DEFAULT, 'minu kaaskiri','see on fail',1);

INSERT INTO public.cv (id, title,file,user_id) VALUES (DEFAULT, 'minu cv','see on fail',1);

INSERT INTO public.internship (id,company_id,category_id,title,description,status) VALUES (DEFAULT,1,1,'Back-end arendaja','otsime inimest','A');

INSERT INTO public.internship_address (id,address_id,internship_id) VALUES (DEFAULT,1,1);


INSERT INTO public.application (id,internship_id,user_id,status) VALUES (DEFAULT,1,1,'A');