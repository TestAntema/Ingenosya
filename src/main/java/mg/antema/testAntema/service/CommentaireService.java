package mg.antema.testAntema.service;

import mg.antema.testAntema.model.Commentaire;
import mg.antema.testAntema.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository cRepo;

    public List<Commentaire> getAll(){
        return cRepo.findAll();
    }

    public Commentaire getById(int id){
        return cRepo.findById(id).get();
    }

    public void save(Commentaire commentaire){
        cRepo.save(commentaire);
    }

    public void delete(int id){
        cRepo.deleteById(id);
    }

    public List<Commentaire> getByUtilisateur(int idUtilisateur){
        return cRepo.findByUtilisateurIdUtilisateur(idUtilisateur);
    }

    public List<Commentaire> getByVoiture(int idVoiture){
        return cRepo.findByVoitureIdVoiture(idVoiture);
    }

    public void deleteByIdUtilisateur(int idUtilisateur){
        cRepo.deleteByUtilisateur(idUtilisateur);
    }

    public void deleteByIdVoiture(int idVoiture){
        cRepo.deleteByVoiture(idVoiture);
    }

}
