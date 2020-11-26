package bstrom.akimts.demoRestSpring.service;

import bstrom.akimts.demoRestSpring.model.Voiture;

import java.util.List;

public interface VoitureService {

    //Create
    int create(Voiture voiture);

    // Read
    Voiture readOne(int index);
    List<Voiture> readAll();

    // Update
    void update(int index, Voiture toUpdate);

    // Delete
    void delete(int index);

    // Autre
    int count();

}
