package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 23/01/13
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtAddress {

    @XmlAttribute(name = "AdditionnalRecipient")
    private String additionnalRecipient;

    /**
     * Le numéro de la place
     */
    @XmlAttribute(name = "Number")
    private String number;

    /**
     * Le libellé de la place
     */
    @XmlAttribute(name = "Place")
    private String place;

    @XmlAttribute(name = "AdditionnalPlace")
    private String additionnalPlace;

    /**
     * Le code postal
     */
    @XmlAttribute(name = "ZipCode")
    private String zipCode;

    /**
     * La municipalité
     */
    @XmlAttribute(name = "Municipality")
    private String municipality;

    @XmlAttribute(name = "TerritoryUnit")
    private String territoryUnit;

    /**
     * La circonscription
     */
    @XmlAttribute(name = "Circonscription")
    private String circonscription;

    /**
     * Le secteur
     */
    @XmlAttribute(name = "Secteur")
    private String secteur;

    /**
     * Le code du departement
     */
    @XmlAttribute(name = "DepartmentCode")
    private String departmentCode;

    /**
     * Le code de la municipalité
     */
    @XmlAttribute(name = "MunicipalityCode")
    private String municipalityCode;

    /**
     * Le code de la place
     */
    @XmlAttribute(name = "PlaceCode")
    private String placeCode;

    /**
     * Numéro de téléphone du secteur
     */
    @XmlAttribute(name = "SectorTel")
    private String sectorTel;

    @XmlElement(name = "PortalExtAddress", namespace = "http://www.infodb.fr/solis/portail/extsocial")
    private PortalSocialExtAddress portalExtAddress;

    public String getAdditionnalRecipient() {
        return additionnalRecipient;
    }

    public void setAdditionnalRecipient(String additionnalRecipient) {
        this.additionnalRecipient = additionnalRecipient;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAdditionnalPlace() {
        return additionnalPlace;
    }

    public void setAdditionnalPlace(String additionnalPlace) {
        this.additionnalPlace = additionnalPlace;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getTerritoryUnit() {
        return territoryUnit;
    }

    public void setTerritoryUnit(String territoryUnit) {
        this.territoryUnit = territoryUnit;
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


    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public PortalSocialExtAddress getPortalExtAddress() {
        return portalExtAddress;
    }

    public void setPortalExtAddress(PortalSocialExtAddress portalExtAddress) {
        this.portalExtAddress = portalExtAddress;
    }

	public String getSectorTel() {
		return sectorTel;
	}

	public void setSectorTel(String sectorTel) {
		this.sectorTel = sectorTel;
	}

}
