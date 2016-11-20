package _scratch;

/**
 * Created by vasanth on 11/19/16.
 */
public class CountBy4 {
    public static void main(String[] args){
        int j=0;
        for(int i=2;i<=2000;i=i+2){
            System.out.print(i);
            System.out.print("\t");
            j++;
            if(j==10) {
                j=0;
                System.out.println();
            }
        }
    }
}
