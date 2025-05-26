package com.example.app.exception;

import com.example.app.dto.response.MessageRs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<MessageRs> handleResponseStatusException(ResponseStatusException exception) {
        exception.printStackTrace();
        return ResponseEntity.status(exception.getStatusCode())
                .body(new MessageRs(exception.getReason()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<MessageRs> handleAccessDeniedException(AccessDeniedException exception) {
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new MessageRs(exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageRs> handleUnknownException(Exception exception) {
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new MessageRs(exception.getMessage()));
    }
}
