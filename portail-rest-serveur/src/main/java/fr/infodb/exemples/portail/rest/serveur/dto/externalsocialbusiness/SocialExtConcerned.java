package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 17:06
 *
 * Représente les individus concernés par un dossier
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtConcerned extends SocialExtIndividual {
    @XmlAttribute(name = "LinkType")
    private String linkType;

    @XmlTransient
    private Set<SocialExtMeasure> measures = new HashSet<SocialExtMeasure>();

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public Set<SocialExtMeasure> getMeasures() {
        return measures;
    }

    public void setMeasures(Set<SocialExtMeasure> measures) {
        this.measures = measures;
    }
}
