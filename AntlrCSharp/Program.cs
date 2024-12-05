using System;
using System.Collections.Generic;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

class Program
{
    // Diccionario para almacenar las variables de tipo entero
    static Dictionary<string, int> variables = new Dictionary<string, int>();

    // Método principal que se ejecuta al iniciar el programa
    static void Main(string[] args)
    {
        // Archivo de entrada
        string filePath = "input.cl";

        // Leer contenido del archivo de entrada
        string input = ReadFile(filePath);

        // Crea un flujo de entrada desde el texto leído
        var inputStream = new AntlrInputStream(input);

        // Iniciar el lexer para el lenguaje natural
        var lexer = new NaturalLangOpsLexer(inputStream);

        // Crea un flujo a partir del lexer
        var tokens = new CommonTokenStream(lexer);

        // Inicializa el parser con los tokens del lexer
        var parser = new NaturalLangOpsParser(tokens);

        // Crea un listener para el arbol de sintaxis
        var listener = new NaturalLangOpsListener();

        // Recorrido del arbol de sintaxis
        var walker = new ParseTreeWalker();
        var tree = parser.program();

        // Recorrer el arbol de sintaxis con el listener
        walker.Walk(listener, tree);
    }

    // Método que lee el contenido de un archivo y devuelve su texto
    // INPUT: string
    // OUTPUT: string
    static string ReadFile(string filePath)
    {
        // Verifica si el archivo existe
        if (!File.Exists(filePath))
        {
            throw new FileNotFoundException($"El archivo '{filePath}' no se encuentra.");
        }

        // Lee el contenido del archivo y lo retorna como texto
        return File.ReadAllText(filePath);
    }

    // Clase de Listener personalizado para manejar los metodos de la gramatica
    // 1. Realiza operaciones aritmeticas
    // 2. Realiza operaciones booleanas
    // 3. Compara valores aritmeticos y booleanos
    // 4. Implementa una estructura de control IF-ELSE
    // 5. Ejecuta el codigo en tiempo real.
    class NaturalLangOpsListener : NaturalLangOpsBaseListener
    {
        // Sobreescribir el manejo las operaciones aritméticas

        public override void ExitOperation(NaturalLangOpsParser.OperationContext context)
        {
            // Extrae los operandos y operador de la operación
            string leftExpr = context.expr(0).GetText();         // primer valor
            string operatorToken = context.operador().GetText(); // tipo de operacion
            string rightExpr = context.expr(1).GetText();        // segundo valor
            string variableName = context.ID().GetText();        // variable de el resultado

            // Convierte los valores numericos de texto a enteros
            int leftOperand = GetNumericValue(leftExpr);
            int rightOperand = GetNumericValue(rightExpr);

            // Realiza la operación
            int result = operatorToken switch
            {
                "MAS" => leftOperand + rightOperand,
                "MENOS" => leftOperand - rightOperand,
                "POR" => leftOperand * rightOperand,
                "ENTRE" => leftOperand / rightOperand,
                _ => throw new InvalidOperationException($"Operador desconocido: {operatorToken}")
            };

            // Almacena el resultado en la variable
            variables[variableName] = result;
        }

        // Sobreescribir el manejor de la estructura IF-ELSE
        public override void ExitIfStatement(NaturalLangOpsParser.IfStatementContext context)
        {
            // Extrae el operador y los valores a comparar
            string leftExpr = context.condition().expr(0).GetText();       // valor1
            string comparator = context.condition().comparator().GetText();// < > = !
            string rightExpr = context.condition().expr(1).GetText();      // valor2

            // Convierte los valores a numeros operables
            int leftOperand = GetNumericValue(leftExpr);
            int rightOperand = GetNumericValue(rightExpr);

            // Evalúa la condición según el comparador
            bool conditionResult = comparator switch
            {
                "ES MAYOR" => leftOperand > rightOperand,
                "ES MENOR" => leftOperand < rightOperand,
                "ES IGUAL" => leftOperand == rightOperand,
                "ES DISTINTO" => leftOperand != rightOperand,
                _ => throw new InvalidOperationException($"Comparador desconocido: {comparator}")
            };

            // Si la condición es verdadera, se ejecuta el bloque ENTONCES
            if (conditionResult)
            {
                ProcessStatements(context.statement(0));    // Ejecuta el primer bloque de declaraciones SI FUE VERDADERO
            }
            else if (context.statement().Length > 1)        // Si la condicion fue false, ejecutar siguiente bloque
            {
                ProcessStatements(context.statement(1));    // Ejecuta el bloque "SINO"
            }
        }

        // Sobreescribir el metodo de impresion en pantalla
        public override void ExitMostrarStatement(NaturalLangOpsParser.MostrarStatementContext context)
        {
            // Extrae el nombre de la variable que se quiere mostrar
            string variableName = context.ID().GetText();

            // Verifica si la variable existe en el diccionario de datos
            if (variables.ContainsKey(variableName))
            {
                // Si la variable existe, imprime su valor
                Console.WriteLine($"{variableName} = {variables[variableName]}");
            }
            else
            {
                // Si la variable no está definida, lanza una excepción
                throw new InvalidOperationException($"Variable '{variableName}' no declarada.");
            }
        }

        // Método para convertir una entrada a un valor operable 
        // INPUT: string (variable o valor)
        // OUTPUT: integer
        private int GetNumericValue(string expr)
        {
            // Intenta convertir la expresión a un valor entero
            if (int.TryParse(expr, out int value))
            {
                return value;                       // Si es un número literal, lo retorna directamente
            }
            else if (variables.ContainsKey(expr))
            {
                return variables[expr];             // Si es una variable, retorna su valor
            }
            else
            {
                // Si no puede resolver el valor, lanza una excepción
                throw new InvalidOperationException($"No se puede resolver el valor de '{expr}'");
            }
        }

        // Método para procesar las declaraciones del programa "compilado"
        private void ProcessStatements(NaturalLangOpsParser.StatementContext block)
        {
            // Recorre todos los hijos
            foreach (var child in block.children)
            {
                // Procesa operaciones aritméticas
                if (child is NaturalLangOpsParser.OperationContext operation)
                    ExitOperation(operation);
                // Procesa impresiones en consola
                else if (child is NaturalLangOpsParser.MostrarStatementContext mostrar)
                    ExitMostrarStatement(mostrar);
                // Procesa estructuras de control (y realiza operaciones booleanas)
                else if (child is NaturalLangOpsParser.IfStatementContext ifStatement)
                    ExitIfStatement(ifStatement);
            }
        }
    }
}
