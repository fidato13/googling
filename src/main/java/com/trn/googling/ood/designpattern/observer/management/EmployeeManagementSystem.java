package com.trn.googling.ood.designpattern.observer.management;

import com.trn.googling.ood.designpattern.observer.database.EmployeeDAO;
import com.trn.googling.ood.designpattern.observer.model.Employee;
import com.trn.googling.ood.designpattern.observer.watcher.Subject;
import com.trn.googling.ood.designpattern.observer.watcher.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

// this is our subject , if this has any changes then it will notify the observers
public class EmployeeManagementSystem implements Subject {

    private static Logger LOG = LoggerFactory.getLogger(EmployeeManagementSystem.class);

    private EmployeeDAO employeeDAO;

    private List<Watcher> watchers = new ArrayList<>();

    public EmployeeManagementSystem(EmployeeDAO employeeDAO, List<Watcher> watchers) {
        this.employeeDAO = employeeDAO;
        this.watchers = watchers;
    }

    public void hireNewEmployee(Employee employee){
        LOG.info("Hired new employee : "+employee.getName());
        employeeDAO.addNewEmployee(employee);
        notifyObservers();
    }

    public void changeSalary(Employee employee, double newSalary){
        LOG.info("changing salary : "+employee.getName());
        employee.setSalary(newSalary);
        employeeDAO.changeSalary(employee);
        notifyObservers();
    }

    @Override
    public void notifyObservers(){
        LOG.info("Notifying Observers...");
        for(Watcher watcher : watchers){
            watcher.notifyMe();
        }
    }

    @Override
    public void registerObserver(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeObserver(Watcher watcher) {
        watchers.remove(watcher);
    }


}
