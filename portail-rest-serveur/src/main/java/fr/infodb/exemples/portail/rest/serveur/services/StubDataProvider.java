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
public class StubDataProvider implements DataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(StubDataProvider.class);

    /**
     * Evénement SIRH
     *
     * @param userId Identifiant de l'utilisateur
     * @return Nombre d'événement pour l'utilisateur
     */
    @Override
    public Long getNumberSirhEvents(String userId) {
        return 0L;
    }

    /**
     * Recherche des offres de services
     *
     * @param individualId Identifiant du bénéficiaire
     * @return Liste d'offre
     */
    @Override
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

    /**
     * Récupère la référence du dossier
     *
     * @param module     SocialModule concerné.
     * @param type       Type d'identifiant.
     * @param externalId Id du user portail à l'origine de l'appel
     * @return Référence du dossier.
     */
    @Override
    public String getModuleIdentifier(SocialModule module, ModuleIdentifierType type, String externalId) {
        return "ref-dossier-123";
    }

    /**
     * Récupère les aides liées à un bénéficiaire.
     *
     * @param userId Id de l'utilisateur à l'origine de l'appel
     * @param index  Id du bénéficiaire
     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
     */
    @Override
    public SocialExtBeneficiary getSocialFileMeasures(String userId, String index) {
        return getSocialExtBeneficiary();
    }

    private SocialExtBeneficiary getSocialExtBeneficiary() {
        SocialExtBeneficiary res = new SocialExtBeneficiary();
        res.setLastName("DUPONT");
        res.setFirstName("Marie Hélène");
        res.setBirthDate(localDateToDate(LocalDate.of(1980, Month.APRIL, 24)));
        return res;
    }

    /**
     * Créer un individu.
     *
     * @param beneficiary Données de l'individu à créer
     * @return Identifiant de l'individu créer
     */
    @Override
    public String createIndividuals(SocialExtBeneficiary beneficiary) {
        return "123456";
    }

    /**
     * Modifier un individu.
     *
     * @param beneficiary Paramètres de l'individu à modifier.
     * @see SocialExtBeneficiary
     */
    @Override
    public void updateIndividual(SocialExtBeneficiary beneficiary) {
        LOGGER.info("Mise à jour de l'individu {} {}", beneficiary.getLastName(), beneficiary.getFirstName());
    }

    /**
     * Retourner les profils d'un utilisateur si l'id de l'utilisateur est renseigné.
     * <p>
     * Si l'id n'est pas renseigné, retourner la liste de tous les profils.
     *
     * @param userId Id de l'utilisateur.
     * @return Un Set de String correspondant aux profils.
     */
    @Override
    public Set<String> getProfiles(String userId) {
        Set<String> res = new HashSet<>();
        res.add("Administrateur");
        return res;
    }

    /**
     * Retourner tous les profils utilisateurs actifs.
     *
     * @return Un Set de String correspondant aux profils utilisateurs.
     */
    @Override
    public Set<String> getAvailableProfiles() {
        Set<String> res = new HashSet<>();
        res.add("Administrateur");
        res.add("Secrétaire");
        return res;
    }

    /**
     * Retourner un ensemble de lieux en fonction d'un type donné.
     *
     * @param type Type de lieu
     * @return Les lieux correspondant au type de lieu donné.
     * @see SocialExtPlaceType
     */
    @Override
    public Set<SocialExtPlace> getPlacesByType(SocialExtPlaceType type) {

        Set<SocialExtPlace> res = new HashSet<>();
        SocialExtPlace socialExtPlace = new SocialExtPlace("avenue Jean Biray", "", "", "12345", 123, 64, "PAU", "64000", "64");
        res.add(socialExtPlace);
        return res;
    }

    /**
     * Retourner la circonscription liée à un lieu.
     *
     * @param placeId Identifiant du lieu
     * @return Circonscription liée à un lieu.
     */
    @Override
    public String getCirco(String placeId) {
        return "Pau-Nord";
    }

    /**
     * Retourne le dossier d'un bénéficiaire.
     *
     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
     * @param index  Id du bénéficiaire recherché.
     * @return Un objet socialExtBeneficiary contenant le détail du bénéficiaire.
     */
    @Override
    public SocialExtBeneficiary getFileRecord(String userId, String index) {
        return getSocialExtBeneficiary();
    }

    /**
     * Récupère la synthèse d'un individu.
     *
     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
     * @param index  Id du bénéficiaire recherché
     * @return Un SocialExtBeneficiary, contenant le détail du bénéficiaire.
     */
    @Override
    public SocialExtBeneficiary getIndividualSynthesis(String userId, String index) {
        return getSocialExtBeneficiary();
    }

    /**
     * Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @Override
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

    /**
     * Récupérer tous les travailleurs sociaux.
     * <p>
     * Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @Override
    public SocialWorkerSearchResultDTO findAllSocialWorkers(int pageSize, int pageNumber) {

        List<SocialExtWorker> workers = new ArrayList<>();

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

    /**
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @Override
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

    /**
     * Récupérer un utilisateur à partir de son id.
     *
     * @param externalId Id de l'utilisateur.
     * @return Un objet SocialExtUser correspondant à l'utilisateur recherché.
     */
    @Override
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

    /**
     * Récupérer un bénéficiaire à partir de son id.
     *
     * @param externalId Identifiant du bénéficiaire.
     * @return Un objet SocialExtBeneficiary.
     */
    @Override
    public SocialExtBeneficiary findBeneficiary(String externalId) {
        return getSocialExtBeneficiary();
    }

    /**
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     */
    @Override
    public Set<SocialModule> getAvailableSocialModules() {
        return Arrays.stream(SocialModule.values())
                .filter(v -> v.getName().startsWith("A"))
                .collect(Collectors.toSet());
    }

    /**
     * Récupérer les news relatives à un travailleur social.
     *
     * @param userId Id du travailleur social concerné.
     * @return Un objet NewsList, qui contient une liste de News. L'objet News contient une date et une liste de lignes de contenu (type String).
     */
    @Override
    public NewsList getNews(String userId) {
        NewsList res = new NewsList();
        res.setNewsList(new ArrayList<>());
        News news = new News(new Date(), "information 1");
        res.getNewsList().add(news);
        return res;
    }

    /**
     * Récupérer les liens de débranchement vers les écrans de Solis.
     *
     * @param screens         Ensemble d'écrans.
     * @param user            Utilisateur du portail
     * @param indexIndividual Id de l'individu concerné
     * @param token           Token d'authentification.
     * @return Une Map avec en clé une enum correspondant aux écrans et en valeur une String contenant le lien
     */
    @Override
    public Map<SocialModuleScreen, String> getLinks(Set<SocialModuleScreen> screens, String user, String indexIndividual, String token) {
        Map<SocialModuleScreen, String> res = new HashMap<>();
        if (screens != null) {
            for (SocialModuleScreen screen : screens) {
                res.put(screen, "http://host:8080/applicationMetier/" + screen.getName());
            }
        }
        return res;
    }

    /**
     * Récupérer les liens vers les pages d'accueil des modules sociaux
     *
     * @param modules Ensemble de modules.
     * @param user    Utilisateur du portail
     * @param token   Token d'authentification
     * @return Une Map avec en clé une enum correspondant aux modules et en valeur une String contenant le lien.
     */
    @Override
    public Map<SocialModule, String> getHomePages(Set<SocialModule> modules, String user, String token) {
        Map<SocialModule, String> res = new HashMap<>();
        if (modules != null) {
            for (SocialModule module : modules) {
                res.put(module, "http://host:8080/applicationMetier/" + module.getName());
            }
        }
        return res;
    }

    /**
     * Retourne un lien de débranchement vers un écran SOLIS indépendant d'un module social.
     *
     * @param token    Token d'authentification
     * @param linkType Type de lien pour débranchement
     * @return Le lien http.
     * @see SolisLinkType
     */
    @Override
    public String getLink(SolisLinkType linkType, String token, SocialExtUser user) throws SocialExtException {
        return "http://host:8080/applicationMetier/businessuri?param1=123&param2=test";
    }

    /**
     * Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités.
     *
     * @param token Contient les premiers caractères de la municipalité.
     * @return Liste de SocialExtMunicipalities.
     */
    @Override
    public List<SocialExtMunicipality> suggestMunicipalities(String token) {
        List<SocialExtMunicipality> res = new ArrayList<>();
        SocialExtMunicipality socialExtMunicipality = new SocialExtMunicipality(1, 64, "PAU", "64000");
        res.add(socialExtMunicipality);
        return res;
    }

    /**
     * Retourner une liste de lieux correspondant à une portion de nom donnée.
     *
     * @param token          Portion du nom du lieu.
     * @param municipalityId Id de la commune.
     * @return Liste de lieux dont le nom contient la portion donnée.
     */
    @Override
    public List<SocialExtPlace> suggestPlaces(String token, String municipalityId) {
        List<SocialExtPlace> res = new ArrayList<>();
        SocialExtPlace socialExtPlace = new SocialExtPlace("avenue Jean Biray", "", "", "12345", 123, 64, "PAU", "64000", "64");
        res.add(socialExtPlace);
        return res;
    }

    /**
     * Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie.
     *
     * @return Un Set de SocialModule.
     */
    @Override
    public Set<SocialModule> getAvailableSocialModulesForLifeLine() {
        //renvoie ceux commençant par "A"
        return Arrays.stream(SocialModule.values())
                .filter(v -> v.getName().startsWith("A"))
                .collect(Collectors.toSet());
    }

    /**
     * Authentifier un utilisateur.
     *
     * @param updto Représentation d'un utilisateur avec mot de passe
     * @return Résultat de l'authentification (enum correspondant aux différents statuts possibles
     */
    @Override
    public AuthenticationResult authenticate(UserAndPwdDTO updto) {
        SocialExtUser user = updto.getUser();
        String password = updto.getPassword();
        if (user == null || password == null) {
            return AuthenticationResult.KO;
        }
        return "amelie.durand".equals(user.getUsername()) ? AuthenticationResult.OK : AuthenticationResult.KO;
    }

    /**
     * Recherche les message à afficher sur la page d'authentification.
     *
     * @return Liste des messages
     */
    @Override
    public List<LoginHomepageMessage> getAllLoginHomepageMessages() {
        List<LoginHomepageMessage> res = new ArrayList<>();
        LoginHomepageMessage loginHomepageMessage = new LoginHomepageMessage();
        loginHomepageMessage.setMessage("Message du jour sur la home page");
        loginHomepageMessage.setType(TypeLoginHomepageMessageEnum.INFO);
        res.add(loginHomepageMessage);
        return res;
    }

    /**
     * fixme erreur de serialisation SocialExtRendezVous
     * Rechercher dans les rendez-vous des individus.
     *
     * @param externalId Clé de l'individu
     * @return Une liste de SocialExtRendezVous.
     */
    @Override
    public List<SocialExtRendezVous> getIndividualRendezVous(String externalId) {
        List<SocialExtRendezVous> res = new ArrayList<>();
        SocialExtRendezVous socialExtRendezVous = new SocialExtRendezVous();
        socialExtRendezVous.setLabel("rendez vous 1");
        socialExtRendezVous.setType(SocialExtRendezVousType.CIRCO);
        res.add(socialExtRendezVous);
        return res;
    }

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
    @Override
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
        SocialExtRendezVous rdv = new SocialExtRendezVous();
        Random random = new Random();
        rdv.setId(String.valueOf(random.nextInt()));
        Calendar calendar = Calendar.getInstance();
        rdv.setStartDate(calendar.getTime());
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        rdv.setEndDate(calendar.getTime());
        rdv.setFullDay(false);
        rdv.setType(SocialExtRendezVousType.COMMISSION);
        rdv.setIndividual(findBeneficiary("200"));
        rdv.setLabel("Objectif : Evaluation - Etat : Prévu");
        rdv.setComment("comment");

        res.add(rdv);

        return res;
    }

    /**
     * Créer un rendez-vous pour un intervenant social.
     *
     * @param rendezVous Paramètres du rendez-vous (date, travailleurs sociaux, etc...)
     * @return L'id du rendez-vous créé.
     * @see SocialExtRendezVous
     */
    @Override
    public String createSocialWorkerRendezVous(SocialExtRendezVous rendezVous) {
        TypeAndIdRendezvous typeAndIdRendezvous = new TypeAndIdRendezvous(123, TypeRendezVous.RENDEZ_VOUS_CENTRALISE);
        return typeAndIdRendezvous.getId() + ":" + typeAndIdRendezvous.getType().name();
    }

    /**
     * Récupérer un token de redirection.
     *
     * @param updto Wrapper autour d'un SocialExtUSer (habilitation) et une map de paramètres.
     * @return Token de redirection.
     */
    @Override
    public String getRedirectionToken(UserAndParamsDTO updto) {
        return "stub_token";
    }

    /**
     * Récupérer un intervenant social à partir de son id.
     *
     * @param socialWorkerId Id de l'intervenant social.
     */
    @Override
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
        res.setUsers(new HashSet<>());
        final SocialExtUser socialExtUser = findSocialExtUser("123");
        socialExtUser.setSocialWorkerId(socialWorkerId);
        res.getUsers().add(socialExtUser);
        return res;
    }

    /**
     * Récupération des valeurs d'un référentiel (nomenclature).
     *
     * @param referential Enum correspondant au type de référentiel voulu.
     * @param userId      Id du user à l'origine de l'appel
     * @return Un objet ReferentialDTO qui contient les valeurs du référentiel. Ce DTO contient une liste de ReferentialEntryDTO.
     * @see Referential
     */
    @Override
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
    @Override
    public List<SocialExtBeneficiary> findAllIndividuals(Set<SearchCriterionDTO> searchCriteria) {
        List<SocialExtBeneficiary> res = new ArrayList<>();
        res.add(findBeneficiary("123"));
        return res;
    }

    /**
     * Conversion d'un java.time.LocalDate en java.util.Date
     *
     * @param localDate LocalDate à convertir
     * @return Nouvelle instance de java.util.Date
     */
    private static Date localDateToDate(final LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Stub d'une représentation de l'environnement d'origine des données
     *
     * @return Représentation de l'environnement d'origine des données
     */
    private Environment getStubEnvironment() {
        return new Environment("application64", "Application 64", "Application de gestion des aides sociales du CD64");
    }
}
