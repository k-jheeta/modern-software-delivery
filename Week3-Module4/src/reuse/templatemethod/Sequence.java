package reuse.templatemethod;

public interface Sequence {
    default int calculateSequenceTotal(int i, int intReturningOne) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        if (i < intReturningOne) {
            return 1;
        }
        return calculateSequenceTotal(i - 1, intReturningOne) + getAdditionalSum(i);
    }

    int getAdditionalSum(int i);
}
