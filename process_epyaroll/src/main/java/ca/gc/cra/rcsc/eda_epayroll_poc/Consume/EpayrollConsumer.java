package ca.gc.cra.rcsc.eda_epayroll_poc.Consume;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.gc.cra.rcsc.eda_epayroll_poc.models.Epayroll;
import ca.gc.cra.rcsc.eda_epayroll_poc.models.EpayrollEntity;

import java.io.IOException;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import org.jboss.logging.Logger;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import io.smallrye.reactive.messaging.annotations.Blocking;
import com.fasterxml.jackson.databind.ObjectMapper;
@ApplicationScoped
public class EpayrollConsumer {
    @Inject
    EntityManager em; 

   // private static final Logger LOG = Logger.getLogger(EpayrollConsumer.class);
    @Incoming("epayrolls") 
    @Transactional
    @Blocking                                    
    public void process(String epayrollData) {
        try{
            Epayroll obj = new ObjectMapper().readValue(epayrollData, Epayroll.class); 
            EpayrollEntity ep = new EpayrollEntity();
            ep.setBn(obj.getBn());
            ep.setEmployer_paydac(obj.getEmployer_paydac());
            ep.setEmployer_name(obj.getEmployer_name());
            ep.setPay_start(obj.getPay_start());
            ep.setPay_end(obj.getPay_end());
            ep.setEmployee_status(obj.getEmployee_status());
            ep.setEmployee_name(obj.getEmployee_name());
            ep.setEmployee_sin(obj.getEmployee_sin());
            ep.setEmployee_id(obj.getEmployee_id());
            ep.setGross_pay(obj.getGross_pay());
            ep.setTax_deducted(obj.getTax_deducted());
            ep.setCpp_contrib(obj.getCpp_contrib());
            ep.setCpp_pension_earn(obj.getCpp_pension_earn());
            ep.setEi_contrib(obj.getEi_contrib());
            ep.setEi_insur_earnings(obj.getEi_insur_earnings());

            em.persist(ep);
            ObjectMapper Obj = new ObjectMapper();  
            String jsonStr = Obj.writeValueAsString(obj);  
            // Displaying Java object into a JSON string  
            System.out.println(jsonStr);  
        }
        catch(JsonProcessingException j){
            j.printStackTrace(); 
        }
        catch (IOException e) {  
            e.printStackTrace();  
        } 
        //JSONObject receivedEpayroll = new JSONObject(obj);

        
        // ObjectMapper Obj = new ObjectMapper();  
        // try {
        //     String jsonStr = Obj.writeValueAsString(obj);  
        //         // Displaying Java object into a JSON string  
        //     System.out.println(jsonStr);  
        //     }  
        
     
       
    }

}
