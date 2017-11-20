package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "FormNodeField", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlAccessorType(XmlAccessType.FIELD)
public class FormNodeFieldDTO extends FormNodeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "Value")
	private Object value;

	public FormNodeFieldDTO() {
		this(null, null);
	}
	public FormNodeFieldDTO(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
