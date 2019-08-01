package com.trn.googling.ood.lsp.homeentertainment.devices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Device implements Controllable{

    private static Logger LOG = LoggerFactory.getLogger(Device.class);

    protected String name;

    protected String buildYear;

    public Device(){
        name = getName();
    }

    abstract public String getName();

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", buildYear='" + buildYear + '\'' +
                '}';
    }
}
