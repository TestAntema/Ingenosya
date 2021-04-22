package mg.antema.testIngenosya.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur {
    public Utilisateur(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idUtilisateur;
    private String login;
    private String mdp;
    @OneToMany(mappedBy = "utilisateur")
    private List<Commentaire> commentaires;


    public Utilisateur(int idUtilisateur, String login, String mdp) {
        this.idUtilisateur = idUtilisateur;
        this.login = login;
        this.mdp = mdp;
    }

    public String toString() {
        return "Utilisateur{idUtilisateur="+ idUtilisateur + "login=" + login + "mdp=" + mdp + "}";
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}