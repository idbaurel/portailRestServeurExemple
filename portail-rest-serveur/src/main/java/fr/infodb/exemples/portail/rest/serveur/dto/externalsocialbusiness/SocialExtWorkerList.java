package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author thomas.limin
 *
 */
@XmlRootElement(name = "SocialWorkerList", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtWorkerList {
    @XmlElement(name = "SocialWorker")
    private List<SocialExtWorker> socialExtWorkerList = new ArrayList<SocialExtWorker>();

    public List<SocialExtWorker> getSocialExtWorkerList() {
        return socialExtWorkerList;
    }

    public void setSocialExtWorkerList(List<SocialExtWorker> newsList) {
        this.socialExtWorkerList = newsList;
    }
}
