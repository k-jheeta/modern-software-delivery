package reuse.templatemethod;

public enum SequenceName {
    TRIANGLE(1),
    FIBONACCI(2);

    private final int intReturningOne;

    SequenceName(int intReturningOne) {
        this.intReturningOne = intReturningOne;
    }

    public int getIntReturningOne() {
        return intReturningOne;
    }
}