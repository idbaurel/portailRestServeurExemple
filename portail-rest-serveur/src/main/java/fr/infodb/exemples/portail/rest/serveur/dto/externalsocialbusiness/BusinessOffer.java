package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Structure d'une offre de service
 *
 * @author Jerome Catric
 *
 */
@XmlRootElement(name = "BusinessOffer", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class BusinessOffer implements Comparable<BusinessOffer> {

	@XmlAttribute(name = "OfferStatus")
	private String offerStatus;

	@XmlAttribute(name = "OfferLabel")
	private String offerLabel;

	@XmlAttribute(name = "OfferDate")
	private Date offerDate;

	@XmlAttribute(name = "OfferLabelDate")
	private String offerLabelDate;

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getOfferLabel() {
		return offerLabel;
	}

	public void setOfferLabel(String offerLabel) {
		this.offerLabel = offerLabel;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	public String getOfferLabelDate() {
		return offerLabelDate;
	}

	public void setOfferLabelDate(String offerLabelDate) {
		this.offerLabelDate = offerLabelDate;
	}

	@Override
	public int compareTo(BusinessOffer otherOffer) {
		if (otherOffer == null || otherOffer.getOfferDate() == null) {
			return 1;
		} else if (getOfferDate() == null) {
			return -1;
		} else if (getOfferDate().getTime() == otherOffer.getOfferDate().getTime()) {
			return 0;
		} else if (getOfferDate().getTime() < otherOffer.getOfferDate().getTime()) {
			return -1;
		} else { // if (getOfferDate().getTime() > otherOffer.getOfferDate().getTime()) {
			return 1;
		}
	}

}
