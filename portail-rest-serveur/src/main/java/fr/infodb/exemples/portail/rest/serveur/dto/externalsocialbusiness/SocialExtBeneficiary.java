package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 17:06
 *
 * Représente un bénéficiaire de l'action sociale.
 *
 */
@XmlRootElement(name = "Beneficiary", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtBeneficiary extends SocialExtIndividual implements Serializable {

	private static final long serialVersionUID = 1L;

	public SocialExtBeneficiary() {

		super();
	}

    @XmlTransient
    private Set<SocialExtMeasure> measures = new HashSet<SocialExtMeasure>();
    @XmlElement(name = "RendezVous")
    private Set<SocialExtRendezVous> rendezVous = new HashSet<SocialExtRendezVous>();
    @XmlTransient
    private Set<SocialExtWorker> socialWorkers = new HashSet<SocialExtWorker>();


    public Set<SocialExtMeasure> getMeasures() {
        return measures;
    }

    public void setMeasures(Set<SocialExtMeasure> measures) {
        this.measures = measures;
    }

    public Set<SocialExtRendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(Set<SocialExtRendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Set<SocialExtWorker> getSocialWorkers() {
        return socialWorkers;
    }

    public void setSocialWorkers(Set<SocialExtWorker> socialWorkers) {
        this.socialWorkers = socialWorkers;
    }
}
