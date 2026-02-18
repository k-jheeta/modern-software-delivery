package reuse.strategy;

import java.util.Iterator;

public interface Sequence extends Iterable<Integer> {
    int intReturningOne();

    int getAdditionalSum(int i);

    default int calculateSequenceTotal(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        if (i < intReturningOne()) {
            return 1;
        }
        return calculateSequenceTotal(i - 1) + getAdditionalSum(i);
    }

    @Override
    default Iterator<Integer> iterator() {
        return new SequenceIterator(this);
    }
}
