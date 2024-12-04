grammar NaturalLangOps;

program: statement+;

statement: operation ';' ;

operation: expr operador expr 'es' 'igual' 'a' ID ;

expr: NUMERO
    | ID
    ;

operador: 'MAS'
        | 'MENOS'
        | 'POR'
        | 'ENTRE'
        ;

ID: [a-zA-Z][a-zA-Z0-9]*; // Identificadores de variable
NUMERO: [0-9]+; // Números enteros
WS: [ \t\r\n]+ -> skip; // Espacios en blanco
