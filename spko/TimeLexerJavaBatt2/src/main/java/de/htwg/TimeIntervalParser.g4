parser grammar TimeIntervalParser;

options { tokenVocab=TimeIntervalLexer; }

timeinterval: uhrzeit WS Until WS uhrzeit;

uhrzeit: (Hours Seperator Minutes WS (AM|PM))|(MidnightNoon)|(HoursText);