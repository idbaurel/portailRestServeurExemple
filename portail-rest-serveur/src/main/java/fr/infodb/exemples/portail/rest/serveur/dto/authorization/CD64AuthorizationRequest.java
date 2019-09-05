package fr.infodb.exemples.portail.rest.serveur.dto.authorization;

import java.io.Serializable;

/**
 * @author aurelien
 * créé le 27/06/18.
 */
public class CD64AuthorizationRequest implements Serializable {

    private String login;
    private String password;

    public CD64AuthorizationRequest() {
    }

    public CD64AuthorizationRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
