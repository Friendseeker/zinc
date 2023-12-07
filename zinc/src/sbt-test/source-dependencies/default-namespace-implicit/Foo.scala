import sbt.zinc.example._

class Foo(implicit baz: Baz)

object Foo {
  val f = new Foo
}
