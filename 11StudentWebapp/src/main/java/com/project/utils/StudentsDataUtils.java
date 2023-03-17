package com.project.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.project.resources.model.Student;

public class StudentsDataUtils {

	Connection con = null;
	Statement statement = null;
	ResultSet rs = null;
	List<Student> students = new ArrayList<>();

	public StudentsDataUtils(Connection con) {
		this.con = con;
	}

	public List<Student> getStudents() {
		try {
			statement = con.createStatement();
			rs = statement.executeQuery("Select * from student order by id");
			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				students.add(new Student(id, first_name, last_name, email));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, statement, rs);
		}
		return students;
	}

	private void close(Connection con1, Statement statement, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (con1 != null) {
				con1.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
