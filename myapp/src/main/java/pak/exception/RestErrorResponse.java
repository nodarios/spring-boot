package pak.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
@NoArgsConstructor
public class RestErrorResponse {

    private ErrorCodeType error;
    private Instant timestamp;
    private int status;

    public RestErrorResponse(ErrorCodeType errorCode) {
        this.error = errorCode;
        timestamp = Instant.now();
        status = errorCode.getHttpStatus().value();
    }

}
