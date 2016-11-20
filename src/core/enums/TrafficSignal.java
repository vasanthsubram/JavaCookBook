package core.enums;

import java.util.Random;

public enum TrafficSignal{
	STOP (SignalColor.RED) {
		public boolean canProceed(){
			return false;
		}
	},
	
	WATCH(SignalColor.YELLOW){
		public boolean canProceed(){
			return rnd.nextBoolean();
		}
	}, 
	
	GO(SignalColor.GREEN)
	{
		public boolean canProceed(){
			return true;
		}
	};
	
	SignalColor signalColor;
	
	TrafficSignal(SignalColor color) {this.signalColor=color;}
	
	public abstract boolean canProceed();
	
	public SignalColor getColor(){
		return signalColor;
	}
	
	public static void main(String args[]){
		System.out.println(TrafficSignal.GO.getColor().name());
		System.out.println(TrafficSignal.GO.canProceed());
		System.out.println(TrafficSignal.WATCH.canProceed());
	}
	
	public enum SignalColor {
		RED, YELLOW, GREEN;
	}

	private static Random rnd = new Random();
}
