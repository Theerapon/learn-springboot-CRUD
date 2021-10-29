package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
//	private EmployeeDAO employeeDAO;
	
//	@Autowired
//	public EmployeeServiceImpl(@Qualifier("employeeDAOHibernateImpl") EmployeeDAO employeeDAO) {
//		this.employeeDAO = employeeDAO;
//	}
	
//	@Autowired
//	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
//		this.employeeDAO = employeeDAO;
//	}
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		//return employeeDAO.findAll();
		return employeeRepository.findAll();
	}

	

	@Override
	@Transactional
	public Employee findById(int theId) {
		//return employeeDAO.findById(theId);
		Optional<Employee> result = employeeRepository.findById(theId);
				
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Did not find employee id " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		//employeeDAO.save(theEmployee);
		employeeRepository.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		//employeeDAO.deleteById(theId);
		employeeRepository.deleteById(theId);
	}

}
