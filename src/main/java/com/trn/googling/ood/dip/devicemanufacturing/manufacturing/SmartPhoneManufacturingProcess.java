package com.trn.googling.ood.dip.devicemanufacturing.manufacturing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmartPhoneManufacturingProcess extends GeneralManufacturingProcess {

    private static Logger LOG = LoggerFactory.getLogger(SmartPhoneManufacturingProcess.class);

    @Override
    protected void performAssembly() {
        LOG.info("Performing Smartphone assembly");
    }

    @Override
    protected void performTesting() {
        LOG.info("Performing Smartphone testing");
    }

    @Override
    protected void performPackaging() {
        LOG.info("Performing Smartphone packaging");
    }

    @Override
    protected void performStoring() {
        LOG.info("Performing Smartphone storage");
    }
}
