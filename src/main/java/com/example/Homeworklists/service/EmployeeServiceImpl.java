package com.example.Homeworklists.service;

import com.example.Homeworklists.exception.EmployeeAlreadyAddedException;
import com.example.Homeworklists.exception.EmployeeNotFoundException;
import com.example.Homeworklists.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    int employeesSize = 5;
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Арнольд", "Шварцнеггер"),
            new Employee("Сильвестр", "Сталлоне"),
            new Employee("Брюс", "Ли"),
            new Employee("Стивен", "Сигал"),
            new Employee("Чак", "Норрис")
    ));

    @Override
    public void addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);

        if (employees.size() == employeesSize) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("В коллекции уже есть такой сотрудник");
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee1 = new Employee(firstName, lastName);

        if (!employees.contains(employee1)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public void findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee2 = new Employee(firstName, lastName);

        if (!employees.contains(employee2)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }
}
