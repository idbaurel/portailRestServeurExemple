package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;
import java.util.Date;

/**
 * @author aurelien
 * créé le 29/01/18.
 */
public class Individu implements Serializable {

    /**
     * identifiant unique d'individu sur l'application tierce
     */
    private String id;

    private IndividuGenre genre;

    //@XmlAttribute(name = "Title")
    private String title;
    //@XmlAttribute(name = "FirstName")
    private String prenom;
    //@XmlAttribute(name = "LastName")
    private String nom;
    //@XmlAttribute(name = "BirthName")
    private String nomNaissance;
    //@XmlAttribute(name = "BirthDate")
    private Date dateNaissance;
    //@XmlAttribute(name = "Caf")
    private String caf;
    //@XmlAttribute(name = "Major")
    private Boolean majeur = true;
    //@XmlAttribute(name = "Deceased")
    private boolean decede;
    //@XmlAttribute(name = "DeceasedDate")
    private Date dateDeces;
    //@XmlAttribute(name = "AdditionnalData")
//    private String additionnalData;
    //@XmlAttribute(name = "Tel")
    private String tel;
    //@XmlAttribute(name = "Mobile")
    private String mobile;
    //@XmlAttribute(name = "Email")
    private String email;
    //@XmlAttribute(name = "TelTravail")
    private String telTravail;
    //@XmlAttribute(name = "secteurDossier")
    private String secteurDossier;
    //@XmlAttribute(name = "secteurSuivi")
    private String secteurSuivi;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getNomNaissance() {
        return nomNaissance;
    }

    public void setNomNaissance(String nomNaissance) {
        this.nomNaissance = nomNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCaf() {
        return caf;
    }

    public void setCaf(String caf) {
        this.caf = caf;
    }

    public Boolean getMajeur() {
        return majeur;
    }

    public void setMajeur(Boolean majeur) {
        this.majeur = majeur;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelTravail() {
        return telTravail;
    }

    public void setTelTravail(String telTravail) {
        this.telTravail = telTravail;
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
}
