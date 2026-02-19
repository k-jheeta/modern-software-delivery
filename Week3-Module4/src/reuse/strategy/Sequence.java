package reuse.strategy;

import java.util.Iterator;

public class Sequence implements Iterable<Integer>{
    private final TriangleNumbersSequence triangleNumbersSequence;

    public Sequence(TriangleNumbersSequence triangleNumbersSequence) {
        this.triangleNumbersSequence = triangleNumbersSequence;
    }

    public int calculateSequenceTotal(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        if (i < triangleNumbersSequence.intReturningOne()) {
            return 1;
        }
        return calculateSequenceTotal(i - 1) + triangleNumbersSequence.getAdditionalSum(i);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SequenceIterator(this);
    }
}
