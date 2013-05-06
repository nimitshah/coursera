package week1
object PrimitivesAsClass {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(84); val res$0 = 
  //Sum(Prod(2, Var(�x�)), Var(�y�))
  Sum(Prod(Var("x"), Var("y")), Var("z")).show;System.out.println("""res0: String = """ + $show(res$0))}
}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}
/*
object Zero extends Nat {
  def isZero: Boolean = true
    def predecessor: Nat = throw new IllegalArgumentException()
  def successor: Nat = new Succ()
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}
class Succ(n: Nat) extends Nat {
def isZero: Boolean = false
}
*/
trait Expr {
  def show(): String = this match {
    case n => n.toString()
    case Var(n) => n
    case Sum(l, r) => l.show + "+" + r.show
    case Prod(l, r) => "(" + l.show + "*" + r.show + ")"
  }
}
case class Var(name: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
