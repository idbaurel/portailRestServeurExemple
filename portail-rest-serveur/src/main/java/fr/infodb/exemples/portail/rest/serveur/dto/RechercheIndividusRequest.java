package fr.infodb.exemples.portail.rest.serveur.dto;

import java.util.Date;

/**
 * @author aurelien
 * créé le 06/02/18.
 */
public class RechercheIndividusRequest extends Pagination {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String commune;
    private boolean rechercheSurNomDeNaissance;

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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public boolean isRechercheSurNomDeNaissance() {
        return rechercheSurNomDeNaissance;
    }

    public void setRechercheSurNomDeNaissance(boolean rechercheSurNomDeNaissance) {
        this.rechercheSurNomDeNaissance = rechercheSurNomDeNaissance;
    }
}
