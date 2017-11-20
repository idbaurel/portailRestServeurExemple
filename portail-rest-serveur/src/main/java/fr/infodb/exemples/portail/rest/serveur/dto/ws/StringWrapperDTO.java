package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Wrapper pour une String (sinon la sérialisation d'une String simple en JSON pose problème aux parsers)
 * @author asi
 *
 */
@XmlRootElement(name = "StringWrapper", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlAccessorType(XmlAccessType.FIELD)
public class StringWrapperDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "String")
	private String string;

	public StringWrapperDTO() {
		this(null);
	}
	public StringWrapperDTO(String s) {
		this.string = s;
	}
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

    @Override
    public String toString() {
        return string;
    }
}
