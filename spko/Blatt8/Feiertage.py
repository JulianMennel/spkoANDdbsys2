import requests
import json

jahr = '2024'
bl = 'BW'

if (bl == '' or jahr == ''):
    raise Exception('Jahr oder Bundesland sind leer!')
else:
    api_url = 'https://feiertage-api.de/api/?jahr='+jahr+'&nur_land='+bl

#response = requests.get(api_url)
#print(response.json)

response = json.loads('{"Neujahrstag":{"datum":"2024-01-01","hinweis":""},"Heilige Drei K\u00f6nige":{"datum":"2024-01-06","hinweis":""},"Gr\u00fcndonnerstag":{"datum":"2024-03-28","hinweis":"Gem\u00e4\u00df \u00a7 4 Abs. 3 des Feiertagsgesetzes von Baden-W\u00fcrttemberg[10] haben Sch\u00fcler am Gr\u00fcndonnerstag und am Reformationstag schulfrei. In der Regel legt das Kultusministerium die Ferientermine so fest, dass diese beiden Tage in die Osterferien bzw. in die Herbstferien fallen."},"Karfreitag":{"datum":"2024-03-29","hinweis":""},"Ostermontag":{"datum":"2024-04-01","hinweis":""},"Tag der Arbeit":{"datum":"2024-05-01","hinweis":""},"Christi Himmelfahrt":{"datum":"2024-05-09","hinweis":""},"Pfingstmontag":{"datum":"2024-05-20","hinweis":""},"Fronleichnam":{"datum":"2024-05-30","hinweis":""},"Tag der Deutschen Einheit":{"datum":"2024-10-03","hinweis":""},"Reformationstag":{"datum":"2024-10-31","hinweis":"Gem\u00e4\u00df \u00a7 4 Abs. 3 des Feiertagsgesetzes von Baden-W\u00fcrttemberg[10] haben Sch\u00fcler am Gr\u00fcndonnerstag und am Reformationstag schulfrei. In der Regel legt das Kultusministerium die Ferientermine so fest, dass diese beiden Tage in die Osterferien bzw. in die Herbstferien fallen."},"Allerheiligen":{"datum":"2024-11-01","hinweis":""},"1. Weihnachtstag":{"datum":"2024-12-25","hinweis":""},"2. Weihnachtstag":{"datum":"2024-12-26","hinweis":""}}')

for key, value in response.items():
    datum = value['datum']
    hinweis = value['hinweis']
    hinweis2 = ''
    if (hinweis != ''):
        hinweis2 = f', \n -> Hinweis: {hinweis}'
    print(f'{key} \n -> Datum: {datum}'+hinweis2)


# deklarationsfreie Syntax: Python ist dynamisch typisiert, was bedeutet, dass Variablen deklariert werden können, ohne explizit den Datentyp anzugeben.
# Automatische Typkonvertierung: Die API-Antwort wird als String dargestellt und dann mit json.loads in ein Dictionary umgewandelt. Python übernimmt hier die automatische Typkonvertierung.
# Einfache Syntax: Python hat eine klare und einfache Syntax, was die Lesbarkeit des Codes erhöht. (keine klammern)