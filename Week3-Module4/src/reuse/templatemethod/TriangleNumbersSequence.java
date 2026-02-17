package reuse.templatemethod;

import java.util.Iterator;

public class TriangleNumbersSequence implements Sequence{
    @Override
    public int intReturningOne() {
        return 1;
    }

    @Override
    public int getAdditionalSum(int i) {
        return i + 1;
    }
}
