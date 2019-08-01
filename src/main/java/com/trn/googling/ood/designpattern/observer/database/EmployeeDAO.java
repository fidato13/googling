package com.trn.googling.ood.designpattern.observer.database;

import com.trn.googling.ood.designpattern.observer.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// this class basically serves as the mockup for the DAO
public class EmployeeDAO {

    private static Logger LOG = LoggerFactory.getLogger(EmployeeDAO.class);

    private List<Employee> employees = new ArrayList<>();

    public void addNewEmployee(Employee employee){
        employees.add(employee);
    }

    public void changeSalary(Employee employee){
        Optional<Employee> value = employees.stream().filter(employee1 -> employee1.getId() == employee.getId()).findFirst();
        if(value.isPresent()){
            value.get().setSalary(employee.getSalary());
            LOG.info("Salary changed for the employee : "+ value.get().getName() + " , the new salary is ; "+ value.get().getSalary());
        } else {
            LOG.error("Employee not found in the database");
        }
    }

}
