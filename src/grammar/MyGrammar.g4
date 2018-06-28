grammar MyGrammar;

program : statement+;

assignment : TYPE ID ASSIGN expr                               # declAssign
           | ID ASSIGN expr                                    # varAssign
           | TYPE ID ASSIGN LSQBRAC expr (COMMA expr)* RSQBRAC # arrayDeclAssign
           | ID LSQBRAC expr RSQBRAC ASSIGN expr               # arrayAssign
           ;

statement : IF LPARENT comp RPARENT block (ELSE block)?          # ifStat
          | WHILE LPARENT comp RPARENT block                     # whileStat
          | FOR LPARENT assignment SC comp SC expr RPARENT block # forStat
          | FORK block                                           # forkStat
          | JOIN                                                 # joinStat
          | expr                                                 # exprStat
          | comment                                              # commentStat
          ;
          
block : LBRACE statement+ RBRACE;

comment : '#' (~('#'))* '#';

comp : expr COMP expr;

expr : expr ADD term # addExpr
     | expr NEG term # negExpr
     | term          # termExpr
     | assignment    # assignExpr
     ;
term: expo MULT term # multTerm
    | NEG term       # negTerm
    | expo           # expoTerm
    ;
expo: <assoc=right> factor EXP expo # expExpo
    | factor                        # factorExpo
    ;
factor: NUM                     # numFactor
      | BOOL                    # boolFactor
      | ID                      # varFactor
      | ID LSQBRAC expr RSQBRAC # arrayFactor
      | CHAR                    # charFactor
      | LPARENT expr RPARENT    # parFactor
      ;

// keywords
IF :    'if';
ELSE :  'else';
WHILE : 'while';
FOR : 'for';
FORK : 'fork';
JOIN : 'join';

// symbols
COMMA :   ',';
SC :      ';';
QUOTE :   '"';
SQUOTE :  '\'';
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

// types
TYPE : TYPE_INT | TYPE_BOOL | TYPE_CHAR;

fragment TYPE_INT : 'int';
fragment TYPE_BOOL : 'bool';
fragment TYPE_CHAR : 'char';

// variables
BOOL : 'true' | 'false';
ID : LETTER (LETTER|DIGIT)*;
NUM : '0' | [1-9] DIGIT*;
CHAR : SQUOTE ~('\'') SQUOTE;

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

//ignore whitespaces
WS : [ \t\n\r] -> skip;