package com.makStudio.springservice.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtility {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Properties prop = new Properties();
				InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
				System.out.println("InputStream"+ inputStream);
				String driver = null;
                String url =null;
                String user = null;
                String password = null;
				if(inputStream != null){
					System.out.println("If Part when properties file is loaded ");
					prop.load(inputStream);
					driver = prop.getProperty("driver");
					url = prop.getProperty("url");
					user = prop.getProperty("user");
					password = prop.getProperty("password");
					}
				else{
					System.out.println("Else Part when properties file is not loaded ");
					driver = "com.mysql.jdbc.Driver";
					url = "jdbc:mysql://localhost:3306/taskmanager";
					user = "root";
					password = "root";
				}
				System.out.println("--before Class Loaded--"+ Class.forName(driver));
				Class.forName(driver);
				System.out.println("--Class Loaded--"+ Class.forName(driver));
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
	public static void main(String[] args) {
		System.out.println(DBUtility.getConnection());
	}
}