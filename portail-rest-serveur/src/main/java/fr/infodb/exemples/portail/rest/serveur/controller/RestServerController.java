package fr.infodb.exemples.portail.rest.serveur.controller;

import fr.infodb.exemples.portail.rest.serveur.api.DataProvider;
import fr.infodb.exemples.portail.rest.serveur.dto.*;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.AuthenticationResult;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.ModuleIdentifierType;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.Referential;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.SocialModule;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import static fr.infodb.exemples.portail.rest.serveur.helpers.RestUriHelper.*;

/**
 * Web services REST exposés
 */
@RestController
@RequestMapping(value = "/portail/spi")
@Api(tags = "InfoDB, services rest Portail Agent", value = "Concernant la gestion des erreurs : les conventions classiques REST sont appliquées, côté client seules les erreurs 404 seront remontées de façon différente.")
public class RestServerController implements DataProvider {

    //fournisseur de données
    private final DataProvider dataProvider;

    @Autowired
    public RestServerController(@Qualifier("StubDataProvider") DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * Authentifier un utilisateur.
     *
     * @return Résultat de l'authentification (enum correspondant aux différents statuts possibles).
     * @see AuthenticationResult
     */
    @PostMapping(RESTURL_AUTHENTICATE)
    @ApiOperation("Authentifier un utilisateur.")
    public AuthenticationResult authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return dataProvider.authenticate(authenticationRequest);
    }

    /**
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @GetMapping(RESTURL_FIND_ALL_INDIVIDUALS)
    @ApiOperation("Récupérer tous les individus. Cette méthode est utilisée dans le cadre de la reprise de données.")
    public PaginationIndividus findAllIndividuals(
            @RequestParam(QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllIndividuals(pageSize, pageNumber);
    }

    /**
     * Récupérer tous les travailleurs sociaux.
     * <p>
     * Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @GetMapping(RESTURL_FIND_ALL_SOCIAL_WORKERS)
    @ApiOperation("Récupérer tous les travailleurs sociaux. Cette méthode est utilisée dans le cadre de la reprise de données.")
    public PaginationIntervenantsSociaux findAllSocialWorkers(
            @RequestParam(QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllSocialWorkers(pageSize, pageNumber);
    }

    /**
     * Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     * Les requêtes se font de manière paginée.
     * Attention, cela implique que la recherche doit être ordonnée côté serveur.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @GetMapping(RESTURL_FIND_ALL_USER)
    @ApiOperation("Récupérer tous les utilisateurs. Cette méthode est utilisée dans le cadre de la reprise de données.")
    public PaginationUtilisateurs findAllUser(
            @RequestParam(QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllUser(pageSize, pageNumber);
    }

    /**
     * Récupérer un bénéficiaire à partir de son id.
     *
     * @param individuId Identifiant du bénéficiaire.
     * @return Un objet SocialExtBeneficiary.
     */
    @GetMapping(RESTURL_GET_BENEFICIARY)
    @ApiOperation("Récupérer un bénéficiaire à partir de son id.")
    public Individu findBeneficiary(
            @PathVariable(PATHPARAM_BENEFICIARYID) String individuId) {
        return dataProvider.findBeneficiary(individuId);
    }

    /**
     * Récupérer un utilisateur à partir de son id.
     *
     * @param userId Id de l'utilisateur.
     * @return Un objet SocialExtUser correspondant à l'utilisateur recherché.
     */
    @GetMapping(RESTURL_GET_SOCIAL_EXT_USER)
    @ApiOperation("Récupérer un utilisateur à partir de son id.")
    public Utilisateur findSocialExtUser(
            @PathVariable(PATHPARAM_USERID) String userId) {
        return dataProvider.findSocialExtUser(userId);
    }

    /**
     * Récupérer un intervenant social à partir de son id.
     *
     * @param externalId Id de l'intervenant social.
     * @return Un objet SocialExtWorker correspondant à l'intervenant social recherché.
     */
    @GetMapping(RESTURL_GET_SOCIAL_WORKER)
    @ApiOperation("Récupérer un intervenant social à partir de son id.")
    public IntervenantSocial findSocialWorker(@PathVariable(PATHPARAM_SOCIALWORKERID) String externalId) {
        return dataProvider.findSocialWorker(externalId);
    }

    /**
     * Rechercher les message à afficher sur la page d'authentification.
     *
     * @return Une liste de messages.
     */
    @GetMapping(RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES)
    @ApiOperation("Rechercher les message à afficher sur la page d'authentification.")
    public LoginHomepageMessages getAllLoginHomepageMessages() {
        return dataProvider.getAllLoginHomepageMessages();
    }

    /**
     * Retourner les profils d'un utilisateur si l'id de l'utilisateur est renseigné.
     * <p>
     * Si l'id n'est pas renseigné, retourner la liste de tous les profils.
     *
     * @return profils.
     */
    @GetMapping(RESTURL_GET_PROFILES)
    @ApiOperation("Retourner tous les profils utilisateurs.")
    public Profiles getAvailableProfiles() {
        return dataProvider.getAvailableProfiles();
    }

    /**
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     * @see SocialModule
     */
    @GetMapping(RESTURL_GET_SOCIAL_MODULES)
    @ApiOperation("Retourner les modules métiers disponibles sur l'application.")
    public SocialModules getAvailableSocialModules() {
        return dataProvider.getAvailableSocialModules();
    }

    /**
     * Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.
     *
     * @return Un Set de SocialModule.
     */
    @GetMapping(RESTURL_GET_SOCIAL_MODULES_FOR_LIFE_LINE)
    @ApiOperation("Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.")
    public SocialModules getAvailableSocialModulesForLifeLine() {
        return dataProvider.getAvailableSocialModulesForLifeLine();
    }

    /**
     * Retourner le dossier d'un bénéficiaire.
     *
     * @param userId     Id de l'utilisateur du portail à l'origine de cet appel
     * @param individuId Id du bénéficiaire recherché.
     * @return Un objet socialExtBeneficiary contenant le détail du bénéficiaire.
     */
    @GetMapping(RESTURL_GET_FILE_RECORD)
    @ApiOperation("Retourner le dossier d'un bénéficiaire.")
    public DossierBeneficiaire getFileRecord(
            @RequestHeader(HEADERNAME_USERID) String userId,
            @PathVariable(PATHPARAM_BENEFICIARYID) String individuId)
            throws SocialExtException {
        return dataProvider.getFileRecord(userId, individuId);
    }

    /**
     * Récupérer tous les rendez-vous d'individu.
     *
     * @param individuId Identifiant de l'individu
     * @return Représentation des rendez vous d'un individu.
     */
    @GetMapping(RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS)
    @ApiOperation("Rechercher dans les rendez-vous des individus.")
    public ListeRendezVous getIndividualRendezVous(
            @PathVariable(PATHPARAM_BENEFICIARYID) String individuId) {
        return dataProvider.getIndividualRendezVous(individuId);
    }

    /**
     * Récupère l'identifiant d'un module pour un individu en fonction du nom du module et du type d'identifiant.
     * <p>
     * Chaque module métier peut avoir un ou plusieurs identifiants spécifiques pour un même individu.
     * <p>
     * Notion de référence dossier.
     *
     * @param individuId   id de l'individu demandé
     * @param socialModule le SocialModule concerné
     * @param moduleIdType le type d'identifiant voulu
     * @return Référence du dossier métier
     */
    @GetMapping(RESTURL_GET_MODULE_IDENTIFIER)
    @ApiOperation("Récupérer la référence du dossier.")
    public StringWrapperDTO getModuleIdentifier(
            @PathVariable(PATHPARAM_SOCIALMODULE) SocialModule socialModule,
            @RequestParam(QUERYPARAM_MODULEIDTYPE) ModuleIdentifierType moduleIdType,
            @RequestParam(QUERYPARAM_INDIVIDUALID) String individuId) {
        return dataProvider.getModuleIdentifier(socialModule, moduleIdType, individuId);
    }

    /**
     * Récupérer les tâches à accomplir par un travailleur social
     *
     * @param socialWorkerId Id du travailleur social concerné.
     * @return Représentation des tâches à accomplir par un travailleur social
     */
    @GetMapping(RESTURL_GET_NEWS)
    @ApiOperation("Récupérer les news relatives à un travailleur social.")
    public TachesUtilisateur getNews(@RequestParam(QUERYPARAM_SWUSERID) String socialWorkerId) {
        return dataProvider.getNews(socialWorkerId);
    }

    /**
     * Retourner les profils d'un utilisateur si l'id de l'utilisateur est renseigné.
     *
     * @param userId id de l'utilisateur
     * @return profils
     */
    @GetMapping(RESTURL_GET_PROFILES + "/{" + PATHPARAM_USERID + "}")
    @ApiOperation("Retourner les profils d'un utilisateur.")
    public Profiles getProfiles(@PathVariable(value = PATHPARAM_USERID) String userId) {
        return dataProvider.getProfiles(userId);
    }

    /**
     * Récupérer les données d'un référentiel (nomenclature).
     *
     * @param referential Enum correspondant au type de référentiel voulu.
     * @return Un objet ReferentialDTO qui contient les valeurs du référentiel. Ce DTO contient une liste de ReferentialEntryDTO.
     * @see Referential
     */
    @GetMapping(RESTURL_GET_REFERENTIAL)
    @ApiOperation("Récupérer les données d'un référentiel (nomenclature).")
    public ReferentialDTO getReferential(
            @PathVariable(PATHPARAM_REFERENTIAL) String referential)
            throws SocialExtException {
        return dataProvider.getReferential(referential);
    }

    /**
     * Récupérer les aides liées à un bénéficiaire.
     *
     * @param userId     Id du SocialExtUser à l'origine de l'appel
     * @param individuId Id du bénéficiaire.
     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
     */
    @GetMapping(RESTURL_GET_SOCIAL_FILE_MEASURES)
    @ApiOperation("Récupérer les aides liées à un bénéficiaire.")
    public MesuresSociales getSocialFileMeasures(
            @RequestHeader(HEADERNAME_USERID) String userId,
            @PathVariable(PATHPARAM_BENEFICIARYID) String individuId) {
        return dataProvider.getSocialFileMeasures(userId, individuId);
    }

    /**
     * Rechercher dans les rendez-vous des travailleurs sociaux.
     *
     * @param userId         Id de l'utilisateur portail à l'origine de l'appel
     * @param socialWorkerId Id du travailleur social
     * @param startDate      Date de début de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @param endDate        Date de fin de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @return Un Set de SocialExtRendezVous.
     */
    @GetMapping(RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS)
    @ApiOperation("Rechercher dans les rendez-vous des travailleurs sociaux.")
    public ListeRendezVous getSocialWorkerRendezVous(
            @RequestHeader(HEADERNAME_USERID) String userId,
            @PathVariable(PATHPARAM_SOCIALWORKERID) String socialWorkerId,
            @RequestParam(QUERYPARAM_DATEDEBUT) String startDate,
            @RequestParam(QUERYPARAM_DATEFIN) String endDate) {
        return dataProvider.getSocialWorkerRendezVous(userId, socialWorkerId, startDate, endDate);
    }

    /**
     * Rechercher tous les individus correspondant aux critères reçus
     *
     * @param rechercheIndividusRequest Critères pour filtrer les individus
     * @return Représentation des individus trouvés
     */
    @PostMapping(RESTURL_SEARCH_INDIVIDUALS)
    @ApiOperation("Rechercher des individus sur critères simples (pas de recherche avancée).")
    public PaginationIndividus searchIndividuals(@RequestBody RechercheIndividusRequest rechercheIndividusRequest) {
        return dataProvider.searchIndividuals(rechercheIndividusRequest);
    }
}
