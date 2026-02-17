package reuse.templatemethod;

import java.util.Iterator;

public class TriangleNumbersSequence implements Iterable<Integer>{
    public int calculateTriangleNumberSequenceTotal(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        if (i < 2) {
            return 1;
        }
        return calculateTriangleNumberSequenceTotal(i - 1) + calculateTriangleNumberSequenceTotal(i - 2);
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
            return calculateTriangleNumberSequenceTotal(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }
}
