package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*
import task5.Optionals.OptionalInt.{Empty, Just, filter, mapInt}

class OptionalIntTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

/** Testing Task 5: **/

  @Test def mapIntOptionalJust(): Unit =
    assertEquals(Just(6), mapInt(Just(5))(_ + 1))

  @Test def mapIntOptionalEmpty(): Unit =
    assertEquals(Empty(), mapInt(Empty())(_ + 1))

  @Test def filterKeepsValueWhenPredicateIsTrue(): Unit =
    assertEquals(Just(5), filter(Just(5))(_ > 2))

  @Test def filterKeepsValueWhenPredicateIsFalse(): Unit =
    assertEquals(Empty(), filter(Just(5))(_ > 8))

  @Test def filterOnEmpty(): Unit =
    assertEquals(Empty(), filter(Empty())(_ > 2))