SELECT NVL(Kundenalter, 0) as Kundenalter, NVL(Schlafzimmer_Anzahl, 0) as Schlafzimmer_Anzahl, NVL(Elektronik_Anzahl, 0) as Elektronik_Anzahl, NVL(K�che_Anzahl, 0) as K�che_Anzahl, NVL(Textilien_Anzahl, 0) as Textilien_Anzahl, NVL(Wohnzimmer_Anzahl, 0) as Wohnzimmer_Anzahl
FROM (Select Kundenalter, Produktgruppenname, Anzahl From Verkauf_2DC)
PIVOT(
 SUM(anzahl) as anzahl
 FOR Produktgruppenname
 IN (
 'Schlafzimmer' as Schlafzimmer,
 'Elektronik' as Elektronik,
 'K�che' as K�che,
 'Textilien' as Textilien,
 'Wohnzimmer' as Wohnzimmer)
);