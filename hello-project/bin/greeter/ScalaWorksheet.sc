package greeter

/*object ScalaWorksheet {
  println("Welcome to the Scala worksheet")
  val x = 1
  def increase(i: Int) = i + 1
  increase(x)
}*/

abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
  //def printDesc(): Unit = println(description)
}