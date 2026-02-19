package reuse.strategy;

import java.util.Iterator;

public class CalculateSequence implements Iterable<Integer> {
    private final Sequence sequence;

    public CalculateSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public int calculateSequenceTotal(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        if (i < sequence.intReturningOne()) {
            return 1;
        }
        return calculateSequenceTotal(i - 1) + sequence.getAdditionalSum(i, this);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SequenceIterator(this);
    }
}
