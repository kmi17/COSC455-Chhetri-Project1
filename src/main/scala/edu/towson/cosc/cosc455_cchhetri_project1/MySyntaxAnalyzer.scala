  package edu.towson.cosc.cosc455_cchhetri_project1

  /**
    * Created by camychhetri on 10/11/16.
    */
  class MySyntaxAnalyzer extends SyntaxAnalyzer {

    var parseTree = new scala.collection.mutable.Stack[String]


    override def gittex(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DOCB)) {

        parseTree.push(CONSTANTS.DOCB)

        Compiler.Scanner.getNextToken()

        variableDefine()
        title()
        body()

        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DOCE)) {
          // do stuff

        }
      } else {
        println("Syntax Error")
        System.exit(1)

      }
    }


    override def title(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.TITLEB)) {
        parseTree.push(CONSTANTS.TITLEB)
        Compiler.Scanner.getNextToken()

        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
          parseTree.push(CONSTANTS.REQTEXT)
          Compiler.Scanner.getNextToken()

          if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BRACKETE)) {
            parseTree.push(CONSTANTS.BRACKETE)
            Compiler.Scanner.getNextToken()
          } else {
            println("Syntax Error")
            System.exit(1)
          }
        } else {
          println("Syntax Error")
          System.exit(1)
        }
      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }


    override def body(): Unit = {
      innerText()
      body()

    }

    override def paragraph(): Unit = {

      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.PARAB)) {
        parseTree.push(CONSTANTS.PARAB)
        variableDefine()
        innerText()
        Compiler.Scanner.getNextToken()

        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.PARAE)) {
          parseTree.push(CONSTANTS.PARAE)
          Compiler.Scanner.getNextToken()
        } else {
          println("Syntax Error")
          System.exit(1)
        }
      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }

    override def innerText(): Unit = {


      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.USEB)) {
        variableUse()
        innerText()
      } else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.HEADING)) {
        heading()
        innerText()
        //or
      } else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BOLD)) {
        bold()
        innerText()
        //or
      } else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ITALICS)) {
        italics()
        innerText()
        //or
      } else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LISTITEM)) {
        listItem()
        innerText()
        //or
      } else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.IMAGEB)) {

        image()
        innerText()
      } else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LINKB)) {
        //or
        link()
        innerText()
      } else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LISTITEM)) {
        //or
        newline()
        innerText()
        //or
      } else{
        text()
        innerText()
      }
      println("Syntax Error")
      System.exit(1)

    }

    override def heading(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.HEADING)) {
        parseTree.push(CONSTANTS.HEADING)
        Compiler.Scanner.getNextToken()
        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
          parseTree.push(CONSTANTS.REQTEXT)

        } else {
          println("Syntax Error")
          System.exit(1)
        }

      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }

    override def variableDefine(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DEFB)) {
        parseTree.push(CONSTANTS.DEFB)
        Compiler.Scanner.getNextToken()

        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
          parseTree.push(CONSTANTS.REQTEXT)
          Compiler.Scanner.getNextToken()

          if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.EQSIGN)) {
            parseTree.push(CONSTANTS.EQSIGN)
            Compiler.Scanner.getNextToken()
            if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
              parseTree.push(CONSTANTS.REQTEXT)
              Compiler.Scanner.getNextToken()
              if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BRACKETE)) {
                parseTree.push(CONSTANTS.BRACKETE)
                variableDefine()
                Compiler.Scanner.getNextToken()

              } else {
                println("Syntax Error")
                System.exit(1)
              }
            } else {
              println("Syntax Error")
              System.exit(1)
            }

          } else {
            println("Syntax Error")
            System.exit(1)
          }
        } else {
          println("Syntax Error")
          System.exit(1)
        }
      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }

    override def variableUse(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.USEB)) {
        parseTree.push(CONSTANTS.USEB)
        Compiler.Scanner.getNextToken()

        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
          parseTree.push(CONSTANTS.REQTEXT)
          Compiler.Scanner.getNextToken()

          if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BRACKETE)) {
            parseTree.push(CONSTANTS.BRACKETE)
            Compiler.Scanner.getNextToken()
          } else {
            println("Syntax Error")
            System.exit(1)
          }
        } else {
          println("Syntax Error")
          System.exit(1)
        }
      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }

    override def bold(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BOLD)) {
        parseTree.push(CONSTANTS.BOLD)
        Compiler.Scanner.getNextToken()
        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.TEXT)) {
          parseTree.push(CONSTANTS.TEXT)
          Compiler.Scanner.getNextToken()
          if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BOLD)) {
            parseTree.push(CONSTANTS.BOLD)
            Compiler.Scanner.getNextToken()
          } else {
            println("Syntax Error")
            System.exit(1)
          }
        } else {
          println("Syntax Error")
          System.exit(1)
        }
      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }


    override def italics(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ITALICS)) {
        parseTree.push(CONSTANTS.ITALICS)
        Compiler.Scanner.getNextToken()
        // add it  so that u can build a parse tree

        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.TEXT)) {
          parseTree.push(CONSTANTS.TEXT)
          Compiler.Scanner.getNextToken()

          if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ITALICS)) {
            parseTree.push(CONSTANTS.ITALICS)
            Compiler.Scanner.getNextToken()
          } else {
            println("Syntax Error")
            System.exit(1)
          }
        } else {
          println("Syntax Error")
          System.exit(1)
        }
      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }


    override def listItem(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LISTITEM)) {
        parseTree.push(CONSTANTS.LISTITEM)
        Compiler.Scanner.getNextToken()
        // add it  so that u can build a parse tree
        innerItem()
        listItem()
      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }

    override def innerItem(): Unit = {
      variableUse()
      innerItem()
      //or
      bold()
      innerItem()
      //or
      italics()
      innerItem()
      //or
      link()
      innerItem()
      //or
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
        parseTree.push(CONSTANTS.REQTEXT)
        Compiler.Scanner.getNextToken()
        // add it  so that u can build a parse tree
        innerItem()

      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }

    override def link(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LINKB)) {
        parseTree.push(CONSTANTS.LINKB)
        Compiler.Scanner.getNextToken()

        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
          parseTree.push(CONSTANTS.REQTEXT)
          Compiler.Scanner.getNextToken()

          if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BRACKETE)) {
            parseTree.push(CONSTANTS.BRACKETE)
            Compiler.Scanner.getNextToken()
            if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ADDRESSB)) {
              parseTree.push(CONSTANTS.ADDRESSB)
              Compiler.Scanner.getNextToken()
              if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
                parseTree.push(CONSTANTS.REQTEXT)
                variableDefine()
                Compiler.Scanner.getNextToken()
                if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ADDRESSE)) {
                  parseTree.push(CONSTANTS.ADDRESSE)
                  variableDefine()
                  Compiler.Scanner.getNextToken()

                } else {
                  println("Syntax Error")
                  System.exit(1)
                }
              } else {
                println("Syntax Error")
                System.exit(1)
              }

            } else {
              println("Syntax Error")
              System.exit(1)
            }
          } else {
            println("Syntax Error")
            System.exit(1)
          }
        } else {
          println("Syntax Error")
          System.exit(1)
        }

      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }

    override def image(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.IMAGEB)) {
        parseTree.push(CONSTANTS.IMAGEB)
        Compiler.Scanner.getNextToken()

        if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
          parseTree.push(CONSTANTS.REQTEXT)
          Compiler.Scanner.getNextToken()

          if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BRACKETE)) {
            parseTree.push(CONSTANTS.BRACKETE)
            Compiler.Scanner.getNextToken()
            if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ADDRESSB)) {
              parseTree.push(CONSTANTS.ADDRESSB)
              Compiler.Scanner.getNextToken()
              if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.REQTEXT)) {
                parseTree.push(CONSTANTS.REQTEXT)
                variableDefine()
                Compiler.Scanner.getNextToken()
                if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ADDRESSE)) {
                  parseTree.push(CONSTANTS.ADDRESSE)
                  variableDefine()
                  Compiler.Scanner.getNextToken()

                } else {
                  println("Syntax Error")
                  System.exit(1)
                }
              } else {
                println("Syntax Error")
                System.exit(1)
              }

            } else {
              println("Syntax Error")
              System.exit(1)
            }
          } else {
            println("Syntax Error")
            System.exit(1)
          }
        } else {
          println("Syntax Error")
          System.exit(1)
        }

      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }

    override def newline(): Unit = {
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.NEWLINE)) {
        parseTree.push(CONSTANTS.NEWLINE)
        Compiler.Scanner.getNextToken()
      } else {
        println("Syntax Error")
        System.exit(1)
      }
    }


    def text(): Unit = {

      alphabets()
      numbers()
      strExtraText()


    }

    def reqtext(): Unit = {

    }


    def alphabets(): Unit ={
      for (alphabets <- 'a' to 'z') {

        if (Compiler.currentToken.equals(alphabets)) {
          val charToStr = alphabets.toString
          parseTree.push(charToStr)
        }else{
          println("Syntax Error")
          System.exit(1)
        }
      }
    }
    def numbers(): Unit = {
      for (numbers <- 0 to 9) {
        val intToStr = numbers.toString
        if (Compiler.currentToken.equals(intToStr)) {
          val charToStr = intToStr.toString
          parseTree.push(intToStr)
        }
      }
    }
    def strExtraText(): Unit = {
      val strList: List[String] = List(",", ".", "?", "_", "/","""""")
      for (i <- 0 until strList.length - 1)
        if (Compiler.currentToken.equals(strList {
          i
        })) {
          parseTree.push(strList {
            i
          })
        } else {
          println("Syntax Error")
          System.exit(1)
        }
    }





  }
