package bstrom.akimts.demoRestSpring.service;

import bstrom.akimts.demoRestSpring.model.Personne;

import javax.validation.Valid;

public interface PersonneService {

    void prouverExistence();
    void add(@Valid Personne pers);
    Personne get(int index);
    void remove(int index);

}
