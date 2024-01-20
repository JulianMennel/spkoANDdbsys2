/*
a)
Auf Verknüpfung von ort und anr von Abt
ODER
Auf Verknüpfung von beruf, name und anr von Pers
*/

//b)
CREATE INDEX idx_department_location ON Abt(ort, anr);
CREATE INDEX idx_programmer_search ON Pers(beruf, name, anr);

EXPLAIN PLAN FOR
SELECT p.anr, min(p.gehalt), max(p.gehalt)
FROM Pers p INNER JOIN Abt a ON p.anr = a.anr
WHERE p.beruf = 'Programmierer'
AND p.name = 'Junghans'
AND a.ort = 'Erlangen'
GROUP BY p.anr
ORDER BY p.anr;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

//c)
UPDATE Pers
SET anr = 'K55'
WHERE pnr = 829;

INSERT INTO Abt Values('K100', 'Entwicklung2', 'Konstanz2');