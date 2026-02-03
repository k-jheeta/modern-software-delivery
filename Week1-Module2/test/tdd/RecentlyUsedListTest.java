package tdd;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RecentlyUsedListTest {

    @Test
    public void recentlyUsedListShouldBeEmpty(){
        RecentlyUsed<PhoneNumber> recentlyUsed = new RecentlyUsed<>();

        List<PhoneNumber> list = recentlyUsed.recentlyUsedList();

        assertThat(list.size(), is(0));
    }

    @Test
    public void addItemsToRecentlyUsedList(){
        RecentlyUsed<PhoneNumber> recentlyUsed = new RecentlyUsed<>();

        recentlyUsed.addRecentlyUsed(new PhoneNumber("1234567890"));

        List<PhoneNumber> recentlyUsedList = recentlyUsed.recentlyUsedList();

        assertThat(recentlyUsedList.size(), is(1));
    }

    @Test
    public void readItemsFromRecentlyUsedList(){
        File file = new File("file1.txt");
        RecentlyUsed<File> recentlyUsed = new RecentlyUsed<>();

        recentlyUsed.addRecentlyUsed(file);

        List<File> recentlyUsedList = recentlyUsed.recentlyUsedList();

        assertThat(recentlyUsedList.size(), is(1));
        assertThat(recentlyUsedList.get(0), is(file));
    }

    @Test
    public void mostRecentItemShouldBeFirstInList(){
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        RecentlyUsed<File> recentlyUsed = new RecentlyUsed<>();

        recentlyUsed.addRecentlyUsed(file1);
        recentlyUsed.addRecentlyUsed(file2);

        List<File> recentlyUsedList = recentlyUsed.recentlyUsedList();

        assertThat(recentlyUsedList.size(), is(2));
        assertThat(recentlyUsedList.get(0), is(file2));
        assertThat(recentlyUsedList.get(1), is(file1));
    }

    @Test
    public void itemsShouldBeUniqueAndDuplicatesAreMoved(){
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        RecentlyUsed<File> recentlyUsed = new RecentlyUsed<>();

        recentlyUsed.addRecentlyUsed(file1);
        recentlyUsed.addRecentlyUsed(file2);
        recentlyUsed.addRecentlyUsed(file1);
        recentlyUsed.addRecentlyUsed(file3);

        List<File> recentlyUsedList = recentlyUsed.recentlyUsedList();

        assertThat(recentlyUsedList.size(), is(3));
        assertThat(recentlyUsedList.get(0), is(file3));
        assertThat(recentlyUsedList.get(1), is(file1));
        assertThat(recentlyUsedList.get(2), is(file2));
    }

    @Test
    public void throwErrorWhenAddingNullItem(){
        RecentlyUsed<File> recentlyUsed = new RecentlyUsed<>();

        try {
            recentlyUsed.addRecentlyUsed(null);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Item cannot be null"));
        }
    }

}