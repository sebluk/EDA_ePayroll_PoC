package org.acme;
import org.acme.model.Epayroll;
import io.smallrye.reactive.messaging.annotations.Broadcast;

import org.acme.model.Epayroll;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class EpayrollConsumer {

    @Incoming("epayrolls")                                     
    public void process(Epayroll obj) {
      //  obj.getBn()
        System.out.println("message received"+ obj.getBn());
      //  Epayroll e = new Epayroll()
        // System.out.println("message received"+ epayroll);
        // System.out.println("Business Number: "+ epayroll.getBn());
    }

}