package week1

object Anagram {
  /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]

  type Occurrences = List[(Char, Int)]
  
   def combinations(occurrences: Occurrences): List[Occurrences] = {
   	val flatOc = flatOccurences(occurrences)
   	for(
		   	(ch, i) <- flatOc;
		   	idx <- (0 until flatOc.takeRight(flatOc.indexOf((ch, i))).filter(ocTail=>ocTail._1!=ch).size)
	   	) yield {
   		List((ch, i)) ++ flatOc.takeRight(flatOc.indexOf((ch, i))).filter(ocTail=>ocTail._1!=ch).takeRight(idx)
   	}
  }                                               //> combinations: (occurrences: week1.Anagram.Occurrences)List[week1.Anagram.Occ
                                                  //| urrences]
  
  def flatOccurences(occurrences: Occurrences):Occurrences = {
	  for((ch, i) <- occurrences; count <- (1 to i)) yield(ch, count)
  }                                               //> flatOccurences: (occurrences: week1.Anagram.Occurrences)week1.Anagram.Occurr
                                                  //| ences
  flatOccurences(List(('a', 2), ('b', 2)))        //> res0: week1.Anagram.Occurrences = List((a,1), (a,2), (b,1), (b,2))
  combinations(List(('a', 2), ('b', 2)))          //> res1: List[week1.Anagram.Occurrences] = List(List((a,2)), List((b,2)))
  
	println("Hi")                             //> Hi
}