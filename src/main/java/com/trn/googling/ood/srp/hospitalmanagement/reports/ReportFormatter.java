package com.trn.googling.ood.srp.hospitalmanagement.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ReportFormatter {

    private static Logger LOG = LoggerFactory.getLogger(ReportFormatter.class);

    String formattedOutput;

    public ReportFormatter(Object object, FormatType formatType) {
        switch (formatType){
            case XML :
                formattedOutput = convertObjectToXML(object);
                break;
            case CSV :
                formattedOutput = convertObjectToCSV(object);
                break;
        }
    }

    protected String convertObjectToXML(Object object){
        LOG.info("Converting object to XML using cool generic XML serializing library...");
        return "XML : <title>"+object.toString()+"</title>";
    }

    protected String convertObjectToCSV(Object object){
        LOG.info("Converting object to CSV using cool generic CSV serializing library...");
        return "CSV : ,,,"+object.toString()+",,,";
    }

    protected String getFormattedValue(){
        return formattedOutput;
    }
}
