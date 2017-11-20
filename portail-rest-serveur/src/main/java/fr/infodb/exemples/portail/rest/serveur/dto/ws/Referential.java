package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 06/03/13
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/referential")
@XmlAccessorType(XmlAccessType.FIELD)
public enum Referential {
    CIRCO("circonscription"),
    DOMAIN("domaine"),
    THEME("sous_domaine"),
    ACTE("nature_acte_prof"),
    SPECIFIC("specifique"),
    PROBLEMATIC("problematique"),
    FAMILY("famille_acte_prof"),
    ORIGINE("demandeur");

    /**
     * prefixe des données contenu dans les onglets
     */
    private String prefix;

    private Referential(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Récupère le prefix des données contenu dans les onglets
     *
     * @return le prefix des données contenu dans les onglets
     */
    public String getPrefix() {
        return prefix;
    }
}
