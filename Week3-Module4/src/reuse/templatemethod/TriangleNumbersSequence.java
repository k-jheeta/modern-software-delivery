package reuse.templatemethod;

import java.util.Iterator;

public class TriangleNumbersSequence implements Iterable<Integer>, Sequence{
    @Override
    public int getAdditionalSum(int i) {
        return i + 1;
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
            return calculateSequenceTotal(index++, SequenceName.TRIANGLE);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }
}
