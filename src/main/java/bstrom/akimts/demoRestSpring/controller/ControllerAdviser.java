package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.VoitureNotFoundReport;
import bstrom.akimts.demoRestSpring.service.exception.VoitureNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = {HelloController.class, VoitureController.class})
public class ControllerAdviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VoitureNotFoundException.class)
    public ResponseEntity<VoitureNotFoundReport> voitureNotFoundExceptionHandler(VoitureNotFoundException ex, HttpServletRequest request){

        VoitureNotFoundReport report = new VoitureNotFoundReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest()
                .body(report);

        // return new ResponseEntity<>(report, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        StringBuilder body = new StringBuilder("@ Global violation --------------------\n");

        if(ex.getGlobalErrorCount() == 0)
            body.append("\taucune\n");

        for (ObjectError globalError : ex.getGlobalErrors()) {
            body.append(globalError.getObjectName()).append(" - ").append(globalError.getDefaultMessage()).append("\n");
        }

        body.append("@ field violation --------------------\n");

        if(ex.getFieldErrorCount() == 0)
            body.append("\taucune\n");

        for (FieldError fieldError : ex.getFieldErrors()) {
            body.append(fieldError.getField()).append(" - ").append(fieldError.getDefaultMessage()).append("\n");
        }

        return ResponseEntity.badRequest()
                .body(body.toString());

    }

    // ATTENTION !!! Conflit à cause de l'héritage de ResponseEntityExceptionHandler
    // qui possède un @ExceptionHandler pour cette exception (entre autres)

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex, HttpServletRequest req){
//
//        // return ResponseEntity.badRequest().body(ex); // fout le bordel
//
//        StringBuilder body = new StringBuilder("- Global violation --------------------\n");
//
//        if(ex.getGlobalErrorCount() == 0)
//            body.append("\taucune\n");
//
//        for (ObjectError globalError : ex.getGlobalErrors()) {
//            body.append(globalError.getObjectName()).append(" - ").append(globalError.getDefaultMessage()).append("\n");
//        }
//
//        body.append("- field violation --------------------\n");
//
//        if(ex.getFieldErrorCount() == 0)
//            body.append("\taucune\n");
//
//        for (FieldError fieldError : ex.getFieldErrors()) {
//            body.append(fieldError.getField()).append(" - ").append(fieldError.getDefaultMessage()).append("\n");
//        }
//
//        return ResponseEntity.badRequest()
//                .body(body.toString());
//    }

}
