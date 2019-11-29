package com.controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class RelayController {

    private static GpioPinDigitalOutput gpioPinDigitalOutput = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_01 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_02 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_03 = null;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_08 = null;

    @RequestMapping(value = "onCommand/{gpioId}")
    public String toggleOnCommand(@PathVariable Integer gpioId) throws InterruptedException {

        final GpioController gpio = GpioFactory.getInstance();

        String state = null;
        switch (gpioId) {
            case 1:
                if (gpioPinDigitalOutput_01 == null) {
                    gpioPinDigitalOutput_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
                }
                gpioPinDigitalOutput_01.high();
                TimeUnit.MILLISECONDS.sleep(500);
                gpioPinDigitalOutput_01.low();
                state = gpioPinDigitalOutput_01.getState().getName();
                break;
            case 2:
                if (gpioPinDigitalOutput_02 == null) {
                    gpioPinDigitalOutput_02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
                }
                gpioPinDigitalOutput_02.high();
                TimeUnit.MILLISECONDS.sleep(500);
                gpioPinDigitalOutput_02.low();
                state = gpioPinDigitalOutput_02.getState().getName();
                break;
            case 3:
                if (gpioPinDigitalOutput_03 == null) {
                    gpioPinDigitalOutput_03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
                }
                gpioPinDigitalOutput_03.high();
                TimeUnit.MILLISECONDS.sleep(500);
                gpioPinDigitalOutput_03.low();
                state = gpioPinDigitalOutput_03.getState().getName();
                break;
            case 8:
                if (gpioPinDigitalOutput_08 == null) {
                    gpioPinDigitalOutput_08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
                }
                gpioPinDigitalOutput_08.high();
                TimeUnit.MILLISECONDS.sleep(500);
                gpioPinDigitalOutput_08.low();
                state = gpioPinDigitalOutput_08.getState().getName();
                break;
            default:
                if (gpioPinDigitalOutput == null) {
                    gpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
                }
                gpioPinDigitalOutput.high();
                TimeUnit.MILLISECONDS.sleep(500);
                gpioPinDigitalOutput.low();
                state = gpioPinDigitalOutput.getState().getName();
                break;
        }

        return state;
    }

    @RequestMapping(value = "relay/{gpioId}")
    public String toggleRelay(@PathVariable Integer gpioId) {

        final GpioController gpio = GpioFactory.getInstance();

        String state = null;
        switch (gpioId) {
            case 1:
                if (gpioPinDigitalOutput_01 == null) {
                    gpioPinDigitalOutput_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);
                } else {
                    gpioPinDigitalOutput_01.toggle();
                }
                state = gpioPinDigitalOutput_01.getState().getName();
                break;
            case 8:
                if (gpioPinDigitalOutput_08 == null) {
                    gpioPinDigitalOutput_08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW);
                } else {
                    gpioPinDigitalOutput_08.toggle();
                }
                state = gpioPinDigitalOutput_08.getState().getName();
                break;
            default:
                if (gpioPinDigitalOutput == null) {
                    gpioPinDigitalOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
                } else {
                    gpioPinDigitalOutput.toggle();
                }
                state = gpioPinDigitalOutput.getState().getName();
                break;
        }

        return state;
    }

}
