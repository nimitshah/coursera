package week1

object Balance {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(765); 
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
  };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(51); val res$0 = 
  
  balance("(if (zero? x) max (/ 1 x))".toList);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(24); val res$1 = 
  balance(":-)".toList);System.out.println("""res1: Boolean = """ + $show(res$1))}
}
