package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * Représente un critère de recherche d'un individu.
 * @author asi
 *
 */
@XmlRootElement(name = "SearchCriterion", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchCriterionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "Value")
	private Object value;
	@XmlElement(name = "ValueClass")
	private Class<?> criterionValueClass;
	@XmlElement(name = "Type")
	private String criterionType;
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Class<?> getCriterionValueClass() {
		return criterionValueClass;
	}
	public void setCriterionValueClass(Class<?> criterionValueClass) {
		this.criterionValueClass = criterionValueClass;
	}
	public String getCriterionType() {
		return criterionType;
	}
	public void setCriterionType(String criterionType) {
		this.criterionType = criterionType;
	}
	
	
}
