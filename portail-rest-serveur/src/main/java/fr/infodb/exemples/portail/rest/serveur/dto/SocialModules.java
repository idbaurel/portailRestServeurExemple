package fr.infodb.exemples.portail.rest.serveur.dto;

import fr.infodb.exemples.portail.rest.serveur.dto.constants.SocialModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 10/01/18.
 */
public class SocialModules implements Serializable {

    private final List<SocialModule> modules = new ArrayList<>();

    public List<SocialModule> getModules() {
        return modules;
    }
}
