package week1

object CaseClass {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet")
  
  
  trait Expr {
  def show(): String = this match {
    case Var(n) => n
    case Sum(l, r) => l.show + "+" + r.show
    case Prod(l, r) => "(" + l.show + "*" + r.show + ")"
  }
}
case class Var(name: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr;$skip(371); val res$0 = 

Sum(Prod(Var("x"), Var("y")), Var("z")).show;System.out.println("""res0: String = """ + $show(res$0))}
}
