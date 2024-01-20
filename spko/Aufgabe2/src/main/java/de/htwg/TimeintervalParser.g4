//TimeintervalParser.g4
parser grammar TimeintervalParser;

options { tokenVocab=TimeintervalLexer; }

timeinterval: uhrzeit WS Until WS uhrzeit;

uhrzeit: (Hours Seperator Minutes WS (AM|PM))|(MidnightNoon)|(HoursText);
