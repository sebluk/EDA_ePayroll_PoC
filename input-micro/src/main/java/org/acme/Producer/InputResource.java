package org.acme.producer;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.model.*;
import javax.ws.rs.Consumes;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import javax.inject.Inject;

@Path("/input")
public class InputResource {

    @Inject
    @Channel("input-epayrolls")
    Emitter<Epayroll> epayrollEmitter; 


    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Epayroll[] sendEpayrolls(Epayroll[] epayrolls) {

        for (Epayroll e : epayrolls) {
            epayrollEmitter.send(e); 
        }
        return epayrolls;
       
    }
}
    