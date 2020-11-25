package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.Voiture;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/voit")
public class VoitureController {

    @PostMapping //POST > http://localhost:8080/voit -> mettre une voiture en JSON dans le body
    public void writeVoiture(@RequestBody @Valid Voiture voit){
        System.out.println(voit);
    }

}
