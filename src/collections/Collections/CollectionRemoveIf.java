package collections.Collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionRemoveIf {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("ABC", "DEF", "GHI"));
        System.out.println(list);
        list.removeIf(value -> value.equals("GHI"));
        System.out.println(list);
    }
}
