import sbt.zinc.example._

class Foo(implicit bar: Bar) {
  def show = println(bar.x)
}

object Foo {
  def main = {
    val f = new Foo
    f.show
  }
}

// Random Placeholder comment to let Zinc detect that Foo has changed