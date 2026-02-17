package reuse.templatemethod;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static reuse.matchers.IterableBeginsWith.beginsWith;

public class TriangleNumbersSequenceTest {

  final TriangleNumbersSequence sequence = new TriangleNumbersSequence();

  @Test
  public void definesFirstTwoTermsToBeOne() {

    assertThat(sequence.calculateTriangleNumberSequenceTotal(0), is(1));
    assertThat(sequence.calculateTriangleNumberSequenceTotal(1), is(1));
  }

  @Test
  public void definesSubsequentTermsToBeNAdd1MultipliedByNAdd2DividedBy2() {

    assertThat(sequence.calculateTriangleNumberSequenceTotal(2), is((3*4)/2));
    assertThat(sequence.calculateTriangleNumberSequenceTotal(3), is((4*5)/2));
    assertThat(sequence.calculateTriangleNumberSequenceTotal(4), is((5*6)/2));
  }

  @Test
  public void isUndefinedForNegativeIndices() {

    try {
      sequence.calculateTriangleNumberSequenceTotal(-1);
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