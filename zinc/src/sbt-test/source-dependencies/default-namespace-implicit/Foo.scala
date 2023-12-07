import sbt.zinc.example.Baz
// Adding the below import makes issue to changes/Foo.scala and Foo.scala make issue go away
// import `package`.b
class Foo(implicit baz: Baz)

object Foo {
  val f = new Foo
}
