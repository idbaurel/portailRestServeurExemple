package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 10:24
 * <p>
 * Représentation d'un environnement pointant vers un SI Social (services métiers de l'application social)
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class Environment extends EnvironmentConfig {

    @XmlTransient
    private SPIDescription SPIDescription;

    public Environment() {
    }

    public Environment(String id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Environment)) {
            return false;
        }

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public SPIDescription getSPIDescription() {
        return SPIDescription;
    }

    public void setSPIDescription(SPIDescription SPIDescription) {
        this.SPIDescription = SPIDescription;
    }
}
