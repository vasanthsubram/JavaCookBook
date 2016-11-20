package database;

import java.sql.*;

public class DB2BigDecimal {

	public static void main(String args[]){
			//-9,999,999,999,999,999,999,999,999,999,999. to  9,999,999,999,999,999,999,999,999,999,999.
			try{
				Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
				Connection connection = DriverManager.getConnection("jdbc:db2://localhost:50000/db2test","perstest", "startup1");
				Statement  statement = connection.createStatement();
				statement.executeUpdate("INSERT INTO TEST1 values(99999999999999999999999999999.99,-9999999999999999999999999999999., 1234567890.01)");
				//statement.executeUpdate("INSERT INTO TEST1 values(99999999999999999999999999999.99,9999999999999999999999999999999.)");
				ResultSet  rs = statement.executeQuery("SELECT * FROM TEST1");
				while(rs.next()){
					System.out.println(rs.getBigDecimal("COLUMN1"));
					System.out.println(rs.getBigDecimal("COLUMN2"));
					System.out.println(rs.getBigDecimal("COLUMN3"));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}
