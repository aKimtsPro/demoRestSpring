package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.Personne;
import bstrom.akimts.demoRestSpring.model.VoitureNotFoundReport;
import bstrom.akimts.demoRestSpring.service.PersonneService;
import bstrom.akimts.demoRestSpring.service.exception.VoitureNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
    public void add(@RequestBody Personne pers){
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

    @GetMapping("/throw") // demo controllerAdvice
    public void throwVoitureNotFound(){
        throw new VoitureNotFoundException(0);
    }

}
