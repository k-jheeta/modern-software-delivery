package reuse.strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static reuse.matchers.IterableBeginsWith.beginsWith;

public class FibonacciSequenceTest {

  final FibonacciSequence sequence = new FibonacciSequence();

  @Test
  public void definesFirstTwoTermsToBeOne() {

    assertThat(sequence.calculateSequenceTotal(0), is(1));
    assertThat(sequence.calculateSequenceTotal(1), is(1));
  }

  @Test
  public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {

    assertThat(sequence.calculateSequenceTotal(2), is(2));
    assertThat(sequence.calculateSequenceTotal(3), is(3));
    assertThat(sequence.calculateSequenceTotal(4), is(5));
  }

  @Test
  public void isUndefinedForNegativeIndices() {

    try {
      sequence.calculateSequenceTotal(-1);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
    }
  }

  @Test
  public void canBeIteratedThrough() {
    assertThat(sequence, beginsWith(1, 1, 2, 3, 5));
  }
}

