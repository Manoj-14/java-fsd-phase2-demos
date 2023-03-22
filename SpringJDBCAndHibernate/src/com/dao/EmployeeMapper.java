package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.to.Employee;



public class EmployeeMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee e = new Employee();
		e.setEid(rs.getInt("Eid"));
		e.setEname(rs.getString("Ename"));
		e.setAge(rs.getInt("Age"));
		e.setPassword(rs.getString("Password"));
		return e;
	}

	
	
}
