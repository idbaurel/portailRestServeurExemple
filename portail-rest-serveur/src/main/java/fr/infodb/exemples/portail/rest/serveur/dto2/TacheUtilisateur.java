package fr.infodb.exemples.portail.rest.serveur.dto2;

import fr.infodb.exemples.portail.rest.serveur.dto.ws.SocialModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Représentation d'une tâche devant être accomplie par l'utilisateur
 *
 * @author aurelien
 * créé le 27/02/18.
 */
public class TacheUtilisateur implements Serializable {

    //index de la tâche de l'utilisateur
    private String index;

    //date d'échéance de la tâche
    private Date dateEcheance;

    //libellé de la tâche
    private String libelle;

    //descriptions détaillées de la tâches
    private final List<String> details = new ArrayList<String>();

    //type de tâche (commission ou processus métier)
    private TacheUtilisateurType typeTache;

    //module métier à l'origine de la tâche
    private SocialModule socialModule;

    //prénom de l'individu (bénéficiaire) concerné par cette taĉhe
    private String prenomIndividuConcerne;

    //nom de l'individu (bénéficiaire) concerné par cette taĉhe
    private String nomIndividuConcerne;

    //identifiant de l'individu (bénéficiaire) concerné par cette taĉhe
    private String idIndividuConcerne;

    //genre de l'individu
    private IndividuGenre genreIndividuConcerne;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<String> getDetails() {
        return details;
    }

    public TacheUtilisateurType getTypeTache() {
        return typeTache;
    }

    public void setTypeTache(TacheUtilisateurType typeTache) {
        this.typeTache = typeTache;
    }

    public SocialModule getSocialModule() {
        return socialModule;
    }

    public void setSocialModule(SocialModule socialModule) {
        this.socialModule = socialModule;
    }

    public String getPrenomIndividuConcerne() {
        return prenomIndividuConcerne;
    }

    public void setPrenomIndividuConcerne(String prenomIndividuConcerne) {
        this.prenomIndividuConcerne = prenomIndividuConcerne;
    }

    public String getNomIndividuConcerne() {
        return nomIndividuConcerne;
    }

    public void setNomIndividuConcerne(String nomIndividuConcerne) {
        this.nomIndividuConcerne = nomIndividuConcerne;
    }

    public String getIdIndividuConcerne() {
        return idIndividuConcerne;
    }

    public void setIdIndividuConcerne(String idIndividuConcerne) {
        this.idIndividuConcerne = idIndividuConcerne;
    }

    public IndividuGenre getGenreIndividuConcerne() {
        return genreIndividuConcerne;
    }

    public void setGenreIndividuConcerne(IndividuGenre genreIndividuConcerne) {
        this.genreIndividuConcerne = genreIndividuConcerne;
    }
}
