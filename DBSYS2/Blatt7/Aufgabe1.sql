//INSERT INTO Abt Values('K00', 'Mueller', 'Konstanz');


//a) Wie viele Personen sind alleine in einer Abteilung?
SELECT COUNT(DISTINCT pnr)
FROM Pers p
WHERE NOT EXISTS
 (SELECT * FROM pers p2
 WHERE p.anr = p2.anr AND p.pnr != p2.pnr);
 
SELECT COUNT(DISTINCT p.pnr)
FROM Pers p
LEFT JOIN Pers p2 ON p.anr = p2.anr AND p.pnr != p2.pnr
WHERE p2.anr IS NULL;



//b) In welchen Abteilungen arbeiten keine Programmierer?
SELECT a.aname
FROM abt a
WHERE NOT EXISTS (SELECT * FROM pers p
 WHERE p.anr = a.anr
AND beruf = 'Programmierer');

SELECT a.aname
FROM abt a
LEFT JOIN pers p ON a.anr = p.anr AND p.beruf = 'Programmierer'
WHERE p.anr IS NULL;



//c) Wie viele Personen verdienen mehr als das Durchschnittsgehalt aller Programmierer?
SELECT COUNT(DISTINCT p.pnr)
FROM pers p
WHERE p.gehalt > (SELECT AVG(gehalt)
 FROM pers WHERE beruf = 'Programmierer');
 
SELECT COUNT(p.pnr)
FROM pers p
JOIN (
    SELECT AVG(gehalt) AS avg_gehalt
    FROM pers
    WHERE beruf = 'Programmierer'
) avg_table ON p.gehalt > avg_table.avg_gehalt;
 
 
//d) Welche Personen haben einen Chef der jünger ist als sie selbst?
SELECT Name
FROM Pers p1
WHERE p1.jahrg < (SELECT p2.jahrg FROM pers p2
 WHERE p2.pnr = p1.vnr);
 
SELECT p1.Name
FROM Pers p1
JOIN Pers p2 ON p1.vnr = p2.pnr AND p1.jahrg < p2.jahrg;
 
 
 
//e) Ermittle alle Personen, die in der gleichen Abteilung wie Hr. Junghans arbeiten und den gleichen Beruf haben.
SELECT DISTINCT name
FROM Pers
WHERE name != 'Junghans'
AND beruf = ANY(SELECT beruf FROM Pers
 WHERE name = 'Junghans')
AND anr = ANY(SELECT anr FROM Pers
 WHERE name = 'Junghans');
 
SELECT DISTINCT p2.name
FROM Pers p1 JOIN Pers p2 ON p1.name = 'Junghans' AND p1.beruf = p2.beruf AND p1.anr = p2.anr
WHERE p2.name != 'Junghans';
 
 
 
//f) Suche alle Mitarbeiter, deren Namen in der Firma nur einmal vorkommt.
SELECT DISTINCT name
FROM Pers p1
WHERE NOT EXISTS (SELECT * FROM Pers p2
 WHERE p1.name = p2.name
 AND p1.pnr != p2.pnr);
 
SELECT DISTINCT p1.name
FROM Pers p1
LEFT JOIN Pers p2 ON p1.name = p2.name AND p1.pnr != p2.pnr
WHERE p2.name IS NULL;

 
 
//g) Welche Mitarbeiternamen kommen in der Firma auch als Abteilungsname vor?
SELECT DISTINCT p.name
FROM Pers p
WHERE EXISTS (SELECT * FROM Abt a
 WHERE p.name = a.aname);
 
SELECT DISTINCT p.name
FROM Pers p
INNER JOIN Abt a ON p.name = a.aname;