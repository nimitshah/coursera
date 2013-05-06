package week1

object CaseClass {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  trait Expr {
  def show(): String = this match {
    case Var(n) => n
    case Sum(l, r) => l.show + "+" + r.show
    case Prod(l, r) => "(" + l.show + "*" + r.show + ")"
  }
}
case class Var(name: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

Sum(Prod(Var("x"), Var("y")), Var("z")).show      //> res0: String = (x*y)+z
}