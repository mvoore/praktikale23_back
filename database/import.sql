INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kuressaare');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Viljandi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Narva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Haapsalu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Rakvere');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kärdla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Paide');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Põlva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Võru');

INSERT INTO public.category (id, name) VALUES (DEFAULT,'Administratiivtöö');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Ehitus / Kinnisvara');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Elektroonika / Side');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Energeetika / Elekter');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Finants / Raamatupidamine');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Haridus / Teadus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'IT / E-kaubandus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Juhtimine');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Klienditeenindus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Koolitus / Personalitöö');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Korrakaitse / Turva');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Kultuur / Meelelahutus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,' Meedia');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Merendus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Müük / Kaubandus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Põllumajandus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Riigi- ja avalik haldus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Sotsiaaltöö');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Teenindus' );
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Tehnika / Mehhaanika');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Tervishoid');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Toitlustus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Transport / Logistika');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Turism / Hotellindus');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Turundus / Reklaam');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Tööstus / Tootmine' );
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Vabatahtlik töö');
INSERT INTO public.category (id, name) VALUES (DEFAULT,'Õigusteenused');


INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'intern');

INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Harjumaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Hiiumaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Ida-Virumaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Lääne-Virumaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Läänemaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Põlvamaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Pärnumaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Raplamaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Saaremaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Tartumaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Valgamaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Viljandimaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Võrumaa');
INSERT INTO public.region (id, name) VALUES (DEFAULT, 'Eesti');

INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','admin','123',1);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','intern','123',3);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','customer','123',2);

INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','MalleC','123',2);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','MalleI','123',3);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'D','Merit','123',2);

INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','MiisiC','123',2);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','MiisiI','123',3);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'D','Miisi','123',2);

INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','MeritC','123',2);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','MeritI','123',3);
INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'D','Merit','123',2);

INSERT INTO public.user (id, status,username,password,role_id) VALUES (DEFAULT,'A','PlayT','123',2);


INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,5,'Pakipoint OÜ',555666777,'info@pakipoint.ee');
INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,3,'Customer ettevõte',555666777,'customer@customer.ee');
INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,4,'	CrewNew Ltd.',555666777,'juri@crnw.uk');
INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,6,'Deaktiivne firma',555666777,'info@info.ee');

INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,7,'	Piksel OÜ',555666777,'piksel@gmail.com');
INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,9,'Deaktiivne firma2',555666777,'info@info.ee');
INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,10,'Forest Steel OÜ',555666777,'forest@steel.ee');
INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,12,'Datel AS ',555666777,'datel@datel.ee');

INSERT INTO public.company (id,user_id,name,phone_number,email) VALUES (DEFAULT,13,'Playtech ',6977900,'info@playtech.ee');


INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude, status) VALUES (DEFAULT,1,2,3,'Keevise','Pakipoint Tallinn',13,11415,null,null, 'A');
INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude, status) VALUES (DEFAULT,1,2,3,'Rävala','Crew New Tallinna kontor',7,10143,null,null, 'A');
INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude, status) VALUES (DEFAULT,1,2,9,'Lõõtsa','Playtech Tallinn',5,11415,null,null, 'A');
INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude, status) VALUES (DEFAULT,10,3,9,'Vanemuise','Playtech Tartu',7,51001,null,null, 'A');


INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude, status) VALUES (DEFAULT,3,4,2,'Aia Viljandi','Viljandi',7,123456,null,null, 'A');
INSERT INTO public.address (id,region_id,city_id,company_id,street,name,street_number,postal_code,longitude,latitude, status) VALUES (DEFAULT,4,5,2,'Aia Pärnu','Pärnu',7,123456,null,null, 'A');


INSERT INTO public.cover_letter (id, title,file,user_id) VALUES (DEFAULT, 'minu kaaskiri','see on fail',2);
INSERT INTO public.cover_letter (id, title,file,user_id) VALUES (DEFAULT, 'minu kaaskiri','see on fail',5);
INSERT INTO public.cover_letter (id, title,file,user_id) VALUES (DEFAULT, 'minu kaaskiri','see on fail',8);
INSERT INTO public.cover_letter (id, title,file,user_id) VALUES (DEFAULT, 'minu kaaskiri','see on fail',11);

INSERT INTO public.cv (id, title,file,user_id) VALUES (DEFAULT, 'minu cv','see on fail',2);
INSERT INTO public.cv (id, title,file,user_id) VALUES (DEFAULT, 'minu cv','see on fail',5);
INSERT INTO public.cv (id, title,file,user_id) VALUES (DEFAULT, 'minu cv','see on fail',8);
INSERT INTO public.cv (id, title,file,user_id) VALUES (DEFAULT, 'minu cv','see on fail',11);

INSERT INTO public.internship (id,company_id,category_id,title,description,status,date_added) VALUES (DEFAULT,9,7,'Summer Internship 2023','It’s time to kick off your technical career and become the game changer! This year, we''re hosting an internship program with different positions for bright, talented minds in Tallinn and Tartu!

Our internship program is well established - already since the summer of 2012, it has become a tradition for Playtech to welcome interns to its offices. Our internship is the perfect opportunity to join the ranks of a successful international IT company where you can make a real impact. We are on a mission to create technology that changes the way that people experience gaming entertainment! We provide a unique opportunity to see your skills make a difference in products and services that will reach millions of people worldwide.

Here at Playtech, our interns:

are considered full-time team members
have an opportunity to work on real projects from day one
get a personal mentor, who will help and support you during the internship period.
have invaluable real work experience in your CV plus many great memories and friends to take with you
as a bonus, you’ll get paid too
Are you interested in IT and have a positive mindset? Do you see yourself as a curious person who is interested in personal growth? If it sounds like you, then come and join us! Did you know that around 50% of interns will continue working with us after the internship ends? How cool is that?

The internship lasts from June 12th until August 11th, 2023.','A','2023-05-01');

INSERT INTO public.internship_address (id,address_id,internship_id) VALUES (DEFAULT,3,1);


INSERT INTO public.application (id,internship_id,user_id,status, email, full_name, message) VALUES (DEFAULT,1,2,'A','some@gmail.com','some one','Palun võtke tööle. Raha on vaja. Hirmsasti!');