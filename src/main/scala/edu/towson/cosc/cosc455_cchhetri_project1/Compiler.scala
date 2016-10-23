package edu.towson.cosc.cosc455_cchhetri_project1

/**
  * Created by camychhetri on 10/11/16.
  */
object Compiler {

  var currentToken : String = ""
  var fileContents : String = ""

  val Scanner = new MyLexicalAnalyzer
  val Parser = new MySyntaxAnalyzer
  val SemanticAnalyzer = new MySyntaxAnalyzer

  def main(args: Array[String]): Unit = {
    checkFile(args)
    readFile(args(0))
    takeFileContents(args(0))

    Scanner.getNextToken()

  }

  def readFile(file : String) = {
    val source = scala.io.Source.fromFile(file)
    fileContents = try source.mkString finally source.close()
  }

  def checkFile(args : Array[String]) = {
    if (args.length != 1) {
      println("USAGE ERROR: wrong number of args fool!")
      System.exit(1)
    }
    else if (! args(0).endsWith(".mkd")) {
      println("USAGE ERROR: wrong extension fool!")
      System.exit(1)
    }
  }

  // read file content by calling add char then get char then get next token and
// if it starts with / then read until it has space and then use look up table to figure out if it works
  def takeFileContents(file : String)={


}

}
