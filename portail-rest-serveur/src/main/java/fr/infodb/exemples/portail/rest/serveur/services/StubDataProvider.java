package fr.infodb.exemples.portail.rest.serveur.services;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.dto2.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service("StubDataProvider")
public class StubDataProvider implements DataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(StubDataProvider.class);

    private static final DateTimeFormatter FRENCH_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
    public MesuresSociales getSocialFileMeasures(String userId, String index) {
        return stubMesuresSociales(index);
    }

    private MesuresSociales stubMesuresSociales(String index) {
        MesuresSociales res = new MesuresSociales();

        GroupeMesuresSociales groupe1 = new GroupeMesuresSociales();
        //l'id du groupe provient du paramétrage stocké en BDD portail: LIFE_LINE_LABEL.LIFE_LINE_ID
        groupe1.setId("ASG");
        groupe1.setModuleMetier(SocialModule.ASG);

        res.getGroupesMesuresSociales().add(groupe1);



        MesureSociale mesure1 = new MesureSociale();
        mesure1.setIndex("ms-001");
        mesure1.setDateDebut(localDateToDate(LocalDate.of(2016, Month.APRIL,23)));
        mesure1.setDateFin(localDateToDate(LocalDate.of(2017, Month.APRIL,22)));
        mesure1.setLibelle("Mesure de soutien");
        mesure1.setLibelleDateDebut(null);
        mesure1.setLibelleDateFin(null);
        mesure1.setStatut(SocialExtMeasureState.UNKNOWN);
        groupe1.getMesuresSociales().add(mesure1);

        MesureSociale mesure2 = new MesureSociale();
        mesure2.setIndex("ms-002");
        mesure2.setDateDebut(localDateToDate(LocalDate.of(2017, Month.APRIL,23)));
        mesure2.setDateFin(null);
        mesure2.setLibelle("Mesure d'accompagnement");
        mesure2.setLibelleDateDebut(null);
        mesure2.setLibelleDateFin(null);
        mesure2.setStatut(SocialExtMeasureState.IN_PROGRESS);
        groupe1.getMesuresSociales().add(mesure2);

        return res;
    }

    private SocialExtBeneficiary stubSocialExtBeneficiary() {
        SocialExtBeneficiary res = new SocialExtBeneficiary();
        PortalSocialExtIndividual portalExtIndividual = new PortalSocialExtIndividual();
        portalExtIndividual.setIdExt("abc-123");
        res.setPortalExtIndividual(portalExtIndividual);
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
    public Profiles getProfiles(String userId) {
        Profiles res = new Profiles();
        res.getProfiles().add("Administrateur");
        return res;
    }

    /**
     * Retourner tous les profils utilisateurs actifs.
     *
     * @return Un Set de String correspondant aux profils utilisateurs.
     */
    @Override
    public Profiles getAvailableProfiles() {
        Profiles res = new Profiles();
        res.getProfiles().add("Administrateur");
        res.getProfiles().add("Secrétaire");
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
    public DossierBeneficiaire getFileRecord(String userId, String index) {
        return stubDossierBeneficiaire();
    }

    private DossierBeneficiaire stubDossierBeneficiaire() {
        DossierBeneficiaire res = new DossierBeneficiaire();
        res.setIndividu(stubIndividu());
        res.getAutresIndividus().addAll(stubAutresIndividus());
        res.getIntervenantSociaux().add(stubIntervenantSocial("sw-123456"));
//        return "abc-123".equals(res.getIndividu().getId()) ? res : null;
        return res;
    }

    private List<Individu> stubAutresIndividus() {
        List<Individu> res = new ArrayList<>();
        final Individu individu1 = stubIndividu();
        individu1.setId("abc-456");
        individu1.setDateNaissance(localDateToDate(LocalDate.of(1975, Month.DECEMBER, 22)));
        individu1.setNom("DUPONTEL");
        individu1.setPrenom("Frédéric");
        individu1.setNomNaissance(null);
        individu1.setGenre(IndividuGenre.HOMME);
        individu1.setEmail("frederic.dupontel@mail.fr");
        individu1.setMajeur(true);
        individu1.setMobile("0698765432");
        res.add(individu1);

        final Individu individu2 = stubIndividu();
        individu2.setId("abc-789");
        individu2.setDateNaissance(localDateToDate(LocalDate.of(2010, Month.SEPTEMBER, 3)));
        individu2.setNom("DUPONTEL");
        individu2.setPrenom("Eléonore");
        individu2.setNomNaissance(null);
        individu2.setGenre(IndividuGenre.FEMME);
        individu2.setEmail(null);
        individu2.setMajeur(false);
        individu2.setMobile(null);
        res.add(individu2);

        return res;
    }

//    /**
//     * Récupère la synthèse d'un individu.
//     *
//     * @param userId Id de l'utilisateur du portail à l'origine de cet appel
//     * @param index  Id du bénéficiaire recherché
//     * @return Un SocialExtBeneficiary, contenant le détail du bénéficiaire.
//     */
//    @Override
//    public SocialExtBeneficiary getIndividualSynthesis(String userId, String index) {
//        return stubSocialExtBeneficiary();
//    }

    /**
     * Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    @Override
    public PaginationUtilisateurs findAllUser(int pageSize, int pageNumber) {
        PaginationUtilisateurs results = new PaginationUtilisateurs();
        results.setPageNumber(pageNumber);
        results.setPageSize(pageSize);
        results.setTotalNumber(1);

        results.getUtilisateurs().add(getUtilisateur("azerty-123"));
        return results;
    }

    //    public UserSearchResultDTO findAllUser(int pageSize, int pageNumber) {
    //        UserSearchResultDTO results = new UserSearchResultDTO();
    //        results.setPageNumber(pageNumber);
    //        results.setPageSize(pageSize);
    //        results.setTotalNumber(1);
    //
    //        List<SocialExtUser> users = new ArrayList<>();
    //        users.add(findSocialExtUser("123"));
    //        results.setUsers(users);
    //        return results;
    //    }

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
    //    public SocialWorkerSearchResultDTO findAllSocialWorkers(int pageSize, int pageNumber) {
    //
    //        List<SocialExtWorker> workers = new ArrayList<>();
    //
    //        workers.add(findSocialWorker("123"));
    //
    //        SocialWorkerSearchResultDTO workersDTO = new SocialWorkerSearchResultDTO();
    //        workersDTO.setPageNumber(pageNumber);
    //        workersDTO.setPageSize(pageSize);
    //        workersDTO.setTotalNumber(workers.size());
    //
    //        for (int i = 0; i < pageSize; i++) {
    //            // Condition d'arrêt : nb total d'enregistrement atteint
    //            if ((pageNumber - 1) * pageSize + i >= workersDTO.getTotalNumber()) {
    //                break;
    //            }
    //            workersDTO.getWorkers().add(workers.get((pageNumber * pageSize + i) % workers.size()));
    //        }
    //
    //        return workersDTO;
    //    }
    public PaginationIntervenantsSociaux findAllSocialWorkers(int pageSize, int pageNumber) {
        PaginationIntervenantsSociaux pagination = new PaginationIntervenantsSociaux();

        pagination.setPageSize(pageSize);
        pagination.setPageNumber(pageNumber);
        pagination.setTotalNumber(1);

        pagination.getIntervenantsSociaux().add(stubIntervenantSocial("is-123456"));

        return pagination;
    }

    private IntervenantSocial stubIntervenantSocial(String id) {
        IntervenantSocial res = new IntervenantSocial();
        res.setId(id);

        res.setCommentaire("no comment");
        res.setPrenom("Amélie");
        res.setNom("DURAND");
        res.setEmail("amelie.durand@emailprovider.fr");
        res.setSecteur("PAU");
        res.getSecteurs().add("PAU");
        res.getSecteurs().add("secteur 1");
        res.getSecteurs().add("secteur 2");
        res.setTelephone("0501020304");
        res.setGenre(IndividuGenre.FEMME);
        res.setUtilisateur(getUtilisateur("azerty-123"));

        return res;
    }

    /**
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
    //    @Override
    //    public BeneficiarySearchResultDTO findAllIndividuals(int pageSize, int pageNumber) {
    //        List<SocialExtBeneficiary> beneficiaries = new ArrayList<>();
    //        beneficiaries.add(findBeneficiary("123"));
    //
    //        BeneficiarySearchResultDTO bsrdto = new BeneficiarySearchResultDTO();
    //        bsrdto.setTotalNumber(beneficiaries.size());
    //
    //        for (int i = 0; i < pageSize; i++) {
    //            // Condition d'arrêt : nb total d'enregistrement atteint
    //            if ((pageNumber - 1) * pageSize + i >= bsrdto.getTotalNumber()) {
    //                break;
    //            }
    //            bsrdto.getBeneficiaries().add(beneficiaries.get((pageNumber * pageSize + i) % beneficiaries.size()));
    //        }
    //
    //        bsrdto.setPageNumber(pageNumber);
    //        bsrdto.setPageSize(pageSize);
    //
    //        return bsrdto;
    //    }
    @Override
    public PaginationIndividus findAllIndividuals(int pageSize, int pageNumber) {
        PaginationIndividus paginationIndividus = new PaginationIndividus();
        paginationIndividus.getIndividus().addAll(stubIndividus());
        paginationIndividus.setPageSize(pageSize);
        paginationIndividus.setPageNumber(pageNumber);
        paginationIndividus.setTotalNumber(paginationIndividus.getIndividus().size());
        return paginationIndividus;
    }

    private List<Individu> stubIndividus() {
        List<Individu> individus = new ArrayList<>(1);
        individus.add(stubIndividu());
        return individus;
    }

    private Individu stubIndividu() {
        Individu individu = new Individu();

        individu.setId("abc-123");
        individu.setNom("DUPONTEL");
        individu.setPrenom("Marie hélène");
        individu.setGenre(IndividuGenre.FEMME);
        individu.setDecede(false);
        individu.setCaf("0123456789-abcdef...");
        individu.setEmail("mh.dupontel@mailer.fr");
        individu.setDateNaissance(localDateToDate(LocalDate.of(1980, Month.MARCH, 26)));
        individu.setMajeur(true);
        individu.setMobile("0601020304");
        individu.setNomNaissance("MARTIN");
        individu.setSecteurDossier("Pau");
        individu.setSecteurSuivi("Bayonne");
        individu.setTel("0501020304");
        individu.setTelTravail("0599887766");
        individu.setAdresse(stubAdresse());
        return individu;
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

    public Utilisateur getUtilisateur(String externalId) {
        Utilisateur res = new Utilisateur();
        res.setId(externalId);
        res.setLogin("amelie.durand");
        res.setNom("DURAND");
        res.setPrenom("Amélie");
        res.setSecteur("PAU");

        //        res.setSectorList(new ArrayList<String>() {{
        //            add("PAU");
        //            add("secteur 1");
        //            add("secteur 2");
        //        }});
        //        res.setSocialWorkerId("sw-123456");
        //        res.setLinkedWithSocialWorker(true);

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
        return stubSocialExtBeneficiary();
    }

    /**
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     */
    @Override
    public SocialModules getAvailableSocialModules() {
        //        return Arrays.stream(SocialModule.values())
        //                .filter(v -> v.getName().startsWith("F"))
        //                .collect(Collectors.toSet());

        SocialModules res = new SocialModules();
        res.getModules().add(SocialModule.ASE);
        res.getModules().add(SocialModule.ASG);
        res.getModules().add(SocialModule.AST);
        res.getModules().add(SocialModule.FSL);
        return res;
    }

    /**
     * Récupérer les tâches à accomplir par un travailleur social
     *
     * @param socialWorkerId Id du travailleur social concerné.
     * @return Représentation des tâches à accomplir par un travailleur social
     */
    @Override
    public TachesUtilisateur getNews(String socialWorkerId) {
        TachesUtilisateur res = new TachesUtilisateur();

        TacheUtilisateur news = new TacheUtilisateur();
        news.setDateEcheance(new Date());
        news.setLibelle("tâche 1");
        news.getDetails().add("détail 1");
        news.getDetails().add("détail 2");
        news.getDetails().add("détail 3");
        news.setSocialModule(SocialModule.ASG);
        news.setIdIndividuConcerne("abc-123");
        news.setPrenomIndividuConcerne("Marie hélène");
        news.setNomIndividuConcerne("DUPONTEL");
        news.setGenreIndividuConcerne(IndividuGenre.FEMME);
        news.setTypeTache(TacheUtilisateurType.PROCESSUS_ASG);

        res.getTaches().add(news);
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
    public SocialModules getAvailableSocialModulesForLifeLine() {
        SocialModules res = new SocialModules();
        res.getModules().add(SocialModule.ASG);
        res.getModules().add(SocialModule.FSL);
        return res;
    }

    /**
     * Authentifier un utilisateur.
     *
     * @param request Représentation d'un utilisateur avec mot de passe
     * @return Résultat de l'authentification (enum correspondant aux différents statuts possibles
     */
    @Override
    public AuthenticationResult authenticate(AuthenticationRequest request) {
        String login = request.getLogin();
        String password = request.getPassword();
        if (login == null || password == null) {
            return AuthenticationResult.KO;
        }
        return "amelie.durand".equals(login) && "secret".equals(password) ? AuthenticationResult.OK : AuthenticationResult.KO;
    }

    /**
     * Recherche les message à afficher sur la page d'authentification.
     *
     * @return Liste des messages
     */
    //    @Override
    //    public List<LoginHomepageMessage> getAllLoginHomepageMessages() {
    //        List<LoginHomepageMessage> res = new ArrayList<>();
    //        LoginHomepageMessage loginHomepageMessage = new LoginHomepageMessage();
    //        loginHomepageMessage.setMessage("Message du jour sur la home page");
    //        loginHomepageMessage.setType(TypeLoginHomepageMessageEnum.INFO);
    //        res.add(loginHomepageMessage);
    //        return res;
    //    }
    @Override
    public LoginHomepageMessages getAllLoginHomepageMessages() {
        LoginHomepageMessages res = new LoginHomepageMessages();
        LoginHomepageMessages.LoginHomepageMessage loginHomepageMessage = new LoginHomepageMessages.LoginHomepageMessage();
        loginHomepageMessage.setMessage(String.format("Application 64: Message du %s sur la page d'authentification", FRENCH_FORMATTER.format(LocalDate.now())));
        loginHomepageMessage.setType(TypeLoginHomepageMessageEnum.INFO);
        res.getMessages().add(loginHomepageMessage);
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
    public ListeRendezVous getIndividualRendezVous(String externalId) {
        return stubListeRendezVous("is-123456");
    }

    /**
     * Rechercher dans les rendez-vous des travailleurs sociaux.
     *
     * @param userId         Id de l'utilisateur portail à l'origine de l'appel
     * @param socialWorkerId Id du travailleur social
     * @param startDate      Date de début de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @param endDate        Date de fin de la période de recherche, format yyyy-MM-ddTHH:mm:ss
     * @return Représentation d'une liste de rendez-vous
     * @throws SocialExtException Si les dates ne sont pas correctes
     */
    @Override
    public ListeRendezVous getSocialWorkerRendezVous(String userId, String socialWorkerId, String startDate, String endDate) {

        //        //exemple de conversion de java.lang.String vers java.util.Date
        //        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //        Date start;
        //        Date end;
        //        try {
        //            start = df.parse(startDate);
        //            end = df.parse(endDate);
        //        } catch (ParseException e) {
        //            throw new SocialExtException("Erreur de parsing de date", e);
        //        }

        //        //exemple de conversion de java.lang.String vers java.time.LocalDateTime
        //        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        //        LocalDateTime dateTime = LocalDateTime.parse(startDate, formatter);

        return stubListeRendezVous(socialWorkerId);
    }

    private ListeRendezVous stubListeRendezVous(String socialWorkerId) {
        ListeRendezVous res = new ListeRendezVous();
        res.getRendezVous().add(stubRendezVous(socialWorkerId));
        return res;
    }

    private RendezVous stubRendezVous(String socialWorkerId) {
        LocalDate now = LocalDate.now();
        LocalDateTime debut = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 10, 0);
        LocalDateTime fin = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 11, 30);

        RendezVous rdv = new RendezVous();
        rdv.setAdresse(stubAdresse());
        rdv.setCodeTypeRdv(1);
        rdv.setCommentaire("pas de commentaire");
        rdv.setDateDebut(convertLocalDateTimeToDateViaInstant(debut));

        //côté Portail Agent, la durée est prioritaire sur la date de fin si les 2 informations sont renseignées
        rdv.setDateFin(convertLocalDateTimeToDateViaInstant(fin));
        rdv.setDuree(60L);

        rdv.setId("rdv-12345");
        rdv.setJourneeComplete(false);
        rdv.setLibelle("rendez vous de suivi");
        rdv.setModule(SocialModule.AST);
        rdv.setMotif("absence de nouvelle");
        rdv.setPlaceType(SocialExtPlaceType.DOMICILE);
        rdv.setPlaceTypeCode("ptc-123");
        rdv.setPlaceTypeLabel("ptc label");
        rdv.setStatut(RendezVousStatutsEnum.PLANNED);
        rdv.setType(SocialExtRendezVousType.VAD);

        rdv.getIndividus().add(stubIndividu());
        rdv.getIntervenantsSociaux().add(stubIntervenantSocial(socialWorkerId));
        return rdv;
    }

    Date convertLocalDateTimeToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }

    private Adresse stubAdresse() {
        Adresse adresse = new Adresse();
        adresse.setCirconscription("circo 1");
        adresse.setCodeCommune("1");
        adresse.setCodeDepartement("64");
        adresse.setCodeLieu("0022");
        adresse.setCodePostal("64000");
        adresse.setComplementAdresse("batiment B");
        adresse.setComplementDestinataire("Pour M. Jacques Dupond");
        adresse.setLibelleCommune("PAU");
        adresse.setLibelleLieu("avenue Jean Mermoz");
        adresse.setNumero("12bis");
        adresse.setSecteur("PAU EST");
        adresse.setTelephoneSecteur("0599999999");
        adresse.setUniteTerritoriale("territoire 1");
        return adresse;
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

//    /**
//     * Récupérer un token de redirection.
//     *
//     * @param updto Wrapper autour d'un SocialExtUSer (habilitation) et une map de paramètres.
//     * @return Token de redirection.
//     */
//    @Override
//    public String getRedirectionToken(UserAndParamsDTO updto) {
//        return "stub_token";
//    }

    /**
     * Récupérer un intervenant social à partir de son id.
     *
     * @param socialWorkerId Id de l'intervenant social.
     */
    @Override
    public IntervenantSocial findSocialWorker(String socialWorkerId) {
        return stubIntervenantSocial(socialWorkerId);
    }

    /**
     * Récupération des valeurs d'un référentiel (nomenclature).
     *
     * @param referential Enum correspondant au type de référentiel voulu.
     * @return Un objet ReferentialDTO qui contient les valeurs du référentiel. Ce DTO contient une liste de ReferentialEntryDTO.
     * @see Referential
     */
    @Override
    public ReferentialDTO getReferential(String referential) {
        ReferentialDTO rDto = new ReferentialDTO();
        rDto.setId(Referential.valueOf(referential));
        rDto.setName(referential);
        ReferentialEntryDTO reDto = new ReferentialEntryDTO();
        rDto.getEntries().add(reDto);
        reDto.setId("1");
        reDto.setParentRef(rDto.getId());
        reDto.setValue(referential + "1");
        return rDto;
    }

    //    /**
    //     * "Rechercher dans les individus.
    //     *
    //     * @param searchCriteria Set de critères de recherche. Chaque critère contient un type, une classe et une valeur.
    //     * @return Une liste d'individus correspondant aux critères.
    //     * @see SearchCriterionDTO
    //     */
    //    @Override
    //    public List<SocialExtBeneficiary> findAllIndividuals(Set<SearchCriterionDTO> searchCriteria) {
    //        List<SocialExtBeneficiary> res = new ArrayList<>();
    //        res.add(findBeneficiary("123"));
    //        return res;
    //    }

    /**
     * Rechercher tous les individus correspondant aux critères reçus
     *
     * @param rechercheIndividusRequest Critères pour filtrer les individus
     * @return Représentation des individus trouvés
     */
    @Override
    public PaginationIndividus findAllIndividuals(RechercheIndividusRequest rechercheIndividusRequest) {
        final PaginationIndividus res = new PaginationIndividus();
        final Individu individu = stubIndividu();
        //        if (rechercheIndividusRequest.getNom() != null && rechercheIndividusRequest.isRechercheSurNomDeNaissance()) {
        //            individu.setNomNaissance(rechercheIndividusRequest.getNom());
        //        } else if (rechercheIndividusRequest.getNom() != null) {
        //            individu.setNom(rechercheIndividusRequest.getNom());
        //        }
        //        if (rechercheIndividusRequest.getDateNaissance() != null) {
        //            individu.setDateNaissance(rechercheIndividusRequest.getDateNaissance());
        //        }

        res.getIndividus().add(individu);
        res.setPageNumber(1);
        res.setPageSize(1);
        res.setTotalNumber(1);
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
    private Environment stubEnvironment() {
        return new Environment("application64", "Application 64", "Application de gestion des aides sociales du CD64");
    }
}
