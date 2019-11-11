
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS affinitiesNetwork;
CREATE SCHEMA affinitiesNetwork;
USE affinitiesNetwork;

CREATE TABLE amt_user (
  user_id INT NOT NULL auto_increment,
  firstName VARCHAR(45),
  lastName VARCHAR(45),
  amt_username VARCHAR(45),
  amt_password VARCHAR(45),
  PRIMARY KEY(user_id)
);
  
CREATE TABLE amt_centerOfInterest (
  coi_id INT NOT NULL auto_increment,
  coi_name VARCHAR(45),
  description VARCHAR(45),
  PRIMARY KEY  (coi_id)
);

CREATE TABLE amt_affinity (
	affinity_id INT NOT NULL auto_increment,
    affinity_level INT,
    user_id INT,
    coi_id INT,
    PRIMARY KEY (affinity_id),
    CONSTRAINT
    FOREIGN KEY (user_id) REFERENCES amt_user(user_id),
    FOREIGN KEY (coi_id) REFERENCES amt_centerOfInterest(coi_id)
);

INSERT INTO amt_user(firstName, lastName, username, password) VALUES ("Simon", "Jobin");
INSERT INTO amt_user(firstName, lastName) VALUES ("Toto", "Titi");
INSERT INTO amt_user(firstName, lastName) VALUES ("Pierre", "Dupont");
INSERT INTO amt_user(firstName, lastName) VALUES ("Georges", "Bush");
INSERT INTO amt_user(firstName, lastName) VALUES ("Gilles", "Surchat");
INSERT INTO amt_user(firstName, lastName) VALUES ("Pierre", "Dupond");
INSERT INTO amt_user(firstName, lastName) VALUES ("Paul", "Dupond");

INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("football", "");
INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("handball", "");
INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("guitare", "");
INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("piano", "");
INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("rando", "");
INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("jeux videos", "");
INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("dessin", "");
INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("peinture", "");
INSERT INTO amt_centerOfInterest(coi_name, description) VALUES ("harmonica", "");

INSERT INTO amt_affinity(affinity_level, user_id, coi_id) VALUES (12, 0, 3);
INSERT INTO amt_affinity(affinity_level, user_id, coi_id) VALUES (8, 1, 3);
INSERT INTO amt_affinity(affinity_level, user_id, coi_id) VALUES (4, 1, 4);
INSERT INTO amt_affinity(affinity_level, user_id, coi_id) VALUES (5, 2, 6);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


