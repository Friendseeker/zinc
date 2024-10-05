package example
import scala.language.experimental.macros
import scala.reflect.macros._

object Provider {
  // Added one comment
  def tree(args: Any): Any = macro treeImpl
  def treeImpl(c: Context)(args: c.Expr[Any]): c.Expr[Any] = c.universe.reify(args.splice)
}
