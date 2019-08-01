package com.trn.googling.ood.dip.devicemanufacturing.clients;

import com.trn.googling.ood.dip.devicemanufacturing.manufacturing.GeneralManufacturingProcess;
import com.trn.googling.ood.dip.devicemanufacturing.manufacturing.SmartPhoneManufacturingProcess;
import com.trn.googling.ood.dip.devicemanufacturing.manufacturing.TVManufacturingProcess;

public class DeviceManufacturingFactory {

    private GeneralManufacturingProcess manufacturingProcess;

    public static void main(String[] args) {

        DeviceManufacturingFactory deviceManufacturingFactory = new DeviceManufacturingFactory();

        SmartPhoneManufacturingProcess smartPhoneManufacturingProcess = new SmartPhoneManufacturingProcess();
        deviceManufacturingFactory.manufacturingProcess = smartPhoneManufacturingProcess;

        deviceManufacturingFactory.manufacturingProcess.manufacture();




        TVManufacturingProcess tvManufacturingProcess = new TVManufacturingProcess();
        deviceManufacturingFactory.manufacturingProcess = tvManufacturingProcess;

        deviceManufacturingFactory.manufacturingProcess.manufacture();
    }
}
