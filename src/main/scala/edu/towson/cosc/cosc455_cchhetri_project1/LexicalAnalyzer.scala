package edu.towson.cosc.cosc455_cchhetri_project1

/**
  * Created by camychhetri on 10/11/16.
  */
trait LexicalAnalyzer {

    def addChar(x:Char) : String
    def getChar() : Char
    def getNextToken() : Unit
    def lookup(y:String) : Boolean
}
