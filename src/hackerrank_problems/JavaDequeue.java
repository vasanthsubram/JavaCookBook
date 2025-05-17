package hackerrank_problems;

import java.util.*;

/*

In this problem, you are given N integers. You need to find the maximum number of unique integers among all the
 possible contiguous subarrays of size M .

Note: Time limit is 3 second for this problem.

Input Format
The first line of input contains two integers N and M: representing the total number of integers and
the size of the subarray, respectively. The next line contains N space separated integers.

Output Format
Print the maximum number of unique integers among all possible contiguous subarrays of size .

Sample Input
6 3
5 3 5 2 3 2

Sample Output
3

 */
public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
//        int n = in.nextInt();
//        int m = in.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            int num = in.nextInt();
//            deque.add(num);
//        }

        int n = 6;
        int m = 3;

        //5, 3, 5, 2, 3, 2
        deque.add(5);
        deque.add(3);
        deque.add(5);
        deque.add(2);
        deque.add(3);
        deque.add(2);

        HashSet<Integer> maxSet = new HashSet<>();
        int maxIterations=(n==m)?1:n-m;
        Map<Integer, Integer> countMap = new HashMap<>();
        int count=0;
        Iterator<Integer> it = deque.iterator();

        for (int j=0;j<maxIterations;j++) {
            while (it.hasNext() && count <m && deque.size()>=m) {
                int nextVal = it.next();
                countMap.put(nextVal, countMap.getOrDefault(nextVal,0)+ 1);
                count++;
            }
            count--;

            maxSet.add(countMap.keySet().size());
            int deleted = deque.removeFirst();
            if (countMap.get(deleted)==1) {
                countMap.remove(deleted);
            } else {
                countMap.put(deleted,countMap.get(deleted)-1);
            }

        }
        System.out.println(Collections.max(maxSet));
    }
}