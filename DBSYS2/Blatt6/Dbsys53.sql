SET TRANSACTION ISOLATION LEVEL serializable;

SELECT SUM(kontostand) FROM girokonto
WHERE land = 'D';
SELECT SUM(kontostand) FROM girokonto
WHERE land = 'CH';
COMMIT;