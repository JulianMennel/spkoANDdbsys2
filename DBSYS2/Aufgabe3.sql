CREATE TABLE Verkauf_2DC as
SELECT NVL(K.Kundenalter, 0) as Kundenalter, NVL(P.Produktgruppenname,'ALLE') as Produktgruppenname, SUM(NVL(V.Anzahl, 0)) as Anzahl
FROM Kunde K, Produkt P, Verkauf V
WHERE K.Kundenid = V.Kundenid
AND P.Produktid = V.Produktid
AND EXTRACT(YEAR FROM V.datum) >= 2020
GROUP BY CUBE(K.Kundenalter, P.Produktgruppenname);