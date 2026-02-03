package tdd;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsed {
  List<String> recentlyUsed = new ArrayList<>();

  public List<String> recentlyUsedList() {
    return recentlyUsed;
  }

  public void addRecentlyUsed(String item) {
    if (recentlyUsed.contains(item)) {
      recentlyUsed.remove(item);
      recentlyUsed.add(0, item);
    }
    else {
      recentlyUsed.add(0, item);
    }
  }
}