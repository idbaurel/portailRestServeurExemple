package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Describe an external social environment.
 * @author thomas.limin
 *
 */
@XmlRootElement(name = "SPIDescription", namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
final public class SPIDescription {

    @XmlElement(name = "Id", required = true)
    private String id;

    @XmlElement(name = "SPIConfig")
    private SPIConfig spiConfig;

    @XmlElement(name = "ModuleDescription")
    private Set<SocialModuleDesc> moduleDescs = new HashSet<SocialModuleDesc>();

    @XmlElement(name = "Environment")
    private Set<Environment> environments = new HashSet<Environment>();

	public SPIDescription() {

	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SPIConfig getSpiConfig() {
        return spiConfig;
    }

    public void setSpiConfig(SPIConfig spiConfig) {
        this.spiConfig = spiConfig;
    }

    public Set<SocialModuleDesc> getModuleDescs() {
        return moduleDescs;
    }

    public void setModuleDescs(Set<SocialModuleDesc> moduleDescs) {
        this.moduleDescs = moduleDescs;
    }

    public Set<Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Set<Environment> environments) {
        this.environments = environments;
    }

    public boolean hasModule(SocialModule module) {
        boolean result = false;
        Iterator<SocialModuleDesc> configs = this.getModuleDescs().iterator();
        while(!result && configs.hasNext()) {
            SocialModuleDesc config = configs.next();
            result = config.getModule() == module;
        }
        return result;
    }
}
