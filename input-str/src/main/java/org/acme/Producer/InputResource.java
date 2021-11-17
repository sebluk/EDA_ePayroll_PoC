package org.acme.producer;

import java.util.UUID;
import org.json.*; 
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
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.util.ArrayList;
import java.io.IOException;  
@Path("/input")
public class InputResource {

    @Inject
    @Channel("input-epayrolls")
    Emitter<String> epayrollEmitter; 


    // @POST
    // @Path("/")
    // @Produces(MediaType.APPLICATION_JSON)
    // @Consumes(MediaType.APPLICATION_JSON)
    // public ArrayList<String> sendEpayrolls(Epayroll[] epayrolls) {
    //     ObjectMapper Obj = new ObjectMapper();
    //     ArrayList<String> toReturnEpayrolls = new ArrayList<String>(); 

    //     for (Epayroll e : epayrolls) {
    //         try {
    //             String jsonStr = Obj.writeValueAsString(e);
    //             epayrollEmitter.send(jsonStr);
    //             toReturnEpayrolls.add(jsonStr); 
    //             System.out.println(jsonStr);  
    //             }  
    //         catch (IOException ie) {  
    //             ie.printStackTrace();  
    //             } 
    //     }
    //     return toReturnEpayrolls;
       
    // }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<String> sendEpayrolls(JSONObject[] epayrolls) {
        ObjectMapper Obj = new ObjectMapper();
        ArrayList<String> toReturnEpayrolls = new ArrayList<String>(); 

        for (JSONObject e : epayrolls) {
            try {
                String jsonStr = Obj.writeValueAsString(e);
                epayrollEmitter.send(jsonStr);
                toReturnEpayrolls.add(jsonStr); 
                System.out.println(jsonStr);  
                }  
            catch (IOException ie) {  
                ie.printStackTrace();  
                } 
        }
        return toReturnEpayrolls;
       
    }
}
    