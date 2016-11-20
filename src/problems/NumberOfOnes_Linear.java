package problems;

import java.util.Scanner;

public class NumberOfOnes_Linear {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int NUM = in.nextInt();
		int[] bits=new int[NUM];
		
		for (int i = 0; i < NUM; i++) {
			bits[i] = in.nextInt();
		}

		int runTotalMax=0;
		int runTotalMaxIndex =0;
		int sum=0;
		
		//linear
		for(int i=0;i<NUM;i++){
			if(bits[i]==0){ 
				sum++;
			} else{
				sum--;
			}
		
			if(sum>runTotalMax){
				runTotalMax=sum;
				runTotalMaxIndex=i;
			}
		}
		
		sum=runTotalMaxIndex;
		int runTotalMinIndex=0;
		for(int i=runTotalMaxIndex; i>= 0;i--){
			if(bits[i]==0){
				sum--;
			} else{
				sum++;
			}
			if(sum==0){
				runTotalMinIndex=i;
				break;
			}
		}
	
		int maxOnes=0;
		for(int i=runTotalMinIndex;i<=runTotalMaxIndex;i++){
			if(bits[i]==0){
				maxOnes++;
			}
		}
		
		for(int i=0;i<runTotalMinIndex;i++){
			if(bits[i]==1){
				maxOnes++;
			}
		}
		
		for(int i=runTotalMaxIndex;i<NUM;i++){
			if(bits[i]==1){
				maxOnes++;
			}
		}
		
		System.out.println(maxOnes);
	}

}
