package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;


public class DBUtil {

	private static final String URL = "jdbc:mysql://211.194.200.54/everyssafy?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String ID = "ssafy";
	private static final String PASSWORD = "ssafy";

	static
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnect() throws SQLException{
		return DriverManager.getConnection(URL,ID,PASSWORD);
	}
	
	public static void close(AutoCloseable... closeables)
	{
		try {
			for(AutoCloseable ac : closeables ) {
			if(ac != null)
				ac.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
