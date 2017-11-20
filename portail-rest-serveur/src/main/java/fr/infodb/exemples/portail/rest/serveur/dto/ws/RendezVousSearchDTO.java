package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtUser;

/**
 * Dto représentant les critères de recherche pour un rendez-vous.
 * @author asi
 *
 */
@XmlRootElement(name = "RdvSearchCriteria", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso({SocialExtUser.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class RendezVousSearchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Le user propriétaire du rendez-vous. */
	@XmlElement(name="User")
	private SocialExtUser user;
	/** Un external id : ??? TODO */
	@XmlElement(name="ExternalId")
	private String externalId;
	/** La date de début de recherche. */
	@XmlElement(name="StartDate")
	private Date startDate;
	/** La date de fin de recherche. */
	@XmlElement(name="EndDate")
	private Date endDate;
	
	public SocialExtUser getUser() {
		return user;
	}
	public void setUser(SocialExtUser user) {
		this.user = user;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
