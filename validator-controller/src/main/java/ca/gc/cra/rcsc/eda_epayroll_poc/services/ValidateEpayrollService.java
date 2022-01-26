package ca.gc.cra.rcsc.eda_epayroll_poc.services;

import java.util.Set;
import java.util.concurrent.CompletionStage;
import org.json.*; 
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

@Path("/epayrollValidation")
@RegisterRestClient
public interface ValidateEpayrollService {

    @POST
    @Path("/service-method-validation")
    String validateEpayroll(String obj);

    // @GET
    // @Path("/name/{name}")
    // @Produces("application/json")
    // Set<Country> getByName(@PathParam String name);

    // @GET
    // @Path("/name/{name}")
    // @Produces("application/json")
    // CompletionStage<Set<Country>> getByNameAsync(@PathParam String name);

    // @GET
    // @Path("/name/{name}")
    // @Produces("application/json")
    // Uni<Set<Country>> getByNameAsUni(@PathParam String name);
}