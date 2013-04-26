package week1

object Balance {
  def balance(chars: List[Char]): Boolean = {
  	var openBraces = 0
    def isPara(c: Char) = isOpenPara(c) || isClosePara(c)
    def isOpenPara(c: Char): Boolean = c == '('
    def isClosePara(c: Char): Boolean = c == ')'
		def onlyPara():List[Char] = {
			var onlyParaChars:String = ""
			for(c <- chars){
				if(isPara(c)) onlyParaChars+=c
			}
			onlyParaChars.toList
		}
    
    def analyzeChars(chars1: List[Char]): Boolean = {
    	println(chars1 +" "+ openBraces)
      if (chars1.isEmpty) {openBraces == 0}
      else {
      	if (isOpenPara(chars1.head)) openBraces+=1
      	else if(isClosePara(chars1.head) && openBraces >= 0) openBraces-=1
      	analyzeChars(chars1.tail)
      }
    }
    analyzeChars(onlyPara())
  }                                               //> balance: (chars: List[Char])Boolean
  
  balance("(if (zero? x) max (/ 1 x))".toList)    //> List((, (, ), (, ), )) 0
                                                  //| List((, ), (, ), )) 1
                                                  //| List(), (, ), )) 2
                                                  //| List((, ), )) 1
                                                  //| List(), )) 2
                                                  //| List()) 1
                                                  //| List() 0
                                                  //| res0: Boolean = true
  balance(":-)".toList)                           //> List()) 0
                                                  //| List() -1
                                                  //| res1: Boolean = false
}