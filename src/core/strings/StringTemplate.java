package core.strings;

public class StringTemplate {

	public static void main(String[] args) {
		String s="SELECT TRANSACTION_ID_1, TRANSACTION_ID_2 "
		+ "FROM %s.TRANSACTION "
		+ "WHERE BRANCH_SUBMITTED_TIME IS NULL "
		+ "FETCH FIRST %s ROWS ONLY";
			
		System.out.println(String.format(s,"ARCH",10));
		

	}

}
