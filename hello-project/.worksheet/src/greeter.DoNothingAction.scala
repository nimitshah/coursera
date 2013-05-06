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
object DoNothingAction extends UndoableAction;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(359); ("Do nothing") {;System.out.println("""<init> : ()greeter.DoNothingAction.type""");$skip(25); 
  override def undo() {};System.out.println("""undo: ()Unit""");$skip(25); 
  override def redo() {};System.out.println("""redo: ()Unit""")}
}
