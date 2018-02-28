package fr.infodb.exemples.portail.rest.serveur.dto.constants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 03/04/13
 * Time: 09:16
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public enum SocialExtMeasureState {
    IN_PROGRESS, UNKNOWN;
}
