package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
	private EmployeeRepo employeeRepo;
    
    
   public List <Employee> findByName(String name){
	   return employeeRepo.findByName(name);
   }
   public List <Employee> findByNameStartingWithAndSalary(String name,Double salary){
	   return employeeRepo.findByNameStartingWithAndSalary(name, salary);
   }
	   public   List <Employee> findByNameAndSalary(String name,Double salary){
	   return employeeRepo.findByNameAndSalary(name, salary);
	   }
	   public  List<Employee> findByNameContaining(String name){
	   return employeeRepo.findByNameContaining(name);
	   }

    @Query(value="Select * from employeeData where name like :empName and salary >= :empSalary")
   public List<Employee> findByNameContainingAndSalaryGreaterThanEqual(@Param("empName") String name, @Param("empSalary") Double salary){
 	   return employeeRepo.findByNameContainingAndSalaryGreaterThanEqual(name, salary);
    }
    public Employee findById( Long id) {
    	return employeeRepo.findById(id).get();
    	  
      }
	public int count() {
		
		return (int) employeeRepo.count();
	}
	 public Iterable<Employee> findAll() {
			return  employeeRepo.findAll();
			  
		  }
	 public Employee insert( Employee emp) {
		  return employeeRepo.save(emp);
	  }
	 public Employee update( Employee emp) {
		  return employeeRepo.save(emp);
	  }
	 public void delete( long id) {
		  employeeRepo.deleteById(id);
	}
	 public int updateSalary (Double salary, Long id) {
		  return employeeRepo.updateSalary(salary , id);
	  }
}
