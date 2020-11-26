package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.Voiture;
import bstrom.akimts.demoRestSpring.model.VoitureNotFoundReport;
import bstrom.akimts.demoRestSpring.service.VoitureService;
import bstrom.akimts.demoRestSpring.service.exception.VoitureNotFoundException;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

        Voiture body = service.readOne( index );
        return new ResponseEntity<>(body, headers, HttpStatus.OK);

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

        service.update(index, voit);
        return ResponseEntity.ok()
                .header("voit-count", Integer.toString(service.count()))
                .body("voiture modifiée");

    }

    // DELETE : DELETE > http://localhost:8080/voit/{index}
    @DeleteMapping("/{index}")
    public ResponseEntity<String> delete(@PathVariable int index){

        service.delete(index);
        return ResponseEntity.ok()
                .header("voit-count", Integer.toString(service.count()))
                .body("voiture d'index " + index + "supprimée");

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

    // region demo exceptionHandler


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex, HttpServletRequest req){
//
//        // return ResponseEntity.badRequest().body(ex); // fout le bordel
//
//        StringBuilder body = new StringBuilder("- Global violation --------------------\n");
//
//        if(ex.getGlobalErrorCount() == 0)
//            body.append("\taucune\n");
//
//        for (ObjectError globalError : ex.getGlobalErrors()) {
//            body.append(globalError.getObjectName()).append(" - ").append(globalError.getDefaultMessage()).append("\n");
//        }
//
//        body.append("- field violation --------------------\n");
//
//        if(ex.getFieldErrorCount() == 0)
//            body.append("\taucune\n");
//
//        for (FieldError fieldError : ex.getFieldErrors()) {
//            body.append(fieldError.getField()).append(" - ").append(fieldError.getDefaultMessage()).append("\n");
//        }
//
//        return ResponseEntity.badRequest()
//                .body(body.toString());
//    }

    // endregion

}
