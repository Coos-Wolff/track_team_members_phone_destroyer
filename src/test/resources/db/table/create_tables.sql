DROP TABLE IF EXISTS event;
CREATE TABLE event
(
  id             INT          NOT NULL AUTO_INCREMENT,
  team_member_id INT(30)      NULL,
  event_date     VARCHAR(30)  NOT NULL,
  name           VARCHAR(255) NOT NULL,
  has_ended      BOOLEAN      NOT NULL DEFAULT FALSE,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS member;
CREATE TABLE member
(
  id                              INT         NOT NULL AUTO_INCREMENT,
  name                            VARCHAR(255),
  date_joined                     VARCHAR(30) NOT NULL,
  tickets_collected_current_event INT(6)      NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS event_member;
CREATE TABLE event_member
(
  event_id  INT(30) NOT NULL,
  member_id INT(30) NOT NULL,
  FOREIGN KEY (event_id) REFERENCES event (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (member_id) REFERENCES member (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  PRIMARY KEY (event_id, member_id)
);

DROP TABLE IF EXISTS event_history;
CREATE TABLE event_history
(
  id                      INT          NOT NULL AUTO_INCREMENT,
  member_id               INT(30)      NOT NULL,
  event_id                INT(20)      NOT NULL,
  event_tickets_collected INT(6),
  FOREIGN KEY (member_id) REFERENCES member (id),
  event_name              VARCHAR(255) NOT NULL,
  FOREIGN KEY (event_id) REFERENCES event (id),
  PRIMARY KEY (id)
);