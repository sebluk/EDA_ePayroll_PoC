package org.acme;

import java.time.Duration;
import java.util.Random;
import org.acme.repositories.*;
import javax.enterprise.context.ApplicationScoped;
import org.acme.model.Epayroll;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import javax.inject.Inject;
import java.util.Set;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class EpayrollGenerator {


    // @Inject
    // EpayrollRepository repository;

    @Inject @Channel("generated-payroll")
    Emitter<Epayroll> emitter;


    public void sendEpayrollToKafka(Epayroll epayroll) {
        emitter.send(epayroll);
    }

}