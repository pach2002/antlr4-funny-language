using System;
using System.Collections.Generic;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;


class Program
{
    // Almacenamos las variables declaradas
    static Dictionary<string, int> variables = new Dictionary<string, int>();

    static void Main(string[] args)
    {
        // Ruta del archivo de entrada
        string filePath = "input.txt";  // Asegúrate de tener el archivo en la misma carpeta del proyecto o proporciona la ruta completa

        // Leer el contenido del archivo
        string input = ReadFile(filePath);

        // Analizar la entrada
        var inputStream = new AntlrInputStream(input);
        var lexer = new NaturalLangOpsLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new NaturalLangOpsParser(tokens);

        // Crear el listener para ejecutar las operaciones
        var listener = new NaturalLangOpsListener();
        var walker = new ParseTreeWalker();
        var tree = parser.program();

        // Ejecutar el programa
        walker.Walk(listener, tree);

        // Mostrar los resultados de las variables
        foreach (var item in variables)
        {
            Console.WriteLine($"{item.Key} = {item.Value}");
        }
    }

    // Función para leer el contenido de un archivo
    static string ReadFile(string filePath)
    {
        if (!File.Exists(filePath))
        {
            throw new FileNotFoundException($"El archivo '{filePath}' no se encuentra.");
        }
        return File.ReadAllText(filePath);
    }

    // Listener para ejecutar las operaciones
    class NaturalLangOpsListener : NaturalLangOpsBaseListener
    {
        public override void ExitOperation(NaturalLangOpsParser.OperationContext context)
        {
            // Obtener los operandos
            string leftExpr = context.expr(0).GetText();  // Primer operando (NUMERO o variable)
            string operatorToken = context.operador().GetText();   // Operador como texto (MAS, MENOS, POR, ENTRE)
            string rightExpr = context.expr(1).GetText(); // Segundo operando (NUMERO o variable)

            // Obtener el nombre de la variable a la que se asignará el resultado
            string variableName = context.ID().GetText();

            // Convertir el operando izquierdo a un valor
            int leftOperand;
            if (!int.TryParse(leftExpr, out leftOperand))
            {
                leftOperand = variables[leftExpr];  // Si no es número, buscarlo en variables
            }

            // Convertir el operando derecho a un valor
            int rightOperand;
            if (!int.TryParse(rightExpr, out rightOperand))
            {
                rightOperand = variables[rightExpr];  // Si no es número, buscarlo en variables
            }

            // Ejecutar la operación según el operador
            int result = 0;

            if (operatorToken == "MAS")
            {
                result = leftOperand + rightOperand;
            }
            else if (operatorToken == "MENOS")
            {
                result = leftOperand - rightOperand;
            }
            else if (operatorToken == "POR")
            {
                result = leftOperand * rightOperand;
            }
            else if (operatorToken == "ENTRE")
            {
                result = leftOperand / rightOperand;
            }
            else
            {
                throw new InvalidOperationException($"Operador desconocido: {operatorToken}");
            }

            // Guardar el resultado de la operación en la variable
            variables[variableName] = result;
        }
    }
}
