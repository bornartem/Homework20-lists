package com.example.Homeworklists.service;

import com.example.Homeworklists.exception.EmployeeAlreadyAddedException;
import com.example.Homeworklists.exception.EmployeeNotFoundException;
import com.example.Homeworklists.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    int employeesSize = 6;
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Arnold", "Shwarzenegger"),
            new Employee("Silvester", "Stalone"),
            new Employee("Bruce", "Lee"),
            new Employee("Steven", "Sigal"),
            new Employee("Chuck", "Norris")
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= employeesSize) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.add(employee)) {

        }  return employee;
    }


    //            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
//        if (!employees.contains(employee)) {
//            throw new EmployeeNotFoundException("Сотрудник не найден");
//        }
//    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAll() {
        return new ArrayList<>(employees);
    }
}
//        if (!employees.contains(employee)) {
//            throw new EmployeeNotFoundException("Сотрудник не найден");
//        }

