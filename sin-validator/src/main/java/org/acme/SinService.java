package main.java.org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class SinService {

    public boolean isValid(int sin) {
        int sinLength = String.valueOf(sin).length();
       if(sinLength == 9){
           return true;
       }
       else{
           return false;
       }
    }
}