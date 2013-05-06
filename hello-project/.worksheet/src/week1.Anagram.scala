package week1

object Anagram {
  /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]

  type Occurrences = List[(Char, Int)];import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(587); 
  
   def combinations(occurrences: Occurrences): List[Occurrences] = {
   	val flatOc = flatOccurences(occurrences)
   	for(
		   	(ch, i) <- flatOc;
		   	idx <- (0 until flatOc.takeRight(flatOc.indexOf((ch, i))).filter(ocTail=>ocTail._1!=ch).size)
	   	) yield {
   		List((ch, i)) ++ flatOc.takeRight(flatOc.indexOf((ch, i))).filter(ocTail=>ocTail._1!=ch).takeRight(idx)
   	}
  };System.out.println("""combinations: (occurrences: week1.Anagram.Occurrences)List[week1.Anagram.Occurrences]""");$skip(137); 
  
  def flatOccurences(occurrences: Occurrences):Occurrences = {
	  for((ch, i) <- occurrences; count <- (1 to i)) yield(ch, count)
  };System.out.println("""flatOccurences: (occurrences: week1.Anagram.Occurrences)week1.Anagram.Occurrences""");$skip(43); val res$0 = 
  flatOccurences(List(('a', 2), ('b', 2)));System.out.println("""res0: week1.Anagram.Occurrences = """ + $show(res$0));$skip(41); val res$1 = 
  combinations(List(('a', 2), ('b', 2)));System.out.println("""res1: List[week1.Anagram.Occurrences] = """ + $show(res$1));$skip(18); 
  
	println("Hi")}
}
