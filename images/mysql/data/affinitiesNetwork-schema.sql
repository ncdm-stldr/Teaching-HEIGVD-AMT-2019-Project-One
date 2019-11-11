
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS affinitiesNetwork;
CREATE SCHEMA affinitiesNetwork;
USE affinitiesNetwork;

CREATE TABLE amt_user (
  user_id INT,
  firstName VARCHAR(45),
  lastName VARCHAR(45),
  PRIMARY KEY(user_id)
);
  
CREATE TABLE amt_centerOfInterest (
  coi_id INT,
  description VARCHAR(45),
  PRIMARY KEY  (coi_id)
);

CREATE TABLE amt_affinity (
	affinity_id int,
    affinity_level int,
    PRIMARY KEY (affinity_id)
);

INSERT INTO amt_user(user_id, firstName, lastName) VALUES (0, "Simon", "Jobin");
INSERT INTO amt_user(user_id, firstName, lastName) VALUES (1, "Toto", "Titi");
INSERT INTO amt_user(user_id, firstName, lastName) VALUES (2, "Pierre", "Dupont");
INSERT INTO amt_user(user_id, firstName, lastName) VALUES (3, "Georges", "Bush");
INSERT INTO amt_user(user_id, firstName, lastName) VALUES (4, "Gilles", "Surchat");
INSERT INTO amt_user(user_id, firstName, lastName) VALUES (5, "Pierre", "Dupond");
INSERT INTO amt_user(user_id, firstName, lastName) VALUES (6, "Paul", "Dupond");

INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (0, "football");
INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (1, "handball");
INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (2, "guitare");
INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (3, "piano");
INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (4, "rando");
INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (5, "jeux videos");
INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (6, "dessin");
INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (7, "peinture");
INSERT INTO amt_centerOfInterest(coi_id, description) VALUES (8, "harmonica");


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


