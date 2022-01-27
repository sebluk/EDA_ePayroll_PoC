package ca.gc.cra.rcsc.eda_epayroll_poc;

import ca.gc.cra.rcsc.eda_epayroll_poc.models.Epayroll;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class EpayrollDeserializer extends ObjectMapperDeserializer<Epayroll> {
    public EpayrollDeserializer() {
        // pass the class to the parent.
        super(Epayroll.class);
    }
}