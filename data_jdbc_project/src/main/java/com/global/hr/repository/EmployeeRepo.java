package com.global.hr.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository <Employee,Long>{
List <Employee> findByName(String name);
List <Employee> findByNameStartingWithAndSalary(String name,Double salary);
List <Employee> findByNameAndSalary(String name,Double salary);
List<Employee> findByNameContaining(String name);

@Query(value="Select * from employeeData where name like :empName and salary >= :empSalary")
List<Employee> findByNameContainingAndSalaryGreaterThanEqual(@Param("empName") String name, @Param("empSalary") Double salary);

@Modifying // بقوله انى هغير حاجة فالداتا بيز
@Query(value = "update employeeData set salary = :salary where id = :id ")
int updateSalary (Double salary, Long id);

}