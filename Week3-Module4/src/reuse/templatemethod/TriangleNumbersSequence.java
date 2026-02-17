package reuse.templatemethod;

public class TriangleNumbersSequence implements Sequence {
    @Override
    public int intReturningOne() {
        return 1;
    }

    @Override
    public int getAdditionalSum(int i) {
        return i + 1;
    }
}
