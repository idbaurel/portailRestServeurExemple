package fr.infodb.exemples.portail.rest.serveur.services;

import fr.infodb.exemples.portail.rest.serveur.api.DataProvider;
import fr.infodb.exemples.portail.rest.serveur.dto.*;
import fr.infodb.exemples.portail.rest.serveur.dto.constants.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implémentation "bouchon" du fournisseur de données
 */
@Service("StubDataProvider")
public class StubDataProvider implements DataProvider {


    private static final DateTimeFormatter FRENCH_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Récupère la référence du dossier
     *
     * @param module     SocialModule concerné.
     * @param type       Type d'identifiant.
     * @param individuId Id de l'individu demandé
     * @return Référence du dossier.
     */
    @Override
    public StringWrapperDTO getModuleIdentifier(SocialModule module, ModuleIdentifierType type, String individuId) {
        return new StringWrapperDTO("ref-dossier-123");
    }

    /**
     * Récupère les aides liées à un bénéficiaire.
     *
     * @param userId     Id de l'utilisateur à l'origine de l'appel
     * @param individuId Id du bénéficiaire
     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
     */
    @Override
    public MesuresSociales getSocialFileMeasures(String userId, String individuId) {
        return stubMesuresSociales();
    }

    private MesuresSociales stubMesuresSociales() {
        MesuresSociales res = new MesuresSociales();

        GroupeMesuresSociales groupe1 = new GroupeMesuresSociales();
        //l'id du groupe provient du paramétrage stocké en BDD portail: LIFE_LINE_LABEL.LIFE_LINE_ID
        groupe1.setId("ASG");
        groupe1.setModuleMetier(SocialModule.ASG);
        res.getGroupesMesuresSociales().add(groupe1);

        MesureSociale mesure1 = new MesureSociale();
        mesure1.setIndex("ms-001");
        mesure1.setDateDebut(localDateToDate(LocalDate.of(2016, Month.APRIL, 23)));
        mesure1.setDateFin(localDateToDate(LocalDate.of(2017, Month.APRIL, 22)));
        mesure1.setLibelle("Mesure de soutien");
        mesure1.setLibelleDateDebut(null);
        mesure1.setLibelleDateFin(null);
        mesure1.setStatut(SocialExtMeasureState.UNKNOWN);
        groupe1.getMesuresSociales().add(mesure1);

        MesureSociale mesure2 = new MesureSociale();
        mesure2.setIndex("ms-002");
        mesure2.setDateDebut(localDateToDate(LocalDate.of(2017, Month.APRIL, 23)));
        mesure2.setDateFin(null);
        mesure2.setLibelle("Mesure d'accompagnement");
        mesure2.setLibelleDateDebut(null);
        mesure2.setLibelleDateFin(null);
        mesure2.setStatut(SocialExtMeasureState.IN_PROGRESS);
        groupe1.getMesuresSociales().add(mesure2);

        return res;
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
     * Retourne le dossier d'un bénéficiaire.
     *
     * @param userId     Id de l'utilisateur du portail à l'origine de cet appel
     * @param individuId Id du bénéficiaire recherché.
     * @return Un objet socialExtBeneficiary contenant le détail du bénéficiaire.
     */
    @Override
    public DossierBeneficiaire getFileRecord(String userId, String individuId) {
        return stubDossierBeneficiaire();
    }

    private DossierBeneficiaire stubDossierBeneficiaire() {
        DossierBeneficiaire res = new DossierBeneficiaire();
        res.setIndividu(stubIndividu());
        res.getAutresIndividus().addAll(stubAutresIndividus());
        res.getIntervenantSociaux().add(stubIntervenantSocial("sw-123456"));
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

        results.getUtilisateurs().add(stubUtilisateur("azerty-123"));
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
    public PaginationIntervenantsSociaux findAllSocialWorkers(int pageSize, int pageNumber) {
        PaginationIntervenantsSociaux pagination = new PaginationIntervenantsSociaux();

        pagination.setPageSize(pageSize);
        pagination.setPageNumber(pageNumber);
        pagination.setTotalNumber(1);

        final IntervenantSocial intervenantSocial = stubIntervenantSocial("is-123456");
        intervenantSocial.setUtilisateur(stubUtilisateur("azerty-123"));
        pagination.getIntervenantsSociaux().add(intervenantSocial);

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

        return res;
    }

    /**
     * Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale.
     *
     * @param pageSize   Taille de la page de résultats (=nombre de résultats retournés par cette requête).
     * @param pageNumber Numéro de la page de résultats demandée (commençant à 1).
     * @return Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.
     */
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
     * @param userId Id de l'utilisateur.
     * @return Un objet SocialExtUser correspondant à l'utilisateur recherché.
     */
    @Override
    public Utilisateur findSocialExtUser(String userId) {
        return stubUtilisateur(userId);
    }

    private Utilisateur stubUtilisateur(String externalId) {
        Utilisateur res = new Utilisateur();
        res.setId(externalId);
        res.setLogin("amelie.durand");
        res.setNom("DURAND");
        res.setPrenom("Amélie");
        res.setSecteur("PAU");
        res.setIntervenantSocialId("sw-123456");
        return res;
    }

    /**
     * Récupérer un bénéficiaire à partir de son id.
     *
     * @param individuId Identifiant du bénéficiaire.
     * @return Un objet SocialExtBeneficiary.
     */
    @Override
    public Individu findBeneficiary(String individuId) {
        return stubIndividu();
    }

    /**
     * Retourner les modules sociaux disponibles dans l'environnement courant.
     *
     * @return Un Set de SocialModule.
     */
    @Override
    public SocialModules getAvailableSocialModules() {
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
     * Rechercher dans les rendez-vous des individus.
     *
     * @param individuId Clé de l'individu
     * @return Une liste de SocialExtRendezVous.
     */
    @Override
    public ListeRendezVous getIndividualRendezVous(String individuId) {
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

    private Date convertLocalDateTimeToDateViaInstant(LocalDateTime dateToConvert) {
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

    /**
     * Rechercher tous les individus correspondant aux critères reçus
     *
     * @param rechercheIndividusRequest Critères pour filtrer les individus
     * @return Représentation des individus trouvés
     */
    @Override
    public PaginationIndividus searchIndividuals(RechercheIndividusRequest rechercheIndividusRequest) {
        final PaginationIndividus res = new PaginationIndividus();
        final Individu individu = stubIndividu();

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
}
