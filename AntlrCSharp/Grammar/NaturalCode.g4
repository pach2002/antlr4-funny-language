grammar NaturalCode;

/*
 * Parser Rules
 */

program            : statement+ EOF ;
statement          : forLoop | whileLoop | ifStatement | writeStatement ;
forLoop            : 'Para cada' IDENTIFIER 'en el rango de' NUMBER 'a' NUMBER 'Inicio' block 'Fin' ;
whileLoop          : 'Mientras' condition 'Inicio' block 'Fin' ;
ifStatement        : 'Si' condition 'Inicio' block ('De lo contrario' 'Inicio' block)? 'Fin' ;
writeStatement     : 'Escribir:' expression ;

block              : statement+ ; // Permite múltiples sentencias en el bloque

condition          : expression ;
expression         : IDENTIFIER operator value 
                   | IDENTIFIER operator IDENTIFIER
                   | IDENTIFIER
                   | NUMBER
                   | STRING
                   | expression '+' expression 
                   | expression '-' expression 
                   | expression '*' expression
                   | expression '/' expression
                   | '(' expression ')' ;

operator           : 'es mayor que' 
                   | 'es menor que' 
                   | 'es igual a' 
                   | 'es diferente de'
                   | '+' 
                   | '-' 
                   | '*' 
                   | '/' ;

value              : NUMBER 
                   | IDENTIFIER 
                   | STRING ;

NUMBER             : [0-9]+ ;
IDENTIFIER         : [a-zA-Z_][a-zA-Z0-9_]* ;
STRING             : '"' .*? '"' ;
WHITESPACE         : (' ' | '\t')+ -> skip ;
NEWLINE            : ('\r'? '\n' | '\r')+ ;
