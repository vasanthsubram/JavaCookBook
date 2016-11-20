package database;

/*

 Derby - Class SimpleApp

 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_SimpleApp {
	/* the default framework is embedded */
	private String framework = "embedded";
	private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private String protocol = "jdbc:derby:";
	// the name of the database
	private String dbName = "derbyDB"; 
	//embedded databases donot need '//'
	private String jdbcUrl = protocol+dbName;
	
	Connection conn = null;
	PreparedStatement psInsert = null;
	PreparedStatement psUpdate = null;
	Statement s = null;
	ResultSet rs = null;
	
	
	public static void main(String[] args) throws Exception {
		new JDBC_SimpleApp().go(args);
		System.out.println("SimpleApp finished");
	}

	void go(String[] args) throws Exception {
		/* parse the arguments to determine which framework is desired */
		parseArguments(args);
		
		// load JDBC driver
		Class.forName(driver).newInstance();

		try {
			getConnection();

			s = conn.createStatement();

			// create a table
			s.execute("create table location(door_num int, address varchar(40))");
			System.out.println("Created table location");

			/*
			 * Add using statement and prepared statement
			 */
			s.executeUpdate("insert into location values(1956, 'Webster st.')");
			System.out.println("Inserted 1956 Webster");

			psInsert = conn
			.prepareStatement("insert into location values (?, ?)");
			psInsert.setInt(1, 1910);
			psInsert.setString(2, "Union St.");
			psInsert.executeUpdate();
			System.out.println("Inserted 1910 Union");

			psInsert.setInt(1, 1111);
			psInsert.setString(2, "3rd ave");
			psInsert.executeUpdate();
			System.out.println("Inserted 1111 3rd ave");
			
			/*
			 * Update
			 */
			psUpdate = conn
					.prepareStatement("update location set door_num=?, address=? where door_num=?");

			psUpdate.setInt(1, 180);
			psUpdate.setString(2, "Grand Ave.");
			psUpdate.setInt(3, 1956);
			psUpdate.executeUpdate();
			System.out.println("Updated 1956 Webster to 180 Grand");

			/*
			 * Query
			 */
			rs = s
					.executeQuery("SELECT door_num, address FROM location ORDER BY door_num");
			System.out.println();
			System.out.println("door no   address");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
				System.out.println(rs.getInt("door_num") + "\t"
						+ rs.getString("address"));
			}
			System.out.println();

			rs = s.executeQuery("select count(*) from location");
			while (rs.next()) {
				System.out.println("Number of records= " + rs.getInt(1));
			}
			System.out.println();
			
			// delete the table
			s.execute("drop table location");
			System.out.println("Dropped table location");

			conn.commit();
			System.out.println("Committed the transaction");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	
	
	/**
	 * This connection specifies create=true in the connection URL to
	 * cause the database to be created when connecting for the first
	 * time. To remove the database, remove the directory derbyDB (the
	 * same as the database name) and its contents.
	 * 
	 * The directory derbyDB will be created under the directory that
	 * the system property derby.system.home points to, or the current
	 * directory (user.dir) if derby.system.home is not set.
	 */
	private void getConnection() throws SQLException{
		Properties props = new Properties(); // connection properties
		props.put("user", "user1");
		props.put("password", "user1");

		conn = DriverManager.getConnection(jdbcUrl+ ";create=true", props);
		// We want to control transactions manually. Autocommit is on by
		// default in JDBC.
		conn.setAutoCommit(false);
	}



	/**
	 * Parses the arguments given and sets the values of this class' instance
	 * variables accordingly - that is which framework to use, the name of the
	 * JDBC driver class, and which connection protocol protocol to use. The
	 * protocol should be used as part of the JDBC URL when connecting to Derby.
	 * <p>
	 * If the argument is "embedded" or invalid, this method will not change
	 * anything, meaning that the default values will be used.
	 * </p>
	 * <p>
	 * 
	 * @param args
	 *            JDBC connection framework, either "embedded", "derbyclient".
	 *            Only the first argument will be considered, the rest will be
	 *            ignored.
	 */
	private void parseArguments(String[] args) {
		if (args.length > 0) {
			if (args[0].equalsIgnoreCase("derbyclient")) {
				framework = "derbyclient";
				driver = "org.apache.derby.jdbc.ClientDriver";
				protocol = "jdbc:derby://localhost:1527/";
			}
		}
	}
}
