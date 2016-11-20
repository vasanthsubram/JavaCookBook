package problems;

import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
	        int I = in.nextInt();
	        int[] input=new int[I];
	        
	        for(int i=0;i<I;i++){
	        	input[i]=in.nextInt();
	        }
	        
	        UtopianTree tree = new UtopianTree();
	        for(int i=0;i<I;i++){
	        	int height =tree.calculateHeight(input[i]);
	        	System.out.println(height);
	        }

	}
	
	private int calculateHeight(int N){
		int h=1;
		if(N==0){
			return h;
		}
			
		 for(int i=1;i<=N;i++){
	        	if(isOdd(i)){
	        		h=h*2;
	        	} else{
	        		h=h+1;
	        	}
	        }
		 return h;
	}
	
	private boolean isOdd(int x){
		return (x&1) == 1;
	}

}
