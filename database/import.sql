INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');

INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Kokandus');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Ehitus');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Infotehnoloogia');


INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Harjumaa');


INSERT INTO public.address (id,region_id,city_id,street,street_number,postal_code,longitude,latitude) VALUES (DEFAULT,1,1,'Aia',7,123456,null,null);


INSERT INTO public.company (id, name,phone_number,email,address_id) VALUES (DEFAULT, 'BSC Koolitus',555666777,'bcs@valiit.ee',1);