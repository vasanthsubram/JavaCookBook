/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.collection.apacheCollectionUtils;

import utils.CollectionPrinter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author vsubramanian
 */
public class CollectionComparsionIntegers {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(4);
        list1.add(5);
        list1.add(7);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        System.out.println("Disjunction - stuff that are present in one but not the other");
        CollectionPrinter.print(CollectionUtils.disjunction(list1, list2));
        System.out.println();
        System.out.println();
        System.out.println("Intersection - stuff that are present in both");
        CollectionPrinter.print(CollectionUtils.intersection(list1, list2));

        System.out.println();
        System.out.println("Union");
        CollectionPrinter.print(CollectionUtils.union(list2, list1));

        System.out.println();
        System.out.println("list1 - list2");
        CollectionPrinter.print(CollectionUtils.subtract(list1, list2));

        System.out.println();
        System.out.println("list2 - list1");
        CollectionPrinter.print(CollectionUtils.subtract(list2, list1));
    }
}
