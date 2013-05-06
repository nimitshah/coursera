package greeter

object nqueens {


  def queens(n:Int):Set[List[Int]] = {
  	def placeQueens(k:Int):Set[List[Int]] = {
  		if(k==0) Set(List())
  		else
  			for{
  				queens <- placeQueens(k-1)
  				col <- 0 until n
  				if isSafe(col, queens)
  			} yield {println(col::queens);col::queens}
  	}
  	placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]
  
  def isSafe(col:Int, queens:List[Int]):Boolean = {
  	val row = queens length
  	val queensWithRowa = (row-1 to 0 by -1) zip (queens)
  	val isSafeB = queensWithRowa.forall({
  		case (r, c) => col!=c && Math.abs(col-c) != row -r
  	})
  	println(" "+row+" "+col+" "+isSafeB)
  	isSafeB
  } //> isSafe: (col: Int, queens: List[Int])Boolean

  def main(args: Array[String]): Unit = {
    println(queens(4)) //> res0: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
  }
}
