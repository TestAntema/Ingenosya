package mg.antema.testIngenosya.repository;

import mg.antema.testIngenosya.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer>{
    List<Commentaire> findByUtilisateurIdUtilisateur(@Param("idUtilisateur") int idUtilisateur);

    List<Commentaire> findByVoitureIdVoiture(@Param("idVoiture") int idVoiture);

    void deleteByUtilisateur(@Param("idUtilisateur") int idUtilisateur);

    void deleteByVoiture(@Param("idVoiture") int idVoiture);
}
