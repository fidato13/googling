package com.trn.googling.ood.designpattern.observer.main;

import com.trn.googling.ood.designpattern.observer.database.EmployeeDAO;
import com.trn.googling.ood.designpattern.observer.management.EmployeeManagementSystem;
import com.trn.googling.ood.designpattern.observer.model.Employee;
import com.trn.googling.ood.designpattern.observer.watcher.HRDepartment;
import com.trn.googling.ood.designpattern.observer.watcher.PayrollDepartment;
import com.trn.googling.ood.designpattern.observer.watcher.Watcher;

import java.util.Arrays;

public class EmployeeSystemUser {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Kieran", 200.0, "IT");
        Employee employee2 = new Employee("Bob", 300.0, "IT");
        Employee employee3 = new Employee("Riya", 400.0, "sales");

        Watcher hrWatcher = new HRDepartment();
        Watcher payrollWatcher = new PayrollDepartment();

        EmployeeDAO employeeDAO = new EmployeeDAO();

        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem(employeeDAO, Arrays.asList(hrWatcher, payrollWatcher));

        employeeManagementSystem.hireNewEmployee(employee1);
        employeeManagementSystem.hireNewEmployee(employee2);
        employeeManagementSystem.hireNewEmployee(employee3);

        employeeManagementSystem.changeSalary(employee3, 600.0);
    }
}
