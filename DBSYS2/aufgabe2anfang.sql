CREATE TABLE VERKAEUFER (
verkaeuferID INTEGER NOT NULL PRIMARY KEY,
verkaeufername varchar(255),
geburtsdatum DATE,
fachgebiet varchar(255)
);

CREATE TABLE FILIALE(
filialID INTEGER NOT NULL PRIMARY KEY,
filialleiter varchar(255),
stadtname varchar(255),
bezirksname varchar(255),
landname varchar(255)
);

CREATE TABLE KUNDE(
kundenID INTEGER NOT NULL PRIMARY KEY,
kundenname varchar(255),
kundenalter INTEGER,
stadtname varchar(255),
bezirksname varchar(255),
landname varchar(255)
);

CREATE TABLE PRODUKT(
produktID INTEGER NOT NULL PRIMARY KEY,
produktname varchar(255),
produktgruppenname varchar(255),
herstellername varchar(255),
preis INTEGER,
stadtname varchar(255),
bezirksname varchar(255),
landname varchar(255)
);

CREATE TABLE VERKAUF (
verkaufID INTEGER NOT NULL PRIMARY KEY,
anzahl INTEGER,
datum DATE,
verkaeuferID INTEGER REFERENCES VERKAEUFER(verkaeuferID),
filialID INTEGER REFERENCES FILIALE(filialID),
kundenID INTEGER REFERENCES KUNDE(kundenID),
produktID INTEGER REFERENCES PRODUKT(produktID)
);