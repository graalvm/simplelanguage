/*
 * The parser and lexer need to be generated using "mx create-tcl-parser".
 */
grammar Tcl;

@parser::header
{
// DO NOT MODIFY - generated from SimpleLanguage.g4 using "mx create-sl-parser"
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.tcl.SLLanguage;
import com.oracle.truffle.tcl.nodes.SLExpressionNode;
import com.oracle.truffle.tcl.nodes.SLRootNode;
import com.oracle.truffle.tcl.nodes.SLStatementNode;
import com.oracle.truffle.tcl.parser.TclParseError;
}

@lexer::header
{
// DO NOT MODIFY - generated from SimpleLanguage.g4 using "mx create-sl-parser"
}

@parser::members
{
private TclNodeFactory factory;
private Source source;
private static final class BailoutErrorListener extends BaseErrorListener {
    private final Source source;
    BailoutErrorListener(Source source) {
        this.source = source;
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throwParseError(source, line, charPositionInLine, (Token) offendingSymbol, msg);
    }
}

public void SemErr(Token token, String message) {
    assert token != null;
    throwParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
}

private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
    int col = charPositionInLine + 1;
    String location = "-- line " + line + " col " + col + ": ";
    int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
    throw new TclParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
}

public static Map<String, RootCallTarget> parseSL( SLLanguage language, Source source) {
    TclLexer lexer = new TclLexer(CharStreams.fromString(source.getCharacters().toString()));
    TclParser parser = new TclParser(new CommonTokenStream(lexer));
    lexer.removeErrorListeners();
    parser.removeErrorListeners();
    BailoutErrorListener listener = new BailoutErrorListener(source);
    lexer.addErrorListener(listener);
    parser.addErrorListener(listener);
    parser.factory = new TclNodeFactory(language, source);
    parser.source = source;
    parser.tcl();
    return parser.factory.getAllFunctions();
}
}

// parser

tcl	:	declaracion_funcion modulo_ppal ;

declaracion_funcion	:	'proc' IDENTIFICADOR '{' args_funcion '}' '{' cuerpo_funcion '}' declaracion_funcion |  ;
args_funcion	:	'{' IDENTIFICADOR '}' args_funcion |  ;

cuerpo_funcion	:	declaracion cuerpo_funcion | puts cuerpo_funcion | gets ';' cuerpo_funcion | if_funcion cuerpo_funcion
				| for_funcion cuerpo_funcion | while_funcion cuerpo_funcion | switch_funcion cuerpo_funcion
				| r_return cuerpo_funcion | agrup ';' cuerpo_funcion |  ;

if_funcion	:	inicio_if cuerpo_funcion '}' elseif_funcion  ;
elseif_funcion	:	inicio_elseif cuerpo_funcion '}' elseif_funcion | else_funcion  ;
else_funcion	:	inicio_else cuerpo_funcion '}' |  ;

switch_funcion	:	inicio_switch case_funcion '}'  ;
case_funcion	:	inicio_case cuerpo_funcion '}' case2_funcion  ;
case2_funcion	:	inicio_case cuerpo_funcion '}' case2_funcion | default_funcion  ;
default_funcion	:	inicio_default cuerpo_funcion '}' |  ;

for_funcion	:	inicio_for cuerpo_loop_func '}'  ;
while_funcion	:	inicio_while cuerpo_loop_func '}'  ;

cuerpo_loop_func	:	r_break cuerpo_loop_func | r_continue cuerpo_loop_func | declaracion cuerpo_loop_func
					| gets ';' cuerpo_loop_func | puts cuerpo_loop_func | r_return cuerpo_loop_func
					| if_loop_func cuerpo_loop_func | switch_loop_func cuerpo_loop_func | for_funcion cuerpo_loop_func
					| while_funcion cuerpo_loop_func | agrup ';' cuerpo_loop_func |  ;

if_loop_func	:	inicio_if cuerpo_loop_func '}' elseif_loop_func  ;
elseif_loop_func	:	inicio_elseif cuerpo_loop_func '}' elseif_loop_func | else_loop_func  ;
else_loop_func	:	inicio_else cuerpo_loop_func '}' |  ;

switch_loop_func	:	inicio_switch case_loop_func '}'  ;
case_loop_func	:	inicio_case cuerpo_loop_func '}' case2_loop_func  ;
case2_loop_func	:	inicio_case cuerpo_loop_func '}' case2_loop_func | default_loop_func  ;
default_loop_func	:	inicio_default cuerpo_loop_func '}' |  ;

modulo_ppal	:	declaracion modulo_ppal | r_for modulo_ppal | gets ';' modulo_ppal | r_if modulo_ppal
			| puts modulo_ppal | r_while modulo_ppal | r_switch modulo_ppal | agrup ';' modulo_ppal |  ;

r_if	:	inicio_if cuerpo_inst '}' elseif  ;
elseif	:	inicio_elseif cuerpo_inst '}' elseif | r_else  ;
r_else	:	inicio_else cuerpo_inst '}' |  ;

r_switch	:	inicio_switch r_case '}'  ;
r_case	:	inicio_case cuerpo_inst '}' case2  ;
case2	:	inicio_case cuerpo_inst '}' case2 | r_default  ;
r_default	:	inicio_default cuerpo_inst '}' |  ;

cuerpo_inst	:	declaracion cuerpo_inst | r_for cuerpo_inst | gets ';' cuerpo_inst | r_if cuerpo_inst
			| puts cuerpo_inst | r_while cuerpo_inst | r_switch cuerpo_inst | agrup ';' cuerpo_inst |  ;

r_for	:	inicio_for cuerpo_loop '}'  ;
r_while	:	inicio_while cuerpo_loop '}'  ;

cuerpo_loop	:	declaracion cuerpo_loop | r_for cuerpo_loop | gets ';' cuerpo_loop | if_loop cuerpo_loop
			| puts cuerpo_loop | r_while cuerpo_loop | switch_loop cuerpo_loop | r_break cuerpo_loop
			| r_continue cuerpo_loop | agrup ';' cuerpo_loop |  ;

if_loop	:	inicio_if cuerpo_loop '}' elseif_loop  ;
elseif_loop	:	inicio_elseif cuerpo_loop '}' elseif_loop | else_loop  ;
else_loop	:	inicio_else cuerpo_loop '}' |  ;

switch_loop	:	inicio_switch case_loop '}'  ;
case_loop	:	inicio_case cuerpo_loop '}' case2_loop  ;
case2_loop	:	inicio_case cuerpo_loop '}' case2_loop | default_loop  ;
default_loop	:	inicio_default cuerpo_loop '}' |  ;

puts	:	'puts' asignacion ';'  ;
gets	:	'gets' 'stdin'  ;
declaracion	:	'set' IDENTIFICADOR indice asignacion ';'  ;

agrup	:	'[' aux_agrup  ;
aux_agrup	:	expr ']' | IDENTIFICADOR param_func ']' | gets ']' | 'array' aux_array  ;
aux_array	:	'size' IDENTIFICADOR ']' | 'exists' IDENTIFICADOR ']'  ;

param_func	:	'{' aux_param |  ;
aux_param	:	asignacion '}' param_func | expr '}' param_func  ;

asignacion	:	valor | '$' IDENTIFICADOR indice | agrup  ;

indice	:	'(' val_indice ')' |  ;
val_indice	:	valor | agrup | '$' IDENTIFICADOR indice ;

valor	:	VALOR_STRING | VALOR_ENTERO | VALOR_DOUBLE  ;

incremento	:	VALOR_ENTERO |  ;

r_break	:	'break' ';'  ;
r_continue	:	'continue' ';'  ;
r_return	:	'return' value_return ';'  ;
value_return	:	asignacion |  ;

expr	:	'expr' '{' expresion '}'  ;
asig_for	:	VALOR_ENTERO | '$' IDENTIFICADOR indice | expr  ;

inicio_if	:	'if' '{' expresion '}' 'then' '{'  ;
inicio_elseif	:	'elseif' '{' expresion '}' 'then' '{'  ;
inicio_else	:	'else' '{'  ;
inicio_switch	:	'switch' '$' IDENTIFICADOR indice '{'  ;
inicio_case	:	'case' VALOR_ENTERO '{'  ;
inicio_default	:	'default' '{'  ;

inicio_for	:	'for' '{' dec_for '}' '{' expresion '}' '{' 'incr' IDENTIFICADOR incremento '}' '{'  ;
dec_for : 'set' IDENTIFICADOR asig_for ;

inicio_while	:	'while' '{' expresion '}' '{'  ;

expresion	:	exp_or  ;
exp_or	:	exp_or '||' exp_and | exp_and  ;
exp_and	:	exp_and '&&' exp_ig | exp_ig  ;
exp_ig	:	exp_ig op_ig exp_rel | exp_rel  ;
exp_rel	:	exp_rel op_rel exp_add | exp_add  ;
exp_add	:	exp_add op_add exp_mul | exp_mul  ;
exp_mul	:	exp_mul op_mul exp_pot | exp_pot  ;
exp_pot	:	exp_pot '**' exp_una | exp_una  ;
exp_una	:	op_una exp_una | term  ;
term	:	'$' IDENTIFICADOR indice | agrup | valor | '(' exp_or ')'  ;


op_ig	:	'eq' | '==' | 'ne' | '!='  ;
op_rel	:	'>' | '<' | '>=' | '<='  ;
op_add	:	'+' | '-'  ;
op_mul	:	'*' | '/' | '%'  ;
op_una	:	'-' | '!'  ;


IDENTIFICADOR	:	[a-zA-Z_][a-zA-Z0-9_]*  ;
VALOR_ENTERO	:	'-'?[0-9]+  ;
VALOR_DOUBLE	:	[0-9]+ '.' [0-9]+  ;
VALOR_STRING	:	'"' ~[\r\n"]* '"'  ;
WS	:	[ \t\r\n]+	->	skip  ;
COMMENT	:	'#' ~[\r\n]*	->	skip  ;

