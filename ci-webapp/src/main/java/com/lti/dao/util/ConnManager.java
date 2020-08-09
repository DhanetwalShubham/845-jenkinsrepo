package com.lti.dao.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {

	public static Connection connect() {
		try {
			Properties dbProps = new Properties();
			//how to remove hardcoded filename -- we need to pass the filename as an env variable
			//one option is to pass VM arguments using -D option
			//dbProps.load(new FileReader("dev-db.properties"));
			dbProps.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));
			Class.forName(dbProps.getProperty("driverName"));
			return DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("user"), dbProps.getProperty("pass"));
		}
		catch(ClassNotFoundException | IOException | SQLException e ) {
			e.printStackTrace();	//not good, should be thrown rather
			return null;			//very bad, should throw some user defined exception
		}
	}
	
	/*public static Connection connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "hr";
			String pass = "Shubham123";
			return DriverManager.getConnection(url, user, pass);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();	//not good, should be thrown rather
			return null;			//very bad, should throw some user defined exception
		}
	}*/
}