package mg.antema.testAntema.controller;

import mg.antema.testAntema.exceptions.RessourceNotFoundException;
import mg.antema.testAntema.model.Voiture;
import mg.antema.testAntema.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VoitureController {

    @Autowired
    private VoitureRepository vRepo;


    @GetMapping(value = "Voiture")
    public List<Voiture> getAllVoiture(){
        return vRepo.findAll();
    }

    @GetMapping(value = "Voiture/{id}")
    public Voiture getVoiture(@PathVariable int id){

        Voiture voiture = vRepo.findById(id).get();
        if(voiture==null)throw new RessourceNotFoundException("Voiture, id " + id + " not found");
        return voiture;
    }

    @PostMapping(value = "/Voiture")
    public ResponseEntity<Void> saveVoiture(@RequestBody Voiture voiture){
        Voiture voiture1 = vRepo.save(voiture);

        if(voiture == null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(voiture1.getIdVoiture())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
