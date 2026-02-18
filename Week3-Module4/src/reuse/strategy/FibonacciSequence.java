package reuse.strategy;

public class FibonacciSequence implements Sequence {
  @Override
  public int intReturningOne() {
    return 2;
  }

  @Override
  public int getAdditionalSum(int i) {
    return calculateSequenceTotal(i - 2);
  }
}
