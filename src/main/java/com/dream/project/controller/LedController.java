package com.dream.project.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    private static GpioPinDigitalOutput pin = null;

    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }


    @RequestMapping("/light")
    public String light() {
        if (pin == null) {
            final GpioController controller = GpioFactory.getInstance();
            pin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_21, "MyLED");
        }

        pin.high();

        return "OK";
    }

}
