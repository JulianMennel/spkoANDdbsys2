// LexerTime.g4
lexer grammar TimeintervalLexer;

Hours: (([1][0-2])|[0-9]);
Minutes: [0-5][0-9];
HoursText: [1][2] WS (MidnightNoon);
Seperator: ':';
AM: 'a.m.' | 'a.m' ;
PM: 'p.m.' | 'p.m' ;
MidnightNoon: 'midnight' | 'noon' | 'Midnight' | 'Noon';
Until: '-';
WS: ' ' ;