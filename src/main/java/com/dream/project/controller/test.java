package com.dream.project.controller;

import com.pi4j.io.gpio.*;

/**
 * Created by sujan on 11/27/19.
 */
public class test {

    public static void main(String[] args){

        final GpioController controller = GpioFactory.getInstance();
        controller.provisionDigitalOutputPin(RaspiPin.GPIO_21, "MyLED").high();
    }
}
