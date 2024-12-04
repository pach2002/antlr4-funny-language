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
public class MichLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, SUMAR=7, RESTAR=8, MULTIPLICAR=9, 
		DIVIDIR=10, ID=11, INT=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "SUMAR", "RESTAR", "MULTIPLICAR", 
			"DIVIDIR", "ID", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Numero'", "'='", "';'", "'('", "','", "')'", "'SUMAR'", "'RESTAR'", 
			"'MULTIPLICAR'", "'DIVIDIR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "SUMAR", "RESTAR", "MULTIPLICAR", 
			"DIVIDIR", "ID", "INT", "WS"
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


	public MichLexer(CharStream input) {
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
		"\u0004\u0000\r^\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0004\nO\b"+
		"\n\u000b\n\f\nP\u0001\u000b\u0004\u000bT\b\u000b\u000b\u000b\f\u000bU"+
		"\u0001\f\u0004\fY\b\f\u000b\f\f\fZ\u0001\f\u0001\f\u0000\u0000\r\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0003"+
		"\u0002\u0000AZaz\u0001\u000009\u0003\u0000\t\n\r\r  `\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0003\"\u0001\u0000\u0000\u0000"+
		"\u0005$\u0001\u0000\u0000\u0000\u0007&\u0001\u0000\u0000\u0000\t(\u0001"+
		"\u0000\u0000\u0000\u000b*\u0001\u0000\u0000\u0000\r,\u0001\u0000\u0000"+
		"\u0000\u000f2\u0001\u0000\u0000\u0000\u00119\u0001\u0000\u0000\u0000\u0013"+
		"E\u0001\u0000\u0000\u0000\u0015N\u0001\u0000\u0000\u0000\u0017S\u0001"+
		"\u0000\u0000\u0000\u0019X\u0001\u0000\u0000\u0000\u001b\u001c\u0005N\u0000"+
		"\u0000\u001c\u001d\u0005u\u0000\u0000\u001d\u001e\u0005m\u0000\u0000\u001e"+
		"\u001f\u0005e\u0000\u0000\u001f \u0005r\u0000\u0000 !\u0005o\u0000\u0000"+
		"!\u0002\u0001\u0000\u0000\u0000\"#\u0005=\u0000\u0000#\u0004\u0001\u0000"+
		"\u0000\u0000$%\u0005;\u0000\u0000%\u0006\u0001\u0000\u0000\u0000&\'\u0005"+
		"(\u0000\u0000\'\b\u0001\u0000\u0000\u0000()\u0005,\u0000\u0000)\n\u0001"+
		"\u0000\u0000\u0000*+\u0005)\u0000\u0000+\f\u0001\u0000\u0000\u0000,-\u0005"+
		"S\u0000\u0000-.\u0005U\u0000\u0000./\u0005M\u0000\u0000/0\u0005A\u0000"+
		"\u000001\u0005R\u0000\u00001\u000e\u0001\u0000\u0000\u000023\u0005R\u0000"+
		"\u000034\u0005E\u0000\u000045\u0005S\u0000\u000056\u0005T\u0000\u0000"+
		"67\u0005A\u0000\u000078\u0005R\u0000\u00008\u0010\u0001\u0000\u0000\u0000"+
		"9:\u0005M\u0000\u0000:;\u0005U\u0000\u0000;<\u0005L\u0000\u0000<=\u0005"+
		"T\u0000\u0000=>\u0005I\u0000\u0000>?\u0005P\u0000\u0000?@\u0005L\u0000"+
		"\u0000@A\u0005I\u0000\u0000AB\u0005C\u0000\u0000BC\u0005A\u0000\u0000"+
		"CD\u0005R\u0000\u0000D\u0012\u0001\u0000\u0000\u0000EF\u0005D\u0000\u0000"+
		"FG\u0005I\u0000\u0000GH\u0005V\u0000\u0000HI\u0005I\u0000\u0000IJ\u0005"+
		"D\u0000\u0000JK\u0005I\u0000\u0000KL\u0005R\u0000\u0000L\u0014\u0001\u0000"+
		"\u0000\u0000MO\u0007\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"Q\u0016\u0001\u0000\u0000\u0000RT\u0007\u0001\u0000\u0000SR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000V\u0018\u0001\u0000\u0000\u0000WY\u0007\u0002\u0000"+
		"\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0006"+
		"\f\u0000\u0000]\u001a\u0001\u0000\u0000\u0000\u0004\u0000PUZ\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}