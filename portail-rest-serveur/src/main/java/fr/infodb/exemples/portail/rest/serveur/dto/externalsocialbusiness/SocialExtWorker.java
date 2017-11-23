package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 19/12/12
 * Time: 16:54
 *
 * Représente un intervenant social d'un SI social
 *
 */
@XmlRootElement(name = "SocialWorker", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtWorker {

    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "FirstName")
    private String firstName;

    @XmlAttribute(name = "LastName")
    private String lastName;

    @XmlElement(name = "Comment")
    private String comment;

    @XmlElement(name = "Sector")
    private String sector;

    @XmlElement(name = "SectorList")
    private ArrayList<String> sectorList;

    @XmlElement(name = "Users")
    private final Set<SocialExtUser> users = new HashSet<SocialExtUser>();

    @XmlElement(name = "Telephone")
    private String telephone;

    @XmlElement(name = "Mail")
    private String mail;

    //fixme: la récursivité sur SocialExtRendezVous.socialWorkers fait planter swagger
//    @XmlElement(name = "RendezVous")
//    private final Set<SocialExtRendezVous> rendezVous = new HashSet<>();

    @XmlElement(name = "PortalExtWorker", namespace = "http://www.infodb.fr/solis/portail/extsocial")
    private PortalSocialExtWorker portalExtWorker;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }

    public Set<SocialExtUser> getUsers() {
        return users;
    }

//    public void setUsers(Set<SocialExtUser> users) {
//        this.users = users;
//    }

    public PortalSocialExtWorker getPortalExtWorker() {
        return portalExtWorker;
    }

    public void setPortalExtWorker(PortalSocialExtWorker portalExtWorker) {
        this.portalExtWorker = portalExtWorker;
    }

//    public Set<SocialExtRendezVous> getRendezVous() {
//        return rendezVous;
//    }

//    public void setRendezVous(Set<SocialExtRendezVous> rendezVous) {
//        this.rendezVous = rendezVous;
//    }

	public ArrayList<String> getSectorList() {
		return sectorList;
	}

	public void setSectorList(ArrayList<String> sectorList) {
		this.sectorList = sectorList;
	}

    public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


}
