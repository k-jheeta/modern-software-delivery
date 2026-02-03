package tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleTest {

    @Test
    public void alwaysSaysFortyTwo() {
        assertThat(new Example().value(), is(42));
    }

}