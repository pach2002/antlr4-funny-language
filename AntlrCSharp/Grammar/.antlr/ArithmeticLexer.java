// Generated from c:/Users/julio/OneDrive/Documentos/ANTLR/AntlrCSharp/Grammar/Arithmetic.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ArithmeticLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, INT=5, SUMAR=6, RESTAR=7, MULTIPLICAR=8, 
		DIVIDIR=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "ID", "INT", "SUMAR", "RESTAR", "MULTIPLICAR", 
			"DIVIDIR", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Numero'", "'='", "';'", null, null, "'SUMAR'", "'RESTAR'", "'MULTIPLICAR'", 
			"'DIVIDIR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ID", "INT", "SUMAR", "RESTAR", "MULTIPLICAR", 
			"DIVIDIR", "WS"
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


	public ArithmeticLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Arithmetic.g4"; }

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
		"\u0004\u0000\nR\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003\"\b\u0003\u000b"+
		"\u0003\f\u0003#\u0001\u0004\u0004\u0004\'\b\u0004\u000b\u0004\f\u0004"+
		"(\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0004\tM\b\t\u000b\t\f\tN\u0001\t\u0001\t\u0000\u0000\n\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0001\u0000\u0003\u0002\u0000AZaz\u0001\u0000"+
		"09\u0003\u0000\t\n\r\r  T\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003\u001c\u0001\u0000"+
		"\u0000\u0000\u0005\u001e\u0001\u0000\u0000\u0000\u0007!\u0001\u0000\u0000"+
		"\u0000\t&\u0001\u0000\u0000\u0000\u000b*\u0001\u0000\u0000\u0000\r0\u0001"+
		"\u0000\u0000\u0000\u000f7\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000"+
		"\u0000\u0013L\u0001\u0000\u0000\u0000\u0015\u0016\u0005N\u0000\u0000\u0016"+
		"\u0017\u0005u\u0000\u0000\u0017\u0018\u0005m\u0000\u0000\u0018\u0019\u0005"+
		"e\u0000\u0000\u0019\u001a\u0005r\u0000\u0000\u001a\u001b\u0005o\u0000"+
		"\u0000\u001b\u0002\u0001\u0000\u0000\u0000\u001c\u001d\u0005=\u0000\u0000"+
		"\u001d\u0004\u0001\u0000\u0000\u0000\u001e\u001f\u0005;\u0000\u0000\u001f"+
		"\u0006\u0001\u0000\u0000\u0000 \"\u0007\u0000\u0000\u0000! \u0001\u0000"+
		"\u0000\u0000\"#\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001"+
		"\u0000\u0000\u0000$\b\u0001\u0000\u0000\u0000%\'\u0007\u0001\u0000\u0000"+
		"&%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000()\u0001\u0000\u0000\u0000)\n\u0001\u0000\u0000\u0000*+\u0005S\u0000"+
		"\u0000+,\u0005U\u0000\u0000,-\u0005M\u0000\u0000-.\u0005A\u0000\u0000"+
		"./\u0005R\u0000\u0000/\f\u0001\u0000\u0000\u000001\u0005R\u0000\u0000"+
		"12\u0005E\u0000\u000023\u0005S\u0000\u000034\u0005T\u0000\u000045\u0005"+
		"A\u0000\u000056\u0005R\u0000\u00006\u000e\u0001\u0000\u0000\u000078\u0005"+
		"M\u0000\u000089\u0005U\u0000\u00009:\u0005L\u0000\u0000:;\u0005T\u0000"+
		"\u0000;<\u0005I\u0000\u0000<=\u0005P\u0000\u0000=>\u0005L\u0000\u0000"+
		">?\u0005I\u0000\u0000?@\u0005C\u0000\u0000@A\u0005A\u0000\u0000AB\u0005"+
		"R\u0000\u0000B\u0010\u0001\u0000\u0000\u0000CD\u0005D\u0000\u0000DE\u0005"+
		"I\u0000\u0000EF\u0005V\u0000\u0000FG\u0005I\u0000\u0000GH\u0005D\u0000"+
		"\u0000HI\u0005I\u0000\u0000IJ\u0005R\u0000\u0000J\u0012\u0001\u0000\u0000"+
		"\u0000KM\u0007\u0002\u0000\u0000LK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PQ\u0006\t\u0000\u0000Q\u0014\u0001\u0000\u0000\u0000"+
		"\u0004\u0000#(N\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}