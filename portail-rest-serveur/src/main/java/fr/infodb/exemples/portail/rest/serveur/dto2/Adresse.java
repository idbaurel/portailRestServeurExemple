package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;

/**
 * @author aurelien
 * créé le 05/02/18.
 */
public class Adresse implements Serializable{

    /**
     * Complément destinataire
     */
//    @XmlAttribute(name = "AdditionnalRecipient")
    private String complementDestinataire;

    /**
     * Le numéro de la place
     */
//    @XmlAttribute(name = "Number")
    private String numero;

    /**
     * Le libellé du lieu
     */
//    @XmlAttribute(name = "Place")
    private String libelleLieu;

    /**
     * Complement d'adresse
     */
//    @XmlAttribute(name = "AdditionnalPlace")
    private String complementAdresse;

    /**
     * Le code postal
     */
//    @XmlAttribute(name = "ZipCode")
    private String codePostal;

    /**
     * Nom de la commune
     */
//    @XmlAttribute(name = "Municipality")
    private String libelleCommune;

    /**
     * Territoire (découpage géographique)
     */
//    @XmlAttribute(name = "TerritoryUnit")
    private String uniteTerritoriale;

    /**
     * Circonscription (découpage géographique)
     */
//    @XmlAttribute(name = "Circonscription")
    private String circonscription;

    /**
     * Secteur (découpage géographique)
     */
//    @XmlAttribute(name = "Secteur")
    private String secteur;

    /**
     * Le code du departement (ex: 22 pour Côtes d'Armor)
     */
//    @XmlAttribute(name = "DepartmentCode")
    private String codeDepartement;

    /**
     * Le code de la commune
     */
//    @XmlAttribute(name = "MunicipalityCode")
    private String codeCommune;

    /**
     * Le code de la place
     */
//    @XmlAttribute(name = "PlaceCode")
    private String codeLieu;

    /**
     * Numéro de téléphone du secteur
     */
//    @XmlAttribute(name = "SectorTel")
    private String telephoneSecteur;

    public String getComplementDestinataire() {
        return complementDestinataire;
    }

    public void setComplementDestinataire(String complementDestinataire) {
        this.complementDestinataire = complementDestinataire;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLibelleLieu() {
        return libelleLieu;
    }

    public void setLibelleLieu(String libelleLieu) {
        this.libelleLieu = libelleLieu;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLibelleCommune() {
        return libelleCommune;
    }

    public void setLibelleCommune(String libelleCommune) {
        this.libelleCommune = libelleCommune;
    }

    public String getUniteTerritoriale() {
        return uniteTerritoriale;
    }

    public void setUniteTerritoriale(String uniteTerritoriale) {
        this.uniteTerritoriale = uniteTerritoriale;
    }

    public String getCirconscription() {
        return circonscription;
    }

    public void setCirconscription(String circonscription) {
        this.circonscription = circonscription;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }

    public String getCodeLieu() {
        return codeLieu;
    }

    public void setCodeLieu(String codeLieu) {
        this.codeLieu = codeLieu;
    }

    public String getTelephoneSecteur() {
        return telephoneSecteur;
    }

    public void setTelephoneSecteur(String telephoneSecteur) {
        this.telephoneSecteur = telephoneSecteur;
    }
}
