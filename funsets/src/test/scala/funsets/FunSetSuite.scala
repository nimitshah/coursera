package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  trait TestUnions extends TestSets {
    val u12 = union(s1, s2)
    val u123 = union(u12, s3)
  }

  trait TestFilters extends TestUnions {
    val f23 = filter(u123, (x: Int) => x > 1)
  }

  trait TestIntersects extends TestUnions {
    val i12 = intersect(u123, u12)
  }

  trait TestDiffs extends TestUnions {
    val d3 = diff(u123, u12)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton1")
      assert(!contains(s1, 2), "Singleton1.1")
      assert(contains(s2, 2), "Singleton2")
      assert(contains(s3, 3), "Singleton3")

    }
  }

  test("union contains all elements") {
    new TestUnions {
      assert(contains(u12, 1))
      assert(contains(u12, 2))
      assert(!contains(u12, 3))
      assert(contains(u123, 3))
      assert(contains(u123, 2))
      assert(contains(u123, 1))
    }
  }

  test("filter returns subset") {
    new TestFilters {
      assert(!contains(f23, 1))
      assert(contains(f23, 2))
      assert(contains(f23, 3))
    }
  }

  test("intersect returns intersection of 2 sets") {
    new TestIntersects {
      assert(contains(i12, 2))
      assert(contains(i12, 1))
      assert(!contains(i12, 3))
    }
  }

  test("diff returns difference of 2 sets") {
    new TestDiffs {
      assert(contains(d3, 3))
      assert(!contains(d3, 1))
      assert(!contains(d3, 2))
    }
  }

  test("foreach returns true if all elements in set satisfies the condition") {
    new TestUnions {
      assert(forall(u123, (x: Int) => x > 0))
      assert(!forall(u123, (x: Int) => x > 1))
    }
  }

  test("exists returns true if any of the elements in set satisfies the condition") {
    new TestUnions {
      assert(exists(u123, (x: Int) => x > 2))
      assert(!exists(u123, (x: Int) => x > 3))
    }
  }

  test("map transforms a set to another") {
    new TestUnions {
      val m1 = map(s1, (x: Int) => x + 1)
      assert(!contains(m1, 1))
      assert(contains(m1, 2))
      assert(!contains(m1, 3))

      val m2 = map(u12, (x: Int) => x * x)
      assert(contains(m2, 1))
      assert(!contains(m2, 2))
      assert(!contains(m2, 3))
      assert(contains(m2, 4))
      assert(!contains(m2, 5))
      assert(!contains(m2, 1000))
      assert(!contains(m2, 1001))
    }
  }
}
