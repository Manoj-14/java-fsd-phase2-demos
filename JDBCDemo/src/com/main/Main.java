package com.main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/newdb", "root", "root");
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("Select * from account");) {
			
			while(rs.next()) {
				int acctno = rs.getInt(1);
				String lastname = rs.getString(2);
				String firstname = rs.getString(3);
				int bal = rs.getInt(4);
				
				System.out.println(acctno+"|"+lastname+"|"+firstname+"|"+bal);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
