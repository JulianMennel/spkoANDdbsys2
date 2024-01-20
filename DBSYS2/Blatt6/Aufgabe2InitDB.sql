CREATE TABLE girokonto (
 name VARCHAR2(20) primary key,
 kontostand INT,
 land VARCHAR2(20)
 );
GRANT INSERT, SELECT, UPDATE ON girokonto TO dbsysXY;
INSERT INTO girokonto VALUES ('A', 1000, 'D');
INSERT INTO girokonto VALUES ('B', 1000, 'D');
INSERT INTO girokonto VALUES ('C', 1000, 'D');
INSERT INTO girokonto VALUES ('D', 1000, 'D');
INSERT INTO girokonto VALUES ('E', 1000, 'D');
INSERT INTO girokonto VALUES ('F', 1000, 'CH');
INSERT INTO girokonto VALUES ('G', 1000, 'CH');
INSERT INTO girokonto VALUES ('H', 1000, 'CH');
INSERT INTO girokonto VALUES ('I', 1000, 'CH');
INSERT INTO girokonto VALUES ('J', 1000, 'CH');

Grant SELECT ON girokonto TO dbsys50;
Grant UPDATE ON girokonto TO dbsys50;

SET TRANSACTION ISOLATION LEVEL serializable;

COMMIT;