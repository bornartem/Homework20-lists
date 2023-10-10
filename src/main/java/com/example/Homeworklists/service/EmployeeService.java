package com.example.Homeworklists.service;

import com.example.Homeworklists.exception.EmployeeAlreadyAddedException;
import com.example.Homeworklists.exception.EmployeeNotFoundException;
import com.example.Homeworklists.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public void addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    public void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    public void findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;
}


