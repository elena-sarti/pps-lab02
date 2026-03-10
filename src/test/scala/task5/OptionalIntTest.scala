package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

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

  /** Task 5: do test for map **/
  @Test def mapIntShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(empty, OptionalInt.mapInt(empty)(_ + 1))

  @Test def mapIntShouldApplyFunctionWhenNonEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    val expectedOptionalInt = OptionalInt.Just(1)
    assertEquals(expectedOptionalInt, OptionalInt.mapInt(nonEmpty)(_ + 1))

  @Test def filterShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(empty, OptionalInt.filter(empty)(_ > 1))

  @Test def filterShouldReturnJustWhenConditionTrue(): Unit =
    val nonEmpty = OptionalInt.Just(1)
    val expectedOptionalInt = OptionalInt.Just(1)
    assertEquals(expectedOptionalInt, OptionalInt.filter(nonEmpty)(_ > 0))

  @Test def filterShouldReturnEmptyWhenConditionFalse(): Unit =
    val nonEmpty = OptionalInt.Just(1)
    val expectedOptionalInt = OptionalInt.Empty()
    assertEquals(expectedOptionalInt, OptionalInt.filter(nonEmpty)(_ == 0))