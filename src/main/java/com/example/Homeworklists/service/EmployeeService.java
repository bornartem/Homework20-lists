package com.example.Homeworklists.service;

import com.example.Homeworklists.exception.EmployeeAlreadyAddedException;
import com.example.Homeworklists.exception.EmployeeNotFoundException;
import com.example.Homeworklists.exception.EmployeeStorageIsFullException;

import java.util.Collection;


public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Collection<Employee> getAll();
}


