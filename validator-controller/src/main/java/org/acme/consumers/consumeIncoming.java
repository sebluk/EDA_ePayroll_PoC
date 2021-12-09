package org.acme.consumers;

import org.json.*;  
import org.acme.models.*;
import java.util.Set;
import java.io.IOException;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import javax.validation.Valid;
import javax.validation.Validator;
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.enterprise.context.ApplicationScoped;
import org.acme.services.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ApplicationScoped
public class consumeIncoming {

    @Inject
    Validator validator;

    @Inject
    @Channel("output-valid-data")
    Emitter<String> validEmitter;

    @Inject
    @Channel("output-error-data")
    Emitter<String> errorEmitter;
    
    
    @Inject
    @RestClient
    ValidateSinService validateSinService;

    @Inject
    @RestClient
    ValidateBnService validateBnService;

    @Inject
    @RestClient
    ValidateEpayrollService validateEpayrollService;


    @Incoming("validator-epayrolls")                                    
    public void process(String obj) {
        System.out.println("Received string is "+ obj);
        String epayrollValidatorRes = validateEpayrollService.validateEpayroll(obj);
        JSONObject epayrollValidatorResJson = new JSONObject(epayrollValidatorRes);
        System.out.println("Received epayrollValidatorRes is "+ epayrollValidatorRes);

        int epayrollResCode = epayrollValidatorResJson.getInt("responseCode"); 
        if(epayrollResCode == 200){
            String res = validateSinService.validateSin(obj);
          
            System.out.println("Received validateSinServiceRes is "+ res);
            

            JSONObject sinValidatorResJson = new JSONObject(res);
           

            int resCode = sinValidatorResJson.getInt("response_code"); 
           
            if(resCode == 200){
                String res_bn = validateBnService.validateBn(obj);
                System.out.println("Received validateBnServiceRes is "+ res_bn);
                JSONObject bnValidatorResJson = new JSONObject(res_bn);
                int resCodeBn = bnValidatorResJson.getInt("response_code"); 

                if(resCodeBn == 200){
                    //sinValidatorResJson.remove("response_code");
                    bnValidatorResJson.remove("response_code");
                    validEmitter.send(bnValidatorResJson.toString());
                    System.out.println("Message sent from if staement of response 200 inside bn conditional" );
                }else{
                    bnValidatorResJson.put("errorNumber",resCodeBn);
                    bnValidatorResJson.remove("response_code");
                    errorEmitter.send(bnValidatorResJson.toString());
                    System.out.println("Message sent from else staement inside bn conditional" );
                }   
            }else{
                sinValidatorResJson.put("errorNumber",resCode);
                sinValidatorResJson.remove("response_code");
                errorEmitter.send(sinValidatorResJson.toString());
                System.out.println("Message sent from else staement inside sin conditional" );
            }       
        }else{
            epayrollValidatorResJson.put("errorNumber",epayrollResCode);
            epayrollValidatorResJson.remove("responseCode");
            errorEmitter.send(epayrollValidatorResJson.toString());
            System.out.println("Message sent from else staement inside epayroll validation conditional" );

        }  

       
    }


}
