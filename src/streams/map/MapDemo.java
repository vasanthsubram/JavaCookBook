package streams.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vasanthakumarsubramanian on 12/25/16.
 */
public class MapDemo {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("1","2","3");
        //maps the Integer(String) constructor on to each element of strList
//        List<Integer> intList = strList.stream().map(Integer::new).collect(Collectors.toList());
        List<Integer> intList = strList.stream().map(x ->(new Integer(x))).collect(Collectors.toList());

        System.out.println(strList);
        System.out.println(intList);
    }
}
