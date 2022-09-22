package pak.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pak.enums.ErrorType;

import java.time.Instant;

@Getter @Setter
@NoArgsConstructor
public class ErrorDto {

    private ErrorType errorType;
    private Instant timestamp;
    private int status;

    public ErrorDto(ErrorType errorType) {
        this.errorType = errorType;
        timestamp = Instant.now();
        status = errorType.getHttpStatus().value();
    }

}
