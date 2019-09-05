package fr.infodb.exemples.portail.rest.serveur.dto.authorization;

import java.io.Serializable;

/**
 * @author aurelien
 * créé le 02/07/18.
 */
public class CD64Permissions implements Serializable {

    private String id;

    private int version;

    private String menu;

    private String sousMenu;

    private String nomModule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getSousMenu() {
        return sousMenu;
    }

    public void setSousMenu(String sousMenu) {
        this.sousMenu = sousMenu;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }
}
