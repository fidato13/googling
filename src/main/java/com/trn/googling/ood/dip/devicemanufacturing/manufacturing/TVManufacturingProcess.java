package com.trn.googling.ood.dip.devicemanufacturing.manufacturing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TVManufacturingProcess extends GeneralManufacturingProcess {

    private static Logger LOG = LoggerFactory.getLogger(TVManufacturingProcess.class);

    @Override
    protected void performAssembly() {
        LOG.info("Performing TV assembly");
    }

    @Override
    protected void performTesting() {
        LOG.info("Performing TV testing");
    }

    @Override
    protected void performPackaging() {
        LOG.info("Performing TV packaging");
    }

    @Override
    protected void performStoring() {
        LOG.info("Performing TV storage");
    }
}
