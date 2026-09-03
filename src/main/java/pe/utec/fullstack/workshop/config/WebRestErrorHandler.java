package pe.utec.fullstack.workshop.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class WebRestErrorHandler {

    @ExceptionHandler
    public ResponseEntity<Exception> handleGenericException(Exception ex) {

        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex);
    }


    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleFormError(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<ValidationResponse> errors = new ArrayList<>();
        for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errors.add(ValidationResponse.builder()
                    .field(error.getField())
                    .message(error.getDefaultMessage())
                    .build());
        }
        for (ObjectError error : methodArgumentNotValidException.getBindingResult().getGlobalErrors()) {
            errors.add(ValidationResponse.builder()
                    .field(error.getObjectName())
                    .message(error.getDefaultMessage())
                    .build());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionResponse.builder()
                        .code("GEN_ALL_01")
                        .message("Your request has some validation errors")
                        .validations(errors)
                        .build());
    }
}
