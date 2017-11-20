package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 21/03/13
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
public enum SocialMeasureNatureType {
    FAMILY("dossier"), INDIVIDUAL
    , FILLE("dossier-fille"), FILLE_AUTRE_LIEN("dossier-fille-autre-lien"), FILLE_HORS_FOYER("dossier-fille-hors-foyer")
    , GARCON("dossier-garcon"), GARCON_AUTRE_LIEN("dossier-garcon-autre-lien"), GARCON_HORS_FOYER("dossier-garcon-hors-foyer")
    , HOMME("dossier-homme"), HOMME_AUTRE_LIEN("dossier-homme-autre-lien"), HOMME_HORS_FOYER("dossier-homme-hors-foyer")
    , FEMME("dossier-femme"), FEMME_AUTRE_LIEN("dossier-femme-autre-lien"), FEMME_HORS_FOYER("dossier-femme-hors-foyer");

    SocialMeasureNatureType() {
        this.cssClass = null;
    }

    SocialMeasureNatureType(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getCssClass() {
        return cssClass;
    }

    private final String cssClass;
}
