package com.trn.googling.ood.srp.hospitalmanagement.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DatabaseConnectionManager {

    private static Logger LOG = LoggerFactory.getLogger(DatabaseConnectionManager.class);

    public DatabaseConnectionManager getManagerInstance(){
        return this;
    }

    public abstract void connect();

    public abstract void disConnect();

    public abstract void getConnectionObject();


}
