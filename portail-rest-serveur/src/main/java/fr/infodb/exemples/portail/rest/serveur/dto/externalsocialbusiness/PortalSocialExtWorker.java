package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;


import fr.infodb.exemples.portail.rest.serveur.dto.ws.Environment;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 10:24
 *
 * Association entre un travailleur social du portail et un travailleur social connu d'un SI social
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocial")
@XmlAccessorType(XmlAccessType.FIELD)
public class PortalSocialExtWorker {
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
}
