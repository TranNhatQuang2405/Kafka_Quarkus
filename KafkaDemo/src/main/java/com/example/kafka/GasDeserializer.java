package com.example.kafka;

import com.example.model.Gas;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class GasDeserializer extends ObjectMapperDeserializer<Gas> {
    public GasDeserializer(){
        super(Gas.class);
    }
}