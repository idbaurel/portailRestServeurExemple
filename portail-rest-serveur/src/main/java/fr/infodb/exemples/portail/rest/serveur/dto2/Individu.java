package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;
import java.util.Date;

/**
 * Représentation d'un individu
 *
 * @author aurelien
 * créé le 29/01/18.
 */
public class Individu implements Serializable {

    /**
     * identifiant unique d'individu sur l'application tierce
     */
    private String id;

    private String caf;
    private boolean decede;
    private Date dateDeces;
    private Date dateNaissance;
    private String email;
    private IndividuGenre genre;
    private boolean majeur = true;
    private String nom;
    private String nomNaissance;
    private String prenom;
    private String secteurDossier;
    private String secteurSuivi;
    private String tel;
    private String mobile;
    private String telTravail;

    private Adresse adresse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaf() {
        return caf;
    }

    public void setCaf(String caf) {
        this.caf = caf;
    }

    public boolean isDecede() {
        return decede;
    }

    public void setDecede(boolean decede) {
        this.decede = decede;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IndividuGenre getGenre() {
        return genre;
    }

    public void setGenre(IndividuGenre genre) {
        this.genre = genre;
    }

    public boolean isMajeur() {
        return majeur;
    }

    public void setMajeur(boolean majeur) {
        this.majeur = majeur;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomNaissance() {
        return nomNaissance;
    }

    public void setNomNaissance(String nomNaissance) {
        this.nomNaissance = nomNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSecteurDossier() {
        return secteurDossier;
    }

    public void setSecteurDossier(String secteurDossier) {
        this.secteurDossier = secteurDossier;
    }

    public String getSecteurSuivi() {
        return secteurSuivi;
    }

    public void setSecteurSuivi(String secteurSuivi) {
        this.secteurSuivi = secteurSuivi;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTelTravail() {
        return telTravail;
    }

    public void setTelTravail(String telTravail) {
        this.telTravail = telTravail;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
