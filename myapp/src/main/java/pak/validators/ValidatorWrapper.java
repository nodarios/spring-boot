package pak.validators;

import lombok.experimental.UtilityClass;
import pak.enums.ErrorType;
import pak.exception.AppException;

import javax.validation.Validation;
import javax.validation.Validator;

@UtilityClass
public class ValidatorWrapper {

    private Validator validator;

    public void validate(Object object) throws AppException {
        if (validator == null) {
            validator = Validation.buildDefaultValidatorFactory().getValidator();
        }

        var violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new AppException(ErrorType.INVALID_DATA);
        }
    }

}
