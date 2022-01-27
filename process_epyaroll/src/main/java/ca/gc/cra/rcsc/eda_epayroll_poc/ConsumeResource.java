package ca.gc.cra.rcsc.eda_epayroll_poc;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;


import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ca.gc.cra.rcsc.eda_epayroll_poc.models.EpayrollEntity;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("Consume")
@ApplicationScoped
public class ConsumeResource {


    @Inject
    EntityManager entityManager;

    @GET
    public Response list() {
        List<EpayrollEntity> stored_epayrolls = entityManager.createNamedQuery("Epayrolls.findAll", EpayrollEntity.class).getResultList();
        System.out.println(stored_epayrolls);
        return Response.ok(stored_epayrolls).build();
    }
    
}
