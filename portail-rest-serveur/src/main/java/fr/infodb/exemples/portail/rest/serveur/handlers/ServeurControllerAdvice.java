package fr.infodb.exemples.portail.rest.serveur.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author aurelien
 * créé le 22/11/17.
 */
@ControllerAdvice
public class ServeurControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServeurControllerAdvice.class);


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity handle(Exception exceptionHandled) {
        return getResponseEntity(exceptionHandled, "Erreur web service", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity getResponseEntity(Exception exceptionHandled, String message, HttpStatus httpStatus) {
        LOGGER.error(message, exceptionHandled);
        ResponseEntity responseEntity = new ResponseEntity(exceptionHandled, httpStatus);
        return responseEntity;
    }
}
