package com.xsis.batch137.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.EmployeeDao;
import com.xsis.batch137.dao.EmployeeOutletDao;
import com.xsis.batch137.dao.UserDao;
import com.xsis.batch137.model.Employee;
import com.xsis.batch137.model.EmployeeOutlet;
import com.xsis.batch137.model.Outlet;
import com.xsis.batch137.model.User;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	@Autowired
	EmployeeOutletDao eoDao;
	
	@Autowired
	UserDao uDao;
	
	public void save(Employee emp) {
		Employee employee = new Employee();
		employee.setId(emp.getId());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setEmail(emp.getEmail());
		employee.setTitle(emp.getTitle());
		employee.setHaveAccount(emp.isHaveAccount());
		employee.setActive(emp.isActive());
		empDao.save(employee);
		
		List<EmployeeOutlet> empos = eoDao.getEmployeeOutletByEmployee(employee);
		if(empos!=null) {
			for(EmployeeOutlet eo : empos) {
				eoDao.delete(eo);
			}
		}
		if(emp.getEmpOutlet()!=null) {
			for(EmployeeOutlet eo : emp.getEmpOutlet()) {
				EmployeeOutlet empo = new EmployeeOutlet();
				empo.setEmployee(employee);
				empo.setOutlet(eo.getOutlet());
				eoDao.save(empo);
			}
		}
		if(emp.getUser()!=null) {
			User user = new User();
			user.setId(emp.getUser().getId());
			user.setEmployee(employee);
			user.setActive(emp.getUser().isActive());
			user.setRole(emp.getUser().getRole());
			user.setUsername(emp.getUser().getUsername());
			user.setPassword(emp.getUser().getPassword());
			uDao.save(user);
		}
		
	}
	
	public void update(Employee emp) {
		empDao.update(emp);
	}
	
	public void delete(int id) {
		Employee emp = new Employee();
		emp.setId(id);
		emp.setFirstName("aaaaa");
		emp.setLastName("aaaaa");
		emp.setHaveAccount(true);
		emp.setActive(false);
		empDao.delete(emp);
	}
	
	public List<Employee> selectAll(){
		List<Employee> emps = empDao.selectAll(); 
		if(emps.isEmpty()) {
			return null;
		}else {
			for(Employee emp : emps) {
				List<EmployeeOutlet> empOUtlets = eoDao.getEmployeeOutletByEmployee(emp);
				emp.setEmpOutlet(empOUtlets);
			}
			return emps;
		}
	}
	
	public Employee getOne(long id) {
		Employee empss = empDao.getOne(id);
		List<EmployeeOutlet> empOUtlets = eoDao.getEmployeeOutletByEmployee(empss);
		if(empOUtlets.isEmpty()) {
			
		}else {
			empss.setEmpOutlet(empOUtlets);
		}
		return empss;
	}

	public void nonaktif(long id) {
		// TODO Auto-generated method stub
		empDao.nonaktif(id);
	}
	
	public List<Employee> getEmployeeByEmail(String email) {
		return empDao.getEmployeeByEmail(email);
	}
	
	public int countEmployeeByEmail(String email) {
		return empDao.countEmployeeByEmail(email);
	}
	
	public int countUserByUsername(String username) {
		return uDao.countUserByUsername(username);
	}
}
