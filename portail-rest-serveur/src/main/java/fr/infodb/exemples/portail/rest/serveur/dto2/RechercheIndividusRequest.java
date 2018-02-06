package fr.infodb.exemples.portail.rest.serveur.dto2;

import fr.infodb.exemples.portail.rest.serveur.dto.ws.SearchCriterionDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 06/02/18.
 */
public class RechercheIndividusRequest extends Pagination {

    private final List<SearchCriterionDTO> criteresRecherches = new ArrayList<SearchCriterionDTO>();

    public List<SearchCriterionDTO> getCriteresRecherches() {
        return criteresRecherches;
    }
}
