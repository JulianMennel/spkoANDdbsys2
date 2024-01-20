// LexerTime.g4
grammar LexerTime;

uhrzeit: (Hours Seperator Minutes WS (AM|PM))|(JUSTTEXT)|(HoursText);

Hours: (([1][0-2])|[0-9]);
Minutes: [0-5][0-9];
HoursText: [1][2] WS (JUSTTEXT|JUSTTEXTSMALL);
Seperator: ':';
AM: 'a.m.' | 'a.m' ;
PM: 'p.m.' | 'p.m' ;
JUSTTEXT: 'Midnight' | 'Noon';
JUSTTEXTSMALL: 'midnight' | 'noon';

WS: ' ' ;