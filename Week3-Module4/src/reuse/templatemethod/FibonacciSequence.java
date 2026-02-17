package reuse.templatemethod;

import java.util.Iterator;

public class FibonacciSequence implements Iterable<Integer>, Sequence {
  @Override
  public int getAdditionalSum(int i) {
    return calculateSequenceTotal(i - 2, 2);
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
      return calculateSequenceTotal(index++, 2);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("remove is not implemented");
    }
  }
}
