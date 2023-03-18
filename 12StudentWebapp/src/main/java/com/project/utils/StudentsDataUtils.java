package com.project.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.project.resources.model.Student;

public class StudentsDataUtils {

	private DataSource dataSource;

	public StudentsDataUtils(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() {
		Statement statement = null;
		ResultSet rs = null;
		Connection con = null;
		List<Student> students = new ArrayList<>();
		try {
			con = this.dataSource.getConnection();
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

	public void deleteStudents(int studentId) {
		Connection con = null;
		PreparedStatement ps = null;
		int res = -1;
		try {
			con = this.dataSource.getConnection();
			ps = con.prepareStatement("Delete from student where id= ?");
			ps.setInt(1, studentId);
			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

	public Student getStudentsById(int studentId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs;
		Student student = null;
		try {
			con = this.dataSource.getConnection();
			ps = con.prepareStatement("Select * from student where id= ?");
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				student = new Student(id, first_name, last_name, email);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	public void update_student(int id, String firstname, String lastname, String email) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.dataSource.getConnection();
			ps = con.prepareStatement("update student set first_name= ?,last_name= ?,email= ? where id=?");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setInt(4, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addStudent(String firstname, String lastname, String email) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = this.dataSource.getConnection();
			ps = con.prepareStatement("insert into student(first_name,last_name,email) values (?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
