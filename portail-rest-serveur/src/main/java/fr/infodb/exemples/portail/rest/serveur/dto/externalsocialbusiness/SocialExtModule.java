package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;



import fr.infodb.exemples.portail.rest.serveur.dto.ws.Environment;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.SocialModule;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 16:57
 *
 * Représente le module (application mdph, fsl, ...) social
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtModule {
    @XmlAttribute(name = "Name")
    private SocialModule name;
    @XmlTransient
    private String picto;

    @XmlTransient
    private Environment environment;

    public SocialModule getName() {
        return name;
    }

    public void setName(SocialModule name) {
        this.name = name;
    }

    public String getPicto() {
        return picto;
    }

    public void setPicto(String picto) {
        this.picto = picto;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
