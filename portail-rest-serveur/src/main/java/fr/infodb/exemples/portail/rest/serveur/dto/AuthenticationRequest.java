package fr.infodb.exemples.portail.rest.serveur.dto;

import java.io.Serializable;

/**
 * @author aurelien
 * créé le 31/01/18.
 */
public class AuthenticationRequest implements Serializable {

    private String login;
    private String password;

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
