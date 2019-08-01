package com.trn.googling.ood.designpattern.observer.watcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayrollDepartment implements Watcher {

    private static Logger LOG = LoggerFactory.getLogger(PayrollDepartment.class);

    @Override
    public void notifyMe() {
     LOG.info("PayrollDepartment notified...");
    }
}
