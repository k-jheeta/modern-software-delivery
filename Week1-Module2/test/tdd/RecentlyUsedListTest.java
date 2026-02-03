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

    @Test
    public void recentlyUsedListShouldAddItem(){
        List<String> list = new RecentlyUsed().addRecentlyUsed("item1");

        assertThat(list.size(), is(1));
        assertThat(list.get(0), is("item1"));
    }

}