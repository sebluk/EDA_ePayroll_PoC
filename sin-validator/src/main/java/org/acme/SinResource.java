package main.java.org.acme;

import java.util.Set;
import java.util.stream.Collectors;
import org.json.*;  

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
import main.java.org.acme.VaidatedResult;
import main.java.org.acme.SinService;

@Path("/sinValidation")
public class SinResource {

    @Inject
    Validator validator;

    @Inject
    SinService sinService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    // @Path("/manual-validation")
    // @POST
    // @Produces(MediaType.APPLICATION_JSON)
    // @Consumes(MediaType.APPLICATION_JSON)
    // public Result tryMeManualValidation(Book book) {
    //     Set<ConstraintViolation<Book>> violations = validator.validate(book);
    //     if (violations.isEmpty()) {
    //         return new Result("Book is valid! It was validated by manual validation.");
    //     } else {
    //         return new Result(violations);
    //     }
    // }

    // @Path("/end-point-method-validation")
    // @POST
    // @Produces(MediaType.APPLICATION_JSON)
    // @Consumes(MediaType.APPLICATION_JSON)
    // public Result tryMeEndPointMethodValidation(@Valid Book book) {
    //     return new Result("Book is valid! It was validated by end point method validation.");
    // }

    @Path("/service-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String tryMeServiceMethodValidation(String obj) {
        JSONObject json = new JSONObject(obj); 
        System.out.println("received and converted to json: "+ json);

        int sin = json.getInt("employee_sin");  
        System.out.println(sin);
        try {
            boolean isSinVlaid = sinService.isValid(sin);
            if(isSinVlaid){
                return "Sin number is valid! It was validated by sin validator service.";
            }
            else{
                return "sin number is invalid";
            }
            
           
        } catch (ConstraintViolationException e) {
            return "error found";
        }
    }


}