package reuse.templatemethod;

import java.util.Iterator;

public class FibonacciSequence implements Iterable<Integer> {

  int intReturningOne = 2;

  public int calculateFibonacciSequenceTotal(int i) {
    if (i < 0) {
      throw new IllegalArgumentException("Not defined for indices < 0");
    }
    if (i < intReturningOne) {
      return 1;
    }
    return calculateFibonacciSequenceTotal(i - 1) + getAdditionalSum(i);
  }

  private int getAdditionalSum(int i) {
    return calculateFibonacciSequenceTotal(i - 2);
  }

  public Iterator<Integer> iterator() {
    return new SequenceIterator();
  }

  private class SequenceIterator implements Iterator<Integer> {

    private int index = 0;

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Integer next() {
      return calculateFibonacciSequenceTotal(index++);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("remove is not implemented");
    }
  }
}
