package fr.infodb.exemples.portail.rest.serveur.dto2;

import fr.infodb.exemples.portail.rest.serveur.dto.ws.SocialModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 10/01/18.
 */
public class AvailableSocialModules implements Serializable {

    private final List<SocialModule> modules = new ArrayList<>();

    public List<SocialModule> getModules() {
        return modules;
    }
}
