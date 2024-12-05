grammar NaturalLangOps;

program: statement+;

statement
    : operation ';'           // Operaciones aritméticas existentes
    | booleanOperation ';'    // Operaciones booleanas
    | mostrarStatement ';'    // Mostrar variables
    | ifStatement             // if-else
    ;

// variable = {valor o variable} OPERACION ARITMETICA {valor o variable} 
// ese seria su equivalente en un lenguaje de programacion tradicional
operation: expr operador expr 'ES IGUAL A' ID; // Calcular un valor numerico y almacenarlo en una variable

// En una version anterior, se hacian calculos de tipo booleano
booleanOperation: expr comparator expr 'GUARDAR' ID; // unused

// Estructura del condicional
// IF (condicion) {codigo a ejecutar si se cumple} ELSE {codigo a ejecutar si no se cumple}
ifStatement: 'SI' condition 'ENTONCES' '{' statement+ '}' ('SINO' '{' statement+ '}')?;

// Estructura de una condicion
// {valor o variable} COMPARADOR {valor o variable}
condition: expr comparator expr;

// Imprimir el resultado numerico
mostrarStatement: 'MOSTRAR' ID;

// Expresiones permitidas 
expr: NUMERO // valores numericos
    | ID     // variables
    ;        // Aqui podria aumentar el soporte para más tipos de datos
             // como string, float, double, boolean etc.

// Operador: grupo para numeros enteros
// No se almacenan valores booleanos, unicamente se usan para las comparaciones
operador: 'MAS'
        | 'MENOS'
        | 'POR'
        | 'ENTRE'
        ;
// Comparador: grupo para valores booleanos
comparator: 'ES MAYOR'
          | 'ES MENOR'
          | 'ES IGUAL'
          | 'ES DISTINTO'
          ;

ID: [a-zA-Z][a-zA-Z0-9]*;   // Nombres de variables permitidos
NUMERO: [0-9]+;             // Números enteros permitidos
WS: [ \t\r\n]+ -> skip;     // Espacios en blanco
