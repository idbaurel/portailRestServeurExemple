package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 27/02/18.
 */
public class TachesUtilisateur implements Serializable {

    private final List<TacheUtilisateur> taches = new ArrayList();

    public List<TacheUtilisateur> getTaches() {
        return taches;
    }
}
