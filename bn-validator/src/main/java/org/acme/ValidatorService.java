package org.acme;
import java.util.regex.*;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class ValidatorService {
    boolean valid;
    public boolean isBnValid(String bn) {
        this.valid =false;
        String REGEX = "^\\d+[a-zA-Z]+\\d+$";
        if(bn.length() == 15){ 
        boolean matcher = Pattern.matches(REGEX, bn);
        if (matcher) {
            System.out.println("match found for Regex.");
            this.valid = true;
        }
        else {
            System.out.println("No match found for Regex.");
            this.valid = false;
        }
        }
        
        return valid;
    }
}