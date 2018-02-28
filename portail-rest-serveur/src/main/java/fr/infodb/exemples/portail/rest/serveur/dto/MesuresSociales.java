package fr.infodb.exemples.portail.rest.serveur.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 14/02/18.
 */
public class MesuresSociales implements Serializable {

    private final List<GroupeMesuresSociales> groupesMesuresSociales = new ArrayList<>();

    public List<GroupeMesuresSociales> getGroupesMesuresSociales() {
        return groupesMesuresSociales;
    }
}
