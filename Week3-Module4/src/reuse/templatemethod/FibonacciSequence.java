package reuse.templatemethod;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {
  @Override
  public int getAdditionalSum(int i) {
    return calculateSequenceTotal(i - 2, SequenceName.FIBONACCI);
  }
}
