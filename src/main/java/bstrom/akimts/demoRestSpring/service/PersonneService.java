package bstrom.akimts.demoRestSpring.service;

import bstrom.akimts.demoRestSpring.model.Personne;

public interface PersonneService {

    void prouverExistence();
    void add(Personne pers);
    Personne get(int index);
    void remove(int index);

}
