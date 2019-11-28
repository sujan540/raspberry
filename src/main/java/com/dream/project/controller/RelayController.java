package com.dream.project.controller;

import com.pi4j.io.gpio.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RelayController {

    private static GpioPinDigitalOutput pinOutput = null;

    @RequestMapping(value = "{gpioId}")
    public ResponseEntity toggleRelay(@PathVariable Integer gpioId) {

        Pin pin = null;
        switch (gpioId) {
            case 1:
                pin = RaspiPin.GPIO_01;
                break;
            case 8:
                pin = RaspiPin.GPIO_08;
                break;
            default:
                pin = RaspiPin.GPIO_00;
                break;
        }
        if (pinOutput == null) {
            final GpioController gpio = GpioFactory.getInstance();
            pinOutput = gpio.provisionDigitalOutputPin(pin);
        }
        if (pinOutput.isHigh()) {
            pinOutput.low();
        } else if (pinOutput.isLow()) {
            pinOutput.high();
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
