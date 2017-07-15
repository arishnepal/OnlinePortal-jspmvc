package com.onp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUtil {
		private static String url = "jdbc:mysql://localhost:3306/";
		private static String databaseName = "onp";
		private static String user = "root";
		private static String pass = "root";
		private static String driverName = "com.mysql.jdbc.Driver";

		public static Connection getConnection() throws ClassNotFoundException,
				SQLException {
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url + databaseName, user,
					pass);
			return con;
		}

		public static void closeConnection(Connection con) throws SQLException {
			if (null != con && !con.isClosed()) {
				con.close();

			}
		}

		public static void closeAll(PreparedStatement preparedStatement) {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}


	}



