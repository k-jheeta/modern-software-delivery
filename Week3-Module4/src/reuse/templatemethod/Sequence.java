package reuse.templatemethod;

import java.util.Iterator;

public interface Sequence extends Iterable<Integer> {
    default int calculateSequenceTotal(int i, SequenceName sequenceName) {
        int intReturningOne = sequenceName.getIntReturningOne();
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        if (i < intReturningOne) {
            return 1;
        }
        return calculateSequenceTotal(i - 1, sequenceName) + getAdditionalSum(i);
    }

    int getAdditionalSum(int i);

    @Override
    default Iterator<Integer> iterator() {
        return new SequenceIterator(this);
    }
}
