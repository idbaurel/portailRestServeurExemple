package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;


import fr.infodb.exemples.portail.rest.serveur.dto.ws.SocialWorkerUser;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 26/09/12
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "User", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(SocialWorkerUser.class)
public class SocialExtUser implements Serializable {

    private static final long serialVersionUID = -4673828568465652436L;

    @XmlAttribute(name = "Id", required = true)
    private String id;

    @XmlAttribute(name = "UserName", required = true)
    private String username;

    @XmlAttribute(name = "FirstName")
    private String firstName;

    @XmlAttribute(name = "LastName")
    private String lastName;

    /**
     * Secteur de IS associé à l'utilisateur
     */
    @XmlAttribute(name = "Sector")
    private String sector;

    /**
     * Liste des secteurs de l'utilisateur
     */
    private ArrayList<String> sectorList;

    @XmlAttribute(name = "LinkedWithSocialWorker")
    private boolean linkedWithSocialWorker;

    /**
     * Identifiant externe de l'IS associé à l'utilisateur
     */
    @XmlAttribute(name = "SocialWorkerId")
    private String socialWorkerId;


    public SocialExtUser() {
    }

    public SocialExtUser(String login) {
        this.username = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public boolean isLinkedWithSocialWorker() {
        return linkedWithSocialWorker;
    }

    public void setLinkedWithSocialWorker(boolean linkedWithSocialWorker) {
        this.linkedWithSocialWorker = linkedWithSocialWorker;
    }

    public String getSocialWorkerId() {
        return socialWorkerId;
    }

    public void setSocialWorkerId(String socialWorkerId) {
        this.socialWorkerId = socialWorkerId;
    }

    public ArrayList<String> getSectorList() {
        return sectorList;
    }

    public void setSectorList(ArrayList<String> sectorList) {
        this.sectorList = sectorList;
    }

    @Override
    public String toString() {
        return "SocialExtUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sector='" + sector + '\'' +
                ", linkedWithSocialWorker=" + linkedWithSocialWorker +
                ", socialWorkerId='" + socialWorkerId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SocialExtUser user = (SocialExtUser) o;

        if (id != null ? !id.equals(user.id) : user.id != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
