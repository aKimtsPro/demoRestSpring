package bstrom.akimts.demoRestSpring.service;

import bstrom.akimts.demoRestSpring.model.Personne;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonneServiceImpl implements PersonneService {

    private List<Personne> list = new ArrayList<>();

    public void prouverExistence(){
        System.out.println("j'existe");
    }

    public void add(@Valid Personne pers){
        list.add(pers);
    }

    public void remove(int index){
        list.remove(index);
    }

    public Personne get(int index){
        return list.get(index);
    }

}
