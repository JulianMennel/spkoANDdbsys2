SELECT NVL(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM Geburtsdatum), 0) AS VerkaeuferAlter, NVL(EXTRACT(YEAR FROM F.Datum), 0) as Jahr, NVL(P.Produktgruppenname, 'ALLE')as Produktgruppenname, SUM(P.Preis) as Umsatz
FROM Verkaeufer V, Verkauf F, Produkt P
WHERE F.Verkaeuferid = V.Verkaeuferid
AND F.Produktid = P.Produktid
GROUP BY ROLLUP (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM Geburtsdatum), EXTRACT(YEAR FROM F.Datum), P.Produktgruppenname)
ORDER BY VerkaeuferAlter ASC, Umsatz DESC;

SELECT NVL(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM Geburtsdatum), 0) AS VerkaeuferAlter, NVL(EXTRACT(YEAR FROM F.Datum), 0) as Jahr, NVL(P.Produktgruppenname, 'ALLE')as Produktgruppenname, SUM(P.Preis) as Umsatz
FROM Verkaeufer V, Verkauf F, Produkt P
WHERE F.Verkaeuferid = V.Verkaeuferid
AND F.Produktid = P.Produktid
GROUP BY CUBE (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM Geburtsdatum), EXTRACT(YEAR FROM F.Datum), P.Produktgruppenname)
ORDER BY VerkaeuferAlter ASC, Umsatz DESC;