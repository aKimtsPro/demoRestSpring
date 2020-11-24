package bstrom.akimts.demoRestSpring.service;

import bstrom.akimts.demoRestSpring.model.Personne;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonneService {

    private List<Personne> list = new ArrayList<>();

    public void prouverExistence(){
        System.out.println("j'existe");
    }

    public void add(Personne pers){
        list.add(pers);
    }

    public void remove(int index){
        list.remove(index);
    }

    public Personne get(int index){
        return list.get(index);
    }

}
