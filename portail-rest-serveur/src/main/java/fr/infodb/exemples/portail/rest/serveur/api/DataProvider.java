package fr.infodb.exemples.portail.rest.serveur.api;

import fr.infodb.exemples.portail.rest.serveur.dto.*;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.AuthenticationResult;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.ModuleIdentifierType;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.Referential;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.SocialModule;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;

/**
 * Interface pour guider l'implémentation du controller ou du service.
 *
 * Le Portail Agent de Solis utilise les signatures décrites ici pour communiquer via des web services REST.
 *
 * @author aurelien
 * créé le 22/11/17.
 */
public interface DataProvider {

    /**
     * Authentifier un utilisateur.
     *
     * @param updto Représentation d'un utilisateur avec mot de passe
     * @return Résultat de l'authentification (enum correspondant aux différents statuts possibles
     */
    AuthenticationResult authenticate(AuthenticationRequest updto);

    /**
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    PaginationIndividus findAllIndividuals(int pageSize, int pageNumber);

    /**
     * Récupérer tous les travailleurs sociaux.
     * <p>
     * Cette méthode est utilisée uniquement dans le cadre de la reprise de données.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    PaginationIntervenantsSociaux findAllSocialWorkers(int pageSize, int pageNumber);

    /**
     * Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    PaginationUtilisateurs findAllUser(int pageSize, int pageNumber);

    /**
     * Récupérer un individu à partir de son id.
     *
     * @param individuId Id de l'individu.
     * @return L'individu recherché.
     */
    Individu findBeneficiary(String individuId);

    /**
     * Récupérer un utilisateur à partir de son id.
     *
     * @param userId Id de l'utilisateur.
     * @return L'utilisateur recherché.
     */
    Utilisateur findSocialExtUser(String userId);

    /**
     * Récupérer un intervenant social à partir de son id.
     *
     * @param socialWorkerId Id de l'intervenant social.
     */
    IntervenantSocial findSocialWorker(String socialWorkerId);

    /**
     * Recherche les message à afficher sur la page d'authentification.
     *
     * @return Liste des messages
     */
    LoginHomepageMessages getAllLoginHomepageMessages();

    /**
     * Retourner tous les profils utilisateurs actifs.
     *
     * @return Profils utilisateurs.
     */
    Profiles getAvailableProfiles();

    /**
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     */
    SocialModules getAvailableSocialModules();

    /**
     * Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.
     *
     * @return Un Set de SocialModule.
     */
    SocialModules getAvailableSocialModulesForLifeLine();

    /**
     * Retourner le dossier d'un bénéficiaire.
     *
     * @param userId     Id de l'utilisateur du portail à l'origine de cet appel
     * @param individuId Id du bénéficiaire recherché.
     * @return Représentation du dossier bénéficiaire
     */
    DossierBeneficiaire getFileRecord(String userId, String individuId);

    /**
     * Rechercher dans les rendez-vous des individus.
     *
     * @param individuId Id de l'individu.
     * @return Représentation des rendez-vous d'un individu
     */
    ListeRendezVous getIndividualRendezVous(String individuId);

    /**
     * Récupèrer la référence du dossier
     *
     * @param module     SocialModule concerné.
     * @param type       Type d'identifiant.
     * @param individuId Identifiant de l'individu recherché
     * @return Référence du dossier.
     */
    StringWrapperDTO getModuleIdentifier(SocialModule module, ModuleIdentifierType type, String individuId);

    /**
     * Récupérer les tâches à accomplir par un travailleur social
     *
     * @param socialWorkerId Id du travailleur social concerné.
     * @return Représentation des tâches à accomplir par un travailleur social
     */
    TachesUtilisateur getNews(String socialWorkerId);

    /**
     * Retourner les profils d'un utilisateur
     *
     * @param userId Id de l'utilisateur.
     * @return Profils de l'utilisateur.
     */
    Profiles getProfiles(String userId);

    /**
     * Récupération des valeurs d'un référentiel (nomenclature).
     *
     * @param referential Enum correspondant au type de référentiel voulu.
     * @return Un objet ReferentialDTO qui contient les valeurs du référentiel. Ce DTO contient une liste de ReferentialEntryDTO.
     * @see Referential
     */
    ReferentialDTO getReferential(String referential);

    /**
     * Récupèrer les aides liées à un bénéficiaire.
     *
     * @param userId     Id de l'utilisateur à l'origine de l'appel
     * @param individuId Id du bénéficiaire
     * @return Représentation des mesures sociales du bénéficiaire.
     */
    MesuresSociales getSocialFileMeasures(String userId, String individuId);

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
     * Rechercher tous les individus correspondant aux critères reçus
     *
     * @param rechercheIndividusRequest Critères pour filtrer les individus
     * @return Représentation des individus trouvés
     */
    PaginationIndividus searchIndividuals(RechercheIndividusRequest rechercheIndividusRequest);
}
