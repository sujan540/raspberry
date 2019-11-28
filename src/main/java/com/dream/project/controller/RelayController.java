package com.dream.project.controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RelayController {

    private static GpioPinDigitalOutput gpioPinDigitalOutput = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_01 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_08 = null;

    @RequestMapping(value = "relay/{gpioId}")
    public String toggleRelay(@PathVariable Integer gpioId) {

        final GpioController gpio = GpioFactory.getInstance();

        String state = null;
        switch (gpioId) {
            case 1:
                if (gpioPinDigitalOutput_01 == null) {
                    gpioPinDigitalOutput_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
                    state = gpioPinDigitalOutput_01.getState().getName();
                }
                gpioPinDigitalOutput_01.toggle();
                break;
            case 8:
                if (gpioPinDigitalOutput_08 == null) {
                    gpioPinDigitalOutput_08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
                    state = gpioPinDigitalOutput_08.getState().getName();
                }
                gpioPinDigitalOutput_08.toggle();
                break;
            default:
                if (gpioPinDigitalOutput == null) {
                    gpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
                    state = gpioPinDigitalOutput.getState().getName();
                }
                gpioPinDigitalOutput.toggle();
                break;
        }

        return state;
    }

}
