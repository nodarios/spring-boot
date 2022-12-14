package pak.exception;

import lombok.Getter;
import pak.enums.ErrorType;

@Getter
public class AppException extends RuntimeException {

    private final ErrorType errorType;

    public AppException(ErrorType errorType) {
        super(errorType.toString());
        this.errorType = errorType;
    }

}
