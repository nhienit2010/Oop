package com.kma.qltkb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

	public String fullName;
	
	public String id;
	
	public String pass;
	
	public Student() {}

	public Student(String fullName, String id, String pass) {
		this.fullName = fullName;
		this.id = id;
		this.pass = pass;
	}

	public void addIntoSQL() {
		try {
			Connect_SQL connect = new Connect_SQL();
			Connection conn = connect.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); 
			Statement stmt = conn.createStatement();
            String query = "insert into oop_users values ('" + this.id +"', '" + this.pass + "');";
            stmt.executeUpdate(query);
            conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static boolean checkExists(String id) {
		boolean flag = false;
		
		try {
			Connect_SQL connect = new Connect_SQL();
			Connection conn = connect.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select password from oop_users");
            
            while (rs.next() && flag == false) {
                if (rs.getString(1).equals(id) )
                	flag = true;
            }
            conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return flag;
		
	}
	public static boolean checkLogin(String id,String pass) {
		boolean flag = false;
		
		try {
			Connect_SQL connect = new Connect_SQL();
			Connection conn = connect.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select password from oop_users where username= '"+ id + "'");
            
            while (rs.next()) {
                if (pass.equals(rs.getString(1)))
                	flag = true;
                else 
                	flag = false;
                break;
            }
            conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		
		return flag;
	}
}
