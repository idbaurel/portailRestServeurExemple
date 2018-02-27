package fr.infodb.exemples.portail.rest.serveur.dto2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aurelien
 * créé le 14/02/18.
 */
public class DossierBeneficiaire implements Serializable {

    private Individu individu;

    private final List<Individu> autresIndividus = new ArrayList<>();

    private final List<IntervenantSocial> intervenantSociaux = new ArrayList<>();


    public Individu getIndividu() {
        return individu;
    }

    public void setIndividu(Individu individu) {
        this.individu = individu;
    }

    public List<Individu> getAutresIndividus() {
        return autresIndividus;
    }

    public List<IntervenantSocial> getIntervenantSociaux() {
        return intervenantSociaux;
    }
}
