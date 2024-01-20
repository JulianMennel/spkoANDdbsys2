UPDATE DBSYS53.girokonto SET kontostand = kontostand - 500 WHERE
name = 'A';
UPDATE DBSYS53.girokonto SET kontostand = kontostand + 500 WHERE
name = 'F';
COMMIT;

UPDATE DBSYS53.girokonto SET kontostand = kontostand - 500 WHERE
name = 'F';
UPDATE DBSYS53.girokonto SET kontostand = kontostand + 500 WHERE
name = 'A';