DROP TABLE PRUEFUNGSERGEBNISTab;
DROP TABLE VorlesungTab;
DROP TABLE StudierenderTab;
DROP TABLE StudiengangTab;
DROP TABLE FakultaetTab;
DROP TABLE ProfessorTab;

DROP TYPE PRUEFUNGSERGEBNIST;
DROP TYPE VorlesungT;
DROP TYPE StudierenderT;
DROP TYPE StudiengangT;
DROP TYPE FakultaetT;
DROP TYPE ProfessorenVA;
DROP TYPE ProfessorT;
DROP TYPE PersonT;

CREATE OR REPLACE TYPE PersonT AS OBJECT
(name VARCHAR2(40)) NOT FINAL;
/
CREATE OR REPLACE TYPE ProfessorT UNDER PersonT
(fachgebiet VARCHAR2(40),
buero CHAR(4)) FINAL;
/
CREATE OR REPLACE TYPE ProfessorenVA AS VARRAY(50) OF REF ProfessorT;
/
CREATE OR REPLACE TYPE FakultaetT AS OBJECT
(name VARCHAR2(20),
 dekan REF ProfessorT,
 professoren ProfessorenVA) FINAL;
/
CREATE OR REPLACE TYPE StudiengangT AS OBJECT
(name VARCHAR2(40),
fakultaet REF FakultaetT) FINAL;
/




CREATE OR REPLACE TYPE StudierenderT UNDER PersonT
(matrikelnummer VARCHAR(6),
 studiengang REF StudiengangT,
 MEMBER FUNCTION getNotenschnitt RETURN FLOAT) FINAL;
/




CREATE OR REPLACE TYPE VorlesungT AS OBJECT
(name VARCHAR2(40),
professor REF ProfessorT) FINAL;
/
CREATE TABLE ProfessorTab OF ProfessorT;
CREATE TABLE FakultaetTab OF FakultaetT
(dekan SCOPE IS ProfessorTab);
CREATE TABLE StudiengangTab OF StudiengangT
(fakultaet SCOPE IS FakultaetTab);
CREATE TABLE StudierenderTab OF StudierenderT
(studiengang SCOPE IS StudiengangTab);
CREATE TABLE VorlesungTab OF VorlesungT
(professor SCOPE IS ProfessorTab);


CREATE OR REPLACE TYPE PruefungsergebnisT AS OBJECT
(pruefungsdatum date,
vorlesung REF VorlesungT,
studierender REF StudierenderT,
note NUMBER(2,1)) FINAL;
/
CREATE TABLE PruefungsergebnisTab OF PruefungsergebnisT
(vorlesung SCOPE IS VorlesungTab,
studierender SCOPE IS StudierenderTab,
CONSTRAINT valid_note CHECK (note IN (1.0,1.3,1.7,2.0,2.3,2.7,3.0,3.3,3.7,4.0,43,4.7,5.0)));



INSERT INTO ProfessorTab VALUES('Langweg', 'IT Security', 'O003');
INSERT INTO ProfessorTab VALUES('Eck', 'Datenbanken', 'O002');
INSERT INTO ProfessorTab VALUES('Boger', 'Web-Applikationen', 'O004');
INSERT INTO ProfessorTab VALUES('Eigelsperger', 'Software Qualität', 'O004');

INSERT INTO FakultaetTab VALUES('Informatik', NULL, ProfessorenVA((SELECT REF(p) 
                                FROM ProfessorTab p
                                WHERE p.name = 'Eck')));         
INSERT INTO FakultaetTab VALUES('Kunst', NULL, ProfessorenVA((SELECT REF(p) 
                                FROM ProfessorTab p
                                WHERE p.name = 'Boger')));
UPDATE FakultaetTab SET dekan = (SELECT REF(p) 
                                 FROM ProfessorTab p 
                                 WHERE name = 'Eigelsperger') 
                    WHERE name = 'Informatik';         
UPDATE FakultaetTab SET dekan = (SELECT REF(p) 
                                 FROM ProfessorTab p 
                                 WHERE name = 'Langweg') 
                    WHERE name = 'Kunst';
                    
INSERT INTO StudiengangTab VALUES('WIN', (SELECT REF(f) FROM FakultaetTab f WHERE f.name = 'Informatik'));
INSERT INTO StudiengangTab VALUES('AIN', (SELECT REF(f) FROM FakultaetTab f WHERE f.name = 'Informatik'));
INSERT INTO StudiengangTab VALUES('KunstKunst', (SELECT REF(f) FROM FakultaetTab f WHERE f.name = 'Kunst'));
                    
INSERT INTO StudierenderTab VALUES ('Can Kabak', '123456', NULL);
UPDATE StudierenderTab SET studiengang = (SELECT REF(s) FROM StudiengangTab s WHERE name = 'AIN') WHERE name = 'Can Kabak';
INSERT INTO StudierenderTab VALUES ('Ümit Simsek', '113456', NULL);
UPDATE StudierenderTab SET studiengang = (SELECT REF(s) FROM StudiengangTab s WHERE name = 'AIN') WHERE name = 'Ümit Simsek';
INSERT INTO StudierenderTab VALUES ('Julian Mennel', '223456', NULL);
UPDATE StudierenderTab SET studiengang = (SELECT REF(s) FROM StudiengangTab s WHERE name = 'WIN') WHERE name = 'Julian Mennel';
INSERT INTO StudierenderTab VALUES ('Hans Gustav', '123455', NULL);
UPDATE StudierenderTab SET studiengang = (SELECT REF(s) FROM StudiengangTab s WHERE name = 'WIN') WHERE name = 'Hans Gustav';
INSERT INTO StudierenderTab VALUES ('Hans Peter', '123455', NULL);
UPDATE StudierenderTab SET studiengang = (SELECT REF(s) FROM StudiengangTab s WHERE name = 'KunstKunst') WHERE name = 'Hans Peter';

INSERT INTO VorlesungTab VALUES ('IT Security', NULL);
INSERT INTO VorlesungTab VALUES ('Datenbanken', NULL);
INSERT INTO VorlesungTab VALUES ('Web-Applikationen', NULL);
INSERT INTO VorlesungTab VALUES ('Software Qualität', NULL);
UPDATE VorlesungTab SET professor = (SELECT REF(p) FROM ProfessorTab p WHERE fachgebiet = 'IT Security') WHERE name = 'IT Security';
UPDATE VorlesungTab SET professor = (SELECT REF(p) FROM ProfessorTab p WHERE fachgebiet = 'Datenbanken') WHERE name = 'Datenbanken';
UPDATE VorlesungTab SET professor = (SELECT REF(p) FROM ProfessorTab p WHERE fachgebiet = 'Web-Applikationen') WHERE name = 'Web-Applikationen';
UPDATE VorlesungTab SET professor = (SELECT REF(p) FROM ProfessorTab p WHERE fachgebiet = 'Software Qualität') WHERE name = 'Software Qualität';

INSERT INTO PruefungsergebnisTab VALUES (TO_DATE('09.11.2023', 'DD.MM.YYYY'), (SELECT REF(v) FROM VorlesungTab v WHERE name = 'IT Security'), (SELECT REF(s) FROM StudierenderTab s WHERE name = 'Can Kabak'), 1.7);
INSERT INTO PruefungsergebnisTab VALUES (TO_DATE('09.11.2023', 'DD.MM.YYYY'), (SELECT REF(v) FROM VorlesungTab v WHERE name = 'IT Security'), (SELECT REF(s) FROM StudierenderTab s WHERE name = 'Julian Mennel'), 3.3);
INSERT INTO PruefungsergebnisTab VALUES (TO_DATE('09.11.2023', 'DD.MM.YYYY'), (SELECT REF(v) FROM VorlesungTab v WHERE name = 'Software Qualität'), (SELECT REF(s) FROM StudierenderTab s WHERE name = 'Ümit Simsek'), 1.0);
INSERT INTO PruefungsergebnisTab VALUES (TO_DATE('09.11.2023', 'DD.MM.YYYY'), (SELECT REF(v) FROM VorlesungTab v WHERE name = 'Software Qualität'), (SELECT REF(s) FROM StudierenderTab s WHERE name = 'Can Kabak'), 2.3);
INSERT INTO PruefungsergebnisTab VALUES (TO_DATE('09.11.2023', 'DD.MM.YYYY'), (SELECT REF(v) FROM VorlesungTab v WHERE name = 'Web-Applikationen'), (SELECT REF(s) FROM StudierenderTab s WHERE name = 'Ümit Simsek'), 2.7);
INSERT INTO PruefungsergebnisTab VALUES (TO_DATE('09.11.2023', 'DD.MM.YYYY'), (SELECT REF(v) FROM VorlesungTab v WHERE name = 'Datenbanken'), (SELECT REF(s) FROM StudierenderTab s WHERE name = 'Hans Gustav'), 5.0);
INSERT INTO PruefungsergebnisTab VALUES (TO_DATE('09.11.2023', 'DD.MM.YYYY'), (SELECT REF(v) FROM VorlesungTab v WHERE name = 'Datenbanken'), (SELECT REF(s) FROM StudierenderTab s WHERE name = 'Julian Mennel'), 1.7);


/* AUFGABE 2 */

SELECT p.studierender.name, p.note
FROM PruefungsergebnisTab p
WHERE p.vorlesung.name = 'Datenbanken'
AND p.note < 2.0;

SELECT s.name
FROM StudierenderTab s
WHERE s.studiengang.fakultaet.dekan.name = 'Langweg';

SELECT f.dekan.name, DEREF(prof.column_value).name AS ProfessorName
FROM FakultaetTab f, TABLE(f.professoren) prof
WHERE f.name = 'Informatik';

/* AUFGABE 3 */

SELECT s.matrikelnummer, s.name, s.getNotenschnitt() AS Durchschnitt
FROM StudierenderTab s;
/

CREATE OR REPLACE TYPE BODY StudierenderT AS
MEMBER FUNCTION getNotenschnitt RETURN FLOAT IS
durchschnitt FLOAT;
 BEGIN
  SELECT AVG(p.note) 
  INTO durchschnitt 
  FROM PruefungsergebnisTab p
  WHERE SELF.matrikelnummer = p.studierender.matrikelnummer
  GROUP BY p.studierender;
   RETURN durchschnitt;
 END getNotenschnitt;
END;
/

 SELECT AVG(p.note) 
  INTO durchschnitt 
  FROM PruefungsergebnisTab p
  WHERE SELF = p.studierender
  GROUP BY p.studierender;
   /