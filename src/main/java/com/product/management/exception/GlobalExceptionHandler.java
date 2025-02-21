package com.product.management.exception;

import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        ErrorResponse errorResponse = new ErrorResponse(400, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUnauthorisedException(AuthenticationException e) {
        ErrorResponse errorResponse = new ErrorResponse(401, e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        ErrorResponse errorResponse = new ErrorResponse(403, e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundException(EntityNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(404, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleConflictException(DuplicateKeyException e) {
        ErrorResponse errorResponse = new ErrorResponse(409, e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInternalServerErrorException(InternalException e) {
        ErrorResponse errorResponse = new ErrorResponse(500, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
