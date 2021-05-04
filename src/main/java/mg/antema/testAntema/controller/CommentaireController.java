package mg.antema.testAntema.controller;

import mg.antema.testAntema.exceptions.RessourceNotFoundException;
import mg.antema.testAntema.model.Commentaire;
import mg.antema.testAntema.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentaireController {

    @Autowired
    private CommentaireRepository cRepo;

    @GetMapping(value = "Commentaire")
    public List<Commentaire> getAllCommentaire() {
        return cRepo.findAll();
    }

    @GetMapping(value = "Voiture/Commentaire/{id}")
    public List<Commentaire> getVoitureCommentes(@PathVariable int id){
        return cRepo.findByVoitureIdVoiture(id);
    }

    @GetMapping(value = "Commentaire/{id}")
    public Commentaire getCommentaire(@PathVariable int id) {

        Commentaire commentaire = cRepo.findById(id).get();
        if(commentaire==null)throw new RessourceNotFoundException("Commentaire, id " + id + " not found");
        return commentaire;
    }

    @PostMapping(value = "/Commentaire")
    public ResponseEntity<Void> saveCommentaire(@RequestBody Commentaire Commentaire) {
        Commentaire Commentaire1 = cRepo.save(Commentaire);

        if (Commentaire == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(Commentaire1.getIdComment())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}