package mg.antema.testAntema.service;

import mg.antema.testAntema.exceptions.RessourceNotFoundException;
import mg.antema.testAntema.model.CustomeUtilisateur;
import mg.antema.testAntema.model.Utilisateur;
import mg.antema.testAntema.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomeUtilisateurService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByLogin(login);
        if(utilisateur ==  null) throw new RessourceNotFoundException("Utilisateur not found");
        return new CustomeUtilisateur(utilisateur);
    }
}
