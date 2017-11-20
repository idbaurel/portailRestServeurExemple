package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 08/01/13
 * Time: 11:51
 *
 * Représente une nature de mesure pour un module (regroupement de mesure
 *
 */
@XmlRootElement(name = "NatureReferential", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtNatureReferential {

    @XmlElement(name = "Item")
    private Set<SocialExtNature> natures;

    public Set<SocialExtNature> getNatures() {
        return natures;
    }

    public void setNatures(Set<SocialExtNature> natures) {
        this.natures = natures;
    }
}
