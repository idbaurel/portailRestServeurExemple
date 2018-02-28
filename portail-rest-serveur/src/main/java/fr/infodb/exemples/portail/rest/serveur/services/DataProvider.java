package fr.infodb.exemples.portail.rest.serveur.services;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.dto2.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author aurelien
 * créé le 22/11/17.
 */
public interface DataProvider {

    /**
     * Evénement SIRH
     *
     * @param userId Identifiant de l'utilisateur
     * @return Nombre d'événement pour l'utilisateur
     */
    Long getNumberSirhEvents(String userId);

    /**
     * Recherche des offres de services
     *
     * @param individualId Identifiant du bénéficiaire
     * @return Liste d'offre
     */
    List<BusinessOffer> getBusinessOffers(String individualId);

    /**
     * Récupère la référence du dossier
     *
     * @param module     SocialModule concerné.
     * @param type       Type d'identifiant.
     * @param externalId Id du user portail à l'origine de l'appel
     * @return Référence du dossier.
     */
    String getModuleIdentifier(SocialModule module, ModuleIdentifierType type, String externalId);

    /**
     * Récupère les aides liées à un bénéficiaire.
     *
     * @param userId Id de l'utilisateur à l'origine de l'appel
     * @param index  Id du bénéficiaire
     * @return Représentation des mesures sociales du bénéficiaire.
     */
    MesuresSociales getSocialFileMeasures(String userId, String index);

    /**
     * Créer un individu.
     *
     * @param beneficiary Données de l'individu à créer
     * @return Identifiant de l'individu créer
     */
    String createIndividuals(SocialExtBeneficiary beneficiary);

    /**
     * Modifier un individu.
     *
     * @param beneficiary Paramètres de l'individu à modifier.
     * @see SocialExtBeneficiary
     */
    void updateIndividual(SocialExtBeneficiary beneficiary);

    /**
     * Retourner les profils d'un utilisateur
     *
     * @param userId Id de l'utilisateur.
     * @return Profils de l'utilisateur.
     */
    Profiles getProfiles(String userId);

    /**
     * Retourner tous les profils utilisateurs actifs.
     *
     * @return Profils utilisateurs.
     */
    Profiles getAvailableProfiles();

    /**
     * Retourner un ensemble de lieux en fonction d'un type donné.
     *
     * @param type Type de lieu
     * @return Les lieux correspondant au type de lieu donné.
     * @see SocialExtPlaceType
     */
    Set<SocialExtPlace> getPlacesByType(SocialExtPlaceType type);

    /**
     * Retourner la circonscription liée à un lieu.
     *
     * @param placeId Identifiant du lieu
     * @return Circonscription liée à un lieu.
     */
    String getCirco(String placeId);

    /**
     * Retourne le dossier d'un bénéficiaire.
     *
     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
     * @param index  Id du bénéficiaire recherché.
     * @return Représentation du dossier bénéficiaire
     */
    DossierBeneficiaire getFileRecord(String userId, String index);

//    /**
//     * Récupère la synthèse d'un individu.
//     *
//     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
//     * @param index  Id du bénéficiaire recherché
//     * @return Un SocialExtBeneficiary, contenant le détail du bénéficiaire.
//     */
//    SocialExtBeneficiary getIndividualSynthesis(String userId, String index);

    /**
     * Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    PaginationUtilisateurs findAllUser(int pageSize, int pageNumber);

    /**
     * Récupérer tous les travailleurs sociaux.
     * <p>
     * Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    PaginationIntervenantsSociaux findAllSocialWorkers(int pageSize, int pageNumber);

    /**
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
//    BeneficiarySearchResultDTO findAllIndividuals(int pageSize, int pageNumber);
    PaginationIndividus findAllIndividuals(int pageSize, int pageNumber);

    /**
     * Récupérer un utilisateur à partir de son id.
     *
     * @param externalId Id de l'utilisateur.
     * @return L'utilisateur recherché.
     */
    Utilisateur findSocialExtUser(String externalId);

    /**
     * Récupérer un individu à partir de son id.
     *
     * @param externalId Id de l'individu.
     * @return L'individu recherché.
     */
    Individu findBeneficiary(String externalId);

    /**
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     */
//    Set<SocialModule> getAvailableSocialModules();
    SocialModules getAvailableSocialModules();

    /**
     * Récupérer les tâches à accomplir par un travailleur social
     *
     * @param socialWorkerId Id du travailleur social concerné.
     * @return Représentation des tâches à accomplir par un travailleur social
     */
    TachesUtilisateur getNews(String socialWorkerId);

    /**
     * Récupérer les liens de débranchement vers les écrans de Solis.
     *
     * @param screens         Ensemble d'écrans.
     * @param user            Utilisateur du portail
     * @param indexIndividual Id de l'individu concerné
     * @param token           Token d'authentification.
     * @return Une Map avec en clé une enum correspondant aux écrans et en valeur une String contenant le lien
     */
    Map<SocialModuleScreen, String> getLinks(Set<SocialModuleScreen> screens, String user, String indexIndividual, String token);

    /**
     * Récupérer les liens vers les pages d'accueil des modules sociaux
     *
     * @param modules Ensemble de modules.
     * @param user    Utilisateur du portail
     * @param token   Token d'authentification
     * @return Une Map avec en clé une enum correspondant aux modules et en valeur une String contenant le lien.
     */
    Map<SocialModule, String> getHomePages(Set<SocialModule> modules, String user, String token);

    /**
     * Retourne un lien de débranchement vers un écran SOLIS indépendant d'un module social.
     *
     * @param token    Token d'authentification
     * @param linkType Type de lien pour débranchement
     * @return Le lien http.
     * @see SolisLinkType
     */
    String getLink(SolisLinkType linkType, String token, SocialExtUser user) throws SocialExtException;

    /**
     * Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités.
     *
     * @param token Contient les premiers caractères de la municipalité.
     * @return Liste de SocialExtMunicipalities.
     */
    List<SocialExtMunicipality> suggestMunicipalities(String token);

    /**
     * Retourner une liste de lieux correspondant à une portion de nom donnée.
     *
     * @param token          Portion du nom du lieu.
     * @param municipalityId Id de la commune.
     * @return Liste de lieux dont le nom contient la portion donnée.
     */
    List<SocialExtPlace> suggestPlaces(String token, String municipalityId);

    /**
     * Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.
     *
     * @return Un Set de SocialModule.
     */
    SocialModules getAvailableSocialModulesForLifeLine();

    /**
     * Authentifier un utilisateur.
     *
     * @param updto Représentation d'un utilisateur avec mot de passe
     * @return Résultat de l'authentification (enum correspondant aux différents statuts possibles
     */
    AuthenticationResult authenticate(AuthenticationRequest updto);

    /**
     * Recherche les message à afficher sur la page d'authentification.
     *
     * @return Liste des messages
     */
//    List<LoginHomepageMessage> getAllLoginHomepageMessages();
    LoginHomepageMessages getAllLoginHomepageMessages();

    /**
     * Rechercher dans les rendez-vous des individus.
     *
     * @param externalId Clé de l'individu
     * @return Représentation des rendez-vous d'un individu
     */
    ListeRendezVous getIndividualRendezVous(String externalId);

    /**
     * Rechercher dans les rendez-vous des travailleurs sociaux.
     *
     * @param userId         Id de l'utilisateur portail à l'origine de l'appel
     * @param socialWorkerId Id du travailleur social
     * @param startDate      Date de début de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @param endDate        Date de fin de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @return Un Set de SocialExtRendezVous.
     * @throws SocialExtException Si les dates ne sont pas correctes
     */
    ListeRendezVous getSocialWorkerRendezVous(String userId, String socialWorkerId, String startDate, String endDate);

    /**
     * Créer un rendez-vous pour un intervenant social.
     *
     * @param rendezVous Paramètres du rendez-vous (date, travailleurs sociaux, etc...)
     * @return L'id du rendez-vous créé.
     * @see SocialExtRendezVous
     */
    String createSocialWorkerRendezVous(SocialExtRendezVous rendezVous);

//    /**
//     * Récupérer un token de redirection.
//     *
//     * @param updto Wrapper autour d'un SocialExtUSer (habilitation) et une map de paramètres.
//     * @return Token de redirection.
//     */
//    String getRedirectionToken(UserAndParamsDTO updto);

    /**
     * Récupérer un intervenant social à partir de son id.
     *
     * @param socialWorkerId Id de l'intervenant social.
     */
    IntervenantSocial findSocialWorker(String socialWorkerId);

    /**
     * Récupération des valeurs d'un référentiel (nomenclature).
     *
     * @param referential Enum correspondant au type de référentiel voulu.
     * @return Un objet ReferentialDTO qui contient les valeurs du référentiel. Ce DTO contient une liste de ReferentialEntryDTO.
     * @see Referential
     */
    ReferentialDTO getReferential(String referential);

//    /**
//     * "Rechercher dans les individus.
//     *
//     * @param searchCriteria Set de critères de recherche. Chaque critère contient un type, une classe et une valeur.
//     * @return Une liste d'individus correspondant aux critères.
//     * @see SearchCriterionDTO
//     */
//    List<SocialExtBeneficiary> findAllIndividuals(Set<SearchCriterionDTO> searchCriteria);

    /**
     * Rechercher tous les individus correspondant aux critères reçus
     *
     * @param rechercheIndividusRequest Critères pour filtrer les individus
     * @return Représentation des individus trouvés
     */
    PaginationIndividus findAllIndividuals(RechercheIndividusRequest rechercheIndividusRequest);
}
