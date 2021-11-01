package org.acme;

import org.acme.model.Epayroll;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class EpayrollDeserializer extends ObjectMapperDeserializer<Epayroll> {
    public EpayrollDeserializer() {
        // pass the class to the parent.
        super(Epayroll.class);
    }
}