package fr.infodb.exemples.portail.rest.serveur.services;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

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
     * @param userId Id de l'utilisateur à l'origine de l'appel
     * @param index Id du bénéficiaire
     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
     */
    public SocialExtBeneficiary getSocialFileMeasures(String userId, String index) {

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
    public Set<String> getProfiles(String user) {
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

    /**
     * Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    public UserSearchResultDTO findAllUser(int pageSize, int pageNumber) {
        UserSearchResultDTO results = new UserSearchResultDTO();
        results.setPageNumber(pageNumber);
        results.setPageSize(pageSize);
        results.setTotalNumber(1);

        List<SocialExtUser> users = new ArrayList<>();
        users.add(findSocialExtUser("123"));
        results.setUsers(users);
        return results;
    }
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

    /**
     * Récupérer tous les travailleurs sociaux.
     * <p>
     * Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    public SocialWorkerSearchResultDTO findAllSocialWorkers(int pageSize, int pageNumber) {

        List<SocialExtWorker> workers = new ArrayList<SocialExtWorker>();

        workers.add(findSocialWorker("123"));

        SocialWorkerSearchResultDTO workersDTO = new SocialWorkerSearchResultDTO();
        workersDTO.setPageNumber(pageNumber);
        workersDTO.setPageSize(pageSize);
        workersDTO.setTotalNumber(workers.size());

        for (int i = 0; i < pageSize; i++) {
            // Condition d'arrêt : nb total d'enregistrement atteint
            if ((pageNumber - 1) * pageSize + i >= workersDTO.getTotalNumber()) {
                break;
            }
            workersDTO.getWorkers().add(workers.get((pageNumber * pageSize + i) % workers.size()));
        }

        return workersDTO;
    }
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

    /**
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    public BeneficiarySearchResultDTO findAllIndividuals(int pageSize, int pageNumber) {
        List<SocialExtBeneficiary> beneficiaries = new ArrayList<>();
        beneficiaries.add(findBeneficiary("123"));

        BeneficiarySearchResultDTO bsrdto = new BeneficiarySearchResultDTO();
        bsrdto.setTotalNumber(beneficiaries.size());

        for (int i = 0; i < pageSize; i++) {
            // Condition d'arrêt : nb total d'enregistrement atteint
            if ((pageNumber - 1) * pageSize + i >= bsrdto.getTotalNumber()) {
                break;
            }
            bsrdto.getBeneficiaries().add(beneficiaries.get((pageNumber * pageSize + i) % beneficiaries.size()));
        }

        bsrdto.setPageNumber(pageNumber);
        bsrdto.setPageSize(pageSize);

        return bsrdto;
    }
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

    /**
     * Récupérer un utilisateur à partir de son id.
     *
     * @param externalId Id de l'utilisateur.
     * @return Un objet SocialExtUser correspondant à l'utilisateur recherché.
     */
    public SocialExtUser findSocialExtUser(String externalId) {
        SocialExtUser res = new SocialExtUser();
        res.setId(externalId);
        res.setUsername("amelie.durand");
        res.setFirstName("DURAND");
        res.setLastName("Amélie");
        res.setLinkedWithSocialWorker(true);
        res.setSector("PAU");
        res.setSectorList(new ArrayList<String>() {{
            add("PAU");
            add("secteur 1");
            add("secteur 2");
        }});
        res.setSocialWorkerId("sw-123456");
        return res;
    }
//
//    @Override

    /**
     * Récupérer un bénéficiaire à partir de son id.
     * @param externalId Identifiant du bénéficiaire.
     * @return Un objet SocialExtBeneficiary.
     */
    public SocialExtBeneficiary findBeneficiary(String externalId) {
        SocialExtBeneficiary res = new SocialExtBeneficiary();
        res.setLastName("DUPONT");
        res.setFirstName("Marie Hélène");
        res.setBirthDate(localDateToDate(LocalDate.of(1980, Month.APRIL, 24)));

        return res;
    }
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
    /**
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     */
    public Set<SocialModule> getAvailableSocialModules() {
        return Arrays.stream(SocialModule.values())
                .filter(v-> v.getName().startsWith("A"))
                .collect(Collectors.toSet());
    }
//
//    @Override

    /**
     * Récupérer les news relatives à un travailleur social.
     *
     * @param userId Id du travailleur social concerné.
     * @return Un objet NewsList, qui contient une liste de News. L'objet News contient une date et une liste de lignes de contenu (type String).
     */
    public NewsList getNews(String userId) {
        NewsList res = new NewsList();
        res.setNewsList(new ArrayList<>());
        News news = new News(new Date(), "information 1");
        res.getNewsList().add(news);
        return res;
    }
//
//    @Override

    /**
     * Récupérer les liens de débranchement vers les écrans de Solis.
     *
     * @param screens Ensemble d'écrans.
     * @param user Utilisateur du portail
     * @param indexIndividual Id de l'individu concerné
     * @param token Token d'authentification.
     * @return Une Map avec en clé une enum correspondant aux écrans et en valeur une String contenant le lien
     * @throws SocialExtException
     */
    public Map<SocialModuleScreen, String> getLinks(Set<SocialModuleScreen> screens, String user, String indexIndividual, String token) {
        Map<SocialModuleScreen, String> res = new HashMap<>();
        if (screens != null) {
            for (SocialModuleScreen screen : screens) {
                res.put(screen, "http://host:8080/applicationMetier/" + screen.getName());
            }
        }
        return res;
    }
//
//    @Override

    /**
     * Récupérer les liens vers les pages d'accueil des modules sociaux
     *
     * @param modules Ensemble de modules.
     * @param user    Utilisateur du portail
     * @param token   Token d'authentification
     * @return Une Map avec en clé une enum correspondant aux modules et en valeur une String contenant le lien.
     */
    public Map<SocialModule, String> getHomePages(Set<SocialModule> modules, String user, String token) {
        Map<SocialModule, String> res = new HashMap<>();
        if (modules != null) {
            for (SocialModule module : modules) {
                res.put(module, "http://host:8080/applicationMetier/" + module.getName());
            }
        }
        return res;
    }
//
//    @Override
    public String getLink(SolisLinkType linkType, String token, SocialExtUser user) throws SocialExtException {

        return "http://host:8080/applicationMetier/businessuri?param1=123&param2=test";
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

    /**
     * Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités.
     *
     * @param token Contient les premiers caractères de la municipalité.
     * @return Liste de SocialExtMunicipalities.
     */
    public List<SocialExtMunicipality> suggestMunicipalities(String token) {
        List<SocialExtMunicipality> res = new ArrayList<>();
        SocialExtMunicipality socialExtMunicipality = new SocialExtMunicipality(1, 64, "PAU", "64000");
        res.add(socialExtMunicipality);
        return res;
    }
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

    /**
     * Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.
     *
     * @return Un Set de SocialModule.
     */
    public Set<SocialModule> getAvailableSocialModulesForLifeLine() {
        //renvoie ceux commençant par "A"
        return Arrays.stream(SocialModule.values())
                .filter(v-> v.getName().startsWith("A"))
                .collect(Collectors.toSet());
    }
//
//    @Override

    /**
     * Authentifier un utilisateur.
     *
     * @param updto Représentation d'un utilisateur avec mot de passe
     * @return Résultat de l'authentification (enum correspondant aux différents statuts possibles
     */
    public AuthenticationResult authenticate(UserAndPwdDTO updto) {
        SocialExtUser user = updto.getUser();
        String password = updto.getPassword();
        if (user == null || password == null) {
            return AuthenticationResult.KO;
        }
        return "amelie.durand".equals(user.getUsername()) ? AuthenticationResult.OK : AuthenticationResult.KO;
    }
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
    /**
     * fixme erreur de serialisation SocialExtRendezVous
     * Rechercher dans les rendez-vous des individus.
     *
     * @param externalId Clé de l'individu
     * @return Une liste de SocialExtRendezVous.
     */
    public List<SocialExtRendezVous> getIndividualRendezVous(String externalId) {
        List<SocialExtRendezVous> res = new ArrayList<>();
        SocialExtRendezVous socialExtRendezVous = new SocialExtRendezVous();
        socialExtRendezVous.setLabel("rendez vous 1");
        socialExtRendezVous.setType(SocialExtRendezVousType.CIRCO);
        res.add(socialExtRendezVous);
        return res;
    }
//
//    @Override
    /**
     * fixme erreur de serialisation SocialExtRendezVous
     * Rechercher dans les rendez-vous des travailleurs sociaux.
     *
     * @param userId         Id de l'utilisateur portail à l'origine de l'appel
     * @param socialWorkerId Id du travailleur social
     * @param startDate      Date de début de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @param endDate        Date de fin de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @return Un Set de SocialExtRendezVous.
     * @throws SocialExtException Si les dates ne sont pas correctes
     */
    public Set<SocialExtRendezVous> getSocialWorkerRendezVous(String userId, String socialWorkerId, String startDate, String endDate) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date start;
        Date end;
        try {
            start = df.parse(startDate);
            end = df.parse(endDate);
        } catch (ParseException e) {
            throw new SocialExtException("Erreur de parsing de date", e);
        }

        Set<SocialExtRendezVous> res = new HashSet<>();
//        SocialExtRendezVous socialExtRendezVous = new SocialExtRendezVous();
//        socialExtRendezVous.setLabel("rendez vous 1");
//        socialExtRendezVous.setType(SocialExtRendezVousType.CIRCO);
//        res.add(socialExtRendezVous);
//        res.add(socialExtRendezVous);


        //************************************************************
        SocialExtRendezVous rdv = new SocialExtRendezVous();
        Random random = new Random();
        rdv.setId(String.valueOf(random.nextInt()));
        Calendar calendar = Calendar.getInstance();
        rdv.setStartDate(calendar.getTime());
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        rdv.setEndDate(calendar.getTime());
        rdv.setFullDay(false);
        rdv.setType(SocialExtRendezVousType.COMMISSION);
//        rdv.setIndividual(findBeneficiary("200"));
        rdv.setLabel("Objectif : Evaluation - Etat : Prévu");
        rdv.setComment("comment");

        res.add(rdv);
        //************************************************************




        return res;
    }
//
//    //---------------- pas optimisés ---------------------
//    @Override
    public String createSocialWorkerRendezVous(SocialExtRendezVous rendezVous) {
        TypeAndIdRendezvous typeAndIdRendezvous = new TypeAndIdRendezvous(123, TypeRendezVous.RENDEZ_VOUS_CENTRALISE);
        return typeAndIdRendezvous.getId() + ":" + typeAndIdRendezvous.getType().name();
    }
//
//    @Override

    /**
     * Récupérer un token de redirection.
     *
     * @param updto Wrapper autour d'un SocialExtUSer (habilitation) et une map de paramètres.
     * @return Token de redirection.
     */
    public String getRedirectionToken(UserAndParamsDTO updto) {
        return "stub_token";
    }
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

    /**
     * Récupérer un intervenant social à partir de son id.
     * @param socialWorkerId Id de l'intervenant social.
     * @return
     */
    public SocialExtWorker findSocialWorker(String socialWorkerId) {
        SocialExtWorker res = new SocialExtWorker();
        res.setComment("no comment");
        res.setFirstName("Amélie");
        res.setLastName("DURAND");
        res.setMail("amelie.durand@emailprovider.fr");
        PortalSocialExtWorker portalSocialExtWorker = new PortalSocialExtWorker();
        portalSocialExtWorker.setEnvironment(getStubEnvironment());
        portalSocialExtWorker.setIdExt(socialWorkerId);
        res.setPortalExtWorker(portalSocialExtWorker);
        res.setRendezVous(null);
        res.setSector("PAU");
        res.setSectorList(new ArrayList<String>() {{
            add("PAU");
            add("secteur 1");
            add("secteur 2");
        }});
        res.setTelephone("0501020304");
        res.setTitle("");
        Set<SocialExtUser> users;
        res.setUsers(new HashSet<>());
        final SocialExtUser socialExtUser = findSocialExtUser("123");
        socialExtUser.setSocialWorkerId(socialWorkerId);
        res.getUsers().add(socialExtUser);
        return res;
    }

    private Environment getStubEnvironment() {
        Environment environment = new Environment("application64", "Application 64", "Application de gestion des aides sociales du CD64");
        return environment;
    }
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

    /**
     * "Rechercher dans les individus.
     *
     * @param searchCriteria Set de critères de recherche. Chaque critère contient un type, une classe et une valeur.
     * @return Une liste d'individus correspondant aux critères.
     * @see SearchCriterionDTO
     */
    public List<SocialExtBeneficiary> findAllIndividuals(Set<SearchCriterionDTO> searchCriteria) {
        List<SocialExtBeneficiary> res = new ArrayList<>();
        res.add(findBeneficiary("123"));
        return res;
    }
}
