package com.trn.googling.ood.srp.hospitalmanagement.reports;

import com.trn.googling.ood.srp.hospitalmanagement.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeReportFormatter extends ReportFormatter {

    private static Logger LOG = LoggerFactory.getLogger(EmployeeReportFormatter.class);

    public EmployeeReportFormatter(Employee employee, FormatType formatType) {
        super(employee, formatType);
    }


    public String getFormattedEmployee() {
         LOG.info("Getting Employee formatted value");
         return getFormattedValue();
    }
}
