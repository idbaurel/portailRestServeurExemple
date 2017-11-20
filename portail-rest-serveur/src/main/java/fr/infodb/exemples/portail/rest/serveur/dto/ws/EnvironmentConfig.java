package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.*;

/**
 * Describe an external social environment.
 *
 * @author thomas.limin
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvironmentConfig {

    @XmlElement(name = "Id", required = true)
    private String id;
    @XmlElement(name = "Name", required = true)
    private String name;

    @XmlElement(name = "Description")
    private String description;

    @XmlAttribute(name = "ApplicationUrl")
    private String applicationUrl;

    public EnvironmentConfig(String id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public EnvironmentConfig() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof EnvironmentConfig)) {
            return false;
        }
        EnvironmentConfig other = (EnvironmentConfig) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
