package mg.antema.testIngenosya.controller;

import mg.antema.testIngenosya.model.Voiture;
import mg.antema.testIngenosya.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
        return vRepo.findById(id).get();
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
