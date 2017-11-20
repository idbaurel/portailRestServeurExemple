package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 17:02
 *
 * Représente une mesure sociale
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtMeasure {
    @XmlAttribute(name = "Index")
    private String index;
    @XmlAttribute(name = "Name")
    private String name;
    @XmlAttribute(name = "BeginDate")
    private Date beginDate;
    @XmlAttribute(name = "EndDate")
    private Date endDate;
    @XmlAttribute(name = "BeginDateLabel", required = false)
    private String beginDateLabel;
    @XmlAttribute(name = "EndDateLabel", required = false)
    private String endDateLabel;

    @XmlAttribute(name = "State")
    private SocialExtMeasureState state = SocialExtMeasureState.UNKNOWN;

    @XmlElement(name = "Nature")
    private SocialExtNature nature;
    @XmlElement(name = "Beneficiary")
    private SocialExtBeneficiary beneficiary;
    @XmlElement(name = "IndividualsConcerned")
    private Set<SocialExtBeneficiary> individualsConcerned = new HashSet<SocialExtBeneficiary>();
    @XmlTransient
    private boolean hidden;
    
    /** Indique si la date de fin a été calculée ou si elle est issue de la source de données */
    @XmlTransient
    private boolean endDateComputed;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SocialExtNature getNature() {
        return nature;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBeginDateLabel() {
        return beginDateLabel;
    }

    public void setBeginDateLabel(String beginDateLabel) {
        this.beginDateLabel = beginDateLabel;
    }

    public String getEndDateLabel() {
        return endDateLabel;
    }

    public void setEndDateLabel(String endDateLabel) {
        this.endDateLabel = endDateLabel;
    }

    public SocialExtMeasureState getState() {
        return state;
    }

    public void setState(SocialExtMeasureState state) {
        this.state = state;
    }

    public void setNature(SocialExtNature nature) {
        this.nature = nature;
    }

    public SocialExtBeneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(SocialExtBeneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Set<SocialExtBeneficiary> getIndividualsConcerned() {
        return individualsConcerned;
    }

    public void setIndividualsConcerned(Set<SocialExtBeneficiary> individualsConcerned) {
        this.individualsConcerned = individualsConcerned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialExtMeasure measure = (SocialExtMeasure) o;

        if (beginDate != null ? !beginDate.equals(measure.beginDate) : measure.beginDate != null) return false;
        if (beneficiary != null ? !beneficiary.equals(measure.beneficiary) : measure.beneficiary != null) return false;
        if (endDate != null ? !endDate.equals(measure.endDate) : measure.endDate != null) return false;
        if (name != null ? !name.equals(measure.name) : measure.name != null) return false;
        if (nature != null ? !nature.equals(measure.nature) : measure.nature != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (nature != null ? nature.hashCode() : 0);
        result = 31 * result + (beneficiary != null ? beneficiary.hashCode() : 0);
        return result;
    }


    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

	public boolean isEndDateComputed() {
		return endDateComputed;
	}

	public void setEndDateComputed(boolean endDateComputed) {
		this.endDateComputed = endDateComputed;
	}
    
}
