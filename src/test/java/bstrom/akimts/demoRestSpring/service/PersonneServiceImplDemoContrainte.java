package bstrom.akimts.demoRestSpring.service;

import bstrom.akimts.demoRestSpring.model.Personne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonneServiceImplDemoContrainte {

    private PersonneService service = new PersonneServiceImpl();

    @Test
    void add() {
        service.add(new Personne(null,15/*,false, LocalDate.now(), "a@a.com"*/));
    }
}