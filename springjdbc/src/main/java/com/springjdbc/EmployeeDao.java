package com.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee e){
		String query="insert into employee(id,name,salary)values(?,?,?)";
		int r = this.jdbcTemplate.update(query,e.getId(),e.getName(),e.getSalary());
		return r;
	}
	public int updateEmployee(Employee e){  
	    String query="update employee set name='"+e.getName()+"',salary="+e.getSalary()+"where id="+e.getId();
	    return jdbcTemplate.update(query);
	}
	public int deleteEmployee(Employee e) {
		String query="delete from employee where id="+e.getId();
		return jdbcTemplate.update(query);
	}
}
