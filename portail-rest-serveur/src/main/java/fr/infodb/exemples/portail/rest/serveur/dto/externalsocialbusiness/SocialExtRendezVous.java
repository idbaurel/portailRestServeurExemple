package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import fr.infodb.exemples.portail.rest.serveur.dto.ws.SocialModule;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Représente un rendez vous d'un SI social pour un bénéficiaire
 *
 * @author aurelien
 */
@XmlRootElement(name = "SocialExtRendezVous", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtRendezVous {

    /**
     * Id du rendez-vous
     */
    @XmlAttribute(name = "Id", required = true)
    private String id;

    /**
     * Date de début du rendez-vous
     */
    @XmlAttribute(name = "StartDate", required = true)
    private Date startDate;

    /**
     * Date de fin du rendez-vous
     */
    @XmlAttribute(name = "EndDate")
    private Date endDate;

    /**
     * Durée du rendez-vous
     */
    @XmlAttribute(name = "Duration")
    private Long duration;

    /**
     * Rendez-vous prévu sur la journée ?
     */
    @XmlAttribute(name = "IsFullDay")
    private boolean fullDay = false;

    @XmlAttribute(name = "Type", required = true)
    private SocialExtRendezVousType type;

    @XmlAttribute(name = "Module", namespace = "http://www.infodb.fr/solis/portail/portalconfig")
    private SocialModule module;

    @XmlElement(name = "Label")
    private String label;

    @XmlElement(name = "Comment")
    private String comment;

    /**
     * Intervenants sociaux concernés par le rendez-vous
     */
//    @XmlElement(name = "SocialWorkers")
//    private Set<SocialExtWorker> socialWorkers = new HashSet<SocialExtWorker>();

    // Exploité uniquement lors de la création d'un rendez-vous.
    // Lors d'une récupération, considérer le champ concernedIndividuals pour obtenir l'ensemble des individus concernés par le rendez-vous.
//    @XmlElement(name = "Individual")
//    private SocialExtIndividual individual;

    /**
     * Adresse du rendez-vous
     */
    @XmlElement(name = "Address")
    private SocialExtAddress address;

    /**
     * Type de place du rendez-vous
     */
    @XmlAttribute(name = "PlaceType")
    private SocialExtPlaceType placeType;

    /**
     * Code de la place
     */
    @XmlAttribute(name = "PlaceTypeCode")
    private String placeTypeCode;

    /**
     * Libellé de la place
     */
    @XmlAttribute(name = "PlaceTypeLabel")
    private String placeTypeLabel;

    /**
     * Individus concernés par le rendez vous
     */
//    @XmlElement(name = "ConcernedIndividuals")
//    private List<SocialExtConcerned> concernedIndividuals;

    /**
     * Statuts des rendez vous sur le parcours usager
     */
    @XmlElement(name = "RendezVousStatut")
    private RendezVousStatutsEnum statut;

    /**
     * Motif du rendez vous
     */
    @XmlElement(name = "Motif")
    private String motif;

    /**
     * Code du type de rendez vous
     */
    @XmlElement(name = "CodeTypeRdv")
    private Integer codeTypeRdv;

    /**
     * Constructeur
     */
    public SocialExtRendezVous() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public boolean isFullDay() {
        return fullDay;
    }

    public void setFullDay(boolean fullDay) {
        this.fullDay = fullDay;
    }

    public SocialExtRendezVousType getType() {
        return type;
    }

    public void setType(SocialExtRendezVousType type) {
        this.type = type;
    }

    public SocialModule getModule() {
        return module;
    }

    public void setModule(SocialModule module) {
        this.module = module;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public SocialExtAddress getAddress() {
        return address;
    }

    public void setAddress(SocialExtAddress address) {
        this.address = address;
    }

//    public Set<SocialExtWorker> getSocialWorkers() {
//        return socialWorkers;
//    }

//    public void setSocialWorkers(Set<SocialExtWorker> socialWorkers) {
//        this.socialWorkers = socialWorkers;
//    }

//    public SocialExtIndividual getIndividual() {
//        return individual;
//    }

//    public void setIndividual(SocialExtIndividual individual) {
//        this.individual = individual;
//    }

    public SocialExtPlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(SocialExtPlaceType placeType) {
        this.placeType = placeType;
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

//    public List<SocialExtConcerned> getConcernedIndividuals() {
//        return concernedIndividuals;
//    }

//    public void setConcernedIndividuals(List<SocialExtConcerned> concernedIndividuals) {
//        this.concernedIndividuals = concernedIndividuals;
//    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public RendezVousStatutsEnum getStatut() {
        return statut;
    }

    public void setStatut(RendezVousStatutsEnum statut) {
        this.statut = statut;
    }

    public SocialExtRendezVous getSocialExtRendezVous() {
        return this;
    }

    public Integer getCodeTypeRdv() {
        return codeTypeRdv;
    }

    public void setCodeTypeRdv(Integer codeTypeRdv) {
        this.codeTypeRdv = codeTypeRdv;
    }
}
