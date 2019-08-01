package com.trn.googling.ood.lsp.homeentertainment.devices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Projector extends Device {

    private static Logger LOG = LoggerFactory.getLogger(Projector.class);

    @Override
    public void switchOn() {
        LOG.info("Switching On Projector");
    }

    @Override
    public void switchOff() {
        LOG.info("Switching Off Projector");
    }

    @Override
    public String getName() {
        return "Projector";
    }
}
