package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.Voiture;
import bstrom.akimts.demoRestSpring.service.VoitureService;
import bstrom.akimts.demoRestSpring.service.exception.VoitureNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/voit")
public class VoitureController {

    // region correction exo

    private VoitureService service;

    public VoitureController(VoitureService service) {
        this.service = service;
    }

    // CREATE : POST > http://localhost:8080/voit
    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid Voiture toCreate){

        int index = service.create(toCreate);
        return new ResponseEntity<>("Voiture créée à l'index : " + index, HttpStatus.CREATED);
    }

    // READ : GET > http://localhost:8080/voit/{id}
    @GetMapping("/{index}")
    public ResponseEntity<Voiture> getOne(@PathVariable int index){

        HttpHeaders headers = new HttpHeaders();
        headers.add("voit-count", Integer.toString(service.count()) );

        try{
            Voiture body = service.readOne( index );
            return new ResponseEntity<>(body, headers, HttpStatus.OK);
        } catch ( VoitureNotFoundException e ){
            return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
        }

    }

    // READ_ALL : GET > http://localhost:8080/voit
    @GetMapping
    public ResponseEntity<List<Voiture>> getAll(){

        return ResponseEntity.ok( service.readAll() );
        // return ResponseEntity.ok().body(service.readAll()); // meme chose

    }

    // UPDATE : PUT > http://localhost:8080/voit
    @PutMapping("/{index}")
    public ResponseEntity<String> update(@PathVariable int index, @RequestBody Voiture voit){

        try{
            service.update(index, voit);
            return ResponseEntity.ok()
                    .header("voit-count", Integer.toString(service.count()))
                    .body("voiture modifiée");
        }catch (VoitureNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("voiture non trouvée");
        }

    }

    // DELETE : DELETE > http://localhost:8080/voit/{index}
    @DeleteMapping("/{index}")
    public ResponseEntity<String> delete(@PathVariable int index){

        try{
            service.delete(index);
            return ResponseEntity.ok()
                    .header("voit-count", Integer.toString(service.count()))
                    .body("voiture d'index " + index + "supprimée");
        }catch (VoitureNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("voit-count", Integer.toString(service.count()))
                    .body("index invalide");
        }

    }




    // endregion


    // region exemple

    @PostMapping(path = "/exemple", produces = MediaType.TEXT_PLAIN_VALUE /*(string = "text/plain")*/) //POST > http://localhost:8080/voit -> mettre une voiture en JSON dans le body
    public String writeVoiture(@RequestBody @Valid Voiture voit){
        System.out.println(voit);
        return "voiture ecrite";
    }

    @GetMapping("/exemple")
    public ResponseEntity<Voiture> getVoitureExemple(){
        Voiture body = new Voiture("vrimvroom", 120, "bleu", 3);

        HttpHeaders headers = new HttpHeaders();
        headers.add("senderController", "VoitureController");

        HttpStatus status = HttpStatus.OK; // 200

        return new ResponseEntity<>(body, headers, status);
    }

    @GetMapping("/exemple/builder")
    public ResponseEntity<Voiture> getVoitureExempleWithBuilder(){

        Voiture body = new Voiture("vrimvroom", 120, "bleu", 3);

        HttpHeaders headers = new HttpHeaders();
        headers.add("senderController", "VoitureController");

        HttpStatus status = HttpStatus.OK; // 200

        return ResponseEntity.status(status)
                .headers(headers)
                .body(body);

    }

    // endregion

}
