CREATE DATABASE IF NOT EXISTS todolist;

USE todolist;

CREATE TABLE IF NOT EXISTS todos (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  title varchar(255),
  description varchar(255),
  is_complete boolean,
  primary key (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO todos (id, title, description, is_complete) values 
(1, "To buy milk", "Need to buy milk after work", false),
(2, "Schedule appointment about renting a car", "Renting a car when arriving at the airpoert", false);