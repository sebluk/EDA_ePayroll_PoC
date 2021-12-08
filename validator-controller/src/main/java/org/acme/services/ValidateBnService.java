package org.acme.services;

import java.util.Set;
import java.util.concurrent.CompletionStage;
import org.json.*; 
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

@Path("/bnValidation")
@RegisterRestClient
public interface ValidateBnService {

    @POST
    @Path("/service-method-validation")
    String validateBn(String obj);
}