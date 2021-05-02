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

tcl	:	procs_statement modulo_ppal EOF;

procs_statement  : proc_statement* ;
proc_statement	:
'proc'
IDENTIFIER
s='{'
                                            { factory.startFunction($IDENTIFIER, $s); }
    args_statement
'}'
    body=body_statement                     { factory.finishFunction($body.result); }
;
args_statement	:	'{'
IDENTIFIER                                  { factory.addFormalParameter($IDENTIFIER); }
 '}' args_statement |  ;

body_statement returns [SLStatementNode result]:
                                            { factory.startBlock();
                                            List<SLStatementNode> body = new ArrayList<>(); }
s='{'
(
    statement                               { body.add($statement.result); }
)*
e='}'
                                            { $result = factory.finishBlock(body, $s.getStartIndex(), $e.getStopIndex() - $s.getStartIndex() + 1); }
;

statement returns [SLStatementNode result]:
set                                         { $result = $set.result; }
|
puts                                        { $result = $puts.result; }
|
gets ';'                                    { $result = $gets.result; }
|
if_statement                                { $result = $if_statement.result; }
|
for_statement                               { $result = $for_statement.result; }
|
while_statement                             { $result = $while_statement.result; }
|
switch_statement                            { $result = $switch_statement.result; }
|
r_return                                    { $result = $r_return.result; }
|
agroup                                      { $result = $agroup.result; }
';';

if_statement	:	start_if body_statement '}' elseif_statement  ;
elseif_statement	:	start_elseif body_statement '}' elseif_statement | else_statement  ;
else_statement	:	start_else body_statement '}' |  ;

switch_statement	:	start_switch case_statement '}'  ;
case_statement	:	start_case body_statement '}' case2_statement  ;
case2_statement	:	start_case body_statement '}' case2_statement | default_statement  ;
default_statement	:	start_default body_statement '}' |  ;

for_statement	:	start_for body_loop_func '}'  ;
while_statement	:	start_while body_loop_func '}'  ;

body_loop_func	:	r_break body_loop_func | r_continue body_loop_func | set body_loop_func
					| gets ';' body_loop_func | puts body_loop_func | r_return body_loop_func
					| if_loop_func body_loop_func | switch_loop_func body_loop_func | for_statement body_loop_func
					| while_statement body_loop_func | agroup ';' body_loop_func |  ;

if_loop_func	:	start_if body_loop_func '}' elseif_loop_func  ;
elseif_loop_func	:	start_elseif body_loop_func '}' elseif_loop_func | else_loop_func  ;
else_loop_func	:	start_else body_loop_func '}' |  ;

switch_loop_func	:	start_switch case_loop_func '}'  ;
case_loop_func	:	start_case body_loop_func '}' case2_loop_func  ;
case2_loop_func	:	start_case body_loop_func '}' case2_loop_func | default_loop_func  ;
default_loop_func	:	start_default body_loop_func '}' |  ;

modulo_ppal	:	set modulo_ppal | r_for modulo_ppal | gets ';' modulo_ppal | r_if modulo_ppal
			| puts modulo_ppal | r_while modulo_ppal | r_switch modulo_ppal | agroup ';' modulo_ppal |  ;

r_if	:	start_if body_inst '}' elseif  ;
elseif	:	start_elseif body_inst '}' elseif | r_else  ;
r_else	:	start_else body_inst '}' |  ;

r_switch	:	start_switch r_case '}'  ;
r_case	:	start_case body_inst '}' case2  ;
case2	:	start_case body_inst '}' case2 | r_default  ;
r_default	:	start_default body_inst '}' |  ;

body_inst	:	set body_inst | r_for body_inst | gets ';' body_inst | r_if body_inst
			| puts body_inst | r_while body_inst | r_switch body_inst | agroup ';' body_inst |  ;

r_for	:	start_for body_loop '}'  ;
r_while	:	start_while body_loop '}'  ;

body_loop	:	set body_loop | r_for body_loop | gets ';' body_loop | if_loop body_loop
			| puts body_loop | r_while body_loop | switch_loop body_loop | r_break body_loop
			| r_continue body_loop | agroup ';' body_loop |  ;

if_loop	:	start_if body_loop '}' elseif_loop  ;
elseif_loop	:	start_elseif body_loop '}' elseif_loop | else_loop  ;
else_loop	:	start_else body_loop '}' |  ;

switch_loop	:	start_switch case_loop '}'  ;
case_loop	:	start_case body_loop '}' case2_loop  ;
case2_loop	:	start_case body_loop '}' case2_loop | default_loop  ;
default_loop	:	start_default body_loop '}' |  ;

puts	:	'puts' assignment ';'  ;
gets	:	'gets' 'stdin'  ;
set	:	'set' IDENTIFIER index assignment ';'  ;

agroup	:	'[' aux_agroup  ;
aux_agroup	:	expr ']' | IDENTIFIER param_func ']' | gets ']' | 'array' aux_array  ;
aux_array	:	'size' IDENTIFIER ']' | 'exists' IDENTIFIER ']'  ;

param_func	:	'{' aux_param |  ;
aux_param	:	assignment '}' param_func | expr '}' param_func  ;

assignment	:	value | '$' IDENTIFIER index | agroup  ;

index	:	'(' val_index ')' |  ;
val_index	:	value | agroup | '$' IDENTIFIER index ;

value	:	VALUE_STRING | VALUE_INTEGER | VALUE_DOUBLE  ;

increment	:	VALUE_INTEGER |  ;

r_break	:	'break' ';'  ;
r_continue	:	'continue' ';'  ;
r_return	:	'return' value_return ';'  ;
value_return	:	assignment |  ;

expr	:	'expr' '{' expresion '}'  ;
asig_for	:	VALUE_INTEGER | '$' IDENTIFIER index | expr  ;

start_if	:	'if' '{' expresion '}' 'then' '{'  ;
start_elseif	:	'elseif' '{' expresion '}' 'then' '{'  ;
start_else	:	'else' '{'  ;
start_switch	:	'switch' '$' IDENTIFIER index '{'  ;
start_case	:	'case' VALUE_INTEGER '{'  ;
start_default	:	'default' '{'  ;

start_for	:	'for' '{' dec_for '}' '{' expresion '}' '{' 'incr' IDENTIFIER increment '}' '{'  ;
dec_for : 'set' IDENTIFIER asig_for ;

start_while	:	'while' '{' expresion '}' '{'  ;

expresion	:	exp_or  ;
exp_or	:	exp_or '||' exp_and | exp_and  ;
exp_and	:	exp_and '&&' exp_ig | exp_ig  ;
exp_ig	:	exp_ig op_ig exp_rel | exp_rel  ;
exp_rel	:	exp_rel op_rel exp_add | exp_add  ;
exp_add	:	exp_add op_add exp_mul | exp_mul  ;
exp_mul	:	exp_mul op_mul exp_pot | exp_pot  ;
exp_pot	:	exp_pot '**' exp_una | exp_una  ;
exp_una	:	op_una exp_una | term  ;
term	:	'$' IDENTIFIER index | agroup | value | '(' exp_or ')'  ;


op_ig	:	'eq' | '==' | 'ne' | '!='  ;
op_rel	:	'>' | '<' | '>=' | '<='  ;
op_add	:	'+' | '-'  ;
op_mul	:	'*' | '/' | '%'  ;
op_una	:	'-' | '!'  ;


IDENTIFIER	:	[a-zA-Z_][a-zA-Z0-9_]*  ;
VALUE_INTEGER	:	'-'?[0-9]+  ;
VALUE_DOUBLE	:	[0-9]+ '.' [0-9]+  ;
VALUE_STRING	:	'"' ~[\r\n"]* '"'  ;
WS	:	[ \t\r\n]+	->	skip  ;
COMMENT	:	'#' ~[\r\n]*	->	skip  ;

