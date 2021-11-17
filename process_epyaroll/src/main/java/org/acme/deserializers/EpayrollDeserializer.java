package org.acme.deserializers;

import org.acme.models.Epayroll;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class EpayrollDeserializer extends ObjectMapperDeserializer<Epayroll> {
    public EpayrollDeserializer() {
        // pass the class to the parent.
        super(Epayroll.class);
    }
}