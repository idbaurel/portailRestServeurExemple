package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 08/01/13
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocial")
@XmlAccessorType(XmlAccessType.FIELD)
public class PortalSocialExtAddress {

    @XmlAttribute(name = "IdExt")
    private String idExt;

    public String getIdExt() {
        return idExt;
    }

    public void setIdExt(String idExt) {
        this.idExt = idExt;
    }
}
