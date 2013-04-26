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

  override def undo() {};System.out.println("""undo: ()Unit""");$skip(25); 
  override def redo() {};System.out.println("""redo: ()Unit""")}
}