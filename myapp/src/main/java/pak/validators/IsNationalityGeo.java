package pak.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsNationalityGeoValidator.class)
public @interface IsNationalityGeo {

    String message() default "default message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
