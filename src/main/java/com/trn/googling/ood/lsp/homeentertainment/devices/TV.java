package com.trn.googling.ood.lsp.homeentertainment.devices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TV extends Device {

    private static Logger LOG = LoggerFactory.getLogger(TV.class);

    @Override
    public void switchOn() {
        LOG.info("Switching On Tv");
    }

    @Override
    public void switchOff() {
        LOG.info("Switching Off Tv");
    }

    @Override
    public String getName() {
        return "TV";
    }
}
