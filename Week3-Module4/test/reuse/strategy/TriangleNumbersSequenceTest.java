package reuse.strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static reuse.matchers.IterableBeginsWith.beginsWith;

public class TriangleNumbersSequenceTest {

  final TriangleNumbersSequence sequence = new TriangleNumbersSequence();

  @Test
  public void definesFirstTermToBeOne() {

    assertThat(sequence.calculateSequenceTotal(0), is(1));
  }

  @Test
  public void definesSubsequentTermsToBeNAdd1MultipliedByNAdd2DividedBy2() {

    assertThat(sequence.calculateSequenceTotal(2), is(6));
    assertThat(sequence.calculateSequenceTotal(3), is(10));
    assertThat(sequence.calculateSequenceTotal(4), is(15));
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
    assertThat(sequence, beginsWith(1, 3, 6, 10, 15));
  }

}