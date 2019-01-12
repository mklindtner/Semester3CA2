INSERT INTO cityInfo (zipCode, NAME) VALUES (0555, 'Scanning');
INSERT INTO cityInfo (zipCode, NAME) VALUES (0800, 'Høje Taastrup');
INSERT INTO cityInfo (zipCode, NAME) VALUES (0877, 'København C');


INSERT INTO hobby (id, name, description) VALUES (1, 'Soccer', 'Association football, more commonly known as football or soccer, is a team sport played between two teams of eleven players with a spherical ball. It is played by 250 million players in over 200 countries and dependencies, making it the worlds most popular sport.');
INSERT INTO hobby (id, name, description) VALUES (2, 'Handball', 'Handball (also known as team handball, fieldball, European handball or Olympic handball) is a team sport in which two teams of seven players each (six outfield players and a goalkeeper) pass a ball using their hands with the aim of throwing it into the goal of the other team.');
INSERT INTO hobby (id, name, description) VALUES (3, 'Esports', 'eSports (also known as electronic sports, esports, esports, or competitiveprofessional video gaming) are a form of competition using video games.');
INSERT INTO hobby (id, name, description) VALUES (4, 'Fishing', 'Fishing is the activity of trying to catch fish. Fish are normally caught in the wild. Techniques for catching fish include hand gathering, spearing, netting, angling and trapping. Fishing may include catching aquatic animals other than fish, such as molluscs, cephalopods, crustaceans, and echinoderms.');
INSERT INTO hobby (id, name, description) VALUES (5, 'Running', 'Running is a method of terrestrial locomotion allowing humans and other animals to move rapidly on foot. Running is a type of gait characterized by an aerial phase in which all feet are above the ground (though there are exceptions1). This is in contrast to walking, where one foot is always in contact with the ground, the legs are kept mostly straight and the center of gravity vaults over the stance leg or legs in an inverted pendulum fashion.');
INSERT INTO hobby (id, name, description) VALUES (6, 'Baking', 'Baking is a method of cooking food that uses prolonged dry heat, normally in an oven, but also in hot ashes, or on hot stones. The most common baked item is bread but many other types of foods are baked.');
INSERT INTO hobby (id, name, description) VALUES (7, 'Cooking', 'Cooking or cookery is the art, technology, science and craft of preparing food for consumption. Cooking techniques and ingredients vary widely across the world, from grilling food over an open fire to using electric stoves, to baking in various types of ovens, reflecting unique environmental, economic, and cultural traditions and trends.');
INSERT INTO hobby (id, name, description) VALUES (8, 'Ice skating', 'Ice skating is the act of motion by wearer of the ice skates to propel the participant across a sheet of ice. This can be done for a variety of reasons, including exercise, leisure, traveling, and various sports.');
INSERT INTO hobby (id, name, description) VALUES (9, 'Programming', 'Computer programming is the process of designing and building an executable computer program for accomplishing a specific computing task.');
INSERT INTO hobby (id, name, description) VALUES (10, 'Acting', 'Acting is an activity in which a story is told by means of its enactment by an actor or actress who adopts a characterin theatre, television, film, radio, or any other medium that makes use of the mimetic mode.');
INSERT INTO hobby (id, name, description) VALUES (11, 'Painting', 'Painting is the practice of applying paint, pigment, color or other medium to asolid surface (support base). The medium is commonly applied to the base with a brush, but other implements, such as knives, sponges, and airbrushes, can be used. The final work is also called a painting.');
INSERT INTO hobby (id, name, description) VALUES (12, 'Dance', 'Dance is a performing art form consisting of purposefully selected sequences of human movement. This movement has aesthetic and symbolic value, and is acknowledged as dance by performers and observers within a particular culture.');

INSERT INTO address (id, information, street, city_id) VALUES (1, '82', 'Milanovicvej', 1);
INSERT INTO person (ID, EMAIL, FIRSTNAME, LASTNAME, ADDRESS_ID) VALUES (1, 'nicolai-mikkelsen-1@protonmail.io', 'Nicolai', 'Mikkelsen', 1);
INSERT INTO phone (ID, DESCRIPTION, number, infoEntity_id) VALUES (1, 'Hjem', '13990653', 1);

INSERT INTO person_hobby (person_id, hobby_id) VALUES (1, 8);
INSERT INTO person_hobby (person_id, hobby_id) VALUES (1, 4);
INSERT INTO person_hobby (person_id, hobby_id) VALUES (1, 7);

INSERT INTO address (id, information, street, city_id) VALUES (2, '290', 'Milanovicvej', 2);
INSERT INTO person (ID, EMAIL, FIRSTNAME, LASTNAME, ADDRESS_ID) VALUES (2, 'anna-kaspersen-2@hotmail.eu', 'Anna', 'Kaspersen', 2);
INSERT INTO phone (ID, DESCRIPTION, number, infoEntity_id) VALUES (2, 'Hjem', '57207152', 2);

INSERT INTO person_hobby (person_id, hobby_id) VALUES (2, 3);
INSERT INTO person_hobby (person_id, hobby_id) VALUES (2, 11);

INSERT INTO address (id, information, street, city_id) VALUES (3, '24', 'Ryllevej', 3);
INSERT INTO person (ID, EMAIL, FIRSTNAME, LASTNAME, ADDRESS_ID) VALUES (3, 'jacob-behrendt-3@gmail.dk', 'Jacob', 'Behrendt', 3);
INSERT INTO phone (ID, DESCRIPTION, number, infoEntity_id) VALUES (3, 'Bil', '49235055', 3);

INSERT INTO person_hobby (person_id, hobby_id) VALUES (3, 5);
INSERT INTO person_hobby (person_id, hobby_id) VALUES (3, 4);
INSERT INTO person_hobby (person_id, hobby_id) VALUES (3, 10);

INSERT INTO address (id, information, street, city_id) VALUES (301, '113', 'Milanovicvej', 1);
Insert INTO company (id, email, address_id, cvr, description, marketValue, name, numEmployees) VALUES (301, 'company1@email', 301, 1337, 'desc1 of smth', 99999, 'bobs & o', 25);
INSERT INTO phone (ID, DESCRIPTION, number, infoEntity_id) VALUES (513, 'Arbejde', 7482992, 301);
INSERT INTO phone (ID, DESCRIPTION, number, infoEntity_id) VALUES (514, 'Feriehjem', 54393336, 301);






