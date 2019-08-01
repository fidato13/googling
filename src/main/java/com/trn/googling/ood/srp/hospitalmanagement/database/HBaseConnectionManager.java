package com.trn.googling.ood.srp.hospitalmanagement.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HBaseConnectionManager extends DatabaseConnectionManager {

    private static Logger LOG = LoggerFactory.getLogger(HBaseConnectionManager.class);

    @Override
    public void connect() {
        LOG.info("Connecting to HBase...");
    }

    @Override
    public void disConnect() {
        LOG.info("Disconnecting from HBase...");
    }

    @Override
    public void getConnectionObject() {
        LOG.info("The HBase connection Object...");
    }
}
