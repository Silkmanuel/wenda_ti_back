package kutuStech.wenda.infrastructure.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import kutuStech.wenda.infrastructure.config.DefaultApiResponse;
import kutuStech.wenda.infrastructure.exception.type_exception.DuplicateDataException;
import kutuStech.wenda.infrastructure.exception.type_exception.NotFoundException;
import kutuStech.wenda.infrastructure.exception.type_exception.UnauthorizedException;

@ControllerAdvice
public class ApiExceptionHandle {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultApiResponse<?>> handleNotFound(NotFoundException ex, HttpServletRequest request) {
        DefaultApiResponse<?> response = new DefaultApiResponse<>(
                HttpStatus.NOT_FOUND.value(),
                false,
                "Not Found",
                ex.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<DefaultApiResponse<?>>  handleUnauthorized(UnauthorizedException ex, HttpServletRequest request) {
        DefaultApiResponse<?> response = new DefaultApiResponse<>(
                HttpStatus.UNAUTHORIZED.value(),
                false,
                "Unauthorized",
                ex.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<DefaultApiResponse<?>>  handleUnauthorized(DuplicateDataException ex, HttpServletRequest request) {
        DefaultApiResponse<?> response = new DefaultApiResponse<>(
                HttpStatus.CONFLICT.value(),
                false,
                "duplicate data",
                ex.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultApiResponse<?>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err ->
            errors.put(err.getField(), err.getDefaultMessage())
        );

        DefaultApiResponse<?> response = new DefaultApiResponse<>(
            HttpStatus.BAD_REQUEST.value(),
            false,
            "Validation Error",
            "Invalid data sent.",
            errors
        );
        return ResponseEntity.badRequest().body(response);
    }
}
