package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.util.ArrayList;
import java.util.List;

/**
 * Objet permettant de récupérer des individus sous forme de pagination.
 *
 * @author aurelien
 * créé le 29/01/18.
 */
public class PaginationIntervenantsSociaux extends Pagination {

    /**
     * Liste des individus
     */
    private final List<IntervenantSocial> intervenantsSociaux = new ArrayList<>();

    public List<IntervenantSocial> getIntervenantsSociaux() {
        return intervenantsSociaux;
    }
}
