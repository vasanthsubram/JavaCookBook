package core.enums;

public enum DaysOfWeek {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	
	public static void main(String[] args){
		for(DaysOfWeek e: DaysOfWeek.values()){
			System.out.println(e);
		}
		DaysOfWeek m = DaysOfWeek.valueOf(DaysOfWeek.class, "MONDAY");
		System.out.println(m.name());
	}
}
