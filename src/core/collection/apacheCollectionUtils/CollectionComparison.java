package core.collection.apacheCollectionUtils;

import utils.CollectionPrinter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author vsubramanian
 */
public class CollectionComparison {

    public static void main(String[] args) {

        //For this to work, the elements must override equals()
        List<String> userList1 = new ArrayList<String>();
        userList1.add("Test1");
        userList1.add("Test2");
        userList1.add("Test3");

        List<String> userList2 = new ArrayList<String>();
        userList2.add("Test1");
        userList2.add("Test4");
        userList2.add("Test3");

        System.out.println("Disjunction - stuff that are present in one but not the other");
        CollectionPrinter.print(CollectionUtils.disjunction(userList1, userList2));
        System.out.println();
        System.out.println();
        System.out.println("Disjunction - stuff that are present in both");
        CollectionPrinter.print(CollectionUtils.intersection(userList1, userList2));

        System.out.println();
        System.out.println("Union");
        CollectionPrinter.print(CollectionUtils.union(userList2, userList1));

        System.out.println();
        System.out.println("list1 - list2");
        CollectionPrinter.print(CollectionUtils.subtract(userList1, userList2));

        System.out.println();
        System.out.println("list2 - list1");
        CollectionPrinter.print(CollectionUtils.subtract(userList2, userList1));
    }
}
