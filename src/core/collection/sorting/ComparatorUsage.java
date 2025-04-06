package core.collection.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ComparatorUsage {

  private static Comparator SortBySize = new Comparator<String>() {
    @Override
    public int compare(String str1, String str2) {
      return str1.length() - str2.length();
    }
  };

  public static void main(String[] args){
    SortedSet<String> set = new TreeSet<>(SortBySize);
    set.add("aabb");
    set.add("aa");
    set.add("ddddd");
    set.add("z");
    System.out.println(set.toString());


    List<String> list = Arrays.asList("aabb","aa","ddddd","z");
    Collections.sort(list, SortBySize);
    System.out.println(list);

    //reverse the comparator
    Collections.sort(list, SortBySize.reversed());
    System.out.println(list);

  }
}


