package core.enums;

import java.util.Random;

public enum CoinSide {
	HEADS, TAILS;
	private static Random rnd = new Random();
	
	public String toString(){
		return name();
	}
	
	static public CoinSide flip(){
		return (rnd.nextBoolean() ? HEADS : TAILS);
	}
	public static void main(String args[]){
		for(int i=0;i<6;i++){
			System.out.println(CoinSide.flip());
		}
	}
}
