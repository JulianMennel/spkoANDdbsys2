// Generated from D:/Sprachkonzepte/Aufgabe2/src/main/java/de/htwg/TimeintervalParser.g4 by ANTLR 4.13.1
package de.htwg;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TimeintervalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Hours=1, Minutes=2, HoursText=3, Seperator=4, AM=5, PM=6, MidnightNoon=7, 
		Until=8, WS=9;
	public static final int
		RULE_timeinterval = 0, RULE_uhrzeit = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"timeinterval", "uhrzeit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "':'", null, null, null, "'-'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Hours", "Minutes", "HoursText", "Seperator", "AM", "PM", "MidnightNoon", 
			"Until", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TimeintervalParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TimeintervalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeintervalContext extends ParserRuleContext {
		public List<UhrzeitContext> uhrzeit() {
			return getRuleContexts(UhrzeitContext.class);
		}
		public UhrzeitContext uhrzeit(int i) {
			return getRuleContext(UhrzeitContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(TimeintervalParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(TimeintervalParser.WS, i);
		}
		public TerminalNode Until() { return getToken(TimeintervalParser.Until, 0); }
		public TimeintervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeinterval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TimeintervalParserListener ) ((TimeintervalParserListener)listener).enterTimeinterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TimeintervalParserListener ) ((TimeintervalParserListener)listener).exitTimeinterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimeintervalParserVisitor ) return ((TimeintervalParserVisitor<? extends T>)visitor).visitTimeinterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeintervalContext timeinterval() throws RecognitionException {
		TimeintervalContext _localctx = new TimeintervalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_timeinterval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			uhrzeit();
			setState(5);
			match(WS);
			setState(6);
			match(Until);
			setState(7);
			match(WS);
			setState(8);
			uhrzeit();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UhrzeitContext extends ParserRuleContext {
		public TerminalNode Hours() { return getToken(TimeintervalParser.Hours, 0); }
		public TerminalNode Seperator() { return getToken(TimeintervalParser.Seperator, 0); }
		public TerminalNode Minutes() { return getToken(TimeintervalParser.Minutes, 0); }
		public TerminalNode WS() { return getToken(TimeintervalParser.WS, 0); }
		public TerminalNode AM() { return getToken(TimeintervalParser.AM, 0); }
		public TerminalNode PM() { return getToken(TimeintervalParser.PM, 0); }
		public TerminalNode MidnightNoon() { return getToken(TimeintervalParser.MidnightNoon, 0); }
		public TerminalNode HoursText() { return getToken(TimeintervalParser.HoursText, 0); }
		public UhrzeitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uhrzeit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TimeintervalParserListener ) ((TimeintervalParserListener)listener).enterUhrzeit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TimeintervalParserListener ) ((TimeintervalParserListener)listener).exitUhrzeit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimeintervalParserVisitor ) return ((TimeintervalParserVisitor<? extends T>)visitor).visitUhrzeit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UhrzeitContext uhrzeit() throws RecognitionException {
		UhrzeitContext _localctx = new UhrzeitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_uhrzeit);
		int _la;
		try {
			setState(17);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Hours:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(10);
				match(Hours);
				setState(11);
				match(Seperator);
				setState(12);
				match(Minutes);
				setState(13);
				match(WS);
				setState(14);
				_la = _input.LA(1);
				if ( !(_la==AM || _la==PM) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				break;
			case MidnightNoon:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(15);
				match(MidnightNoon);
				}
				}
				break;
			case HoursText:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(16);
				match(HoursText);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\t\u0014\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u0012\b\u0001\u0001\u0001\u0000\u0000\u0002\u0000\u0002"+
		"\u0000\u0001\u0001\u0000\u0005\u0006\u0013\u0000\u0004\u0001\u0000\u0000"+
		"\u0000\u0002\u0011\u0001\u0000\u0000\u0000\u0004\u0005\u0003\u0002\u0001"+
		"\u0000\u0005\u0006\u0005\t\u0000\u0000\u0006\u0007\u0005\b\u0000\u0000"+
		"\u0007\b\u0005\t\u0000\u0000\b\t\u0003\u0002\u0001\u0000\t\u0001\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0005\u0001\u0000\u0000\u000b\f\u0005\u0004"+
		"\u0000\u0000\f\r\u0005\u0002\u0000\u0000\r\u000e\u0005\t\u0000\u0000\u000e"+
		"\u0012\u0007\u0000\u0000\u0000\u000f\u0012\u0005\u0007\u0000\u0000\u0010"+
		"\u0012\u0005\u0003\u0000\u0000\u0011\n\u0001\u0000\u0000\u0000\u0011\u000f"+
		"\u0001\u0000\u0000\u0000\u0011\u0010\u0001\u0000\u0000\u0000\u0012\u0003"+
		"\u0001\u0000\u0000\u0000\u0001\u0011";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}