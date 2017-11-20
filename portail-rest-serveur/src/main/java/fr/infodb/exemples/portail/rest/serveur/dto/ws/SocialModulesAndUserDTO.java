package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtUser;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement(name = "SocialModulesAndUser", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso(SocialExtUser.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialModulesAndUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "Modules")
    private Set<SocialModule> modules;

    @XmlElement(name = "User")
    private SocialExtUser user;

    /**
     * Token d'authentification à SOLIS
     */
    @XmlElement(name = "Token")
    private String token;

    public Set<SocialModule> getModules() {
        return modules;
    }

    public void setModules(Set<SocialModule> modules) {
        this.modules = modules;
    }

    public SocialExtUser getUser() {
        return user;
    }

    public void setUser(SocialExtUser user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
