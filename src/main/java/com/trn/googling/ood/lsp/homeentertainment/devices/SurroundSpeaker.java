package com.trn.googling.ood.lsp.homeentertainment.devices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SurroundSpeaker extends Device {

    private static Logger LOG = LoggerFactory.getLogger(SurroundSpeaker.class);

    @Override
    public void switchOn() {
        LOG.info("Switching On SurroundSpeaker");
    }

    @Override
    public void switchOff() {
        LOG.info("Switching Off SurroundSpeaker");
    }

    @Override
    public String getName() {
        return "SurroundSpeaker";
    }
}
