package fr.infodb.exemples.portail.rest.serveur.dto;

import fr.infodb.exemples.portail.rest.serveur.dto.constants.RendezVousStatutsEnum;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.SocialExtPlaceType;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.SocialExtRendezVousType;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.SocialModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author aurelien
 * créé le 05/02/18.
 */
public class RendezVous implements Serializable {

    /**
     * Id du rendez-vous
     */
    private String id;

    /**
     * Date de début du rendez-vous
     */
    private Date dateDebut;

    /**
     * Date de fin du rendez-vous
     */
    private Date dateFin;

    /**
     * Durée du rendez-vous
     */
    private Long duree;

    /**
     * Rendez-vous prévu sur toute la journée ?
     */
    private boolean journeeComplete = false;

    /**
     * todo utilité à déterminer
     * Type de rendez vous (CIRCO, PERMANENCE, VAD, OTHER, TELEPHONE, COMMISSION)
     */
    private SocialExtRendezVousType type;

    /**
     * todo utilité à déterminer
     * Type de place du rendez-vous
     * Type du lieu de rendez vous (CIRCO, ANTENNE, DOMICILE, TELEPHONE, AUTRE)
     */
    private SocialExtPlaceType placeType;

    /**
     * Module métier concerné
     */
    private SocialModule module;

    /**
     * Libellé du rendez vous
     */
    private String libelle;

    /**
     * Commentaire du rendez vos
     */
    private String commentaire;

    /**
     * Intervenants sociaux concernés par le rendez-vous
     */
    private final List<IntervenantSocial> intervenantsSociaux = new ArrayList<>();

    //    /**
    //     * Exploité uniquement lors de la création d'un rendez-vous.
    //     * Lors d'une récupération, considérer le champ concernedIndividuals pour obtenir l'ensemble des individus concernés par le rendez-vous.
    //     */
    //    @XmlElement(name = "Individual")
    //    private SocialExtIndividual individual;
    //    /**
    //     * Individus concernés par le rendez vous
    //     */
    //    @XmlElement(name = "ConcernedIndividuals")
    //    private List<SocialExtConcerned> concernedIndividuals;
    /**
     * Individus concernés par le rendez vous
     */
    private final List<Individu> individus = new ArrayList<>();

    /**
     * Adresse du rendez-vous
     */
    //    private SocialExtAddress addresse;
    private Adresse adresse;

    /**
     * Code du type de lieu du rendez vous
     */
    private String placeTypeCode;

    /**
     * Libellé du lieu du rendez vous
     */
    private String placeTypeLabel;

    /**
     * Statuts des rendez vous sur le parcours usager (PLANNED, PERFORMED, UNREALIZED)
     */
    private RendezVousStatutsEnum statut;

    /**
     * Motif du rendez vous
     */
    private String motif;

    /**
     * Code du type de rendez vous
     */
    private Integer codeTypeRdv;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }

    public boolean isJourneeComplete() {
        return journeeComplete;
    }

    public void setJourneeComplete(boolean journeeComplete) {
        this.journeeComplete = journeeComplete;
    }

    public SocialExtRendezVousType getType() {
        return type;
    }

    public void setType(SocialExtRendezVousType type) {
        this.type = type;
    }

    public SocialExtPlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(SocialExtPlaceType placeType) {
        this.placeType = placeType;
    }

    public SocialModule getModule() {
        return module;
    }

    public void setModule(SocialModule module) {
        this.module = module;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public List<IntervenantSocial> getIntervenantsSociaux() {
        return intervenantsSociaux;
    }

    public List<Individu> getIndividus() {
        return individus;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getPlaceTypeCode() {
        return placeTypeCode;
    }

    public void setPlaceTypeCode(String placeTypeCode) {
        this.placeTypeCode = placeTypeCode;
    }

    public String getPlaceTypeLabel() {
        return placeTypeLabel;
    }

    public void setPlaceTypeLabel(String placeTypeLabel) {
        this.placeTypeLabel = placeTypeLabel;
    }

    public RendezVousStatutsEnum getStatut() {
        return statut;
    }

    public void setStatut(RendezVousStatutsEnum statut) {
        this.statut = statut;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Integer getCodeTypeRdv() {
        return codeTypeRdv;
    }

    public void setCodeTypeRdv(Integer codeTypeRdv) {
        this.codeTypeRdv = codeTypeRdv;
    }
}
