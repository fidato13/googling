package com.trn.googling.ood.dip.devicemanufacturing.manufacturing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GeneralManufacturingProcess {

    private static Logger LOG = LoggerFactory.getLogger(GeneralManufacturingProcess.class);

    protected abstract void performAssembly();

    protected abstract void performTesting();

    protected abstract void performPackaging();

    protected abstract void performStoring();

    public void manufacture(){
        performAssembly();

        performTesting();

        performPackaging();
        
        performStoring();

    }
}
