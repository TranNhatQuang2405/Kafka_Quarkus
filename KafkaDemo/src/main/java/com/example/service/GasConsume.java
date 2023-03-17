package com.example.service;

import com.example.model.Gas;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GasConsume {
    @Incoming("gas-in")
    public void outputGas(Gas gas){
        System.out.printf("Gas price has been increased to %s",gas.price);
    }
}
