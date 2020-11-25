package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.Voiture;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

@RestController
@RequestMapping("/voit")
public class VoitureController {

    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE /*(string = "text/plain")*/) //POST > http://localhost:8080/voit -> mettre une voiture en JSON dans le body
    public String writeVoiture(@RequestBody @Valid Voiture voit){
        System.out.println(voit);
        return "voiture ecrite";
    }

    @GetMapping
    public ResponseEntity<Voiture> getVoiture(){
        Voiture body = new Voiture("vrimvroom", 120, "bleu", 3);

        HttpHeaders headers = new HttpHeaders();
        headers.add("senderController", "VoitureController");

        HttpStatus status = HttpStatus.OK; // 200

        return new ResponseEntity<>(body, headers, status);
    }

    @GetMapping("/builder")
    public ResponseEntity<Voiture> getVoitureWithBuilder(){

        Voiture body = new Voiture("vrimvroom", 120, "bleu", 3);

        HttpHeaders headers = new HttpHeaders();
        headers.add("senderController", "VoitureController");

        HttpStatus status = HttpStatus.OK; // 200

        return ResponseEntity.status(status)
                .headers(headers)
                .body(body);

    }



}
