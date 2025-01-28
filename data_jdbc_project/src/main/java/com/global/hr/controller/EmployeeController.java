package com.global.hr.controller;
import com.global.hr.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.hr.entity.Employee;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired // optional
	private EmployeeService employeeService;

// @Autowired // optional 
//	public EmployeeController(EmployeeRepo employeeRepo) {
//		super();
//		this.employeeRepo = employeeRepo;
//	}

  //@GetMapping("/count")
	@RequestMapping (method=RequestMethod.GET , path ="/count")
	public int count() {
		
		return (int) employeeService.count();
	}
  @GetMapping("/{id}")
  public Employee findById(@PathVariable Long id) {
	return employeeService.findById(id);
	  
  }
  @GetMapping("/all")
  public Iterable<Employee> findAll() {
	return  employeeService.findAll();
	  
  }
//  @GetMapping("/insert")
//  public Employee addEmp() {
//	  return employeeRepo.save(new Employee("malak",20000));
//  }
  
  @RequestMapping (method=RequestMethod.POST , path ="/insert")
  public Employee insert(@RequestBody Employee emp) {
	  return employeeService.insert(emp);
  }
  
//  @GetMapping("/update")
//  public Employee updateEmp() {
//	  return employeeRepo.save(new Employee(4,"sara",20000));
//  }
  
  @RequestMapping (method=RequestMethod.PUT , path ="/update")
  public Employee update(@RequestBody Employee emp) {
	  return employeeService.update(emp);
  }
  
//  @GetMapping("/delete")
//  public void deleteEmp() {
//	  employeeRepo.deleteById((long) 5);
//  }
  
  @RequestMapping (method=RequestMethod.DELETE , path ="/delete/{id}")
public void deleteEmp(@PathVariable long id) {
	  employeeService.delete(id);
}
  
  @GetMapping("/filter/{name}")
  public List< Employee> findByName(@PathVariable String name ) {
	return employeeService.findByName(name);
	  
  }
  @GetMapping("/filter/{name}/{salary}")
  public List< Employee> findByNameAndSalary(@PathVariable String name , @PathVariable double salary ) {
	return employeeService.findByNameAndSalary(name,salary);
	  
  }
  @GetMapping("/filter/p/{name}/{salary}")
  public List< Employee>  findByNameStartingWithAndSalary(@PathVariable String name , @PathVariable double salary ) {
	return employeeService.findByNameStartingWithAndSalary(name,salary);
	  
  }
  @GetMapping("/filter/c/{name}")
  public List< Employee>  findByNameContaining(@PathVariable String name  ) {
	return employeeService.findByNameContaining(name);
	  
  }
  
  @GetMapping("/filter/nameSal/{name}/{salary}")
  public List< Employee>  findByNameContainingAndSalaryGreaterThanEqual(@PathVariable String name , @PathVariable double salary ) {
	return employeeService.findByNameContainingAndSalaryGreaterThanEqual(name,salary);
	  
  }
  
  @PutMapping("/salary")
	public int updateSalary (@RequestParam Double salary, @RequestParam Long id) {
			
			return employeeService.updateSalary(salary, id);
	}
  
  public void testJaskson() throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString = "{\r\n"
				+ "        \"employeeId\": 20,\r\n"
				+ "        \"name\": \"Mohamed\",\r\n"
				+ "        \"salary\": 5221.0,\r\n"
							+ "    }";
		
		//Object to JSON Conversion
		Employee empObject = mapper.readValue(jsonString, Employee.class);

		//Object to JSON Conversion		
		jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empObject);
	}
}
