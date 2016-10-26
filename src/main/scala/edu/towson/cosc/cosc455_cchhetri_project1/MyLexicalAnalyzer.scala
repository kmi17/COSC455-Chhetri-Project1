package edu.towson.cosc.cosc455_cchhetri_project1

/**
  * Created by camychhetri on 10/11/16.
  */
class MyLexicalAnalyzer extends LexicalAnalyzer {

  //val lexems: List[String] = List("\n", "\\BEGIN","\\END", "\\TITLE[","]", "#", "\\PARAB", "PARAE", "**", "*", "+", "\\", "[", "(", ")", "![", "\\DEF[", "=", "\\USE[")

  def initializeLexems(): Unit ={

    val lexems: List[String] = List("\\BEGIN","\\END", "\\TITLE[","]", "#", "\\PARAB", "PARAE", "**", "*", "+", "\\", "[", "(", ")", "![", "\\DEF[", "=", "\\USE[")

  }


  override def addChar(): Unit = {

  }



  override def getChar(): Unit = {
    var i = 0
    Compiler.fileContents.charAt(i)

    while(!(Compiler.fileContents.charAt(i).equals("\n"))){
      addChar()
      i = i + 1
    }


  }

  override def getNextToken(): Unit = {

    // val c = getChar()
    //if(c.equals(CONSTANTS)){

    //}

  }

  override def lookup(){



  }
}
