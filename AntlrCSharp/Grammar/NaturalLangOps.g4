grammar NaturalLangOps;

program: statement+;

statement
    : operation ';'           // Operaciones aritméticas existentes
    | booleanOperation ';'    // Nueva regla para operaciones booleanas
    | mostrarStatement ';'    // Nueva regla para mostrar variables
    ;

operation: expr operador expr 'ES IGUAL A' ID;

booleanOperation: expr comparator expr 'GUARDAR' ID;

mostrarStatement: 'MOSTRAR' ID;

expr: NUMERO
    | ID
    ;

operador: 'MAS'
        | 'MENOS'
        | 'POR'
        | 'ENTRE'
        ;

comparator: 'ES MAYOR'
          | 'ES MENOR'
          | 'ES IGUAL'
          | 'ES DISTINTO'
          ;

ID: [a-zA-Z][a-zA-Z0-9]*; // Identificadores de variable
NUMERO: [0-9]+; // Números enteros
WS: [ \t\r\n]+ -> skip; // Espacios en blanco
