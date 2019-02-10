CREATE TABLE event (
  id INT NOT NULL AUTO_INCREMENT ,
  event_date VARCHAR (30) NOT NULL ,
  name VARCHAR (255) NOT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE team (
  id INT NOT NULL AUTO_INCREMENT ,
  team_member VARCHAR (255) NOT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE team_member (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR (255) ,
  date_joined VARCHAR (30) NOT NULL ,
  PRIMARY KEY (id)
);