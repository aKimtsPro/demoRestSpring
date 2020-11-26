package bstrom.akimts.demoRestSpring.controller;

import bstrom.akimts.demoRestSpring.model.Personne;
import bstrom.akimts.demoRestSpring.service.exception.VoitureNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private List<String> list = Arrays.asList("luc", "marie", "dominique");

    @GetMapping
    public void helloWorld(){
        System.out.println("hello world");
    }

    // GET > http://localhost:8080/hello -> ecrit "hello world" dans la console de l'appli
    @GetMapping("/r_param")
    public void helloWithRequestParam( @RequestParam(name = "stringValue", required = false) String stringValue ){
        System.out.println(stringValue != null ? stringValue : "hello world");
    }

    // GET > http://localhost:8080/hello(/bye) -> ecrit le nom associé à l'index dans la liste
    @GetMapping({"/{id}/{bye}", "/{id}"})
    public void helloWithPathVariable( @PathVariable(name = "id") int index, @PathVariable(name = "bye", required = false) String auRevoir ){
        String bye = auRevoir == null ? "" : " " + auRevoir;
        System.out.println("hello " + list.get(index) + bye );
    }

    // POST > http://localhost:8080/hello -> ecrit la chaine envoyé par post dans la console de l'appli
    @PostMapping
    public void writeInConsole(@RequestBody Personne body){
        System.out.println(body);
        // throw new RuntimeException();
    }

    @GetMapping("/header")
    public void getHeaders(@RequestHeader HttpHeaders header){
        header.forEach((key, listValue) ->{
            System.out.println("- clef : "+key+" ------------");
            listValue.forEach(System.out::println);
        });
    }

    @GetMapping("/throw") // demo controllerAdvice
    public void throwVoitureNotFound(){
        throw new VoitureNotFoundException(0);
    }
}
