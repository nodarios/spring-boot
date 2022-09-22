package pak.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsNationalityGeoValidator implements ConstraintValidator<IsNationalityGeo, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.equals("geo");
    }

}
