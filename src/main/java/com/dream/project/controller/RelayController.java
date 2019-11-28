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

    private static GpioPinDigitalOutput pinOutput = null;

    @RequestMapping(value = "relay/{gpioId}")
    public String toggleRelay(@PathVariable Integer gpioId) {

        final GpioController gpio = GpioFactory.getInstance();
        switch (gpioId) {
            case 0:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
                break;
            case 1:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
                break;
            case 2:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
                break;
            case 3:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
                break;
            case 4:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
                break;
            case 5:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
                break;
            case 6:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
                break;
            case 7:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
                break;
            case 8:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
                break;
            case 9:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09);
                break;
            case 10:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10);
                break;
            case 11:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11);
                break;
            case 12:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12);
                break;
            case 13:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13);
                break;
            case 14:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14);
                break;
            case 15:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15);
                break;
            case 16:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16);
                break;
            case 17:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17);
                break;
            case 18:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18);
                break;
            case 19:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19);
                break;
            case 20:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20);
                break;
            case 21:
                pinOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21);
                break;
            default:
                pinOutput = null;
                break;
        }
        if (pinOutput == null) {
            return "INVALID";
        }
        if (pinOutput.isHigh()) {
            pinOutput.low();
            return "OFF";
        } else if (pinOutput.isLow()) {
            pinOutput.high();
            return "ON";
        }
        return "NEUTRAL";
    }

}
