package tdd;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsed {

  public List<String> recentlyUsedList() {
    return new ArrayList<>();
  }

  public List<String> addRecentlyUsed(String item1) {
    List<String> list = recentlyUsedList();
    list.add(item1);
    return list;
  }
}