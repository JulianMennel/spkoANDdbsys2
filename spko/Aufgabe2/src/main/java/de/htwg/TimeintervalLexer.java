// Generated from D:/Sprachkonzepte/Aufgabe2/src/main/java/de/htwg/TimeintervalLexer.g4 by ANTLR 4.13.1
package de.htwg;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TimeintervalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Hours=1, Minutes=2, HoursText=3, Seperator=4, AM=5, PM=6, MidnightNoon=7, 
		Until=8, WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Hours", "Minutes", "HoursText", "Seperator", "AM", "PM", "MidnightNoon", 
			"Until", "WS"
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


	public TimeintervalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TimeintervalLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\tR\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0017\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004*\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u00053\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006M\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0000\u0000\t"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0001\u0000\u0005\u0001\u000011\u0001\u000002\u0001"+
		"\u000009\u0001\u000005\u0001\u000022W\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0001\u0016"+
		"\u0001\u0000\u0000\u0000\u0003\u0018\u0001\u0000\u0000\u0000\u0005\u001b"+
		"\u0001\u0000\u0000\u0000\u0007 \u0001\u0000\u0000\u0000\t)\u0001\u0000"+
		"\u0000\u0000\u000b2\u0001\u0000\u0000\u0000\rL\u0001\u0000\u0000\u0000"+
		"\u000fN\u0001\u0000\u0000\u0000\u0011P\u0001\u0000\u0000\u0000\u0013\u0014"+
		"\u0007\u0000\u0000\u0000\u0014\u0017\u0007\u0001\u0000\u0000\u0015\u0017"+
		"\u0007\u0002\u0000\u0000\u0016\u0013\u0001\u0000\u0000\u0000\u0016\u0015"+
		"\u0001\u0000\u0000\u0000\u0017\u0002\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0007\u0003\u0000\u0000\u0019\u001a\u0007\u0002\u0000\u0000\u001a\u0004"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0007\u0000\u0000\u0000\u001c\u001d"+
		"\u0007\u0004\u0000\u0000\u001d\u001e\u0003\u0011\b\u0000\u001e\u001f\u0003"+
		"\r\u0006\u0000\u001f\u0006\u0001\u0000\u0000\u0000 !\u0005:\u0000\u0000"+
		"!\b\u0001\u0000\u0000\u0000\"#\u0005a\u0000\u0000#$\u0005.\u0000\u0000"+
		"$%\u0005m\u0000\u0000%*\u0005.\u0000\u0000&\'\u0005a\u0000\u0000\'(\u0005"+
		".\u0000\u0000(*\u0005m\u0000\u0000)\"\u0001\u0000\u0000\u0000)&\u0001"+
		"\u0000\u0000\u0000*\n\u0001\u0000\u0000\u0000+,\u0005p\u0000\u0000,-\u0005"+
		".\u0000\u0000-.\u0005m\u0000\u0000.3\u0005.\u0000\u0000/0\u0005p\u0000"+
		"\u000001\u0005.\u0000\u000013\u0005m\u0000\u00002+\u0001\u0000\u0000\u0000"+
		"2/\u0001\u0000\u0000\u00003\f\u0001\u0000\u0000\u000045\u0005m\u0000\u0000"+
		"56\u0005i\u0000\u000067\u0005d\u0000\u000078\u0005n\u0000\u000089\u0005"+
		"i\u0000\u00009:\u0005g\u0000\u0000:;\u0005h\u0000\u0000;M\u0005t\u0000"+
		"\u0000<=\u0005n\u0000\u0000=>\u0005o\u0000\u0000>?\u0005o\u0000\u0000"+
		"?M\u0005n\u0000\u0000@A\u0005M\u0000\u0000AB\u0005i\u0000\u0000BC\u0005"+
		"d\u0000\u0000CD\u0005n\u0000\u0000DE\u0005i\u0000\u0000EF\u0005g\u0000"+
		"\u0000FG\u0005h\u0000\u0000GM\u0005t\u0000\u0000HI\u0005N\u0000\u0000"+
		"IJ\u0005o\u0000\u0000JK\u0005o\u0000\u0000KM\u0005n\u0000\u0000L4\u0001"+
		"\u0000\u0000\u0000L<\u0001\u0000\u0000\u0000L@\u0001\u0000\u0000\u0000"+
		"LH\u0001\u0000\u0000\u0000M\u000e\u0001\u0000\u0000\u0000NO\u0005-\u0000"+
		"\u0000O\u0010\u0001\u0000\u0000\u0000PQ\u0005 \u0000\u0000Q\u0012\u0001"+
		"\u0000\u0000\u0000\u0005\u0000\u0016)2L\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}