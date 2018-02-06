package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 05/02/18.
 */
public class ListeRendezVous implements Serializable{

    private List<RendezVous> rendezVous = new ArrayList<>();

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }
}
