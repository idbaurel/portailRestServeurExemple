package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * DTO représentant la structure d'un formulaire.
 * 
 * @author asi
 *
 */
@XmlRootElement(name = "Form", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso({ SocialWorkerUser.class, FormNodeListDTO.class, FormNodeDTO.class, FormNodeFieldDTO.class })
@XmlAccessorType(XmlAccessType.FIELD)
public class FormDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "User")
	private SocialWorkerUser user;
	@XmlElement(name = "FormName")
	private String formName;
	@XmlElement(name = "FormNodeList")
	private FormNodeListDTO formNodeList;

	public SocialWorkerUser getUser() {
		return user;
	}

	public void setUser(SocialWorkerUser user) {
		this.user = user;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public FormNodeListDTO getFormNodeList() {
		return formNodeList;
	}

	public void setFormNodeList(FormNodeListDTO formNodeList) {
		this.formNodeList = formNodeList;
	}
}
