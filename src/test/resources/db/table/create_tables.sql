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
  tickets_collected_current_event INT(6)      NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS event_team_member;
CREATE TABLE event_team_member
(
  event_id       INT(30) NOT NULL,
  team_member_id INT(30) NOT NULL,
  FOREIGN KEY (event_id) REFERENCES event (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (team_member_id) REFERENCES team_member (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  PRIMARY KEY (event_id, team_member_id)
);