package pak.exception;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pak.dtos.ErrorDto;
import pak.enums.ErrorType;

@Slf4j
@RestControllerAdvice
@ApiResponse(responseCode = "error code", description = "error response",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
class RestExceptionHandler {

    @ExceptionHandler(AppException.class)
    private ResponseEntity<ErrorDto> handleAppException(AppException exception) {
        return buildErrorResponse(exception.getErrorType(), exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return buildErrorResponse(ErrorType.INVALID_DATA, exception);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorDto> handleUnknownException(Exception exception) {
        return buildErrorResponse(ErrorType.SERVER_ERROR, exception);
    }

    private ResponseEntity<ErrorDto> buildErrorResponse(ErrorType errorType, Exception exception) {
        log.error("", exception);

        ErrorDto errorDto = new ErrorDto(errorType);
        return ResponseEntity
                .status(errorType.getHttpStatus())
                .body(errorDto);
    }

}
