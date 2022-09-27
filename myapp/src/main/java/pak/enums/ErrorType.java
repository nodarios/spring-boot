package pak.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    INVALID_DATA(HttpStatus.BAD_REQUEST),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);

    private final HttpStatus httpStatus;

}
