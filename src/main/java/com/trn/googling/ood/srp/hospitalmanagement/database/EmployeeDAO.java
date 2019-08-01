package com.trn.googling.ood.srp.hospitalmanagement.database;

import com.trn.googling.ood.srp.hospitalmanagement.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDAO {

    private static Logger LOG = LoggerFactory.getLogger(EmployeeDAO.class);

    private HBaseConnectionManager databaseConnectionManager = new HBaseConnectionManager();

    public void saveEmployee(Employee employee){
        databaseConnectionManager.getConnectionObject();
        LOG.info("Gets the connection object and then calls save over it");
    }

    public void deleteEmployee(Employee employee){
        databaseConnectionManager.getConnectionObject();
        LOG.info("Gets the connection object and then calls delete over it");
    }
}
