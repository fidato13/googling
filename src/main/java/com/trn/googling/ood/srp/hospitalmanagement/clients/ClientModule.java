package com.trn.googling.ood.srp.hospitalmanagement.clients;

import com.trn.googling.ood.srp.hospitalmanagement.database.EmployeeDAO;
import com.trn.googling.ood.srp.hospitalmanagement.model.Employee;
import com.trn.googling.ood.srp.hospitalmanagement.reports.EmployeeReportFormatter;
import com.trn.googling.ood.srp.hospitalmanagement.reports.FormatType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientModule {


    private static Logger LOG = LoggerFactory.getLogger(ClientModule.class);

    private static void hireNewEmployee(Employee employee){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.saveEmployee(employee);
        LOG.info("Hiring new Employee");
    }

    private static void terminateEmployee(Employee employee){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.deleteEmployee(employee);
        LOG.info("Terminating Employee");
    }

    private static void printEmployeeReport(Employee employee, FormatType formatType){

        EmployeeReportFormatter employeeReportFormatter = new EmployeeReportFormatter(employee, formatType);
        LOG.info("printing Employee report : "+ employeeReportFormatter.getFormattedEmployee());
    }

    public static void main(String[] args) {

        Employee employee1 = new Employee(1L, "peggy", "accounting", true);
        hireNewEmployee(employee1);

        terminateEmployee(employee1);

        printEmployeeReport(employee1, FormatType.CSV);
        printEmployeeReport(employee1, FormatType.XML);


    }
}
