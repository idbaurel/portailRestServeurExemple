package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Message a afficher sur la page d'autentification
 *
 * @author Jerome Catric
 *
 */
@XmlRootElement(name = "LoginHomepageMessage", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginHomepageMessage {

	/**
	 * Le message
	 */
	@XmlAttribute(name = "Message")
	private String message;

	/**
	 * Le type de message
	 */
	@XmlAttribute(name = "Type")
	private TypeLoginHomepageMessageEnum type;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TypeLoginHomepageMessageEnum getType() {
		return type;
	}

	public void setType(TypeLoginHomepageMessageEnum type) {
		this.type = type;
	}

}
