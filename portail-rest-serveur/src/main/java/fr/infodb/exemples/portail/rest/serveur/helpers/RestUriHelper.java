package fr.infodb.exemples.portail.rest.serveur.helpers;

/**
 * @author aurelien
 * créé le 20/11/17.
 */
public abstract class RestUriHelper {

    //**********************************************************************
    // Headers utilisés
    //**********************************************************************
    // nom du header utilisé pour passer l'id user
    public static final String HEADERNAME_USERID = "UserId";
    // nom du header utilisé pour passer le token d'authentification
    public static final String HEADERNAME_AUTH_TOKEN = "AuthToken";

    //**********************************************************************
    // Path params utilisés (aucune conséquence sur l'url finale générée)
    //**********************************************************************
    // nom du référentiel (correspond à l'enum Referential)
    public static final String PATHPARAM_REFERENTIAL = "referential";
    // id du beneficiary
    public static final String PATHPARAM_BENEFICIARYID = "beneficiaryId";
    // id du user
    public static final String PATHPARAM_USERID = "userId";
    // type de lien solis
    public static final String PATHPARAM_LINKTYPE = "userId";
    // id de commune
    public static final String PATHPARAM_MUNICIPALITYID = "municipalityId";
    // id du lieu
    public static final String PATHPARAM_PLACEID = "placeId";
    // module social (correspond à l'enum SocialModule)
    public static final String PATHPARAM_SOCIALMODULE = "socialModule";
    // id du travailleur social// Nom des paramètres de requête utilisés
    public static final String PATHPARAM_SOCIALWORKERID = "socialWorkerId";

    //**********************************************************************
    // Paramètres d'url
    //**********************************************************************
    // id du SocialWorkerUser
    public static final String QUERYPARAM_SWUSERID = "swuserId";
    // taille de la page dans les recherches
    public static final String QUERYPARAM_PAGESIZE = "pageSize";
    // numéro de la page voulue dans les recherches (attention, commence à 1)
    public static final String QUERYPARAM_PAGENUMBER = "pageNumber";
    // identifiant d'écran (paramètre multivalué)
    public static final String QUERYPARAM_SCREEN = "screen";
    // id du user
    public static final String QUERYPARAM_USERID = "userId";
    // id de l'individu concerné
    public static final String QUERYPARAM_INDIVIDUALID = "individualId";
    // portion du nom de commune pour suggestion
    public static final String QUERYPARAM_SUGGESTTOKEN = "suggestToken";
    // type de lieu
    public static final String QUERYPARAM_PLACETYPE = "placeType";
    // type d'identifiant de module
    public static final String QUERYPARAM_MODULEIDTYPE = "moduleIdType";
    // module social (correspond à l'enum SocialModule)
    public static final String QUERYPARAM_SOCIALMODULE = "socialModule";
    // date de début
    public static final String QUERYPARAM_DATEDEBUT = "dateDebut";
    // date de fin// Urls de base des ressources (utilisées dans les urls des services rest)
    public static final String QUERYPARAM_DATEFIN = "dateFin";

    //**********************************************************************
    // ressources
    //**********************************************************************
    public static final String RESSOURCE_BASEURL_INDIVIDUAL = "individuals";
    public static final String RESSOURCE_BASEURL_PLACES = "places";
    public static final String RESSOURCE_BASEURL_MUNICIPALITIES = "municipalities";
    public static final String RESSOURCE_BASEURL_LINKS = "links";
    public static final String RESSOURCE_BASEURL_BENEFICIARY = "beneficiary";
    public static final String RESSOURCE_BASEURL_SOCIALMODULES = "socialModules";
    public static final String RESSOURCE_BASEURL_SOCIALWORKERS = "socialWorkers";
    public static final String RESSOURCE_BASEURL_SOCIALEXTUSER = "socialExtUser";
    public static final String RESSOURCE_BASEURL_SECURITY = "security";

    //**********************************************************************
    // Urls des services rest
    //**********************************************************************
    // utilisé avec path param
    public static final String RESTURL_GET_REFERENTIAL = "referentials" + "/{" + PATHPARAM_REFERENTIAL + "}";

    // utilisé avec un queryParam
    public static final String RESTURL_GET_NEWS = "news";

    public static final String RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES = "loginHomepageMessages";

    public static final String RESTURL_AUTHENTICATE = RESSOURCE_BASEURL_SECURITY + "/authenticate";

    public static final String RESTURL_GET_REDIRECTION_TOKEN = RESSOURCE_BASEURL_SECURITY + "/redirectionToken/generate";

    public static final String RESTURL_GET_PROFILES = RESSOURCE_BASEURL_SECURITY + "/profiles";

    public static final String RESTURL_GET_SOCIAL_MODULES_FOR_LIFE_LINE = RESSOURCE_BASEURL_SOCIALMODULES + "/forLifeLine";

    public static final String RESTURL_GET_SOCIAL_MODULES = RESSOURCE_BASEURL_SOCIALMODULES;

    public static final String RESTURL_FIND_ALL_MUNICIPALITIES = RESSOURCE_BASEURL_MUNICIPALITIES;

    // utilisé avec un queryParam
    public static final String RESTURL_SUGGEST_MUNICIPALITIES = RESSOURCE_BASEURL_MUNICIPALITIES + "/suggest";

    // utilisé avec un queryParam
    public static final String RESTURL_SUGGEST_PLACES = RESSOURCE_BASEURL_MUNICIPALITIES + "/{" + PATHPARAM_MUNICIPALITYID + "}/places/suggest";
    public static final String RESTURL_GET_LINKS = RESSOURCE_BASEURL_LINKS;
    public static final String RESTURL_GET_LINK = RESSOURCE_BASEURL_LINKS + "/{" + PATHPARAM_LINKTYPE + "}";
    public static final String RESTURL_GET_HOME_PAGES = RESSOURCE_BASEURL_LINKS + "/homePages";
    public static final String RESTURL_FIND_ALL_PLACES = RESSOURCE_BASEURL_PLACES;
    public static final String RESTURL_GET_CIRCO = RESSOURCE_BASEURL_PLACES + "/{" + PATHPARAM_PLACEID + "}/circo";

    // utilisé avec un QueryParam
    public static final String RESTURL_GET_PLACES_BY_TYPE = RESSOURCE_BASEURL_PLACES + "/search";
    public static final String RESTURL_SEARCH_INDIVIDUALS = RESSOURCE_BASEURL_INDIVIDUAL + "/search";

    // méthode GET
    public static final String RESTURL_FIND_ALL_INDIVIDUALS = RESSOURCE_BASEURL_INDIVIDUAL;
    // méthode PUT
    public static final String RESTURL_UPDATE_INDIVIDUAL = RESSOURCE_BASEURL_INDIVIDUAL;
    // méthode POST
    public static final String RESTURL_CREATE_INDIVIDUAL = RESSOURCE_BASEURL_INDIVIDUAL;

    public static final String RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS = RESSOURCE_BASEURL_INDIVIDUAL + "/{" + PATHPARAM_BENEFICIARYID + "}/rendezvous";
    public static final String RESTURL_GET_BUSINESS_OFFERS = RESSOURCE_BASEURL_INDIVIDUAL + "/{" + PATHPARAM_BENEFICIARYID + "}/businessOffers";
    public static final String RESTURL_FIND_BENEFICIARY = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}";
    public static final String RESTURL_GET_SOCIAL_FILE_MEASURES = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}" + "/socialFileMeasures";
    public static final String RESTURL_GET_INDIVIDUAL_SYNTHESIS = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}" + "/individualSynthesis";
    public static final String RESTURL_GET_FILE_RECORD = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}" + "/fileRecord";
    public static final String RESTURL_GET_MODULE_IDENTIFIER = RESSOURCE_BASEURL_SOCIALMODULES + "/{" + PATHPARAM_SOCIALMODULE + "}" + "/moduleIdentifier";
    public static final String RESTURL_FIND_ALL_USER = RESSOURCE_BASEURL_SOCIALEXTUSER;
    public static final String RESTURL_FIND_SOCIAL_EXT_USER = RESSOURCE_BASEURL_SOCIALEXTUSER + "/{" + PATHPARAM_USERID + "}";
    public static final String RESTURL_GET_NUMBER_SIRH_EVENTS = RESSOURCE_BASEURL_SOCIALEXTUSER + "/{" + PATHPARAM_USERID + "}/numberSirhEvents";
    public static final String RESTURL_FIND_ALL_SOCIAL_WORKERS = RESSOURCE_BASEURL_SOCIALWORKERS;
    public static final String RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS = RESSOURCE_BASEURL_SOCIALWORKERS + "/{" + PATHPARAM_SOCIALWORKERID + "}/rendezVous";
    public static final String RESTURL_CREATE_SOCIAL_WORKER_RENDEZ_VOUS = RESSOURCE_BASEURL_SOCIALWORKERS + "/rendezVous";
    public static final String RESTURL_FIND_SOCIAL_WORKER = RESSOURCE_BASEURL_SOCIALWORKERS + "/{" + PATHPARAM_SOCIALWORKERID + "}";
    public static final String RESTURL_SAVE_FORM = "forms";
}
