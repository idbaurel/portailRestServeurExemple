package fr.infodb.exemples.portail.rest.serveur.services;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;

@Service
public class StubDataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(StubDataProvider.class);

//    // Headers utilisés
//    public static final String HEADERNAME_USERID = "UserId";		// nom du header utilisé pour passer l'id user
//    public static final String HEADERNAME_AUTH_TOKEN = "AuthToken";	// nom du header utilisé pour passer le token d'authentification
//
//    // Path params utilisés (aucune conséquence sur l'url finale générée)
//    public static final String PATHPARAM_REFERENTIAL = "referential";		// nom du référentiel (correspond à l'enum Referential)
//    public static final String PATHPARAM_BENEFICIARYID = "beneficiaryId";		// id du beneficiary
//    public static final String PATHPARAM_USERID = "userId";				// id du user
//    public static final String PATHPARAM_LINKTYPE = "userId";				// type de lien solis
//    public static final String PATHPARAM_MUNICIPALITYID = "municipalityId";		// id de commune
//    public static final String PATHPARAM_PLACEID = "placeId";			// id du lieu
//    public static final String PATHPARAM_SOCIALMODULE = "socialModule";		// module social (correspond à l'enum SocialModule)
//    public static final String PATHPARAM_SOCIALWORKERID = "socialWorkerId";		// id du travailleur social
//
//    // Nom des paramètres de requête utilisés
//    public static final String QUERYPARAM_SWUSERID = "swuserId";			// id du SocialWorkerUser
//    public static final String QUERYPARAM_PAGESIZE = "pageSize";			// taille de la page dans les recherches
//    public static final String QUERYPARAM_PAGENUMBER = "pageNumber";	 		// numéro de la page voulue dans les recherches (attention, commence à 1)
//    public static final String QUERYPARAM_SCREEN = "screen";				// identifiant d'écran (paramètre multivalué)
//    public static final String QUERYPARAM_USERID = "userId";				// id du user
//    public static final String QUERYPARAM_INDIVIDUALID = "individualId";		// id de l'individu concerné
//    public static final String QUERYPARAM_SUGGESTTOKEN = "suggestToken";		// portion du nom de commune pour suggestion
//    public static final String QUERYPARAM_PLACETYPE = "placeType";			// type de lieu
//    public static final String QUERYPARAM_MODULEIDTYPE = "moduleIdType";		// type d'identifiant de module
//    public static final String QUERYPARAM_SOCIALMODULE = "socialModule";		// module social (correspond à l'enum SocialModule)
//    public static final String QUERYPARAM_DATEDEBUT = "dateDebut";			// date de début
//    public static final String QUERYPARAM_DATEFIN = "dateFin";			// date de fin
//
//    // Urls de base des ressources (utilisées dans les urls des services rest)
//    private static final String RESSOURCE_BASEURL_INDIVIDUAL = "individuals";
//    private static final String RESSOURCE_BASEURL_PLACES = "places";
//    private static final String RESSOURCE_BASEURL_MUNICIPALITIES = "municipalities";
//    private static final String RESSOURCE_BASEURL_LINKS = "links";
//    private static final String RESSOURCE_BASEURL_BENEFICIARY = "beneficiary";
//    private static final String RESSOURCE_BASEURL_SOCIALMODULES = "socialModules";
//    private static final String RESSOURCE_BASEURL_SOCIALWORKERS = "socialWorkers";
//    private static final String RESSOURCE_BASEURL_SOCIALEXTUSER = "socialExtUser";
//    private static final String RESSOURCE_BASEURL_SECURITY = "security";
//
//    // Urls des services rest
//    public static final String RESTURL_GET_REFERENTIAL = "referentials" + "/{" + PATHPARAM_REFERENTIAL + "}";
//
//    public static final String RESTURL_GET_NEWS = "news";						// utilisé avec un queryParam
//    public static final String RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES = "loginHomepageMessages";
//
//    public static final String RESTURL_AUTHENTICATE = RESSOURCE_BASEURL_SECURITY + "/authenticate";
//    public static final String RESTURL_GET_REDIRECTION_TOKEN = RESSOURCE_BASEURL_SECURITY + "/redirectionToken/generate";
//    public static final String RESTURL_GET_PROFILES = RESSOURCE_BASEURL_SECURITY + "/profiles";
//
//    public static final String RESTURL_GET_SOCIAL_MODULES_FOR_LIFE_LINE = RESSOURCE_BASEURL_SOCIALMODULES + "/forLifeLine";
//    public static final String RESTURL_GET_SOCIAL_MODULES = RESSOURCE_BASEURL_SOCIALMODULES;
//
//    public static final String RESTURL_FIND_ALL_MUNICIPALITIES = RESSOURCE_BASEURL_MUNICIPALITIES;
//    public static final String RESTURL_SUGGEST_MUNICIPALITIES = RESSOURCE_BASEURL_MUNICIPALITIES + "/suggest";											// utilisé avec un queryParam
//    public static final String RESTURL_SUGGEST_PLACES = RESSOURCE_BASEURL_MUNICIPALITIES + "/{" + PATHPARAM_MUNICIPALITYID + "}/places/suggest";	// utilisé avec un queryParam
//
//    public static final String RESTURL_GET_LINKS = RESSOURCE_BASEURL_LINKS;
//    public static final String RESTURL_GET_LINK = RESSOURCE_BASEURL_LINKS + "/{" + PATHPARAM_LINKTYPE + "}";
//    public static final String RESTURL_GET_HOME_PAGES = RESSOURCE_BASEURL_LINKS + "/homePages";
//
//    public static final String RESTURL_FIND_ALL_PLACES = RESSOURCE_BASEURL_PLACES;
//    public static final String RESTURL_GET_CIRCO = RESSOURCE_BASEURL_PLACES + "/{" + PATHPARAM_PLACEID + "}/circo";
//    public static final String RESTURL_GET_PLACES_BY_TYPE = RESSOURCE_BASEURL_PLACES + "/search";												// utilisé avec un QueryParam
//
//    public static final String RESTURL_SEARCH_INDIVIDUALS = RESSOURCE_BASEURL_INDIVIDUAL + "/search";
//    public static final String RESTURL_FIND_ALL_INDIVIDUALS = RESSOURCE_BASEURL_INDIVIDUAL;					// méthode GET
//    public static final String RESTURL_UPDATE_INDIVIDUAL = RESSOURCE_BASEURL_INDIVIDUAL;					// méthode PUT
//    public static final String RESTURL_CREATE_INDIVIDUAL = RESSOURCE_BASEURL_INDIVIDUAL;					// méthode POST
//    public static final String RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS = RESSOURCE_BASEURL_INDIVIDUAL + "/{" + PATHPARAM_BENEFICIARYID + "}/rendezvous";
//    public static final String RESTURL_GET_BUSINESS_OFFERS = RESSOURCE_BASEURL_INDIVIDUAL + "/{" + PATHPARAM_BENEFICIARYID + "}/businessOffers";
//
//    public static final String RESTURL_FIND_BENEFICIARY = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}";
//    public static final String RESTURL_GET_SOCIAL_FILE_MEASURES = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}" + "/socialFileMeasures";
//    public static final String RESTURL_GET_INDIVIDUAL_SYNTHESIS = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}" + "/individualSynthesis";
//    public static final String RESTURL_GET_FILE_RECORD = RESSOURCE_BASEURL_BENEFICIARY + "/{" + PATHPARAM_BENEFICIARYID + "}" + "/fileRecord";
//
//    public static final String RESTURL_GET_MODULE_IDENTIFIER = RESSOURCE_BASEURL_SOCIALMODULES + "/{" + PATHPARAM_SOCIALMODULE + "}" + "/moduleIdentifier";
//
//    public static final String RESTURL_FIND_ALL_USER = RESSOURCE_BASEURL_SOCIALEXTUSER;
//    public static final String RESTURL_FIND_SOCIAL_EXT_USER = RESSOURCE_BASEURL_SOCIALEXTUSER + "/{" + PATHPARAM_USERID + "}";
//    public static final String RESTURL_GET_NUMBER_SIRH_EVENTS = RESSOURCE_BASEURL_SOCIALEXTUSER + "/{" + PATHPARAM_USERID + "}/numberSirhEvents";
//
//    public static final String RESTURL_FIND_ALL_SOCIAL_WORKERS = RESSOURCE_BASEURL_SOCIALWORKERS;
//    public static final String RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS = RESSOURCE_BASEURL_SOCIALWORKERS + "/{" + PATHPARAM_SOCIALWORKERID + "}/rendezVous";
//    public static final String RESTURL_CREATE_SOCIAL_WORKER_RENDEZ_VOUS = RESSOURCE_BASEURL_SOCIALWORKERS + "/rendezVous";
//    public static final String RESTURL_FIND_SOCIAL_WORKER = RESSOURCE_BASEURL_SOCIALWORKERS + "/{" + PATHPARAM_SOCIALWORKERID + "}";

    public static final String RESTURL_SAVE_FORM = "forms";

    /**
     * Taille de la page pour les findAll : nombre d'éléments retournés en 1
     * requête.
     */
    private static final int DEFAULT_PAGE_SIZE = 500;

    /**
     * Client REST générique de Spring.
     */
//    private final RestTemplate restTemplate;
    /**
     * Url de base des services REST de l'environnement cible.
     */
//    private final String url;

//    public StubDataProvider(Environment env, RestTemplate restTemplate, String baseUrl) {
//        this.url = baseUrl + "/";
//    }

    /**
     * Evénement SIRH
     * @param userId Identifiant de l'utilisateur
     * @return Nombre d'événement pour l'utilisateur
     */
    public Long getNumberSirhEvents(String userId) {

        return 0L;
    }

    /**
     * Recherche des offres de services
     * @param individualId Identifiant du bénéficiaire
     * @return Liste d'offre
     */
    public List<BusinessOffer> getBusinessOffers(String individualId) {

        List<BusinessOffer> res = new ArrayList<>();
        BusinessOffer businessOffer = new BusinessOffer();
        businessOffer.setOfferDate(new Date());
        businessOffer.setOfferLabel("libellé de l'offre");
        businessOffer.setOfferLabelDate("libellé de la date de l'offre");
        businessOffer.setOfferStatus("status de l'offre");
        res.add(businessOffer);
        return res;

    }

//    @Override

    /**
     * Récupère la référence du dossier
     * @param module SocialModule concerné.
     * @param type Type d'identifiant.
     * @param externalId Id du user portail à l'origine de l'appel
     * @return
     */
    public String getModuleIdentifier(SocialModule module, ModuleIdentifierType type, String externalId) {

//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_GET_MODULE_IDENTIFIER)
//                .queryParam(QUERYPARAM_MODULEIDTYPE, type);
//
//        return restTemplate.exchange(builder.buildAndExpand(module.toString()).toUri(), HttpMethod.GET, createUserHeader(externalId), StringWrapperDTO.class).getBody().toString();

        return "ref-dossier-123";

    }
//
//    @Override

    /**
     * Récupère les aides liées à un bénéficiaire.
     * @param user SocialExtUser à l'origine de l'appel
     * @param index Id du bénéficiaire
     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
     */
    public SocialExtBeneficiary getSocialFileMeasures(SocialExtUser user, String index) {

        SocialExtBeneficiary res = new SocialExtBeneficiary();
        res.setLastName("DUPONT");
        res.setFirstName("Marie Hélène");
        res.setBirthDate(localDateToDate(LocalDate.of(1980, Month.APRIL, 24)));

        return res;
    }
//
//    @Override

    /**
     * Créer un individu.
     *
     * @param beneficiary Données de l'individu à créer
     * @return Identifiant de l'individu créer
     */
    public String createIndividuals(SocialExtBeneficiary beneficiary) {
        return "123456";
    }
//
//    @Override
    public void updateIndividual(SocialExtBeneficiary beneficiary) {
        LOGGER.info("Mise à jour de l'individu {} {}", beneficiary.getLastName(), beneficiary.getFirstName());
    }
//
//    @Override

    /**
     * Retourner les profils d'un utilisateur.
     *
     * @param user Représentation d'un utilisateur
     * @return Set de profils d'un utilisateur
     */
    public Set<String> getProfiles(SocialExtUser user) {
        Set<String> res = new HashSet<>();
        res.add("Administrateur");
        return res;
    }
//
//    @Override

    /**
     * Retourner tous les profils utilisateurs actifs.
     * @return Un Set de String correspondant aux profils utilisateurs.
     */
    public Set<String> getAvailableProfiles() {
        Set<String> res = new HashSet<>();
        res.add("Administrateur");
        res.add("Secrétaire");
        return res;
    }
//
//    @Override

    /**
     *
     * @param type
     * @return
     * @throws SocialExtException
     */
    public Set<SocialExtPlace> getPlacesByType(SocialExtPlaceType type) {

        Set<SocialExtPlace> res = new HashSet<>();
        SocialExtPlace socialExtPlace = new SocialExtPlace("avenue Jean Biray", "", "", "12345", 123, 64, "PAU", "64000", "64");
        res.add(socialExtPlace);
        return res;

    }
//
//    @Override

    /**
     * Retourner la circonscription liée à un lieu.
     * @param placeId Identifiant du lieu
     * @return Circonscription liée à un lieu.
     */
    public String getCirco(String placeId) {
        return "Pau-Nord";
    }
//
//    @Override
    public SocialExtBeneficiary getFileRecord(SocialExtUser user, String index)  {
        SocialExtBeneficiary res = new SocialExtBeneficiary();
        res.setLastName("DUPONT");
        res.setFirstName("Marie Hélène");
        res.setBirthDate(localDateToDate(LocalDate.of(1980, Month.APRIL, 24)));

        return res;
    }
//
//    @Override
    public SocialExtBeneficiary getIndividualSynthesis(SocialExtUser user, String index) {
        SocialExtBeneficiary res = new SocialExtBeneficiary();
        res.setLastName("DUPONT");
        res.setFirstName("Marie Hélène");
        res.setBirthDate(localDateToDate(LocalDate.of(1980, Month.APRIL, 24)));

        return res;
    }
//
//    @Override
//    public SocialExtDataIterator<SocialExtMunicipality> findAllMunicipalities() {
//
//        // TODO Données Zippées
//        // Liste finale de résultats
//        List<SocialExtMunicipality> toReturn = new ArrayList<SocialExtMunicipality>();
//
//        // Première requête
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Requête de recherche no 1 ...");
//        }
//        MunicipalitySearchResultDTO results = findMunicipalities(DEFAULT_PAGE_SIZE, 1);
//
//        // Ajout de ces résultats à la liste finale
//        toReturn.addAll(results.getMunicipalities());
//
//        // Récupération des informations sur le nombre total de résultats
//        int totalResultsSize = results.getTotalNumber();
//        if (totalResultsSize == -1) {
//            throw new InvalidDataReceivedException("Le nombre total de résultat n'a pas été renseigné par l'envrironnement");
//        }
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Nombre total de résultats : " + totalResultsSize);
//        }
//
//        // Calcul du nombre total de pages (donc de requêtes)
//        int nbPagesTotal = totalResultsSize / DEFAULT_PAGE_SIZE;
//        if (totalResultsSize % DEFAULT_PAGE_SIZE != 0) {
//            nbPagesTotal++;
//        }
//
//        // Requêtes suivantes
//        if (nbPagesTotal > 1) {
//            for (int p = 2; p <= nbPagesTotal; p++) {
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug("Requête de recherche individus no " + p + "...");
//                }
//                results = findMunicipalities(DEFAULT_PAGE_SIZE, p);
//                toReturn.addAll(results.getMunicipalities());
//            }
//        }
//
//        return new SimpleSocialExtDataIterator<SocialExtMunicipality>(toReturn.size(), toReturn.iterator());
//    }
//
//    /**
//     * Recherche de communes
//     *
//     * @param page
//     * @return
//     */
//    private MunicipalitySearchResultDTO findMunicipalities(int pageSize, int page) {
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_FIND_ALL_MUNICIPALITIES)
//                .queryParam(QUERYPARAM_PAGENUMBER, page)
//                .queryParam(QUERYPARAM_PAGESIZE, pageSize);
//
//        MunicipalitySearchResultDTO results = restTemplate.getForObject(builder.build().toUri(), MunicipalitySearchResultDTO.class);
//        return results;
//    }
//
//    @Override
//    public SocialExtDataIterator<SocialExtPlace> findAllPlaces() {
//
//        // TODO Données Zippées
//        // Liste finale de résultats
//        List<SocialExtPlace> toReturn = new ArrayList<SocialExtPlace>();
//
//        // Première requête
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Requête de recherche no 1 ...");
//        }
//        PlaceSearchResultDTO results = findPlaces(DEFAULT_PAGE_SIZE, 1);
//
//        // Ajout de ces résultats à la liste finale
//        toReturn.addAll(results.getPlaces());
//
//        // Récupération des informations sur le nombre total de résultats
//        int totalResultsSize = results.getTotalNumber();
//        if (totalResultsSize == -1) {
//            throw new InvalidDataReceivedException("Le nombre total de résultat n'a pas été renseigné par l'envrironnement");
//        }
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Nombre total de résultats : " + totalResultsSize);
//        }
//
//        // Calcul du nombre total de pages (donc de requêtes)
//        int nbPagesTotal = totalResultsSize / DEFAULT_PAGE_SIZE;
//        if (totalResultsSize % DEFAULT_PAGE_SIZE != 0) {
//            nbPagesTotal++;
//        }
//
//        // Requêtes suivantes
//        if (nbPagesTotal > 1) {
//            for (int p = 2; p <= nbPagesTotal; p++) {
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug("Requête de recherche individus no " + p + "...");
//                }
//                results = findPlaces(DEFAULT_PAGE_SIZE, p);
//                toReturn.addAll(results.getPlaces());
//            }
//        }
//
//        return new SimpleSocialExtDataIterator<SocialExtPlace>(toReturn.size(), toReturn.iterator());
//    }
//
//    /**
//     * Recherche de places
//     *
//     * @param page
//     * @return
//     */
//    private PlaceSearchResultDTO findPlaces(int pageSize, int page) {
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_FIND_ALL_PLACES)
//                .queryParam(QUERYPARAM_PAGENUMBER, page)
//                .queryParam(QUERYPARAM_PAGESIZE, pageSize);
//
//        PlaceSearchResultDTO results = restTemplate.getForObject(builder.build().toUri(), PlaceSearchResultDTO.class);
//        return results;
//    }
//
//    @Override
//    public SocialExtDataIterator<SocialExtUser> findAllUser() {
//
//        // TODO Données Zippées
//        // Liste finale de résultats
//        List<SocialExtUser> toReturn = new ArrayList<SocialExtUser>();
//
//        // Première requête
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Requête de recherche no 1 ...");
//        }
//        UserSearchResultDTO results = findUsers(DEFAULT_PAGE_SIZE, 1);
//
//        // Ajout de ces résultats à la liste finale
//        toReturn.addAll(results.getUsers());
//
//        // Récupération des informations sur le nombre total de résultats
//        int totalResultsSize = results.getTotalNumber();
//        if (totalResultsSize == -1) {
//            throw new InvalidDataReceivedException("Le nombre total de résultat n'a pas été renseigné par l'envrironnement");
//        }
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Nombre total de résultats : " + totalResultsSize);
//        }
//
//        // Calcul du nombre total de pages (donc de requêtes)
//        int nbPagesTotal = totalResultsSize / DEFAULT_PAGE_SIZE;
//        if (totalResultsSize % DEFAULT_PAGE_SIZE != 0) {
//            nbPagesTotal++;
//        }
//
//        // Requêtes suivantes
//        if (nbPagesTotal > 1) {
//            for (int p = 2; p <= nbPagesTotal; p++) {
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug("Requête de recherche individus no " + p + "...");
//                }
//                results = findUsers(DEFAULT_PAGE_SIZE, p);
//                toReturn.addAll(results.getUsers());
//            }
//        }
//
//        return new SimpleSocialExtDataIterator<SocialExtUser>(toReturn.size(), toReturn.iterator());
//    }
//
//    /**
//     * Recherche de users
//     *
//     * @param page
//     * @return
//     */
//    private UserSearchResultDTO findUsers(int pageSize, int page) {
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_FIND_ALL_USER)
//                .queryParam(QUERYPARAM_PAGENUMBER, page)
//                .queryParam(QUERYPARAM_PAGESIZE, pageSize);
//
//        UserSearchResultDTO results = restTemplate.getForObject(builder.build().toUri(), UserSearchResultDTO.class);
//        return results;
//    }
//
//    @Override
//    public SocialExtDataIterator<SocialExtWorker> findAllSocialWorkers() {
//        // TODO Données Zippées
//
//        // Liste finale de résultats
//        List<SocialExtWorker> toReturn = new ArrayList<SocialExtWorker>();
//
//        // Première requête
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Requête de recherche no 1 ...");
//        }
//        SocialWorkerSearchResultDTO results = findSocialWorkers(DEFAULT_PAGE_SIZE, 1);
//
//        // Ajout de ces résultats à la liste finale
//        toReturn.addAll(results.getWorkers());
//
//        // Récupération des informations sur le nombre total de résultats
//        int totalResultsSize = results.getTotalNumber();
//        if (totalResultsSize == -1) {
//            throw new InvalidDataReceivedException("Le nombre total de résultat n'a pas été renseigné par l'envrironnement");
//        }
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Nombre total de résultats : " + totalResultsSize);
//        }
//
//        // Calcul du nombre total de pages (donc de requêtes)
//        int nbPagesTotal = totalResultsSize / DEFAULT_PAGE_SIZE;
//        if (totalResultsSize % DEFAULT_PAGE_SIZE != 0) {
//            nbPagesTotal++;
//        }
//
//        // Requêtes suivantes
//        if (nbPagesTotal > 1) {
//            for (int p = 2; p <= nbPagesTotal; p++) {
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug("Requête de recherche individus no " + p + "...");
//                }
//                results = findSocialWorkers(DEFAULT_PAGE_SIZE, p);
//                toReturn.addAll(results.getWorkers());
//            }
//        }
//
//        return new SimpleSocialExtDataIterator<SocialExtWorker>(toReturn.size(), toReturn.iterator());
//    }
//
//    /**
//     * Recherche de social workers
//     *
//     * @param page
//     * @return
//     */
//    private SocialWorkerSearchResultDTO findSocialWorkers(int pageSize, int page) {
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_FIND_ALL_SOCIAL_WORKERS)
//                .queryParam(QUERYPARAM_PAGENUMBER, page)
//                .queryParam(QUERYPARAM_PAGESIZE, pageSize);
//
//        SocialWorkerSearchResultDTO results = restTemplate.getForObject(builder.build().toUri(), SocialWorkerSearchResultDTO.class);
//        return results;
//    }
//
//    /**
//     * Implémentation "naïve" pour l'instant : on fait les requêtes par page les
//     * unes après les autres jusqu'à avoir la totalité des éléments.
//     */
//    @Override
//    public SocialExtDataIterator<SocialExtBeneficiary> findAllIndividuals() {
//        // TODO Données Zippées
//
//        // Liste finale de résultats
//        List<SocialExtBeneficiary> individus = new ArrayList<SocialExtBeneficiary>();
//
//        // Première requête
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Requête de recherche individus no 1 ...");
//        }
//        BeneficiarySearchResultDTO results = findIndividuals(DEFAULT_PAGE_SIZE, 1);
//
//        // Ajout de ces résultats à la liste finale
//        individus.addAll(results.getBeneficiaries());
//
//        // Récupération des informations sur le nombre total de résultats
//        int totalResultsSize = results.getTotalNumber();
//        if (totalResultsSize == -1) {
//            throw new InvalidDataReceivedException("Le nombre total de résultat n'a pas été renseigné par l'envrironnement");
//        }
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Recherche individus, nombre total de résultats : " + totalResultsSize);
//        }
//
//        // Calcul du nombre total de pages (donc de requêtes)
//        int nbPagesTotal = totalResultsSize / DEFAULT_PAGE_SIZE;
//        if (totalResultsSize % DEFAULT_PAGE_SIZE != 0) {
//            nbPagesTotal++;
//        }
//
//        // Requêtes suivantes
//        if (nbPagesTotal > 1) {
//            for (int p = 2; p <= nbPagesTotal; p++) {
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug("Requête de recherche individus no " + p + "...");
//                }
//                results = findIndividuals(DEFAULT_PAGE_SIZE, p);
//                individus.addAll(results.getBeneficiaries());
//            }
//        }
//
//        return new SimpleSocialExtDataIterator<SocialExtBeneficiary>(individus.size(), individus.iterator());
//    }
//
//    /**
//     * Recherche d'individus
//     *
//     * @param page
//     * @return
//     */
//    private BeneficiarySearchResultDTO findIndividuals(int pageSize, int page) {
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_FIND_ALL_INDIVIDUALS)
//                .queryParam(QUERYPARAM_PAGENUMBER, page)
//                .queryParam(QUERYPARAM_PAGESIZE, pageSize);
//
//        BeneficiarySearchResultDTO results = restTemplate.getForObject(builder.build().toUri(), BeneficiarySearchResultDTO.class);
//        return results;
//    }
//
//    @Override
//    public ReferentialEntity getReferential(SocialExtUser user, Referential referentialName) throws SocialExtException {
//
//        ReferentialDTO rdto = restTemplate.exchange(url + RESTURL_GET_REFERENTIAL, HttpMethod.GET,
//                createUserHeader(user), ReferentialDTO.class, referentialName).getBody();
//
//        return convertFromDTO(rdto);
//    }
//
//    @Override
//    public SocialExtUser findSocialExtUser(String externalId) {
//
//        return restTemplate.getForObject(url + RESTURL_FIND_SOCIAL_EXT_USER, SocialExtUser.class, externalId);
//    }
//
//    @Override
//    public SocialExtBeneficiary findBeneficiary(String externalId) {
//
//        return restTemplate.getForObject(url + RESTURL_FIND_BENEFICIARY, SocialExtBeneficiary.class, externalId);
//    }
//
//    /**
//     * Crée un header avec l'id d'un utilisateur du portail.
//     *
//     * @param user
//     * @return
//     */
//    private HttpEntity<?> createUserHeader(SocialExtUser user) {
//
//        return createUserHeader(user != null ? user.getId() : null);
//    }
//
//    /**
//     * Crée un header avec l'id d'un utilisateur du portail.
//     *
//     * @param userId
//     * @return
//     */
//    private HttpEntity<Object> createUserHeader(String userId) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        if (userId != null) {
//            headers.add(HEADERNAME_USERID, userId);
//        }
//        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
//        return entity;
//    }
//
//    /**
//     * Crée un header avec un token d'authentification.
//     *
//     * @param token le token d'authentification
//     * @return
//     */
//    private HttpEntity<Object> createAuthTokenHeader(String token) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add(HEADERNAME_AUTH_TOKEN, token);
//        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
//        return entity;
//    }
//
//    @Override
//    public Set<SocialModule> getAvailableSocialModules() {
//        return restTemplate.exchange(url + RESTURL_GET_SOCIAL_MODULES, HttpMethod.GET, null, new ParameterizedTypeReference<Set<SocialModule>>() {
//        }).getBody();
//    }
//
//    @Override
//    public NewsList getNews(SocialWorkerUser user) throws SocialExtException {
//
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_GET_NEWS)
//                .queryParam(QUERYPARAM_SWUSERID, user.getSocialWorkerId());
//
//        return restTemplate.getForObject(builder.build().toUri(), NewsList.class);
//    }
//
//    @Override
//    public Map<SocialModuleScreen, String> getLinks(Set<SocialModuleScreen> screens, SocialExtUser user, String indexIndividual, String token) throws SocialExtException {
//
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_GET_LINKS)
//                .queryParam(QUERYPARAM_USERID, user.getId())
//                .queryParam(QUERYPARAM_INDIVIDUALID, indexIndividual);
//        for (SocialModuleScreen smc : screens) {
//            builder.queryParam(QUERYPARAM_SCREEN, smc);
//        }
//
//        return restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, createAuthTokenHeader(token), new ParameterizedTypeReference<Map<SocialModuleScreen, String>>() {
//        }).getBody();
//    }
//
//    @Override
//    public Map<SocialModule, String> getHomePages(Set<SocialModule> modules, SocialExtUser user, String token) throws SocialExtException {
//
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_GET_HOME_PAGES)
//                .queryParam(QUERYPARAM_USERID, user.getId());
//        for (SocialModule sm : modules) {
//            builder.queryParam(QUERYPARAM_SOCIALMODULE, sm);
//        }
//
//        return restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, createAuthTokenHeader(token), new ParameterizedTypeReference<Map<SocialModule, String>>() {
//        }).getBody();
//    }
//
//    @Override
    public String getLink(SolisLinkType linkType, String token, SocialExtUser user) throws SocialExtException {

        return "http://host:8080/context/businessuri?param1=123&param2=test";
    }
//
//    @Override
//    public SocialExtBeneficiaries searchIndividuals(Iterable<SearchCriterion<IndividualSearchCriterionType>> searchCriteria, Integer pageNumber, Integer pageSize) {
//        // Détermine si une pagination a été spécifiée.
//        boolean withPagination = pageNumber != null && pageSize != null;
//
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_SEARCH_INDIVIDUALS);
//        if (withPagination) {
//            builder = builder.queryParam(QUERYPARAM_PAGENUMBER, pageNumber);
//            builder = builder.queryParam(QUERYPARAM_PAGESIZE, pageSize);
//        }
//
//        // Appel du service REST. Le type du retour est différent selon qu'une pagination est ou non spécifiée.
//        List<SocialExtBeneficiary> beneficiaries = null;
//        if (withPagination) {
//            BeneficiarySearchResultDTO beneficiarySearchResult = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST, new HttpEntity<Object>(convertToDTO(searchCriteria)),
//                    new ParameterizedTypeReference<BeneficiarySearchResultDTO>() {
//            }).getBody();
//            beneficiaries = beneficiarySearchResult.getBeneficiaries();
//        } else {
//            beneficiaries = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST, new HttpEntity<Object>(convertToDTO(searchCriteria)),
//                    new ParameterizedTypeReference<List<SocialExtBeneficiary>>() {
//            }).getBody();
//        }
//
//        // Construit et retourne le résultat.
//        SocialExtBeneficiaries result = new SocialExtBeneficiaries();
//        if (beneficiaries != null) {
//            result.setBeneficiaries(beneficiaries);
//        } else {
//            result.setBeneficiaries(new ArrayList<SocialExtBeneficiary>());
//        }
//        return result;
//    }
//
//    @Override
//    public List<SocialExtMunicipality> suggestMunicipalities(String token) throws SocialExtException {
//
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_SUGGEST_MUNICIPALITIES)
//                .queryParam(QUERYPARAM_SUGGESTTOKEN, token);
//        return restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<SocialExtMunicipality>>() {
//        }).getBody();
//    }
//
//    @Override

    /**
     * Retourner une liste de lieux correspondant à une portion de nom donnée.
     *
     * @param token          Portion du nom du lieu.
     * @param municipalityId Id de la commune.
     * @return Liste de lieux dont le nom contient la portion donnée.
     */
    public List<SocialExtPlace> suggestPlaces(String token, String municipalityId) {
        List<SocialExtPlace> res = new ArrayList<>();
        SocialExtPlace socialExtPlace = new SocialExtPlace("avenue Jean Biray", "", "", "12345", 123, 64, "PAU", "64000", "64");
        res.add(socialExtPlace);
        return res;
    }
//
//    @Override
//    public Set<SocialModule> getAvailableSocialModulesForLifeLine() {
//        return restTemplate.exchange(url + RESTURL_GET_SOCIAL_MODULES_FOR_LIFE_LINE, HttpMethod.GET, null, new ParameterizedTypeReference<Set<SocialModule>>() {
//        }).getBody();
//    }
//
//    @Override
//    public AuthenticationResult authenticate(SocialExtUser user, String password) throws SocialExtException {
//
//        UserAndPwdDTO updto = new UserAndPwdDTO();
//        updto.setPassword(password);
//        updto.setUser(user);
//        return restTemplate.postForObject(url + RESTURL_AUTHENTICATE, updto, AuthenticationResult.class);
//    }
//
//    @Override

    /**
     * Recherche les message à afficher sur la page d'authentification.
     * @return Liste des messages
     */
    public List<LoginHomepageMessage> getAllLoginHomepageMessages() {
//        return restTemplate.exchange(url + RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES, HttpMethod.GET, null, new ParameterizedTypeReference<List<LoginHomepageMessage>>() {
//        }).getBody();

        List<LoginHomepageMessage> res = new ArrayList<>();
        LoginHomepageMessage loginHomepageMessage = new LoginHomepageMessage();
        loginHomepageMessage.setMessage("Message du jour sur la home page");
        loginHomepageMessage.setType(TypeLoginHomepageMessageEnum.INFO);
        res.add(loginHomepageMessage);
        return res;
    }
//
//    @Override
//    public List<SocialExtRendezVous> getIndividualRendezVous(String externalId) throws SocialExtException {
//
//        return restTemplate.exchange(url + RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS, HttpMethod.GET, null, new ParameterizedTypeReference<List<SocialExtRendezVous>>() {
//        }, externalId).getBody();
//    }
//
//    @Override
//    public Set<SocialExtRendezVous> getSocialWorkerRendezVous(SocialExtUser user, String externalId, Date startDate, Date endDate) throws SocialExtException {
//
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//
//        // Construction de l'url avec paramètre
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS)
//                .queryParam(QUERYPARAM_DATEDEBUT, df.format(startDate))
//                .queryParam(QUERYPARAM_DATEFIN, df.format(endDate));
//
//        Set<SocialExtRendezVous> lstRdv = restTemplate.exchange(builder.buildAndExpand(externalId).toUri(), HttpMethod.GET, createUserHeader(user), new ParameterizedTypeReference<Set<SocialExtRendezVous>>() {
//        }).getBody();
//
//        // Renseigne l'environnement dans chaque SocialExtConcerned.
//        for (SocialExtRendezVous rdv : lstRdv) {
//            if (rdv != null && rdv.getConcernedIndividuals() != null) {
//                for (SocialExtConcerned concernedIndividual : rdv.getConcernedIndividuals()) {
//                    if (concernedIndividual != null && concernedIndividual.getPortalExtIndividual() != null) {
//                        concernedIndividual.getPortalExtIndividual().setEnvironment(env);
//                    }
//                }
//            }
//        }
//
//        return lstRdv;
//    }
//
//    //---------------- pas optimisés ---------------------
//    @Override
//    public TypeAndIdRendezvous createSocialWorkerRendezVous(SocialExtRendezVous rendezVous) throws SocialExtException {
//
//        return restTemplate.postForObject(url + RESTURL_CREATE_SOCIAL_WORKER_RENDEZ_VOUS, rendezVous, TypeAndIdRendezvous.class);
//    }
//
//    @Override
//    public String getRedirectionToken(SocialExtUser user, Map<String, String> params) {
//
//        UserAndParamsDTO updto = new UserAndParamsDTO();
//        updto.setParams(params);
//        updto.setUser(user);
//        return restTemplate.postForObject(url + RESTURL_GET_REDIRECTION_TOKEN, updto, StringWrapperDTO.class).getString();
//    }
//
//    @Override
//    public void saveForm(SocialWorkerUser user, String formName, FormNodeList formNodeList) throws SocialExtException {
//
//        FormDTO fdto = new FormDTO();
//        fdto.setFormName(formName);
//        fdto.setFormNodeList(convertToDTO(formNodeList));
//        fdto.setUser(user);
//        restTemplate.postForObject(url + RESTURL_SAVE_FORM, fdto, Object.class);
//    }
//
//    private Set<SearchCriterionDTO> convertToDTO(Iterable<SearchCriterion<IndividualSearchCriterionType>> searchCriteria) {
//
//        Set<SearchCriterionDTO> criteria = new HashSet<SearchCriterionDTO>();
//
//        for (SearchCriterion<IndividualSearchCriterionType> sc : searchCriteria) {
//            SearchCriterionDTO scdto = new SearchCriterionDTO();
//            scdto.setValue(sc.getValue(Object.class));
//            scdto.setCriterionType(sc.getDesc().getCriterionType().name());
//            scdto.setCriterionValueClass(sc.getDesc().getCriterionType().getDataClass());
//            criteria.add(scdto);
//        }
//
//        return criteria;
//    }
//
//    private FormNodeListDTO convertToDTO(FormNodeList fnl) {
//
//        FormNodeListDTO fnldto = new FormNodeListDTO();
//
//        for (FormNode fn : fnl.getNodes()) {
//            if (fn instanceof FormNodeList) {
//                fnldto.getNodes().add(convertToDTO((FormNodeList) fn));
//            } else {
//                fnldto.getNodes().add(new FormNodeFieldDTO(fn.getName(), ((FormNodeField) fn).getValue()));
//            }
//        }
//
//        return fnldto;
//    }
//
//    /**
//     * Conversion d'un referentialDTO vers un ReferentialEntity. Attention :
//     * pour les ReferentialEntity des entrées parentes, seule l'id est
//     * renseigné.
//     *
//     * @param rdto
//     * @return
//     */
//    private ReferentialEntity convertFromDTO(ReferentialDTO rdto) {
//
//        ReferentialEntity re = new ReferentialEntity();
//
//        // Attributs
//        re.setId(rdto.getId());
//        re.setName(rdto.getName());
//
//        // Création de la liste des entrées
//        if (rdto.getEntries() != null) {
//            for (ReferentialEntryDTO parentRedto : rdto.getEntries()) {
//                re.addEntry(convertFromDto(parentRedto));
//            }
//        }
//
//        return re;
//    }
//
//    /**
//     * Conversion d'un ReferentialEntryDTO vers un ReferentialEntry. Attention :
//     * pour les ReferentialEntity des entrées parentes, seule l'id est
//     * renseigné.
//     *
//     * @param redto
//     * @return
//     */
//    private ReferentialEntry convertFromDto(ReferentialEntryDTO redto) {
//
//        // Création entité parente
//        ReferentialEntity parentEntity = new ReferentialEntity();
//        parentEntity.setId(redto.getParentRef());
//
//        // Création entrée
//        ReferentialEntry re = new ReferentialEntry(parentEntity, redto.getId(), redto.getValue());
//
//        // Création de la liste des entrées parentes
//        for (ReferentialEntryDTO parentRedto : redto.getParentEntries()) {
//            re.addParentEntry(convertFromDto(parentRedto));
//        }
//
//        return re;
//    }
//
//    @Override
//    public SocialExtWorker findSocialWorker(String socialWorkerId) {
//        return restTemplate.getForObject(url + RESTURL_FIND_SOCIAL_WORKER, SocialExtWorker.class, socialWorkerId);
//    }
//
//    @Override
//    public List<SocialExtMunicipality> findMunicipalitiesByZipCode(String zipCode) {
//        // TODO Auto-generated method stub
//        return new ArrayList<SocialExtMunicipality>();
//    }
//
//    @Override
//    public List<SocialExtAntenne> findAntennes(Long code, String libelle) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<SocialExtService> findServices(Long code, String libelle) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<SocialExtMunicipality> findMunicipalitiesByZipCode(String zipCode, String token) {
//        // TODO Auto-generated method stub
//        return new ArrayList<SocialExtMunicipality>();
//    }
//
//    @Override
//    public List<SocialExtMunicipality> suggestMunicipalitiesByZipCode(String zipcode, String token) throws SocialExtException {
//       return new ArrayList<SocialExtMunicipality>();
//    }
//



    private static Date localDateToDate(final LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public ReferentialDTO getReferential(String referential, String userId) {
        ReferentialDTO rdto = new ReferentialDTO();
        rdto.setId(Referential.valueOf(referential));
        rdto.setName(referential);
        ReferentialEntryDTO redto = new ReferentialEntryDTO();
        rdto.getEntries().add(redto);
        redto.setId("1");
        redto.setParentRef(rdto.getId());
        redto.setValue(referential + "1");
        return rdto;
    }
}
