package com.example.kafka;

import com.example.model.Gas;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GasProcessor {
    private static final double CONVERSION_RATE = 1.5;

    public Gas process(Gas gas) {
        gas.price = gas.price * CONVERSION_RATE;
        return gas;
    }
}
