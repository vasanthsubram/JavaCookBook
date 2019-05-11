package core.collection.sorting;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortAccordingToSizeOFStrings {
  public static void main(String[] args){
    SortedSet<String> set = new TreeSet<>(new SortBySize());
    set.add("aabb");
    set.add("aa");
    set.add("ddddd");
    set.add("z");
    System.out.println(set.toString());
  }


  static class SortBySize implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
      if(str1.length()== str2.length()){
        return 0;
      }
      if(str1.length()> str2.length()){
        return 1;
      }
      return -1;
    }
  }
}


