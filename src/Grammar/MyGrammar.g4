grammar MyGrammar;


assignment : TYPE? ID ASSIGN expr;

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
factor: NUM_ID | ID
      | LPARENT expr RPARENT;

// keywords
IF :    'if';
ELSE :  'else';
WHILE : 'while';
FOR : 'for';

// symbols
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

// numbers & identifier
ID : LETTER (LETTER|DIGIT)*;

NUM_ID : '0' | [1-9] DIGIT*;


fragment LETTER : [a-zA-Z];
fragment DIGIT : [0-9];

// comparison
COMP : EQ | NE | GE | GT | LE | LT;

fragment EQ : '==';
fragment NE : '!=';
fragment GE : '>=';
fragment GT : '>';
fragment LE : '<=';
fragment LT : '<';

// types
TYPE : TYPE_INT | TYPE_BOOL | TYPE_CHAR;

fragment TYPE_INT : 'int';
fragment TYPE_BOOL : 'bool';
fragment TYPE_CHAR : 'char';

//ignore whitespaces
WS : [ \t\n\r] -> skip;