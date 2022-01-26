package ca.gc.cra.rcsc.eda_epayroll_poc;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;
public class VaidatedResult {

    private String message;
    private boolean success;

    VaidatedResult(String message) {
        this.success = true;
        this.message = message;
    }

    VaidatedResult(Set<? extends ConstraintViolation<?>> violations) {
        this.success = false;
        this.message = violations.stream()
                .map(cv -> cv.getMessage())
                .collect(Collectors.joining(", "));
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

}