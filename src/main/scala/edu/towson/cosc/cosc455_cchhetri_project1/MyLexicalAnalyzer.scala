package edu.towson.cosc.cosc455_cchhetri_project1

/**
  * Created by camychhetri on 10/11/16.
  */
class MyLexicalAnalyzer extends LexicalAnalyzer {

  override def addChar(): Unit = {

  }

  override def getChar(): Unit = {

    Compiler.fileContents.charAt(0)

  }

  override def getNextToken(): Unit = {

    // val c = getChar()
    //if(c.equals(CONSTANTS)){

    //}

  }

  override def lookup(){
    //StringBuffer


  }
}
