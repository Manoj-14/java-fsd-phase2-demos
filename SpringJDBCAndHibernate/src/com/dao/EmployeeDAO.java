package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.to.Employee;

public class EmployeeDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager platformTransactionManager;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	public int addEmployee(Employee e) {
		int count = 0;
		String query = "insert into employee values(?,?,?,?)" ;
		count = jdbcTemplate.update(query, e.getEid(),e.getEname(),e.getAge(),e.getPassword());
		return count;
	}
	
	public List<Employee> getAllEmployee(){
		String query = "Select * from Employee";
		List<Employee> employees = jdbcTemplate.query(query,new EmployeeMapper());
		return employees;
	}
	public void performMultipleActions(Employee e) {
		System.out.println("Performing multiple actions");
		TransactionDefinition td = new DefaultTransactionDefinition();
		TransactionStatus ts = platformTransactionManager.getTransaction(td);
		try {
			String query = "insert into Employee values(?,?,?,?);";
			int count = jdbcTemplate.update(query, e.getEid(),e.getEname(),e.getAge(),e.getPassword());
			System.out.println(count+" data inserted");
			query = "Select * from employee where Age=(Select max(Age) from employee) ;";
			List<Employee> a = jdbcTemplate.query(query,new EmployeeMapper());
			System.out.println("Max Age = "+a.toString());
			
			platformTransactionManager.commit(ts);
			
		}catch(Exception e1) {
			System.out.println("Transaction failed "+e1);
			platformTransactionManager.rollback(ts);
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}

	public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
	}
	
}
