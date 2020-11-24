package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.service.PersonneService;
import bstrom.akimts.demoRestSpring.service.PersonneServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // requete pour ajouter une Personne
    // requete pour supprimer une Personne selon sa position dans la liste
    // requète pour ecrire une Personne selon sa position dans la liste

}
