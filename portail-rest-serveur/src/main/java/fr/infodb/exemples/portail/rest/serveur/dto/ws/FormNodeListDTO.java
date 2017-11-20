package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "FormNodeList", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso(FormNodeFieldDTO.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class FormNodeListDTO extends FormNodeDTO {

	private static final long serialVersionUID = 1L;


	@XmlElements({
		@XmlElement(type=FormNodeListDTO.class, name="ListNode"),
		@XmlElement(type=FormNodeFieldDTO.class, name="FieldNode")
	})
	@XmlElement(name = "Nodes")
	private List<FormNodeDTO> nodes = new ArrayList<FormNodeDTO>();

	public List<FormNodeDTO> getNodes() {
		return nodes;
	}

	public void setNodes(List<FormNodeDTO> nodes) {
		this.nodes = nodes;
	}
	
	
}
