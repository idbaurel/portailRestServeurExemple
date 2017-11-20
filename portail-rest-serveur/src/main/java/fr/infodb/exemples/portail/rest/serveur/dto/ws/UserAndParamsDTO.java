package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtUser;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Map;

/**
 * DTO contenant un User et des paramètes sous forme de HashMap.
 *
 * @author asi
 */
@XmlRootElement(name = "UserAndParams", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso(SocialExtUser.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAndParamsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "User")
    private SocialExtUser user;
    @XmlElement(name = "Params")

    private Map<String, String> params;

    public SocialExtUser getUser() {
        return user;
    }

    public void setUser(SocialExtUser user) {
        this.user = user;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
