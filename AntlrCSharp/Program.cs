using System;
using Antlr4.Runtime;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        // Verifica que el archivo de entrada exista
        string inputPath = "codigo.txt"; // Ruta de tu archivo de entrada
        if (!File.Exists(inputPath))
        {
            Console.WriteLine("El archivo de entrada no existe.");
            return;
        }

        // Lee el contenido del archivo de entrada
        string input = File.ReadAllText(inputPath);

        // Crea el flujo de entrada para ANTLR
        var inputStream = new AntlrInputStream(input);

        // Crea el lexer y el parser para procesar el flujo de entrada
        var lexer = new NaturalCodeLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new NaturalCodeParser(tokens);

        // Obtiene el árbol de sintaxis generado por el parser
        var tree = parser.program();

        // Crea el visitor para traducir el árbol a código ejecutable
        var visitor = new NaturalCodeVisitor();
        string result = visitor.Visit(tree);

        // Muestra el código generado en consola
        Console.WriteLine("Código traducido:");
        Console.WriteLine(result);
    }
}
