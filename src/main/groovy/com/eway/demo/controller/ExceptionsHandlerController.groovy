package com.eway.demo.controller

import com.eway.common.exception.EwayException
import com.eway.common.SystemError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
class ExceptionsHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EwayException.class)
    final ResponseEntity<SystemError> ewayException(EwayException ex, WebRequest request) {
        return new ResponseEntity<SystemError>(new SystemError.Builder(ex.getCode())
            .details(ex.getMessage())
            .fromPath(request.getContextPath())
            .withMessage(ex.getUserMessage()).build(),
            HttpStatus.INTERNAL_SERVER_ERROR)
    }


    @ExceptionHandler(Exception.class)
    final ResponseEntity<SystemError> exception(Exception ex, WebRequest request) {
        return new ResponseEntity<SystemError>(new SystemError.Builder(999)
            .details(ex.getMessage())
            .fromPath(request.getContextPath())
            .withMessage("Unknown exception").build(), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
