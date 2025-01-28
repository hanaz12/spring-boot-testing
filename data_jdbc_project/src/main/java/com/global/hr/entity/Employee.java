//package com.global.hr.entity;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;
//
//import jakarta.persistence.Entity;
//
//@Entity
//@Table (name="employeeData") // optional لو اسم الكلاس نفس الاسم بتاع الداتا بيز 
//public class Employee {
//
////@Column("id") // بما انه فالداتا بيز بنفس الاسم مش لازم اديلة الاسم
//@Id
//private long id;
//private String name;
//private double salary;
//
//public Employee() {
//	super();
//	// TODO Auto-generated constructor stub
//}
//public Employee(long id, String name, double salary) {
//	super();
//	this.id = id;
//	this.name = name;
//	this.salary = salary;
//}
//
//public long getId() {
//	return id;
//}
//public void setId(long id) {
//	this.id = id;
//}
//public String getName() {
//	return name;
//}
//public void setName(String name) {
//	this.name = name;
//}
//public double getSalary() {
//	return salary;
//}
//
//public void setSalary(double salary) {
//	this.salary = salary;
//}
//
//
//}
package com.global.hr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Transient;

@Table("employeeData") // اسم الجدول في قاعدة البيانات
public class Employee {
    @Id
    private long id;
    private String name;
    private double salary;
   
//   @Transient
//    private String classRelatedNotDataBase;
    
    // Constructors
    public Employee() {
    }

    public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
