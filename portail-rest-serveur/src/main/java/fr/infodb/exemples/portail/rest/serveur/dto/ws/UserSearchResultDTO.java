package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.SocialExtUser;

/**
 * Représente les résultats d'une recherche d'individus.
 * @author asi
 *
 */
@XmlRootElement(name = "UserSearchResult", namespace = "http://www.infodb.fr/portail/rest")
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlSeeAlso({ SocialExtUser.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSearchResultDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Liste des users, préserve l'ordre. */
	private List<SocialExtUser> users = new ArrayList<SocialExtUser>();
	
	/** Nombre total d'éléments correspondant à la recherche. */
	private int totalNumber = -1;
	
	/** Taille de la 'page' retournée (= nombre d'éléments dans la liste). */
	private int pageSize = -1;
	/** Numéro de la page retournée (page 1, page 2, etc.). */
	private int pageNumber = -1;
	
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public List<SocialExtUser> getUsers() {
		return users;
	}
	public void setUsers(List<SocialExtUser> users) {
		this.users = users;
	}
}