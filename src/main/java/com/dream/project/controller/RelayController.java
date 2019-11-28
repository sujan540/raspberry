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
        switch (gpioId) {
            case 1:
                gpioPinDigitalOutput_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
                gpioPinDigitalOutput = gpioPinDigitalOutput_01;
                gpioPinDigitalOutput_01.toggle();
                break;
            case 8:
                gpioPinDigitalOutput_08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
                gpioPinDigitalOutput = gpioPinDigitalOutput_08;
                gpioPinDigitalOutput_08.toggle();
                break;
            default:
                gpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
                gpioPinDigitalOutput.toggle();
                break;
        }

        return gpioPinDigitalOutput.getState().getName();
    }

}
