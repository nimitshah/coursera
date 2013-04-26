package recfun
import common._
import scala.collection.mutable.MutableList
import scala.collection.mutable.ArrayBuffer

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if (c == 0 || c == r) 1 else pascal(c, r - 1) + pascal(c - 1, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    var openBraces = 0
    def isPara(c: Char) = isOpenPara(c) || isClosePara(c)
    def isOpenPara(c: Char): Boolean = c == '('
    def isClosePara(c: Char): Boolean = c == ')'
    def onlyPara(): List[Char] = for (c <- chars if isPara(c)) yield c

    def analyzeChars(chars1: List[Char]): Boolean = {
      if (chars1.isEmpty) { openBraces == 0 }
      else {
        if (isOpenPara(chars1.head) && openBraces >= 0) openBraces += 1
        else if (isClosePara(chars1.head) && openBraces >= 0) openBraces -= 1
        analyzeChars(chars1.tail)
      }
    }
    analyzeChars(onlyPara())
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    var totalCombo = 0
    def combo(money: Int, coins: List[Int]): Int = {
      var count = 0
      if (money <= 0 || coins.isEmpty) { 0 }
      else if (coins.size == 1 && money % coins.head == 0) { 1 }
      else {
        var i = 1
        while (coins.head * i < money) { count += combo(money - coins.head * i, coins.tail); i += 1 }
        count
      }

    }

    def uniqueCombinationsOfCoins(coins: List[Int]): List[List[Int]] = {
      var allCombos = MutableList[List[Int]]()
      for (i <- 1 to coins.size) {
        allCombos ++= coins.combinations(i).toList
      }
      allCombos.toList
    }
    
    def totalCombos(): Int = {
      for (uniqueCombinations <- uniqueCombinationsOfCoins(coins)) {
        totalCombo += combo(money, uniqueCombinations.sortWith(_ > _))
      }
      totalCombo
    }
    totalCombos()
  }
}
