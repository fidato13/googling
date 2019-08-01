package com.trn.googling.ood.lsp.homeentertainment.control;

import com.trn.googling.ood.lsp.homeentertainment.devices.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteControl {

    private static Logger LOG = LoggerFactory.getLogger(RemoteControl.class);

    private RemoteControl(){

    }
    private static final RemoteControl singleton = new RemoteControl();

    private static Device connectedTo;

    public static RemoteControl getInstance(){
        return singleton;
    }


    public static void connectTo(Device device){
        connectedTo = device;
        LOG.info("Connecting to : "+ device.getName());
    }


    public void turnOffDevice(){
        LOG.info("Turning Off : "+ connectedTo.getName());
        connectedTo.switchOff();
    }

    public void turnOnDevice(){
        LOG.info("Turning On : "+ connectedTo.getName());
        connectedTo.switchOn();
    }

}
