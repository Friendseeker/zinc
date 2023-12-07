package sbt.zinc.example

case class Bar(x: String)

object Bar {
  def default = Bar("default")

  implicit def bazToBar(implicit z: Baz): Bar = Bar(z.value.toString)
}
