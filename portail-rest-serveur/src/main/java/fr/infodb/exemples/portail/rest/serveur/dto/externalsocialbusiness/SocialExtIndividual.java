package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;



import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 16:54
 *
 * Représente un individual d'un SI social
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class SocialExtIndividual {
    @XmlElement(name = "SocialFile")
    private SocialExtFile socialFile;
    @XmlAttribute(name = "CompositionLink")
    private SocialExtCompositionLink compositionLink = SocialExtCompositionLink.UNKNOWN;
    @XmlAttribute(name = "Title")
    private String title;
    @XmlAttribute(name = "FirstName")
    private String firstName;
    @XmlAttribute(name = "LastName")
    private String lastName;
    @XmlAttribute(name = "BirthName")
    private String birthName;
    @XmlAttribute(name = "BirthDate")
    private Date birthDate;
    @XmlAttribute(name = "Caf")
    private String caf;
    @XmlAttribute(name = "Major")
    private Boolean major = true;
    @XmlAttribute(name = "Deceased")
    private boolean deceased;
    @XmlAttribute(name = "DeceasedDate")
    private Date deceasedDate;
    @XmlAttribute(name = "AdditionnalData")
    private String additionnalData;
    @XmlAttribute(name = "Tel")
    private String tel;
    @XmlAttribute(name = "Mobile")
    private String mobile;
    @XmlAttribute(name = "Email")
    private String email;
    @XmlAttribute(name = "TelTravail")
    private String telTravail;
	@XmlAttribute(name = "secteurDossier")
    private String secteurDossier;
	@XmlAttribute(name = "secteurSuivi")
    private String secteurSuivi;

	@XmlElement(name = "PortalExtIndividual", namespace = "http://www.infodb.fr/solis/portail/extsocial")
    private PortalSocialExtIndividual portalExtIndividual;

    public SocialExtFile getSocialFile() {
        return socialFile;
    }

    public void setSocialFile(SocialExtFile socialFile) {
        this.socialFile = socialFile;
    }

    public String getTelTravail() {
		return telTravail;
	}

	public void setTelTravail(String telTravail) {
		this.telTravail = telTravail;
	}

    public String getSecteur() {
		return secteurDossier;
	}

	public void setSecteur(String secteur) {
		this.secteurDossier = secteur;
	}

    public String getSecteurSuivi() {
		return secteurSuivi;
	}

	public void setSecteurSuivi(String secteur) {
		this.secteurSuivi = secteur;
	}


    public SocialExtCompositionLink getCompositionLink() {
        return compositionLink;
    }

    public void setCompositionLink(SocialExtCompositionLink compositionLink) {
        this.compositionLink = compositionLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCaf() {
        return caf;
    }

    public void setCaf(String caf) {
        this.caf = caf;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }

    public Date getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(Date deceasedDate) {
        this.deceasedDate = deceasedDate;
    }

    public String getAdditionnalData() {
        return additionnalData;
    }

    public void setAdditionnalData(String additionnalData) {
        this.additionnalData = additionnalData;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PortalSocialExtIndividual getPortalExtIndividual() {
        return portalExtIndividual;
    }

    public void setPortalExtIndividual(PortalSocialExtIndividual portalExtIndividual) {
        this.portalExtIndividual = portalExtIndividual;
    }

    public Boolean getMajor() {
        return major;
    }

    public void setMajor(Boolean major) {
        this.major = major;
    }

	@Override
    public boolean equals(Object o) {
        if (this == o) {
			return true;
		}
        if (o == null || getClass() != o.getClass()) {
			return false;
		}

        SocialExtIndividual that = (SocialExtIndividual) o;

        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) {
			return false;
		}
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) {
			return false;
		}
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) {
			return false;
		}
        if (portalExtIndividual != null ? !portalExtIndividual.equals(that.portalExtIndividual) : that.portalExtIndividual != null) {
			return false;
		}

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (portalExtIndividual != null ? portalExtIndividual.hashCode() : 0);
        return result;
    }
}
