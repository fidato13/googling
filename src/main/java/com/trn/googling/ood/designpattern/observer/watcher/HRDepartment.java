package com.trn.googling.ood.designpattern.observer.watcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HRDepartment implements Watcher {

    private static Logger LOG = LoggerFactory.getLogger(HRDepartment.class);

    @Override
    public void notifyMe() {
     LOG.info("HRDepartment notified...");
    }
}
