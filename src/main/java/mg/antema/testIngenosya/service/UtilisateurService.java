package mg.antema.testIngenosya.service;

import mg.antema.testIngenosya.model.Utilisateur;
import mg.antema.testIngenosya.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository uRepo;

    public List<Utilisateur> getAll(){
        return uRepo.findAll();
    }

    public Utilisateur getById(int id){
        return uRepo.findById(id).get();
    }

    public void save(Utilisateur utilisateur){
        uRepo.save(utilisateur);
    }

    public void delete(int id){
        uRepo.deleteById(id);
    }

    public void update(Utilisateur utilisateur){
        Utilisateur existingUtilisateur = uRepo.findById(utilisateur.getIdUtilisateur()).get();
        existingUtilisateur.setMdp(utilisateur.getMdp());
        uRepo.save(existingUtilisateur);
    }
}
