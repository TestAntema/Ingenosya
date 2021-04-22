package mg.antema.testIngenosya.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Commentaire {
    public Commentaire(){}
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idComment;
    private String comment;
    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    @JsonBackReference
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name="idVoiture")
    @JsonBackReference
    private Voiture voiture;

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public String toString(){
        return "Commentaire{idComment=" + idComment + "commentaire=" + comment + "}";
    }
}
