package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 26/09/12
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "UserList", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtUserList {

    @XmlElement(name = "User")
    private List<SocialExtUser> users;

    public SocialExtUserList() {
    }

    public List<SocialExtUser> getUsers() {
        return users;
    }

    public void setUsers(List<SocialExtUser> users) {
        this.users = users;
    }
}
