package problems;

import java.util.Scanner;

public class NumberOfOnes {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int NUM = in.nextInt();
		int[] bits=new int[NUM];
		
		for (int i = 0; i < NUM; i++) {
			bits[i] = in.nextInt();
		}

		int max=0;
		int max_x =0;
		int max_y=0;
		
		//quadratic
		for(int i=0;i<NUM;i++){
			for(int j=i+1;j<NUM;j++){
				
				int sum=0;
				for(int k=i;k<=j;k++){
					if(bits[k]==0){ 
						sum++;
					} else{
						sum--;
					}
					
					if(sum>max){
						max=sum;
						max_x=i;
						max_y=j;
					}
				}
			}
		}
		
		int maxOnes=0;
		for(int i=max_x;i<=max_y;i++){
			if(bits[i]==0){
				maxOnes++;
			}
		}
		
		for(int i=0;i<max_x;i++){
			if(bits[i]==1){
				maxOnes++;
			}
		}
		
		for(int i=max_y;i<NUM;i++){
			if(bits[i]==1){
				maxOnes++;
			}
		}
	
		System.out.println(maxOnes);
	}

}
