package fr.infodb.exemples.portail.rest.serveur.dto;

import fr.infodb.exemples.portail.rest.serveur.dto.constants.IndividuGenre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 31/01/18.
 */
public class IntervenantSocial implements Serializable {

    private String id;

    private IndividuGenre genre;

    private String prenom;

    private String nom;

    private String commentaire;

    private String secteur;

    private final List<String> secteurs = new ArrayList<>();

    private String telephone;

    private String email;

    private Utilisateur utilisateur;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IndividuGenre getGenre() {
        return genre;
    }

    public void setGenre(IndividuGenre genre) {
        this.genre = genre;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public List<String> getSecteurs() {
        return secteurs;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
