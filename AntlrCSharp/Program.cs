using System;
using System.Collections.Generic;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

class Program
{

    // Diccionario de datos para la declaracion de enteros
    static Dictionary<string, int> variables = new Dictionary<string, int>();
    // Diccionarios de datos para la declaracion de booleanos
    static Dictionary<string, bool> booleanVariables = new Dictionary<string, bool>();

    // Metodo principal
    static void Main(string[] args)
    {
        string filePath = "input.txt"; // Archivo de entrada
        string input = ReadFile(filePath); // Leer archivo de entrada

        
        var inputStream = new AntlrInputStream(input);
        var lexer = new NaturalLangOpsLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new NaturalLangOpsParser(tokens);

        var listener = new NaturalLangOpsListener();
        var walker = new ParseTreeWalker();
        var tree = parser.program();

        walker.Walk(listener, tree);
    }

    static string ReadFile(string filePath)
    {
        if (!File.Exists(filePath))
        {
            throw new FileNotFoundException($"El archivo '{filePath}' no se encuentra.");
        }
        return File.ReadAllText(filePath);
    }

    class NaturalLangOpsListener : NaturalLangOpsBaseListener
    {
        public override void ExitOperation(NaturalLangOpsParser.OperationContext context)
        {
            string leftExpr = context.expr(0).GetText();
            string operatorToken = context.operador().GetText();
            string rightExpr = context.expr(1).GetText();
            string variableName = context.ID().GetText();

            int leftOperand = GetNumericValue(leftExpr);
            int rightOperand = GetNumericValue(rightExpr);

            int result = operatorToken switch
            {
                "MAS" => leftOperand + rightOperand,
                "MENOS" => leftOperand - rightOperand,
                "POR" => leftOperand * rightOperand,
                "ENTRE" => leftOperand / rightOperand,
                _ => throw new InvalidOperationException($"Operador desconocido: {operatorToken}")
            };

            variables[variableName] = result;
        }

        public override void ExitBooleanOperation(NaturalLangOpsParser.BooleanOperationContext context)
        {
            string leftExpr = context.expr(0).GetText();
            string comparator = context.comparator().GetText();
            string rightExpr = context.expr(1).GetText();
            string variableName = context.ID().GetText();

            int leftOperand = GetNumericValue(leftExpr);
            int rightOperand = GetNumericValue(rightExpr);

            bool result = comparator switch
            {
                "ES MAYOR" => leftOperand > rightOperand,
                "ES MENOR" => leftOperand < rightOperand,
                "ES IGUAL" => leftOperand == rightOperand,
                "ES DISTINTO" => leftOperand != rightOperand,
                _ => throw new InvalidOperationException($"Comparador desconocido: {comparator}")
            };

            booleanVariables[variableName] = result;
        }

        public override void ExitMostrarStatement(NaturalLangOpsParser.MostrarStatementContext context)
        {
            string variableName = context.ID().GetText();

            if (variables.ContainsKey(variableName))
            {
                Console.WriteLine($"{variableName} = {variables[variableName]}");
            }
            else if (booleanVariables.ContainsKey(variableName))
            {
                Console.WriteLine($"{variableName} = {booleanVariables[variableName]}");
            }
            else
            {
                throw new InvalidOperationException($"Variable '{variableName}' no declarada.");
            }
        }

        private int GetNumericValue(string expr)
        {
            return int.TryParse(expr, out int value) ? value : variables[expr];
        }
    }
}
