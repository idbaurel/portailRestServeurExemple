package fr.infodb.exemples.portail.rest.serveur.controller;

import fr.infodb.exemples.portail.rest.serveur.api.RestSocialExtDataProvider;
import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.dto2.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;
import fr.infodb.exemples.portail.rest.serveur.services.DataProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static fr.infodb.exemples.portail.rest.serveur.helpers.RestUriHelper.*;

/**
 * Web services REST exposés
 */
@RestController
@RequestMapping(value = "/portail/spi")
@Api(tags = "InfoDB, services rest Portail Agent", value = "Concernant la gestion des erreurs : les conventions classiques REST sont appliquées, côté client seules les erreurs 404 seront remontées de façon différente.")
public class RestServerController implements RestSocialExtDataProvider {

    //fournisseur de données
    private final DataProvider dataProvider;

    @Autowired
    public RestServerController(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * done
     * Rechercher les message à afficher sur la page d'authentification.
     *
     * @return Une liste de messages.
     */
    @GetMapping(RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES)
    @ApiOperation("Rechercher les message à afficher sur la page d'authentification. [FAIT]")
    public LoginHomepageMessages getAllLoginHomepageMessages() {
        return dataProvider.getAllLoginHomepageMessages();
    }

    /**
     * done
     * Authentifier un utilisateur.
     *
     * @return Résultat de l'authentification (enum correspondant aux différents statuts possibles).
     * @see AuthenticationResult
     */
    @PostMapping(RESTURL_AUTHENTICATE)
    @ApiOperation("Authentifier un utilisateur. [FAIT]")
    public AuthenticationResult authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return dataProvider.authenticate(authenticationRequest);
    }

    /**
     * done
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     * @see SocialModule
     */
    @GetMapping(RESTURL_GET_SOCIAL_MODULES)
    @ApiOperation("Retourner les modules métiers disponibles sur l'application. [FAIT]")
    public SocialModules getAvailableSocialModules() {
        return dataProvider.getAvailableSocialModules();
    }

    /**
     * done
     * Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.
     *
     * @return Un Set de SocialModule.
     */
    @GetMapping(RESTURL_GET_SOCIAL_MODULES_FOR_LIFE_LINE)
    @ApiOperation("Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie. [FAIT]")
    public SocialModules getAvailableSocialModulesForLifeLine() {
        return dataProvider.getAvailableSocialModulesForLifeLine();
    }

    /**
     * done
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @GetMapping(RESTURL_FIND_ALL_INDIVIDUALS)
    @ApiOperation("Récupérer tous les individus. Cette méthode est utilisée dans le cadre de la reprise de données. [FAIT]")
    public PaginationIndividus findAllIndividuals(
            @RequestParam(QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllIndividuals(pageSize, pageNumber);
    }

    /**
     * done
     * Récupérer tous les travailleurs sociaux.
     * <p>
     * Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @GetMapping(RESTURL_FIND_ALL_SOCIAL_WORKERS)
    @ApiOperation("Récupérer tous les travailleurs sociaux. Cette méthode est utilisée dans le cadre de la reprise de données. [FAIT]")
    public PaginationIntervenantsSociaux findAllSocialWorkers(
            @RequestParam(QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllSocialWorkers(pageSize, pageNumber);
    }

    /**
     * done
     * Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     * Les requêtes se font de manière paginée.
     * Attention, cela implique que la recherche doit être ordonnée côté serveur.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @GetMapping(RESTURL_FIND_ALL_USER)
    @ApiOperation("Récupérer tous les utilisateurs. Cette méthode est utilisée dans le cadre de la reprise de données. [FAIT]")
    public PaginationUtilisateurs findAllUser(
            @RequestParam(QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllUser(pageSize, pageNumber);
    }

    /**
     * done
     * Récupérer un intervenant social à partir de son id.
     *
     * @param externalId Id de l'intervenant social.
     * @return Un objet SocialExtWorker correspondant à l'intervenant social recherché.
     */
    @GetMapping(RESTURL_FIND_SOCIAL_WORKER)
    @ApiOperation("Récupérer un intervenant social à partir de son id. [FAIT]")
    public IntervenantSocial findSocialWorker(@PathVariable(PATHPARAM_SOCIALWORKERID) String externalId) {
        return dataProvider.findSocialWorker(externalId);
    }

    /**
     * done
     * Retourner les profils d'un utilisateur si l'id de l'utilisateur est renseigné.
     * <p>
     * Si l'id n'est pas renseigné, retourner la liste de tous les profils.
     *
     * @return profils.
     */
    @GetMapping(RESTURL_GET_PROFILES)
    @ApiOperation("Retourner tous les profils utilisateurs. [FAIT]")
    public Profiles getProfiles() {
        return dataProvider.getAvailableProfiles();
    }

    /**
     * done
     * Retourner les profils d'un utilisateur si l'id de l'utilisateur est renseigné.
     *
     * @param userId id de l'utilisateur
     * @return profils
     */
    @GetMapping(RESTURL_GET_PROFILES + "/{" + PATHPARAM_USERID + "}")
    @ApiOperation("Retourner les profils d'un utilisateur. [FAIT]")
    public Profiles getProfiles(@PathVariable(value = PATHPARAM_USERID) String userId) {
        return dataProvider.getProfiles(userId);
    }

    /**
     * done
     * Rechercher dans les rendez-vous des travailleurs sociaux.
     *
     * @param userId         Id de l'utilisateur portail à l'origine de l'appel
     * @param socialWorkerId Id du travailleur social
     * @param startDate      Date de début de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @param endDate        Date de fin de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @return Un Set de SocialExtRendezVous.
     */
    @GetMapping(RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS)
    @ApiOperation("Rechercher dans les rendez-vous des travailleurs sociaux. [FAIT]")
    public ListeRendezVous getSocialWorkerRendezVous(
            @RequestHeader(HEADERNAME_USERID) String userId,
            @PathVariable(PATHPARAM_SOCIALWORKERID) String socialWorkerId,
            @RequestParam(QUERYPARAM_DATEDEBUT) String startDate,
            @RequestParam(QUERYPARAM_DATEFIN) String endDate) {
        return dataProvider.getSocialWorkerRendezVous(userId, socialWorkerId, startDate, endDate);
    }

    /**
     * done
     * Rechercher tous les individus correspondant aux critères reçus
     *
     * @param rechercheIndividusRequest Critères pour filtrer les individus
     * @return Représentation des individus trouvés
     */
    @PostMapping(RESTURL_SEARCH_INDIVIDUALS)
    @ApiOperation("Rechercher des individus sur critères simples (pas de recherche avancée). [FAIT]")
    public PaginationIndividus searchIndividuals(@RequestBody RechercheIndividusRequest rechercheIndividusRequest) {
        return dataProvider.findAllIndividuals(rechercheIndividusRequest);
    }

    //-----------------A FAIRE------------------------------------------

    /**
     * Récupérer la référence du dossier.
     *
     * @param userId       Id du user portail à l'origine de l'appel
     * @param socialModule SocialModule concerné.
     * @param moduleIdType Type d'identifiant.
     * @return Référence du dossier.
     */
    @GetMapping(RESTURL_GET_MODULE_IDENTIFIER)
    @ApiOperation("Récupérer la référence du dossier.")
    public StringWrapperDTO getModuleIdentifier(
            @RequestHeader(HEADERNAME_USERID) String userId,
            @PathVariable(PATHPARAM_SOCIALMODULE) SocialModule socialModule,
            @RequestParam(QUERYPARAM_MODULEIDTYPE) ModuleIdentifierType moduleIdType) {
        return new StringWrapperDTO(dataProvider.getModuleIdentifier(socialModule, moduleIdType, userId));
    }

    /**
     * Retourner le dossier d'un bénéficiaire.
     *
     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
     * @param index  Id du bénéficiaire recherché.
     * @return Un objet socialExtBeneficiary contenant le détail du bénéficiaire.
     */
//    @GetMapping(RESTURL_GET_FILE_RECORD)
//    @ApiOperation("Retourne le dossier d'un bénéficiaire.")
//    public SocialExtBeneficiary getFileRecord(
//            @RequestHeader(HEADERNAME_USERID) String userId,
//            @PathVariable(PATHPARAM_BENEFICIARYID) String index)
//            throws SocialExtException {
//        return dataProvider.getFileRecord(userId, index);
//    }

    @GetMapping(RESTURL_GET_FILE_RECORD)
    @ApiOperation("Retourner le dossier d'un bénéficiaire.")
    public DossierBeneficiaire getFileRecord(
            @RequestHeader(HEADERNAME_USERID) String userId,
            @PathVariable(PATHPARAM_BENEFICIARYID) String index)
            throws SocialExtException {
        return dataProvider.getFileRecord(userId, index);
    }

    /**
     * Récupérer la synthèse d'un individu.
     *
     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
     * @param index  Id du bénéficiaire recherché
     * @return Un SocialExtBeneficiary, contenant le détail du bénéficiaire.
     */
    @GetMapping(RESTURL_GET_INDIVIDUAL_SYNTHESIS)
    @ApiOperation("Récupérer la synthèse d'un individu.")
    public SocialExtBeneficiary getIndividualSynthesis(
            @RequestHeader(HEADERNAME_USERID) String userId,
            @PathVariable(PATHPARAM_BENEFICIARYID) String index) {
        return dataProvider.getIndividualSynthesis(userId, index);
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
     * Retourner un lien de débranchement vers un écran d'une application externe indépendant d'un module social.
     *
     * @param token    Token d'authentification
     * @param linkType Type de lien pour débranchement
     * @return Le lien http.
     * @see SolisLinkType
     */
    @GetMapping(RESTURL_GET_LINK)
    @ApiOperation("Retourner un lien de débranchement vers un écran d'une application externe indépendant d'un module social.")
    public StringWrapperDTO getLink(
            @RequestHeader(HEADERNAME_AUTH_TOKEN) String token,
            @PathVariable(PATHPARAM_LINKTYPE) String linkType) throws SocialExtException {
        return new StringWrapperDTO(dataProvider.getLink(SolisLinkType.valueOf(linkType), token, null));
    }

//    /**
//     * Récupérer les aides liées à un bénéficiaire.
//     *
//     * @param userId        Id du SocialExtUser à l'origine de l'appel
//     * @param beneficiaryId Id du bénéficiaire.
//     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
//     */
//    @GetMapping(RESTURL_GET_SOCIAL_FILE_MEASURES)
//    @ApiOperation("Récupérer les aides liées à un bénéficiaire.")
//    public SocialExtBeneficiary getSocialFileMeasures(
//            @RequestHeader(HEADERNAME_USERID) String userId,
//            @PathVariable(PATHPARAM_BENEFICIARYID) String beneficiaryId) {
//        return dataProvider.getSocialFileMeasures(userId, beneficiaryId);
//    }
    /**
     * Récupérer les aides liées à un bénéficiaire.
     *
     * @param userId        Id du SocialExtUser à l'origine de l'appel
     * @param beneficiaryId Id du bénéficiaire.
     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
     */
    @GetMapping(RESTURL_GET_SOCIAL_FILE_MEASURES)
    @ApiOperation("Récupérer les aides liées à un bénéficiaire.")
    public MesuresSociales getSocialFileMeasures(
            @RequestHeader(HEADERNAME_USERID) String userId,
            @PathVariable(PATHPARAM_BENEFICIARYID) String beneficiaryId) {
        return dataProvider.getSocialFileMeasures(userId, beneficiaryId);
    }

    /**
     * Crée un individu.
     *
     * @param beneficiary Données de l'individu à créer.
     * @return L'id de l'individu créé.
     * @see SocialExtBeneficiary
     */
    @PostMapping(RESTURL_CREATE_INDIVIDUAL)
    @ApiOperation("Créer un individu.")
    public StringWrapperDTO createIndividuals(@RequestBody SocialExtBeneficiary beneficiary) throws SocialExtException {
        return new StringWrapperDTO(dataProvider.createIndividuals(beneficiary));
    }

    /**
     * Modifier un individu.
     *
     * @param beneficiary Paramètres de l'individu à modifier.
     * @see SocialExtBeneficiary
     */
    @PutMapping(RESTURL_UPDATE_INDIVIDUAL)
    @ApiOperation("Modifier un individu.")
    public void updateIndividual(@RequestBody SocialExtBeneficiary beneficiary) {
        dataProvider.updateIndividual(beneficiary);
    }

    /**
     * Retourner un ensemble de lieux en fonction d'un type donné.
     *
     * @param type Type de lieu
     * @return Les lieux correspondant au type de lieu donné.
     * @see SocialExtPlaceType
     */
    @GetMapping(RESTURL_GET_PLACES_BY_TYPE)
    @ApiOperation("Retourner un ensemble de lieux en fonction d'un type donné.")
    public Set<SocialExtPlace> getPlacesByType(
            @RequestParam(QUERYPARAM_PLACETYPE) SocialExtPlaceType type) {
        return dataProvider.getPlacesByType(type);
    }

    /**
     * Retourner la circonscription liée à un lieu.
     *
     * @param placeId Identifiant du lieu.
     * @return Un wrapper de String, contenant la circonscription.
     */
    @GetMapping(RESTURL_GET_CIRCO)
    @ApiOperation("Retourner la circonscription liée à un lieu.")
    public StringWrapperDTO getCirco(@PathVariable(PATHPARAM_PLACEID) String placeId) {
        return new StringWrapperDTO(dataProvider.getCirco(placeId));
    }

    /**
     * Retourner pour une commune une liste de lieux correspondant à une portion de nom donnée.
     *
     * @param municipalityId Id de la commune.
     * @param token          Portion du nom du lieu.
     * @return Liste de lieux dont le nom contient la portion donnée.
     */
    @GetMapping(RESTURL_SUGGEST_PLACES)
    @ApiOperation("Retourner une liste de lieux correspondant à une portion de nom donnée.")
    public List<SocialExtPlace> suggestPlaces(
            @PathVariable(PATHPARAM_MUNICIPALITYID) String municipalityId,
            @RequestParam(QUERYPARAM_SUGGESTTOKEN) String token) {
        return dataProvider.suggestPlaces(token, municipalityId);
    }

    /**
     * Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités.
     *
     * @param token Contient les premiers caractères de la municipalité.
     * @return Liste de SocialExtMunicipalities.
     */
    @GetMapping(RESTURL_SUGGEST_MUNICIPALITIES)
    @ApiOperation("Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités.")
    public List<SocialExtMunicipality> suggestMunicipalities(@RequestParam(QUERYPARAM_SUGGESTTOKEN) String token) {
        return dataProvider.suggestMunicipalities(token);
    }

    /**
     * Récupérer les liens de débranchement vers les écrans de l'application externe.
     *
     * @param token        Token d'authentification.
     * @param screens      Ensemble d'écrans.
     * @param userId       Id de l'utilisateur du portail.
     * @param individualId Id de l'individu concerné.
     * @return Une Map avec en clé une enum correspondant aux écrans et en valeur une String contenant le lien.
     * @see SocialModuleScreen
     */
    @GetMapping(RESTURL_GET_LINKS)
    @ApiOperation("Récupérer les liens de débranchement vers les écrans de l'application externe.")
    public Map<SocialModuleScreen, String> getLinks(
            @RequestHeader(HEADERNAME_AUTH_TOKEN) String token,
            @RequestParam(QUERYPARAM_SCREEN) Set<SocialModuleScreen> screens,
            @RequestParam(QUERYPARAM_USERID) String userId,
            @RequestParam(QUERYPARAM_INDIVIDUALID) String individualId) {
        return dataProvider.getLinks(screens, userId, individualId, token);
    }

    /**
     * Récupérer les liens vers les pages d'accueil des modules sociaux.
     *
     * @param token   Token d'authentification.
     * @param userId  Id de l'utilisateur du portail.
     * @param modules Ensemble de modules.
     * @return Une Map avec en clé une enum correspondant aux modules et en valeur une String contenant le lien.
     * @see SocialModule
     */
    @GetMapping(RESTURL_GET_HOME_PAGES)
    @ApiOperation("Récupérer les liens vers les pages d'accueil des modules sociaux.")
    public Map<SocialModule, String> getHomePages(
            @RequestHeader(HEADERNAME_AUTH_TOKEN) String token,
            @RequestParam(QUERYPARAM_USERID) String userId,
            @RequestParam(QUERYPARAM_SOCIALMODULE) Set<SocialModule> modules) {
        return dataProvider.getHomePages(modules, userId, token);
    }

    /**
     * Récupérer un bénéficiaire à partir de son id.
     *
     * @param externalId Identifiant du bénéficiaire.
     * @return Un objet SocialExtBeneficiary.
     */
    @GetMapping(RESTURL_FIND_BENEFICIARY)
    @ApiOperation("Récupérer un bénéficiaire à partir de son id.")
    public SocialExtBeneficiary findBeneficiary(
            @PathVariable(PATHPARAM_BENEFICIARYID) String externalId) {
        return dataProvider.findBeneficiary(externalId);
    }

    /**
     * Récupérer un utilisateur à partir de son id.
     *
     * @param externalId Id de l'utilisateur.
     * @return Un objet SocialExtUser correspondant à l'utilisateur recherché.
     */
    @GetMapping(RESTURL_FIND_SOCIAL_EXT_USER)
    @ApiOperation("Récupérer un utilisateur à partir de son id.")
    public SocialExtUser findSocialExtUser(
            @PathVariable(PATHPARAM_USERID) String externalId) {
        return dataProvider.findSocialExtUser(externalId);
    }

    /**
     * Récupérer les news relatives à un travailleur social.
     *
     * @param userId Id du travailleur social concerné.
     * @return Un objet NewsList, qui contient une liste de News. L'objet News contient une date et une liste de lignes de contenu (type String).
     */
    @GetMapping(RESTURL_GET_NEWS)
    @ApiOperation("Récupérer les news relatives à un travailleur social.")
    public NewsList getNews(@RequestParam(QUERYPARAM_SWUSERID) String userId) {
        return dataProvider.getNews(userId);
    }

//    /**
//     * Obtenir un token de sécurité pour les redirections (débranchement).
//     *
//     * @param updto Wrapper autour d'un SocialExtUSer (habilitation) et une map de paramètres.
//     * @return Wrapper de String, token de redirection.
//     */
//    @PostMapping(RESTURL_GET_REDIRECTION_TOKEN)
//    @ApiOperation("Obtenir un token de sécurité pour les redirections (débranchement).")
//    public StringWrapperDTO getRedirectionToken(UserAndParamsDTO updto) {
//        return new StringWrapperDTO(dataProvider.getRedirectionToken(updto));
//    }

    /**done
     * Récupérer tous les rendez-vous d'individu.
     *
     * @param externalId Identifiant de l'individu
     * @return Représentation des rendez vous d'un individu.
     */
    @GetMapping(RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS)
    @ApiOperation("Rechercher dans les rendez-vous des individus.")
    public ListeRendezVous getIndividualRendezVous(
            @PathVariable(PATHPARAM_BENEFICIARYID) String externalId) {
        return dataProvider.getIndividualRendezVous(externalId);
    }

    /**
     * Créer un rendez-vous pour un intervenant social.
     *
     * @param rendezVous Paramètres du rendez-vous (date, travailleurs sociaux, etc...)
     * @return L'id du rendez-vous créé.
     * @see SocialExtRendezVous
     */
    @PostMapping(RESTURL_CREATE_SOCIAL_WORKER_RENDEZ_VOUS)
    @ApiOperation("Créer un rendez-vous pour un intervenant social.")
    public StringWrapperDTO createSocialWorkerRendezVous(SocialExtRendezVous rendezVous) {
        return new StringWrapperDTO(dataProvider.createSocialWorkerRendezVous(rendezVous));
    }

    /**
     * Retourner, pour l'utilisateur spécifié, le nombre d'évènements en attente de traitement issus du SIRH.
     *
     * @param userId Identifiant de l'utilisateur
     * @return Le nombre d'évènements.
     */
    @GetMapping(RESTURL_GET_NUMBER_SIRH_EVENTS)
    @ApiOperation("Retourner, pour l'utilisateur spécifié, le nombre d'évènements en attente de traitement issus du SIRH.")
    public Long getNumberSirhEvents(@ApiParam("Identifiant de l'utilisateur") @PathVariable(PATHPARAM_USERID) String userId) {
        return dataProvider.getNumberSirhEvents(userId);
    }

    /**
     * Rechercher les offres de service pour un individu.
     *
     * @param individualId Clé de l'individu
     * @return Une liste d'offres de service.
     */
    @GetMapping(RESTURL_GET_BUSINESS_OFFERS)
    @ApiOperation("Rechercher les offres de service pour un individu.")
    public List<BusinessOffer> getBusinessOffers(
            @ApiParam("Clé de l'individu") @PathVariable(PATHPARAM_BENEFICIARYID) String individualId) {
        return dataProvider.getBusinessOffers(individualId);
    }
}
