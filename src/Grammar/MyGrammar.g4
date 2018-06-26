grammar MyGrammar;


statement: IF LPARENT comp RPARENT LBRACE statement+ (RBRACE ELSE LBRACE statement+)? RBRACE
         | WHILE LPARENT comp RPARENT LBRACE statement+ RBRACE
         | FOR LPARENT assignment SC comp SC expr RPARENT LBRACE statement+ RBRACE
         | expr;

comp: expr COMP expr;
expr: expr ADD term
    | expr NEG term
    | term;
term: expo MULT term
    | NEG term
    | expo;
expo: <assoc=right> factor EXP expo
    | factor;
factor: NUM
      | LPARENT expr RPARENT;


IF :    'if';
ELSE :  'else';
WHILE : 'while';


COMMA :   ',';
SC :      ';';
QUOTE :   '"';
ASSIGN :  '=';
LBRACE :  '{';
RBRACE :  '}';
LPARENT : '(';
RPARENT : ')';
LSQBRAC : '[';
RSQBRAC : ']';
EXP :     '^';
NEG :     '-';
MULT :    '*';
ADD :     '+';

NUM : '0' | ('1'..'9')('0'..'9')*;
COMP : EQ | NE | GE | GT | LE | LT;

fragment EQ : '==';
fragment NE : '!=';
fragment GE : '>=';
fragment GT : '>';
fragment LE : '<=';
fragment LT : '<';

//ignore whitespaces
WS : [ \t\n\r] -> skip;