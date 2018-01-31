package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Objet permettant de récupérer des individus sous forme de pagination.
 *
 * @author aurelien
 * créé le 29/01/18.
 */
public class PaginationUtilisateurs implements Serializable {

    /**
     * Liste des individus
     */
    private final List<Utilisateur> utilisateurs = new ArrayList<>();

    /**
     * Nombre total d'éléments correspondant à la recherche.
     */
    private int totalNumber = -1;

    /**
     * Taille de la 'page' retournée (= nombre maximum d'éléments dans la liste).
     */
    private int pageSize = -1;

    /**
     * Numéro de la page retournée (page 1, page 2, etc.).
     */
    private int pageNumber = -1;

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
