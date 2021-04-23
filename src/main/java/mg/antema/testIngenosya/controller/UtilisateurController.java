package mg.antema.testIngenosya.controller;

import mg.antema.testIngenosya.model.Utilisateur;
import mg.antema.testIngenosya.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository uRepo;

    @GetMapping(value = "Utilisateur")
    public List<Utilisateur> getAllUtilisateur(){
        return uRepo.findAll();
    }

    @GetMapping(value = "Utilisateur/{id}")
    public Utilisateur getUtilisateur(@PathVariable int id){
        return uRepo.findById(id).get();
    }

    @PostMapping(value = "/Utilisateur")
    public ResponseEntity<Void> saveUtilisateur(@RequestBody Utilisateur Utilisateur){
        Utilisateur Utilisateur1 = uRepo.save(Utilisateur);

        if(Utilisateur == null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(Utilisateur1.getIdUtilisateur())
                .toUri();
        return ResponseEntity.created(location).build();
    }}
