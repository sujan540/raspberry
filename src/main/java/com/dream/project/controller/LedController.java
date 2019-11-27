package com.dream.project.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    private static GpioPinDigitalOutput pin;
    private static GpioPinDigitalOutput pin1;

    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }

    @RequestMapping("/fourOn")
    public String oneOn() {

        if (pin1 == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.HIGH);
        }
        pin1.toggle();

        return "OK";
    }

    @RequestMapping("/fourOff")
    public String oneOff() {

        if (pin1 == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW);
        }
        pin1.toggle();
        return "OK";
    }

    @RequestMapping("/light")
    public String light() {
        if (pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW);
        }

        pin.toggle();

        return "OK";
    }

}
