package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * DTO contenant un SocialModule, un ModuleIdentifierType et son external id
 *
 * @author asi
 */
@XmlRootElement(name = "SocialModuleAndExtId", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso({SocialModule.class, ModuleIdentifierType.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialModuleAndExtIdDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "SocialModule")
    private SocialModule module;

    @XmlElement(name = "ExternalId")
    private String externalId;

    @XmlElement(name = "ModuleIdentifierType")
    private ModuleIdentifierType moduleIdentifierType;

    public SocialModule getModule() {
        return module;
    }

    public void setModule(SocialModule module) {
        this.module = module;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public ModuleIdentifierType getModuleIdentifierType() {
        return moduleIdentifierType;
    }

    public void setModuleIdentifierType(ModuleIdentifierType moduleIdentifierType) {
        this.moduleIdentifierType = moduleIdentifierType;
    }
}
