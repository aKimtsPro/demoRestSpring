package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.DemoContrainte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/prep")
public class PrepController {

    @PostMapping
    public void test(@RequestBody @Valid DemoContrainte test){
        System.out.println(test);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> goWrong(MethodArgumentNotValidException ex, HttpServletRequest request) throws IOException {

        StringBuilder builder = new StringBuilder();

        builder.append("global errors:------------------------\n");
        if(ex.getBindingResult().getGlobalErrors().size() == 0)
            builder.append(" / \n");
        for (ObjectError allError : ex.getBindingResult().getGlobalErrors()) {
            builder.append(allError.getObjectName()).append(" - ").append(allError.getDefaultMessage()).append("\n");
        }

        builder.append("field errors:------------------------\n");
        if(ex.getBindingResult().getFieldErrors().size() == 0)
            builder.append(" / \n");
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            builder.append(fieldError.getField()).append(" - ").append(fieldError.getDefaultMessage()).append("\n");
        }
        return new ResponseEntity<>(builder.toString(), HttpStatus.BAD_REQUEST);
    }
}
