package week1
import scala.collection.mutable.MutableList
import scala.collection.mutable.ArrayBuffer
object coins {
  def countChange(money: Int, coins: List[Int]): Int = {
    var totalCombo = 0
    def combo(money: Int, coins: List[Int]): Int = {
      var count = 0
      if (money <= 0 || coins.isEmpty) { 0 }
      else if (coins.size == 1 && money % coins.head == 0) { 1 }
      else {
        var i = 1
        while (coins.head * i < money) { count += combo(money - coins.head * i, coins.tail);i += 1}
        //println(coins+" "+money+" "+count)
        count
      }

    }

    def uniqueCombinationsOfCoins(coins: List[Int]): List[List[Int]] = {
    	var allCombos = MutableList[List[Int]]()
    	for(i <- 1 to coins.size){
	    	allCombos ++= coins.combinations(i).toList
	    	println(i+" "+coins.combinations(i).toList+" "+allCombos)
    	}
    	println(allCombos)
    	allCombos.toList
      //List(List(1), List(2), List(5), List(1, 2),List(1,5), List(2,5), List(1,2,5))
    }
    def totalComboDef(): Int = {
      for (uniqueCombinations <- uniqueCombinationsOfCoins(coins)) {
        var temp = 0
        temp = combo(money, uniqueCombinations.sortWith(_ > _))
        totalCombo += temp //coins.sortWith(_ > _))
        println("-------"+uniqueCombinations.sortWith(_ > _)+" "+temp+" "+totalCombo)
      }
      totalCombo
    }
    totalComboDef()
  }                                               //> countChange: (money: Int, coins: List[Int])Int

  //countChange(2, List(1))
  //countChange(4, List(1, 2))
  countChange(20, List(1, 2, 5))                  //> 1 List(List(1), List(2), List(5)) MutableList(List(1), List(2), List(5))
                                                  //| 2 List(List(1, 2), List(1, 5), List(2, 5)) MutableList(List(1), List(2), Li
                                                  //| st(5), List(1, 2), List(1, 5), List(2, 5))
                                                  //| 3 List(List(1, 2, 5)) MutableList(List(1), List(2), List(5), List(1, 2), Li
                                                  //| st(1, 5), List(2, 5), List(1, 2, 5))
                                                  //| MutableList(List(1), List(2), List(5), List(1, 2), List(1, 5), List(2, 5), 
                                                  //| List(1, 2, 5))
                                                  //| -------List(1) 1 1
                                                  //| -------List(2) 1 2
                                                  //| -------List(5) 1 3
                                                  //| -------List(2, 1) 9 12
                                                  //| -------List(5, 1) 3 15
                                                  //| -------List(5, 2) 1 16
                                                  //| -------List(5, 2, 1) 13 29
                                                  //| res0: Int = 29
  var x = new MutableList[List[Int]]()            //> x  : scala.collection.mutable.MutableList[List[Int]] = MutableList()
  x ++= List(List(1),List(2))                     //> res1: scala.collection.mutable.MutableList[List[Int]] = MutableList(List(1)
                                                  //| , List(2))
 // println(List(1, 2, 5).combinations(2).toList)
  //countChange(300, List(5, 10, 20, 50, 100, 200, 500))
}