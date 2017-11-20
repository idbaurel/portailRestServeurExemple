package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtUser;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "UserAndReferential", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso({SocialExtUser.class, Referential.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAndReferentialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "User")
    private SocialExtUser user;
    @XmlElement(name = "Referential")
    private Referential referential;

    public SocialExtUser getUser() {
        return user;
    }

    public void setUser(SocialExtUser user) {
        this.user = user;
    }

    public Referential getReferential() {
        return referential;
    }

    public void setReferential(Referential referential) {
        this.referential = referential;
    }
}
