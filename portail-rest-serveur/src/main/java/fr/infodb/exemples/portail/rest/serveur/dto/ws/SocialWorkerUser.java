package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtUser ;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 27/03/13
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "User", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialWorkerUser extends SocialExtUser implements Serializable {

	private static final long serialVersionUID = 1L;

    public SocialWorkerUser() {
    	super();
    }

    public SocialWorkerUser(String login, String socialWorkerId) {
        super(login);
        setSocialWorkerId(socialWorkerId);
    }

}
