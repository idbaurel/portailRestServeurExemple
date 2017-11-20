package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.io.Serializable;

/**
 * Représente l'agrégation d'un type de lien de débranchement SOLIS et d'un token d'authentification.  
 *
 * @author ASI
 */
public class LinkTypeAndTokenDTO implements Serializable {

	/** Version de sérialisation de la classe */
	private static final long serialVersionUID = 1L;
	
	/** Type du lien de débranchement SOLIS */
	private String linkType;
	
	/** Token d'authentification */
	private String token;

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
