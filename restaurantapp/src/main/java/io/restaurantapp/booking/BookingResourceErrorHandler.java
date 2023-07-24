package io.restaurantapp.booking;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class BookingResourceErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorView handleValidationExceptionsFor(IllegalArgumentException ex) {
        return new ErrorView(ex.getClass().getCanonicalName(), ex.getMessage());
    }

    public static class ErrorView {
        private String exception;
        private String message;

        public ErrorView() {
        }

        public ErrorView(String exception, String message) {
            this.exception = exception;
            this.message = message;
        }

        public String getException() {
            return exception;
        }

        public String getMessage() {
            return message;
        }


    }
}
