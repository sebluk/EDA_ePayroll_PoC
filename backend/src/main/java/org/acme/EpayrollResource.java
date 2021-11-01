package org.acme;

import javax.ws.rs.GET;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.acme.EpayrollGenerator;
import org.acme.model.Epayroll;


@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EpayrollResource {

    @Inject
    EpayrollGenerator producer;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("test")
    public String greeting() {
        return "Yay!, it works ;)";
    }

    @POST
    public Response send(Epayroll epayroll) {

        producer.sendEpayrollToKafka(epayroll);
        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }
}