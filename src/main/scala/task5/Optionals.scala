package task5

// overall module
object Optionals:

  // type "public" definition, exposing structure
  enum OptionalInt:
    case Just(value: Int)
    case Empty()

  // operations (/algorithms)
  object OptionalInt:

    def isEmpty(opt: OptionalInt): Boolean = opt match
      case Empty() => true
      case _       => false

    def orElse(opt: OptionalInt, orElse: Int): Int = opt match
      case Just(a) => a
      case _       => orElse
    
    def mapInt(opt: OptionalInt)(f: Int => Int): OptionalInt = opt match 
      case Just(a) => Just(f(a))
      case Empty() => Empty()

    def filter(opt: OptionalInt)(predicate: Int => Boolean): OptionalInt = opt match
      case Just(a) => predicate(a) match
        case true  => Just(a)
        case false => Empty()
      case Empty() => Empty()

@main def tryOptionals(): Unit =
  import Optionals.* // to work with Optionals (to see OptionalInt type)
  import OptionalInt.* // to directly access algorithms

  val s1: OptionalInt = Just(5)
  val s2: OptionalInt = Empty()

  println(s1) // Some(1)
  println(isEmpty(s1)) // false
  println(orElse(s1, 0)) // 1
  println(orElse(s2, 0)) // 0

  // test esecuzione task
  println("mapInt(Just(5))(_ + 1): " + mapInt(Just(5))(_ + 1)) // Just(5)
  println("mapInt(Empty())(_ + 1): " + mapInt(Empty())(_ + 1)) // Empty()
  println("filter(Just(5))(_ > 2): " + filter(Just(5))(_ > 2)) // Just(5)
  println("filter(Just(5))(_ > 8): " + filter(Just(5))(_ > 8)) // Empty()
  println("filter(Empty())(_ > 2): " + filter(Empty())(_ > 2)) // Empty()