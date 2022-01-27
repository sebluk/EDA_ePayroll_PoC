package ca.gc.rcsc.eda_epayroll_poc;
import java.util.*;
import java.util.Set;
import java.util.Arrays;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashSet;
import java.util.stream.Collectors;

import ca.gc.rcsc.eda_epayroll_poc.Epayroll;
import org.json.*;  
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/epayrollValidation")
public class EpayrollValidatorResource {

    @Inject
    Validator validator;



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @Path("/service-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String tryMeServiceMethodValidation(String obj) {
        System.out.println("receivedString is "+ obj);
        HashMap<String, Object> mapCheck = new HashMap<String, Object>();        
        Set<String> epayrollkeySet = new HashSet<>(Arrays.asList("bn", "employer_paydac",  "employer_name", "pay_start",  "pay_end",  "employee_status", "employee_name", "employee_sin", "employee_id", "gross_pay", "tax_deducted", "cpp_contrib", "cpp_pension_earn", "ei_contrib", "ei_insur_earnings"));
        try{
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map  = mapper.readValue(obj, new TypeReference<Map<String,String>>(){});
            Set<String> missingKeys = new HashSet<>();
            JSONObject toReturn = new JSONObject();
            epayrollkeySet.forEach(key -> {
            if (!map.containsKey(key)) {
                missingKeys.add(key);
                mapCheck.put("valid","f");              
            }
        });

        if(mapCheck.get("valid") == "f"){
            toReturn.put("data",obj);
            toReturn.put("errorDescription","Received data does not contains these properties: " + missingKeys );
            toReturn.put("responseCode",500);
            // System.out.println("toReturn is "+ toReturn.toString());
            System.out.println("sending error string is "+ toReturn.toString());
            return toReturn.toString(); 
        }
        else{
            Epayroll receivedStringToJson = mapper.readValue(obj, Epayroll.class);
            // JSONObject receivedData = new JSONObject(obj);
            // receivedData.put("responseCode",200);
            // System.out.println("receivedData is "+ receivedData.toString());
            JSONObject jMap = new JSONObject(map);
            jMap.put("responseCode",200);
            System.out.println("sending string is "+ jMap.toString());
            return jMap.toString();
        }
            
        }catch(UnrecognizedPropertyException u){
            u.printStackTrace();
            JSONObject errorData = new JSONObject();
            errorData.put("data",obj);
            errorData.put("errorDescription","Received data contains more or less properties than expected");
            errorData.put("responseCode",500);
            System.out.println("errorData is "+ errorData.toString());
            return errorData.toString();

        }catch(JsonProcessingException j)
        {
            j.printStackTrace();
            JSONObject errorData = new JSONObject();
            errorData.put("data",obj);
            errorData.put("errorDescription","Received data cannot be parsed into JSON format");
            errorData.put("responseCode",400);
            System.out.println("errorData is "+ errorData.toString());
            return errorData.toString();
            
        }
}
}