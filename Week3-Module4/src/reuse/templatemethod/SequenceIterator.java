package reuse.templatemethod;

import java.util.Iterator;

public final class SequenceIterator implements Iterator<Integer> {
    private final Sequence sequence;
    private int index = 0;

    public SequenceIterator(Sequence sequence) {
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
