package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;

/**
 * @author aurelien
 * créé le 31/01/18.
 */
public class Utilisateur implements Serializable {


    private String id;
    private String login;
    private String nom;
    private String prenom;
    private String secteur;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }
}
