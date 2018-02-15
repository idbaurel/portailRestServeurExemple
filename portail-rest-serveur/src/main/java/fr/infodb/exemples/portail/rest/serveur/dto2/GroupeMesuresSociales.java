package fr.infodb.exemples.portail.rest.serveur.dto2;

import fr.infodb.exemples.portail.rest.serveur.dto.ws.SocialModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 14/02/18.
 */
public class GroupeMesuresSociales implements Serializable {

    private String id;

    private SocialModule moduleMetier;

    private final List<MesureSociale> mesuresSociales = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SocialModule getModuleMetier() {
        return moduleMetier;
    }

    public void setModuleMetier(SocialModule moduleMetier) {
        this.moduleMetier = moduleMetier;
    }

    public List<MesureSociale> getMesuresSociales() {
        return mesuresSociales;
    }
}
