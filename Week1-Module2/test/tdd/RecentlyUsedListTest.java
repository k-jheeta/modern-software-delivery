package tdd;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RecentlyUsedListTest {

    @Test
    public void recentlyUsedListShouldBeEmpty(){
        List<String> list = new RecentlyUsed().recentlyUsedList();

        assertThat(list.size(), is(0));
    }

}