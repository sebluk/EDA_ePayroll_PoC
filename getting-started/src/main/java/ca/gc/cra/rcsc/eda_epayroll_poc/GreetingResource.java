package ca.gc.cra.rcsc.eda_epayroll_poc;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ca.gc.cra.rcsc.eda_epayroll_poc.GreetingService;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;
    
    @Channel("error-data")
    Emitter<String> errorDataEmitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
    	System.out.println("*** greeting(" + name +") ***");
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	System.out.println("*** hello() ***");
        return "hello";
    }
    
    @POST
    @Path("/senderror")
    @Consumes(MediaType.TEXT_PLAIN)
    public String sendErrorData(String data) {
 
    	errorDataEmitter.send(data);
    	
    	String result = "Sent:" + data;
    	System.out.println(result);
    	
    	return result;
    }
}