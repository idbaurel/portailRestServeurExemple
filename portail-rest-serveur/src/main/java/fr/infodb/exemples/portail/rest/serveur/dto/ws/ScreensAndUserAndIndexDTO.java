package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtUser;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement(name = "ScreensAndUsers", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso({SocialModuleScreen.class, SocialExtUser.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class ScreensAndUserAndIndexDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "Screens")
    Set<SocialModuleScreen> screens;

    @XmlElement(name = "User")
    private SocialExtUser user;

    @XmlElement(name = "Index")
    private String indexIndividual;

    /**
     * Token d'authentification à SOLIS
     */
    @XmlElement(name = "Token")
    private String token;

    public Set<SocialModuleScreen> getScreens() {
        return screens;
    }

    public void setScreens(Set<SocialModuleScreen> screens) {
        this.screens = screens;
    }

    public SocialExtUser getUser() {
        return user;
    }

    public void setUser(SocialExtUser user) {
        this.user = user;
    }

    public String getIndexIndividual() {
        return indexIndividual;
    }

    public void setIndexIndividual(String indexIndividual) {
        this.indexIndividual = indexIndividual;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
