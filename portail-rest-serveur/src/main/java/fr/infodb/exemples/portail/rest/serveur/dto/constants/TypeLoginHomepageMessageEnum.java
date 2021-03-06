package fr.infodb.exemples.portail.rest.serveur.dto.constants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Enumération permettant d'indiquer le type du message affiché sur la page d'authentification
 *
 * @author Jerome Catric
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public enum TypeLoginHomepageMessageEnum implements Serializable{
	INFO, WARNING;
}
