DROP TABLE IF EXISTS event;
CREATE TABLE event (
  id INT NOT NULL AUTO_INCREMENT ,
  team_member_id INT (30) NULL ,
  event_date VARCHAR (30) NOT NULL ,
  name VARCHAR (255) NOT NULL ,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS team_member;
CREATE TABLE team_member (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR (255) ,
  date_joined VARCHAR (30) NOT NULL ,
  PRIMARY KEY (id)
);