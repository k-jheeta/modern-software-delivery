package tdd;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecentlyUsed<T> {
  List<T> recentlyUsed = new ArrayList<>();

  public List<T> recentlyUsedList() {
    return recentlyUsed;
  }

  public void addRecentlyUsed(T item) {
    if (item == null) {
        throw new IllegalArgumentException("Item cannot be null");
    }
    if (recentlyUsed.contains(item)) {
        recentlyUsed.remove(item);
        recentlyUsed.add(0, item);
    } else {
        recentlyUsed.add(0, item);
    }
  }
}