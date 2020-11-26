package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.VoitureNotFoundReport;
import bstrom.akimts.demoRestSpring.service.exception.VoitureNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = ListController.class)
public class ControllerAdviserList {

    @ExceptionHandler(VoitureNotFoundException.class)
    public ResponseEntity<VoitureNotFoundReport> voitureNotFoundExceptionHandler(VoitureNotFoundException ex, HttpServletRequest request){

        VoitureNotFoundReport report = new VoitureNotFoundReport(ex.getIndex(), request.getMethod(), "http://localhost:8080"+request.getRequestURI());

        return ResponseEntity.badRequest()
                .body(report);

        // return new ResponseEntity<>(report, HttpStatus.BAD_REQUEST);
    }
}
