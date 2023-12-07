import sbt.zinc.example._

class Foo(implicit baz: Baz)

object Foo {
  val f = new Foo
}


// Random Placeholder comment to let Zinc detect that Foo has changed