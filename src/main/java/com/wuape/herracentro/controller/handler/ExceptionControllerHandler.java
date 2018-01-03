package com.wuape.herracentro.controller.handler;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Bowpi GT
 * Created by Jose on 3/01/2018.
 */
@ControllerAdvice
public class ExceptionControllerHandler {

    private final Logger logger = LoggerFactory.getLogger(ExceptionControllerHandler.class);

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<MessageHandler> notFound(HttpServletRequest req, Exception ex) {
        logger.error("Error trying to process request. Error message is: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageHandler(req.getRequestURI(), ex.getMessage()));

    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<MessageHandler> globalExceptionHandler(HttpServletRequest req, Exception ex) {
        logger.error("Unknown message ocurred. Error message is: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageHandler(req.getRequestURI(), ex.getMessage()));

    }
}
