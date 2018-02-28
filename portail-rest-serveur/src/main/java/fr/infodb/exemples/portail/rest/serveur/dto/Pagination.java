package fr.infodb.exemples.portail.rest.serveur.dto;

import java.io.Serializable;

/**
 * @author aurelien
 * créé le 06/02/18.
 */
public abstract class Pagination implements Serializable {

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
