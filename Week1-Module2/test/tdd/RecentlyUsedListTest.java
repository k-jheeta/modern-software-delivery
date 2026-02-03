package tdd;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RecentlyUsedListTest {

    @Test
    public void recentlyUsedListShouldBeEmpty(){
        RecentlyUsed recentlyUsed = new RecentlyUsed();

        List<String> list = recentlyUsed.recentlyUsedList();

        assertThat(list.size(), is(0));
    }

    @Test
    public void addItemsToRecentlyUsedList(){
        RecentlyUsed recentlyUsed = new RecentlyUsed();

        recentlyUsed.addRecentlyUsed("item1");

        List<String> recentlyUsedList = recentlyUsed.recentlyUsedList();

        assertThat(recentlyUsedList.size(), is(1));
    }

    @Test
    public void readItemsFromRecentlyUsedList(){
        RecentlyUsed recentlyUsed = new RecentlyUsed();

        recentlyUsed.addRecentlyUsed("item1");

        List<String> list = recentlyUsed.recentlyUsedList();

        assertThat(list.size(), is(1));
        assertThat(list.get(0), is("item1"));
    }

    @Test
    public void mostRecentItemShouldBeFirstInList(){
        RecentlyUsed recentlyUsed = new RecentlyUsed();

        recentlyUsed.addRecentlyUsed("item1");
        recentlyUsed.addRecentlyUsed("item2");

        List<String> list = recentlyUsed.recentlyUsedList();

        assertThat(list.size(), is(2));
        assertThat(list.get(0), is("item2"));
        assertThat(list.get(1), is("item1"));
    }

    @Test
    public void itemsShouldBeUniqueAndDuplicatesAreMoved(){
        RecentlyUsed recentlyUsed = new RecentlyUsed();

        recentlyUsed.addRecentlyUsed("item1");
        recentlyUsed.addRecentlyUsed("item2");
        recentlyUsed.addRecentlyUsed("item1");
        recentlyUsed.addRecentlyUsed("item3");

        List<String> list = recentlyUsed.recentlyUsedList();

        assertThat(list.size(), is(3));
        assertThat(list.get(0), is("item3"));
        assertThat(list.get(1), is("item1"));
        assertThat(list.get(2), is("item2"));
    }

    @Test
    public void throwErrorWhenAddingNullItem(){
        RecentlyUsed recentlyUsed = new RecentlyUsed();

        try {
            recentlyUsed.addRecentlyUsed(null);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Item cannot be null"));
        }
    }

}