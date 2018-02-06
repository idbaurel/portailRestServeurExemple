package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.util.ArrayList;
import java.util.List;

/**
 * Objet permettant de récupérer des individus sous forme de pagination.
 *
 * @author aurelien
 * créé le 29/01/18.
 */
public class PaginationUtilisateurs extends Pagination {

    /**
     * Liste des individus
     */
    private final List<Utilisateur> utilisateurs = new ArrayList<>();

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
}
