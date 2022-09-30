package touristTrip.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = PassportValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)

public @interface PassportInterface {


    String message() default "{Incorrect passport number!}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

