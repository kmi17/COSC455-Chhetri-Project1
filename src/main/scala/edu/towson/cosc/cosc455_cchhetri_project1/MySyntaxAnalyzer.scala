package edu.towson.cosc.cosc455_cchhetri_project1

/**
  * Created by camychhetri on 10/11/16.
  */
class MySyntaxAnalyzer extends SyntaxAnalyzex {
  override def gittex(): Unit = {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DOCB)) {
      Compiler.Scanner.getNextToken()
      variableDefine()
      title()
      body()
      if (Compiler.currentToken.equaltoIgnoreCase(CONSTANTS.DOCB)) {
        // do stuff

      }
    } else {
      println("Syntax Error")
      System.exit(1)

    }
  }


  override def title(): Unit = ???

  override def body(): Unit = ???

  override def paragraph(): Unit = ???

  override def innerText(): Unit = ???

  override def heading(): Unit = ???

  override def variableDefine(): Unit = ???

  override def variableUse(): Unit = ???

  override def bold(): Unit = ???

  override def italics(): Unit = ???

  override def listItem(): Unit = ???

  override def innerItem(): Unit = ???

  override def link(): Unit = ???

  override def image(): Unit = ???

  override def newline(): Unit = ???
}
