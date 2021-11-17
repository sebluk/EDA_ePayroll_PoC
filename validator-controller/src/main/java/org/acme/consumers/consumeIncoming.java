package org.acme.consumers;

import org.json.*;  
import org.acme.models.*;

import java.io.IOException;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.enterprise.context.ApplicationScoped;
import org.acme.services.ValidateSinService;


@ApplicationScoped
public class consumeIncoming {
    
    
    @Inject
    @RestClient
    ValidateSinService validateSinService;


    @Incoming("validator-epayrolls")                                    
    public void process(String obj) {
        String res = validateSinService.validateSin(obj);
        System.out.println(res);

        // JSONObject json = new JSONObject(obj);  
        // System.out.println(json.toString());  
        // int technology = json.getInt("bn");  
        // System.out.println(technology);
        //ObjectMapper Obj = new ObjectMapper();  
        // try {
        //     String jsonStr = Obj.writeValueAsString(obj);  
        //         // Displaying Java object into a JSON string  
        //     System.out.println(jsonStr);  
        //     }  
        // catch (IOException e) {  
        //     e.printStackTrace();  
        //     } 

    }


}
