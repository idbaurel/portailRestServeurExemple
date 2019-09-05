package fr.infodb.exemples.portail.rest.serveur.helpers;

/**
 * Classe d'aide pour la construction des urls
 *
 * @author aurelien
 * créé le 20/11/17.
 */
public abstract class RestUriHelper {

    //**********************************************************************
    // Headers utilisés
    //**********************************************************************
    // nom du header utilisé pour passer l'id user
    public static final String HEADERNAME_USERID = "UserId";

    //**********************************************************************
    // Path params utilisés (aucune conséquence sur l'url finale générée)
    //**********************************************************************
    // nom du référentiel (correspond à l'enum Referential)
    public static final String PATHPARAM_REFERENTIAL = "referential";
    // id du beneficiary
    public static final String PATHPARAM_BENEFICIARYID = "beneficiaryId";
    // id du user
    public static final String PATHPARAM_USERID = "userId";
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
    // id de l'individu concerné
    public static final String QUERYPARAM_INDIVIDUALID = "individualId";
    // type d'identifiant de module
    public static final String QUERYPARAM_MODULEIDTYPE = "moduleIdType";
    // date de début
    public static final String QUERYPARAM_DATEDEBUT = "dateDebut";
    // date de fin
    public static final String QUERYPARAM_DATEFIN = "dateFin";

    //**********************************************************************
    // ressources
    // Urls de base des ressources (utilisées dans les urls des services REST)
    //**********************************************************************
    private static final String RESSOURCE_BASEURL_INDIVIDUAL = "individuals";
    private static final String RESSOURCE_BASEURL_BENEFICIARY = "beneficiary";
    private static final String RESSOURCE_BASEURL_SOCIALMODULES = "socialModules";
    private static final String RESSOURCE_BASEURL_SOCIALWORKERS = "socialWorkers";
    private static final String RESSOURCE_BASEURL_SOCIALEXTUSER = "socialExtUser";
    private static final String RESSOURCE_BASEURL_SECURITY = "security";

    //**********************************************************************
    // Urls des services REST
    //**********************************************************************

    //sécurité
    public static final String RESTURL_AUTHENTICATE = RESSOURCE_BASEURL_SECURITY + "/authenticate";
    public static final String RESTURL_GET_PROFILES = RESSOURCE_BASEURL_SECURITY + "/profiles";

    //reprise données
    public static final String RESTURL_FIND_ALL_INDIVIDUALS = RESSOURCE_BASEURL_INDIVIDUAL;
    public static final String RESTURL_FIND_ALL_SOCIAL_WORKERS = RESSOURCE_BASEURL_SOCIALWORKERS;
    public static final String RESTURL_FIND_ALL_USER = RESSOURCE_BASEURL_SOCIALEXTUSER;

    //données
    public static final String RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES = "loginHomepageMessages";
    public static final String RESTURL_GET_BENEFICIARY = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}";
    public static final String RESTURL_GET_FILE_RECORD = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}" + "/fileRecord";
    public static final String RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS = RESSOURCE_BASEURL_INDIVIDUAL + "/{" + PATHPARAM_BENEFICIARYID + "}/rendezVous";
    public static final String RESTURL_GET_MODULE_IDENTIFIER = RESSOURCE_BASEURL_SOCIALMODULES + "/{" + PATHPARAM_SOCIALMODULE + "}" + "/moduleIdentifier";
    public static final String RESTURL_GET_NEWS = "news";
    public static final String RESTURL_GET_REFERENTIAL = "referentials" + "/{" + PATHPARAM_REFERENTIAL + "}";
    public static final String RESTURL_GET_SOCIAL_EXT_USER = RESSOURCE_BASEURL_SOCIALEXTUSER + "/{" + PATHPARAM_USERID + "}";
    public static final String RESTURL_GET_SOCIAL_FILE_MEASURES = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}" + "/socialFileMeasures";
    public static final String RESTURL_GET_SOCIAL_MODULES = RESSOURCE_BASEURL_SOCIALMODULES;
    public static final String RESTURL_GET_SOCIAL_MODULES_FOR_LIFE_LINE = RESSOURCE_BASEURL_SOCIALMODULES + "/forLifeLine";
    public static final String RESTURL_GET_SOCIAL_WORKER = RESSOURCE_BASEURL_SOCIALWORKERS + "/{" + PATHPARAM_SOCIALWORKERID + "}";
    public static final String RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS = RESSOURCE_BASEURL_SOCIALWORKERS + "/{" + PATHPARAM_SOCIALWORKERID + "}/rendezVous";

    //recherche
    public static final String RESTURL_SEARCH_INDIVIDUALS = RESSOURCE_BASEURL_INDIVIDUAL + "/search";





}
