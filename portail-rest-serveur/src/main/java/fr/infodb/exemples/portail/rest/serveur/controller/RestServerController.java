package fr.infodb.exemples.portail.rest.serveur.controller;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;
import fr.infodb.exemples.portail.rest.serveur.services.DataProvider;
import fr.infodb.exemples.portail.rest.serveur.helpers.RestDataProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Web services REST exposés
 */
@RestController
@RequestMapping(value = "/portail/spi" /*, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}*/)
@Api(tags = "InfoDB, services rest Portail Agent", value = "Concernant la gestion des erreurs : les conventions classiques REST sont appliquées, côté client seules les erreurs 404 seront remontées de façon différente.")
public class RestServerController /*implements RestSocialExtDataProvider*/ {

    //fournisseur de données
    private final DataProvider dataProvider;

    @Autowired
    public RestServerController(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * Retourner, pour l'utilisateur spécifié, le nombre d'évènements en attente de traitement issus du SIRH.
     *
     * @param userId Identifiant de l'utilisateur
     * @return Le nombre d'évènements.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_NUMBER_SIRH_EVENTS)
    @ApiOperation("Retourner, pour l'utilisateur spécifié, le nombre d'évènements en attente de traitement issus du SIRH.")
    public Long getNumberSirhEvents(@ApiParam("Identifiant de l'utilisateur") @PathVariable("userId") String userId) {
        return dataProvider.getNumberSirhEvents(userId);
    }

    /**
     * Rechercher les offres de service pour un individu.
     *
     * @param individualId Clé de l'individu
     * @return Une liste d'offres de service.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_BUSINESS_OFFERS)
    @ApiOperation("Rechercher les offres de service pour un individu.")
    public List<BusinessOffer> getBusinessOffers(
            @ApiParam("Clé de l'individu") @PathVariable(RestDataProvider.PATHPARAM_BENEFICIARYID) String individualId) {
        return dataProvider.getBusinessOffers(individualId);
    }

    /**
     * Rechercher les message à afficher sur la page d'authentification.
     *
     * @return Une liste de messages.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES)
    @ApiOperation("Rechercher les message à afficher sur la page d'authentification.")
    public List<LoginHomepageMessage> getAllLoginHomepageMessages() {
        return dataProvider.getAllLoginHomepageMessages();
    }

    /**
     * Récupère la référence du dossier.
     *
     * @param userId       Id du user portail à l'origine de l'appel
     * @param socialModule SocialModule concerné.
     * @param moduleIdType Type d'identifiant.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_MODULE_IDENTIFIER)
    @ApiOperation("Récupère la référence du dossier.")

    public StringWrapperDTO getModuleIdentifier(
            @RequestHeader(RestDataProvider.HEADERNAME_USERID) String userId,
            @PathVariable(RestDataProvider.PATHPARAM_SOCIALMODULE) SocialModule socialModule,
            @RequestParam(RestDataProvider.QUERYPARAM_MODULEIDTYPE) ModuleIdentifierType moduleIdType) {

        return new StringWrapperDTO(dataProvider.getModuleIdentifier(socialModule, moduleIdType, userId));
    }

    /**
     * Retourne le dossier d'un bénéficiaire.
     *
     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
     * @param index  Id du bénéficiaire recherché.
     * @return Un objet socialExtBeneficiary contenant le détail du bénéficiaire.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_FILE_RECORD)
    @ApiOperation("Retourne le dossier d'un bénéficiaire.")
    public SocialExtBeneficiary getFileRecord(
            @RequestHeader(RestDataProvider.HEADERNAME_USERID) String userId,
            @PathVariable(RestDataProvider.PATHPARAM_BENEFICIARYID) String index)
            throws SocialExtException {
        return dataProvider.getFileRecord(new SocialExtUser("User" + userId), index);
    }

    /**
     * Récupère la synthèse d'un individu.
     *
     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
     * @param index  Id du bénéficiaire recherché
     * @return Un SocialExtBeneficiary, contenant le détail du bénéficiaire.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_INDIVIDUAL_SYNTHESIS)
    @ApiOperation("Récupérer la synthèse d'un individu.")
    public SocialExtBeneficiary getIndividualSynthesis(
            @RequestHeader(RestDataProvider.HEADERNAME_USERID) String userId,
            @PathVariable(RestDataProvider.PATHPARAM_BENEFICIARYID) String index) {
        return dataProvider.getIndividualSynthesis(new SocialExtUser("User" + userId), index);
    }

    /**
     * Récupération des valeurs d'un référentiel (nomenclature).
     *
     * @param referential Enum correspondant au type de référentiel voulu.
     * @param userId      Id du user à l'origine de l'appel
     * @return Un objet ReferentialDTO qui contient les valeurs du référentiel. Ce DTO contient une liste de ReferentialEntryDTO.
     * @see Referential
     */
    @GetMapping(RestDataProvider.RESTURL_GET_REFERENTIAL)
    @ApiOperation("Récupérer les données d'un référentiel (nomenclature).")
    public ReferentialDTO getReferential(
            @PathVariable(RestDataProvider.PATHPARAM_REFERENTIAL) String referential,
            @RequestHeader(RestDataProvider.HEADERNAME_USERID) String userId)
            throws SocialExtException {
        return dataProvider.getReferential(referential, userId);
    }

    /**
     * Retourne un lien de débranchement vers un écran SOLIS indépendant d'un module social.
     *
     * @param token    Token d'authentification
     * @param linkType Type de lien pour débranchement
     * @return Le lien http.
     * @see SolisLinkType
     */
    @GetMapping(RestDataProvider.RESTURL_GET_LINK)
    @ApiOperation("Retourner un lien de débranchement vers un écran SOLIS indépendant d'un module social.")
    public StringWrapperDTO getLink(
            @RequestHeader(RestDataProvider.HEADERNAME_AUTH_TOKEN) String token,
            @PathVariable(RestDataProvider.PATHPARAM_LINKTYPE) String linkType) throws SocialExtException {
        return new StringWrapperDTO(dataProvider.getLink(SolisLinkType.valueOf(linkType), token, null));
    }

    /**
     * Récupérer les aides liées à un bénéficiaire.
     *
     * @param userId        Id du SocialExtUser à l'origine de l'appel
     * @param beneficiaryId Id du bénéficiaire.
     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_SOCIAL_FILE_MEASURES)
    @ApiOperation("Récupérer les aides liées à un bénéficiaire.")
    public SocialExtBeneficiary getSocialFileMeasures(
            @RequestHeader(RestDataProvider.HEADERNAME_USERID) String userId,
            @PathVariable(RestDataProvider.PATHPARAM_BENEFICIARYID) String beneficiaryId) {
        return dataProvider.getSocialFileMeasures(userId, beneficiaryId);
    }

    /**
     * Crée un individu.
     *
     * @param beneficiary Données de l'individu à créer.
     * @return L'id de l'individu créé.
     * @see SocialExtBeneficiary
     */
    @PostMapping(RestDataProvider.RESTURL_CREATE_INDIVIDUAL)
    @ApiOperation("Créer un individu.")
    public StringWrapperDTO createIndividuals(@RequestBody SocialExtBeneficiary beneficiary) throws SocialExtException {
        return new StringWrapperDTO(dataProvider.createIndividuals(beneficiary));
    }

    /**
     * Modifier un individu.
     *
     * @param beneficiary Paramètres de l'individu à modifier.
     */
    @PutMapping(RestDataProvider.RESTURL_UPDATE_INDIVIDUAL)
    @ApiOperation("Modifier un individu.")
    public void updateIndividual(@RequestBody SocialExtBeneficiary beneficiary) {
        dataProvider.updateIndividual(beneficiary);
    }

    /**
     * Retourner les profils d'un utilisateur si l'id de l'utilisateur est renseigné.
     * <p>
     * Si l'id n'est pas renseigné, retourner la liste de tous les profils.
     *
     * @param userId Id de l'utilisateur.
     * @return Un Set de String correspondant aux profils.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_PROFILES)
    @ApiOperation("Retourner les profils d'un utilisateur si l'id de l'utilisateur est renseigné. Si l'id n'est pas renseigné, retourner la liste de tous les profils.")

    public Set<String> getProfiles(@RequestParam(value = RestDataProvider.QUERYPARAM_USERID, required = false) String userId) {
        return userId == null ? dataProvider.getAvailableProfiles() : dataProvider.getProfiles(userId);
    }

    /**
     * Retourner un ensemble de lieux en fonction d'un type donné.
     *
     * @param type Type de lieu
     * @return Les lieux correspondant au type de lieu donné.
     * @see SocialExtPlaceType
     */
    @GetMapping(RestDataProvider.RESTURL_GET_PLACES_BY_TYPE)
    @ApiOperation("Retourner un ensemble de lieux en fonction d'un type donné.")
    public Set<SocialExtPlace> getPlacesByType(
            @RequestParam(RestDataProvider.QUERYPARAM_PLACETYPE) SocialExtPlaceType type) {
        return dataProvider.getPlacesByType(type);
    }

    /**
     * Retourner la circonscription liée à un lieu.
     *
     * @param placeId Identifiant du lieu.
     * @return Un wrapper de String, contenant la circonscription.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_CIRCO)
    @ApiOperation("Retourner la circonscription liée à un lieu.")
    public StringWrapperDTO getCirco(@PathVariable(RestDataProvider.PATHPARAM_PLACEID) String placeId) {
        return new StringWrapperDTO(dataProvider.getCirco(placeId));
    }

    /**
     * Retourner une liste de lieux correspondant à une portion de nom donnée.
     *
     * @param municipalityId Id de la commune.
     * @param token          Portion du nom du lieu.
     * @return Liste de lieux dont le nom contient la portion donnée.
     */
    @GetMapping(RestDataProvider.RESTURL_SUGGEST_PLACES)
    @ApiOperation("Retourner une liste de lieux correspondant à une portion de nom donnée.")
    public List<SocialExtPlace> suggestPlaces(
            @PathVariable(RestDataProvider.PATHPARAM_MUNICIPALITYID) String municipalityId,
            @RequestParam(RestDataProvider.QUERYPARAM_SUGGESTTOKEN) String token) {
        return dataProvider.suggestPlaces(token, municipalityId);
    }

    /**
     * Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités.
     *
     * @param token Contient les premiers caractères de la municipalité.
     * @return Liste de SocialExtMunicipalities.
     */
    @GetMapping(RestDataProvider.RESTURL_SUGGEST_MUNICIPALITIES)
    @ApiOperation("Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités.")
    public List<SocialExtMunicipality> suggestMunicipalities(@RequestParam(RestDataProvider.QUERYPARAM_SUGGESTTOKEN) String token) {
        return dataProvider.suggestMunicipalities(token);
    }

    /**
     * Récupérer les liens de débranchement vers les écrans de Solis.
     *
     * @param token        Token d'authentification.
     * @param screens      Ensemble d'écrans.
     * @param userId       Id de l'utilisateur du portail.
     * @param individualId Id de l'individu concerné.
     * @return Une Map avec en clé une enum correspondant aux écrans et en valeur une String contenant le lien.
     * @see SocialModuleScreen
     */
    @GetMapping(RestDataProvider.RESTURL_GET_LINKS)
    @ApiOperation("Récupérer les liens de débranchement vers les écrans de Solis.")
    public Map<SocialModuleScreen, String> getLinks(
            @RequestHeader(RestDataProvider.HEADERNAME_AUTH_TOKEN) String token,
            @RequestParam(RestDataProvider.QUERYPARAM_SCREEN) Set<SocialModuleScreen> screens,
            @RequestParam(RestDataProvider.QUERYPARAM_USERID) String userId,
            @RequestParam(RestDataProvider.QUERYPARAM_INDIVIDUALID) String individualId) {
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
    @GetMapping(RestDataProvider.RESTURL_GET_HOME_PAGES)
    @ApiOperation("Récupérer les liens vers les pages d'accueil des modules sociaux.")
    public Map<SocialModule, String> getHomePages(
            @RequestHeader(RestDataProvider.HEADERNAME_AUTH_TOKEN) String token,
            @RequestParam(RestDataProvider.QUERYPARAM_USERID) String userId,
            @RequestParam(RestDataProvider.QUERYPARAM_SOCIALMODULE) Set<SocialModule> modules) {
        return dataProvider.getHomePages(modules, userId, token);
    }

    /**
     * Récupérer un bénéficiaire à partir de son id.
     *
     * @param externalId Identifiant du bénéficiaire.
     * @return Un objet SocialExtBeneficiary.
     */
    @GetMapping(RestDataProvider.RESTURL_FIND_BENEFICIARY)
    @ApiOperation("Récupérer un bénéficiaire à partir de son id.")
    public SocialExtBeneficiary findBeneficiary(
            @PathVariable(RestDataProvider.PATHPARAM_BENEFICIARYID) String externalId) {
        return dataProvider.findBeneficiary(externalId);
    }

    /**
     * Récupérer un utilisateur à partir de son id.
     *
     * @param externalId Id de l'utilisateur.
     * @return Un objet SocialExtUser correspondant à l'utilisateur recherché.
     */
    @GetMapping(RestDataProvider.RESTURL_FIND_SOCIAL_EXT_USER)
    @ApiOperation("Récupérer un utilisateur à partir de son id.")
    public SocialExtUser findSocialExtUser(
            @PathVariable(RestDataProvider.PATHPARAM_USERID) String externalId) {
        return dataProvider.findSocialExtUser(externalId);
    }

    /**
     * Récupérer un intervenant social à partir de son id.
     *
     * @param externalId Id de l'intervenant social.
     * @return Un objet SocialExtWorker correspondant à l'intervenant social recherché.
     */
    @GetMapping(RestDataProvider.RESTURL_FIND_SOCIAL_WORKER)
    @ApiOperation("Récupérer un intervenant social à partir de son id.")
    public SocialExtWorker findSocialWorker(@PathVariable(RestDataProvider.PATHPARAM_SOCIALWORKERID) String externalId) {
        return dataProvider.findSocialWorker(externalId);
    }

    /**
     * Authentifier un utilisateur.
     *
     * @return Résultat de l'authentification (enum correspondant aux différents statuts possibles).
     * @see AuthenticationResult
     */
    @PostMapping(RestDataProvider.RESTURL_AUTHENTICATE)
    @ApiOperation("Authentifier un utilisateur.")
    public AuthenticationResult authenticate(UserAndPwdDTO updto) {
        return dataProvider.authenticate(updto);
    }

    /**
     * Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.
     *
     * @return Un Set de SocialModule.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_SOCIAL_MODULES_FOR_LIFE_LINE)
    @ApiOperation("Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.")
    public Set<SocialModule> getAvailableSocialModulesForLifeLine() {
        return dataProvider.getAvailableSocialModulesForLifeLine();
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
    @GetMapping(RestDataProvider.RESTURL_FIND_ALL_SOCIAL_WORKERS)
    @ApiOperation("Récupérer tous les travailleurs sociaux. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.")
    public SocialWorkerSearchResultDTO findAllSocialWorkers(
            @RequestParam(RestDataProvider.QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(RestDataProvider.QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllSocialWorkers(pageSize, pageNumber);
    }

    /**
     * Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @GetMapping(RestDataProvider.RESTURL_FIND_ALL_USER)
    @ApiOperation("Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.")
    public UserSearchResultDTO findAllUser(
            @RequestParam(RestDataProvider.QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(RestDataProvider.QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllUser(pageSize, pageNumber);
    }

    /**
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @GetMapping(RestDataProvider.RESTURL_FIND_ALL_INDIVIDUALS)
    @ApiOperation("Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.")
    public BeneficiarySearchResultDTO findAllIndividuals(
            @RequestParam(RestDataProvider.QUERYPARAM_PAGESIZE) int pageSize,
            @RequestParam(RestDataProvider.QUERYPARAM_PAGENUMBER) int pageNumber) {
        return dataProvider.findAllIndividuals(pageSize, pageNumber);
    }

    /**
     * Récupérer les news relatives à un travailleur social.
     *
     * @param userId Id du travailleur social concerné.
     * @return Un objet NewsList, qui contient une liste de News. L'objet News contient une date et une liste de lignes de contenu (type String).
     */
    @GetMapping(RestDataProvider.RESTURL_GET_NEWS)
    @ApiOperation("Récupérer les news relatives à un travailleur social.")
    public NewsList getNews(@RequestParam(RestDataProvider.QUERYPARAM_SWUSERID) String userId) {
        return dataProvider.getNews(userId);
    }

    /**
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     * @see SocialModule
     */
    @GetMapping(RestDataProvider.RESTURL_GET_SOCIAL_MODULES)
    @ApiOperation("Retourner les modules sociaux disponibles dans l'environnement courant.")
    public Set<SocialModule> getAvailableSocialModules() {
        return dataProvider.getAvailableSocialModules();
    }

    /**
     * Récupérer un token de redirection.
     *
     * @param updto Wrapper autour d'un SocialExtUSer (habilitation) et une map de paramètres.
     * @return Wrapper de String, token de redirection.
     */
    @PostMapping(RestDataProvider.RESTURL_GET_REDIRECTION_TOKEN)
    @ApiOperation("Récupérer un token de redirection.")
    public StringWrapperDTO getRedirectionToken(UserAndParamsDTO updto) {
        return new StringWrapperDTO(dataProvider.getRedirectionToken(updto));
    }

    /**
     * "Rechercher dans les individus.
     *
     * @param searchCriteria Set de critères de recherche. Chaque critère contient un type, une classe et une valeur.
     * @return Une liste d'individus correspondant aux critères.
     * @see SearchCriterionDTO
     */
    @PostMapping(RestDataProvider.RESTURL_SEARCH_INDIVIDUALS)
    @ApiOperation("Recherche dans les individus.")
    public List<SocialExtBeneficiary> searchIndividuals(HashSet<SearchCriterionDTO> searchCriteria) {
        return dataProvider.findAllIndividuals(searchCriteria);
    }

    /**
     * Rechercher dans les rendez-vous des individus.
     *
     * @param externalId Clé de l'individu
     * @return Une liste de SocialExtRendezVous.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS)
    @ApiOperation("Rechercher dans les rendez-vous des individus.")
    public List<SocialExtRendezVous> getIndividualRendezVous(
            @PathVariable(RestDataProvider.PATHPARAM_BENEFICIARYID) String externalId) {
        return dataProvider.getIndividualRendezVous(externalId);
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
    @GetMapping(RestDataProvider.RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS)
    @ApiOperation("Rechercher dans les rendez-vous des travailleurs sociaux.")
    public Set<SocialExtRendezVous> getSocialWorkerRendezVous(
            @RequestHeader(RestDataProvider.HEADERNAME_USERID) String userId,
            @PathVariable(RestDataProvider.PATHPARAM_SOCIALWORKERID) String socialWorkerId,
            @RequestParam(RestDataProvider.QUERYPARAM_DATEDEBUT) String startDate,
            @RequestParam(RestDataProvider.QUERYPARAM_DATEFIN) String endDate) {
        return dataProvider.getSocialWorkerRendezVous(userId, socialWorkerId, startDate, endDate);
    }

    /**
     * Créer un rendez-vous pour un intervenant social.
     *
     * @param rendezVous Paramètres du rendez-vous (date, travailleurs sociaux, etc...)
     * @return L'id du rendez-vous créé.
     * @see SocialExtRendezVous
     */
    @PostMapping(RestDataProvider.RESTURL_CREATE_SOCIAL_WORKER_RENDEZ_VOUS)
    @ApiOperation("Créer un rendez-vous pour un intervenant social.")
    public StringWrapperDTO createSocialWorkerRendezVous(SocialExtRendezVous rendezVous) {
        return new StringWrapperDTO(dataProvider.createSocialWorkerRendezVous(rendezVous));
    }
}
