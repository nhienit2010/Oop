package com.kma.qltkb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect_SQL {
	
    private static String DB_URL = "jdbc:mysql://localhost:3306/test";	// Kết nối với mySQL thông qua port 3306
    private static String USER_NAME = "root"; // Login bằng người dùng root
    private static String PASSWORD = "";	// Password của root (trường hợp này là rỗng)
    
	// Tạo class kết nối mySQL
    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            //System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

}
