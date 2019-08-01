package com.trn.googling.ood.lsp.homeentertainment.user;

import com.trn.googling.ood.lsp.homeentertainment.control.RemoteControl;
import com.trn.googling.ood.lsp.homeentertainment.devices.Device;
import com.trn.googling.ood.lsp.homeentertainment.devices.Projector;
import com.trn.googling.ood.lsp.homeentertainment.devices.SurroundSpeaker;
import com.trn.googling.ood.lsp.homeentertainment.devices.TV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {

    private static Logger LOG = LoggerFactory.getLogger(Person.class);

    public static void main(String[] args) {

        Device tv = new TV();
        Device projector = new Projector();
        Device surroundSpeaker = new SurroundSpeaker();

        RemoteControl remoteControl = RemoteControl.getInstance();

        RemoteControl.connectTo(tv);

        remoteControl.turnOnDevice();
        remoteControl.turnOffDevice();

        RemoteControl.connectTo(projector);

        remoteControl.turnOnDevice();
        remoteControl.turnOffDevice();

        RemoteControl.connectTo(surroundSpeaker);

        remoteControl.turnOnDevice();
        remoteControl.turnOffDevice();
    }
}
