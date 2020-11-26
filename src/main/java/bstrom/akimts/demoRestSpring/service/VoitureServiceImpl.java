package bstrom.akimts.demoRestSpring.service;

import bstrom.akimts.demoRestSpring.model.Voiture;
import bstrom.akimts.demoRestSpring.service.exception.VoitureNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService{

    private ArrayList<Voiture> list = new ArrayList<>();

    @Override
    public int create(Voiture voiture) {

        if(voiture == null)
            throw new IllegalArgumentException("toUpdate should not be null");

        list.add(voiture);
        return list.indexOf(voiture);
    }

    @Override
    public Voiture readOne(int index) {

        if(index >= list.size() || index < 0)
            throw new VoitureNotFoundException(index);

        return list.get(index);

//        try{
//            return list.get(index);
//        }
//        catch (IndexOutOfBoundsException e){
//            throw new VoitureNotFoundException(index);
//        }
    }

    @Override
    public List<Voiture> readAll() {
        return (ArrayList<Voiture>) list.clone();
    }

    @Override
    public void update(int index, Voiture toUpdate) {

        if(toUpdate == null)
            throw new IllegalArgumentException("toUpdate should not be null");

        if(index >= list.size() || index < 0)
            throw new VoitureNotFoundException(index);

        list.set(index, toUpdate);
    }

    @Override
    public void delete(int index) {

        if(index >= list.size() || index < 0)
            throw new VoitureNotFoundException(index);

        list.remove(index);
    }

    @Override
    public int count() {
        return list.size();
    }
}
