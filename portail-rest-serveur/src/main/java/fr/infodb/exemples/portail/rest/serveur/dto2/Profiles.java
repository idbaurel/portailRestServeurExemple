package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 12/01/18.
 */
public class Profiles implements Serializable {

    private List<String> profiles = new ArrayList<>();

    public List<String> getProfiles() {
        return profiles;
    }

}
