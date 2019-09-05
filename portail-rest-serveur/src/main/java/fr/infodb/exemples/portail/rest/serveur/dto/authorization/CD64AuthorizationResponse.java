package fr.infodb.exemples.portail.rest.serveur.dto.authorization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author aurelien
 * créé le 27/06/18.
 */
public class CD64AuthorizationResponse implements Serializable {

    private String id;
    private String login;
    private String token;
    private String nom;
    private String prenom;
    private List<Long> roles = new ArrayList<>();
    private Map<String, List<CD64Permissions>> modules;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

    public Map<String, List<CD64Permissions>> getModules() {
        return modules;
    }

    public void setModules(Map<String, List<CD64Permissions>> modules) {
        this.modules = modules;
    }
}
