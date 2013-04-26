package week1
import scala.collection.mutable.MutableList
import scala.collection.mutable.ArrayBuffer
object coins {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(1376); 
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
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(94); val res$0 = 

  //countChange(2, List(1))
  //countChange(4, List(1, 2))
  countChange(20, List(1, 2, 5));System.out.println("""res0: Int = """ + $show(res$0));$skip(39); 
  var x = new MutableList[List[Int]]();System.out.println("""x  : scala.collection.mutable.MutableList[List[Int]] = """ + $show(x ));$skip(30); val res$1 = 
  x ++= List(List(1),List(2));System.out.println("""res1: scala.collection.mutable.MutableList[List[Int]] = """ + $show(res$1))}
 // println(List(1, 2, 5).combinations(2).toList)
  //countChange(300, List(5, 10, 20, 50, 100, 200, 500))
}
