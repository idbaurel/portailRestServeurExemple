package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 17:16
 *
 * Représente un dossier social
 *
 */
@XmlRootElement(name = "SocialFile", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtFile {
    @XmlElement(name = "SocialFileAddress")
    private SocialExtAddress socialFileAddress;
    @XmlElement(name = "MailAddress")
    private SocialExtAddress mailAddress;
    @XmlElement(name = "HomeAddress")
    private SocialExtAddress homeAddress;

    @XmlElement(name = "IndividualsConcerned")
    private Set<SocialExtConcerned> individualsConcerned = new HashSet<SocialExtConcerned>();
    @XmlElement(name = "Measures")
    private Set<SocialExtMeasure> measures = new HashSet<SocialExtMeasure>();
    @XmlElement(name = "SocialWorkers")
    private Set<SocialExtWorker> socialWorkers = new HashSet<SocialExtWorker>();

    public SocialExtAddress getSocialFileAddress() {
        return socialFileAddress;
    }

    public void setSocialFileAddress(SocialExtAddress socialFileAddress) {
        this.socialFileAddress = socialFileAddress;
    }

    public SocialExtAddress getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(SocialExtAddress mailAddress) {
        this.mailAddress = mailAddress;
    }

    public SocialExtAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(SocialExtAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<SocialExtConcerned> getIndividualsConcerned() {
        return individualsConcerned;
    }

    public void setIndividualsConcerned(Set<SocialExtConcerned> individualsConcerned) {
        this.individualsConcerned = individualsConcerned;
    }

    public Set<SocialExtMeasure> getMeasures() {
        return measures;
    }

    public void setMeasures(Set<SocialExtMeasure> measures) {
        this.measures = measures;
    }

    public Set<SocialExtWorker> getSocialWorkers() {
        return socialWorkers;
    }

    public void setSocialWorkers(Set<SocialExtWorker> socialWorkers) {
        this.socialWorkers = socialWorkers;
    }
}
