package mg.antema.testAntema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
public class Voiture {
    public Voiture(){}
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idVoiture;
    private String marque;
    private String modele;
    private String ficheTech;
    private int prix;
    @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<Commentaire> commentaires;

    public Voiture(int idVoiture, String marque, String modele, String ficheTech, int prix) {
        this.idVoiture = idVoiture;
        this.marque = marque;
        this.modele = modele;
        this.ficheTech = ficheTech;
        this.prix = prix;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public String toString(){
        return "Voiture{"+"idVoiture="+ idVoiture + "marque=" + marque + "modele=" + modele + "ficheTech="+ ficheTech + "prix=" + prix + "}";
    }

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getFicheTech() {
        return ficheTech;
    }

    public void setFicheTech(String ficheTech) {
        this.ficheTech = ficheTech;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}