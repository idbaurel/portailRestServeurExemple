package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtUser;

@XmlRootElement(name = "UserAndIndex", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso(SocialExtUser.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAndIndexDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "User")
	private SocialExtUser user;
	@XmlElement(name = "Index")
	private String index;
	
	public SocialExtUser getUser() {
		return user;
	}
	public void setUser(SocialExtUser user) {
		this.user = user;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}

}
