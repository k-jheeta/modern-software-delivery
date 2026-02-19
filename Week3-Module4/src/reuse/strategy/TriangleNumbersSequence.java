package reuse.strategy;

public class TriangleNumbersSequence implements Sequence {
    @Override
    public int intReturningOne() {
        return 1;
    }

    @Override
    public int getAdditionalSum(int i, CalculateSequence calculateSequence) {
        return i + 1;
    }
}
