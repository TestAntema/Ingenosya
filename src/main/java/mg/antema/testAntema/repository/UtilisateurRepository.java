package mg.antema.testAntema.repository;

import mg.antema.testAntema.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
Utilisateur findByLogin(@Param("login") String login);
}
