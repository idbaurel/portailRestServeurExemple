package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;


import fr.infodb.exemples.portail.rest.serveur.dto.ws.Environment;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 10:24
 *
 * Association entre un individu du portail et un individu connu d'un SI social
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocial")
@XmlAccessorType(XmlAccessType.FIELD)
public class PortalSocialExtIndividual {
    @XmlAttribute(name = "IdExt")
    private String idExt;
    @XmlTransient
    private Environment environment;

    public String getIdExt() {
        return idExt;
    }

    public void setIdExt(String idExt) {
        this.idExt = idExt;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortalSocialExtIndividual that = (PortalSocialExtIndividual) o;

        if (idExt != null ? !idExt.equals(that.idExt) : that.idExt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idExt != null ? idExt.hashCode() : 0;
    }
}
