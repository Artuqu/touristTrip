package touristTrip.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PassportValidator implements ConstraintValidator<PassportInterface,String> {

private Pattern pattern;

private Matcher matcher;

private static final String passportPattern = "^\\D{2}[0-9]{7}$";


    @Override
    public void initialize(PassportInterface constraintAnnotation) {

    }

    @Override
    public boolean isValid(String passport, ConstraintValidatorContext constraintValidatorContext) {
       return validatePassport(passport);
    }

    private boolean validatePassport(String passport){
        pattern=Pattern.compile(passportPattern);
        matcher=pattern.matcher(passport);
        return matcher.matches();
    }
}
