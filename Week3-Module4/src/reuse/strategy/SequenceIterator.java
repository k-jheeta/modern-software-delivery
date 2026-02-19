package reuse.strategy;

import java.util.Iterator;

public class SequenceIterator implements Iterator<Integer> {
    private final CalculateSequence sequence;
    private int index = 0;

    public SequenceIterator(CalculateSequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return sequence.calculateSequenceTotal(index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove is not implemented");
    }
}