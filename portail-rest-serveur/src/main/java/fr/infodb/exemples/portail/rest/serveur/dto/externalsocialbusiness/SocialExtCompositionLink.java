package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 03/04/13
 * Time: 09:19
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlEnum
public enum SocialExtCompositionLink {
    IN_FILE, IN_RELATION_WITH_FILE, OUTSIDE_FILE, UNKNOWN;
}
