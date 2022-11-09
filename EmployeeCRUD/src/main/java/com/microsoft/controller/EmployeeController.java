package com.microsoft.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.beans.Employee;

@RestController
public class EmployeeController {
	
	List<Employee> emps = new LinkedList<Employee>();  
	//get
  @GetMapping("/getAllEmpRecords")
public List<Employee> getAllEmployeeDetails()
  {
	return emps;
	  
  }
  @GetMapping("/getEmpByEmpId/{empId}")
	public Employee getEmployeeById(@PathVariable int empId)
	{
		for(Employee emp : emps)
		{
			if(empId==emp.getEmpId())
			{
				return emp;
			}
		}
		
		return null;
	}
  
   //post
 @PostMapping("/insert")
 public void insertEmployeeData(@RequestBody Employee employee)
 {
	 emps.add(employee);
 }
 }
