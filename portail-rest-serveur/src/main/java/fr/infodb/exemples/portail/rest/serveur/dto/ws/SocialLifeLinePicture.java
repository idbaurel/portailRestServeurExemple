package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 11/02/13
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
public enum SocialLifeLinePicture {
    MALE, FEMALE, YOUNG_MALE, YOUNG_FEMALE, SEVERAL;
}
