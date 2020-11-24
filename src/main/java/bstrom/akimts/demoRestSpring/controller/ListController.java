package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.Personne;
import bstrom.akimts.demoRestSpring.model.DemoContrainte;
import bstrom.akimts.demoRestSpring.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListController {

    private final PersonneService service;

    public ListController(PersonneService service) {
        this.service = service;
    }

    // GET > http://localhost:8080/list/hello
    @GetMapping("/hello")
    public void prouverExistence(){
        service.prouverExistence();
    }


    // POST > http://localhost:8080/list -> requete pour ajouter une Personne
    @PostMapping
    public void add(@Valid @RequestBody Personne pers){
        service.add(pers);
    }

    // GET > http://localhost:8080/list/{index} -> requète pour ecrire une Personne selon sa position dans la liste
    @GetMapping("/{index}")
    public void writeOne(@PathVariable int index){
        System.out.println(service.get(index));
    }

    // DELETE > http://localhost:8080/list/{index} -> requete pour supprimer une Personne selon sa position dans la liste
    @DeleteMapping("/{index}")
    public void delete(@PathVariable(name = "index") int toDelete){
        service.remove(toDelete);
    }


}
