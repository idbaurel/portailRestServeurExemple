package fr.infodb.exemples.portail.rest.serveur.api;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.dto2.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Interface définissant les services distants appelés par le portail.
 * Cette interface de service doit être implémentée par les services exposés par les environnements distants (Solis 2,
 * Horus, etc.).
 *
 * @author asi
 */
public interface RestSocialExtDataProvider {

    /**
     * Recherche les rendez vous d'un travailleur social entre deux dates données
     *
     * @param userId         id de l'utilisateur portail à l'origine de l'appel (pour habilitation ?)
     * @param socialWorkerId id du travailleur social
     * @param startDate      date de début de la période de recherche
     * @param endDate        date de fin de la période de recherche
     * @return Représentation d'une liste de rendez vous
     * @throws SocialExtException Exception en cas d'erreur
     */
    ListeRendezVous getSocialWorkerRendezVous(String userId, String socialWorkerId, String startDate, String endDate) throws SocialExtException;

    /**
     * Méthode permettant de récupérer la liste des offres de services
     *
     * @param individualId identifiant externe de l'individu
     * @return La liste des offres de services
     */
    List<BusinessOffer> getBusinessOffers(String individualId);

    /**
     * Retourne, pour l'utilisateur spécifié, le nombre d'évènements en attente de traitement issus du SIRH SCNF.
     *
     * @param userId l'identifiant de l'utilisateur.
     * @return le nombre d'évènements; ou <code>null</code> si la configuration cliente n'est pas associée au client SNCF.
     */
    Long getNumberSirhEvents(String userId);

    /**
     * Méthode permettan de récupérer la liste des messages à afficher sur la page d'authentification.
     *
     * @return la liste des messages à afficher sur la page d'authentification
     */
//    List<LoginHomepageMessage> getAllLoginHomepageMessages();
    LoginHomepageMessages getAllLoginHomepageMessages();

    /**
     * Retourne les liens vers les home pages de modules.
     *
     * @param token   token d'authentification
     * @param userId  id de l'utilisateur du portail à l'origine de l'appel.
     * @param modules Set de SocialModule pour lesquels on veut récupérer les liens.
     * @return Les liens construits associés à leur module.
     * @throws SocialExtException Exception en cas d'erreur
     */
    Map<SocialModule, String> getHomePages(String token, String userId, Set<SocialModule> modules) throws SocialExtException;

    /**
     * Récupère l'identifiant d'un module en fonction du nom du module et du type d'identifiant.
     *
     * @param userId       id de l'utilisateur à l'origine de l'appel (pour habilitation ?)
     * @param socialModule le SocialModule concerné
     * @param moduleIdType le type d'identifiant voulu
     * @return une String correspondant à l'identifiant du module
     */
    StringWrapperDTO getModuleIdentifier(String userId, SocialModule socialModule, ModuleIdentifierType moduleIdType);

    /**
     * Récupère les aides sociales liées à un bénéficiaire.
     *
     * @param userId id de l'utilisateur à l'origine de l'appel (pour habilitation ?)
     * @param index  id du bénéficiaire
     * @return Représentation des mesures sociales du bénéficiaire.
     */
    MesuresSociales getSocialFileMeasures(String userId, String index);

    /**
     * Retourne les profils d'un utilisateur.
     *
     * @param userId id de l'utilisateur. Si ce paramètre est null, l'ensemble des profils est retourné
     * @return un Set de String contenant les profils de l'utilisateur
     * @throws SocialExtException Exception en cas d'erreur
     */
    Profiles getProfiles(String userId) throws SocialExtException;


    /**
     * Retourne une liste de suggestion de lieux dans une commune donnée, à partir d'une portion du nom du lieu.
     *
     * @param municipalityId Identifiant de la commune
     * @param token          Nom partiel du lieu (rue, boulevard etc...)
     * @return Liste de lieux correspondant à la recherche
     * @throws SocialExtException Exception en cas d'erreur
     */
    List<SocialExtPlace> suggestPlaces(String municipalityId, String token) throws SocialExtException;

    /**
     * Retourne une liste de suggestion de communes à partir d'une portion du nom de commune.
     *
     * @param token une portion du nom de la commune
     * @return une liste de communes dont le nom contien le token
     * @throws SocialExtException Exception en cas d'erreur
     */
    List<SocialExtMunicipality> suggestMunicipalities(String token) throws SocialExtException;

//    /**
//     * Retourne un token d'authentification.
//     *
//     * @param updto Dto contenant les informations nécessaires pour construire le token d'authentification.
//     * @return un StringWrapperDTO contenant le token généré
//     */
//    StringWrapperDTO getRedirectionToken(UserAndParamsDTO updto);

    /**
     * Retourne une Map de liens correspondant à des écrans de Solis (pour débranchement).
     *
     * @param token        Token d'authentification
     * @param screens      Identifiants des liens à produire
     * @param userId       Identifiant de l'utilisateur qui souhaite se connecter
     * @param individualId Identifiant de l'individu concerné
     * @return Les liens construits associés à leur type de lien
     * @throws SocialExtException Exception en cas d'erreur
     */
    Map<SocialModuleScreen, String> getLinks(String token, Set<SocialModuleScreen> screens, String userId, String individualId) throws SocialExtException;

    /**
     * Retourne un lien de débranchement vers un écran SOLIS indépendant d'un module social.
     *
     * @param token    le token d'authentification
     * @param linkType le type de lien Solis
     * @return le lien.
     * @throws SocialExtException Exception en cas d'erreur si une erreur est levée.
     */
    StringWrapperDTO getLink(String token, String linkType) throws SocialExtException;

    /**
     * Récupère le "dossier" pour un bénéficiaire donné, c'est-à-dire ses informations détaillées.
     * Remarque : cette méthode fait peut-être doublon avec getIndividualSynthesis ??? (cf J. Perceveau)
     *
     * @param userId id de l'utilisateur du portail à l'origine de cet appel (pour habilitation ?)
     * @param index  id du bénéficiaire
     * @return un objet SocialExtBeneficiary contenant le détail du bénéficiaire
     * @throws SocialExtException Exception en cas d'erreur
     */
    DossierBeneficiaire getFileRecord(String userId, String index) throws SocialExtException;

    /**
     * Récupère la "synthèse individuelle" pour un bénéficiaire donné, c'est-à-dire ses informations détaillées.
     * Remarque : cette méthode fait peut-être doublon avec getFileRecord ??? (cf J. Perceveau)
     *
     * @param userId id de l'utilisateur du portail à l'origine de cet appel (pour habilitation ?)
     * @param index  id du bénéficiaire
     * @return un objet SocialExtBeneficiary contenant le détail du bénéficiaire
     * @throws SocialExtException Exception en cas d'erreur
     */
    SocialExtBeneficiary getIndividualSynthesis(String userId, String index) throws SocialExtException;

    /**
     * Récupère tous les individus (utilisé pour la reprise de données initiale).
     * Les requêtes se font de manière paginée.
     * Attention, cela implique que la recherche doit être ordonnée côté serveur.
     *
     * @param pageSize   taille de la page (=nombre d'individus récupérés par requête)
     * @param pageNumber numéro de la page récupérée, commençant au numéro 1
     */
//    BeneficiarySearchResultDTO findAllIndividuals(int pageSize, int pageNumber);
    PaginationIndividus findAllIndividuals(int pageSize, int pageNumber);

    /**
     * Récupère tous les utilisateurs (utilisé pour la reprise de données initiale).
     * Les requêtes se font de manière paginée.
     * Attention, cela implique que la recherche doit être ordonnée côté serveur.
     *
     * @param pageSize   taille de la page (=nombre d'éléments récupérés par requête)
     * @param pageNumber numéro de la page récupérée, commençant au numéro 1
     */
    PaginationUtilisateurs findAllUser(int pageSize, int pageNumber);

    /**
     * Récupère tous les utilisateurs (utilisé pour la reprise de données initiale).
     * Les requêtes se font de manière paginée.
     * Attention, cela implique que la recherche doit être ordonnée côté serveur.
     *
     * @param pageSize   taille de la page (=nombre d'éléments récupérés par requête)
     * @param pageNumber numéro de la page récupérée, commençant au numéro 1
     */
    PaginationIntervenantsSociaux findAllSocialWorkers(int pageSize, int pageNumber);

    /**
     * Récupérer les taĉhes à accomplir par un utilisateur
     *
     * @param userId Id de l'utilisateur concerné.
     * @return Représentation des taĉhes à accomplir par un utilisateur
     */
    TachesUtilisateur getNews(String userId) throws SocialExtException;

    /**
     * Récupère les valeurs d'un référentiel.
     *
     * @param referential enum correspondant au référentiel souhaité
     * @return un ReferentialDTO contenant les entrées de référentiel souhaites.
     * @throws SocialExtException Exception en cas d'erreur
     */
    ReferentialDTO getReferential(String referential) throws SocialExtException;

    /**
     * Récupère les modules sociaux disponibles sur l'environnement.
     *
     * @return un Set de SocialModule (spi-portail)
     */
    SocialModules getAvailableSocialModules();

//    /**
//     * Recherche d'"individus" : il s'agit des personnes pouvant demander une aide sociale?
//     *
//     * @param searchCriteria critères de recherche
//     * @return wrapper autour d'une liste de bénéficiaires
//     * @throws SocialExtException Exception en cas d'erreur
//     */
//    List<SocialExtBeneficiary> searchIndividuals(HashSet<SearchCriterionDTO> searchCriteria) throws SocialExtException;

    /**
     * Rechercher tous les individus correspondant aux critères reçus
     *
     * @param rechercheIndividusRequest Critères pour filtrer les individus
     * @return Représentation des individus trouvés
     */
    PaginationIndividus searchIndividuals(RechercheIndividusRequest rechercheIndividusRequest);

    /**
     * Récupère les modules métiers disponibles pour la ligne de vie sur le Parcours Usager du Portail Agent.
     *
     * @return Représentation des modules métiers
     */
    SocialModules getAvailableSocialModulesForLifeLine();

    /**
     * Retourne la liste des rendez-vous d'un individu.
     *
     * @param externalId id de l'individu
     * @return une List de SocialExtRendezVous
     * @throws SocialExtException Exception en cas d'erreur
     */
    ListeRendezVous getIndividualRendezVous(String externalId) throws SocialExtException;

    /**
     * Récupère l'ensemble des lieux d'un type de lieux donné (par exemple l'ensemble des CIRCO).
     *
     * @param type le type de lieu voulu
     * @return un Set de SocialExtPlace
     * @throws SocialExtException Exception en cas d'erreur
     */
    Set<SocialExtPlace> getPlacesByType(SocialExtPlaceType type) throws SocialExtException;

    /**
     * Retourne la circonscription correspondant à un lieu donné.
     *
     * @param placeId id du lieu
     * @return une String correspondant à la circonscription
     * @throws SocialExtException Exception en cas d'erreur
     */
    StringWrapperDTO getCirco(String placeId) throws SocialExtException;

    /**
     * Crée un rendez-vous.
     *
     * @param rendezVous le rendez-vous à créer.
     * @return l'id du rendez-vous créé.
     * @throws SocialExtException Exception en cas d'erreur
     */
    StringWrapperDTO createSocialWorkerRendezVous(SocialExtRendezVous rendezVous) throws SocialExtException;

    /**
     * Crée un individu.
     *
     * @param beneficiary Individu principal et individus associés à créer et/ou à relier
     * @return l'identifiant de l'individu principal si il a été cré ou null si il existait
     * @throws SocialExtException Exception en cas d'erreur
     */
    StringWrapperDTO createIndividuals(SocialExtBeneficiary beneficiary) throws SocialExtException;

    /**
     * Modifie un individu
     *
     * @param beneficiary Individu principal et individus associés à créer et/ou à relier
     * @throws SocialExtException Exception en cas d'erreur
     */
    void updateIndividual(SocialExtBeneficiary beneficiary) throws SocialExtException;

    /**
     * Authentifie un utilisateur, grâce à son login et mot de passe.
     *
     * @param updto Dto contenant le login et le mot de passe de l'utilisateur
     * @return un AuthenticationResult contenant le statut de l'authentification
     * @throws SocialExtException Exception en cas d'erreur
     */
    AuthenticationResult authenticate(AuthenticationRequest updto) throws SocialExtException;

    /**
     * Récupère un bénéficiaire à partir de son id.
     *
     * @param externalId id du bénéficiaire
     * @return le bénéficiaire
     */
    SocialExtBeneficiary findBeneficiary(String externalId);

    /**
     * Récupère un utilisateur à partir de son id.
     *
     * @param externalId id de l'utilisateur
     * @return l'utilisateur
     */
    SocialExtUser findSocialExtUser(String externalId);

    /**
     * Récupère un intervenant social à partir de son id.
     *
     * @param externalId id de l'intervenant social
     * @return l'intervenant social
     */
    IntervenantSocial findSocialWorker(String externalId);
}
