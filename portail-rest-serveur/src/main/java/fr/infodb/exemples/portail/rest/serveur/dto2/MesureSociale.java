package fr.infodb.exemples.portail.rest.serveur.dto2;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtMeasureState;
import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtNature;

import java.io.Serializable;
import java.util.Date;

/**
 * @author aurelien
 * créé le 14/02/18.
 */
public class MesureSociale implements Serializable{

    private String index;
    private String libelle;
    private Date dateDebut;
    private Date dateFin;
    private String libelleDateDebut;
    private String libelleDateFin;

    private SocialExtMeasureState statut = SocialExtMeasureState.UNKNOWN;
//    private SocialExtNature nature;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getLibelleDateDebut() {
        return libelleDateDebut;
    }

    public void setLibelleDateDebut(String libelleDateDebut) {
        this.libelleDateDebut = libelleDateDebut;
    }

    public String getLibelleDateFin() {
        return libelleDateFin;
    }

    public void setLibelleDateFin(String libelleDateFin) {
        this.libelleDateFin = libelleDateFin;
    }

    public SocialExtMeasureState getStatut() {
        return statut;
    }

    public void setStatut(SocialExtMeasureState statut) {
        this.statut = statut;
    }
}
