package mg.antema.testAntema.service;

import mg.antema.testAntema.model.Voiture;
import mg.antema.testAntema.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository vRepo;

    public List<Voiture> getAll(){
        return vRepo.findAll();
    }

    public void save(Voiture voiture){
        vRepo.save(voiture);
    }

    public Voiture getById(int id){
        return vRepo.findById(id).get();
    }

    public void delete(int id){
        vRepo.deleteById(id);
    }

    public void update(Voiture voiture){
        Voiture existingVoiture = vRepo.findById(voiture.getIdVoiture()).get();
        existingVoiture.setMarque(voiture.getMarque());
        existingVoiture.setFicheTech(voiture.getFicheTech());
        existingVoiture.setModele(voiture.getModele());
        existingVoiture.setPrix(voiture.getPrix());
        vRepo.save(existingVoiture);
    }
}
