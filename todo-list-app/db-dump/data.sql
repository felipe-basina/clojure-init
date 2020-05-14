CREATE DATABASE todolist;

--USE todolist;

CREATE TABLE todos (
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