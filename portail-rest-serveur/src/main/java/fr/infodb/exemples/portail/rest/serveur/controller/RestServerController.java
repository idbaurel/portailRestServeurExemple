package fr.infodb.exemples.portail.rest.serveur.controller;

//import fr.infodb.portail.spi.api.RestDataProvider;
//import fr.infodb.portail.spi.api.StubDataProvider;
//import fr.infodb.portail.spi.api.rest.RestSocialExtDataProvider;
//import fr.infodb.portail.spi.api.rest.dto.*;
//import fr.infodb.portail.spi.impl.StubEnvironmentResourceProvider;
//import fr.infodb.portail.spi.model.SocialWorkerUser;
//import fr.infodb.portail.spi.model.externalsocialbusiness.*;
//import fr.infodb.portail.spi.model.portalconfig.*;
//import fr.infodb.portail.spi.model.referential.Referential;
//import org.apache.commons.lang.CharEncoding;
//import org.apache.cxf.jaxrs.ext.xml.XMLName;
//import org.apache.cxf.jaxrs.model.wadl.Description;
//import org.apache.cxf.jaxrs.model.wadl.Descriptions;
//import org.apache.cxf.jaxrs.model.wadl.DocTarget;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;
import fr.infodb.exemples.portail.rest.serveur.services.RestDataProvider;
import fr.infodb.exemples.portail.rest.serveur.services.StubDataProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Services Rest exposés
 */
@RestController
@RequestMapping("/portail/spi")
@Api(tags="InfoDB, services rest Portail Agent", value="Concernant la gestion des erreurs : les conventions classiques REST sont appliquées, côté client seules les erreurs 404 seront remontées de façon différente.")
public class RestServerController /*implements RestSocialExtDataProvider*/ {


    //fournisseur de données de test
    private final StubDataProvider sdp;

    @Autowired
    public RestServerController(StubDataProvider stubDataProvider) {
        this.sdp = stubDataProvider;
    }


//
//	/** Permet de récupérer les données de test. */
//	private StubDataProvider sdp;
//
//	/** Logger slf4j. */
//	private static final Logger LOGGER = LoggerFactory.getLogger(RestServerResource.class);
//
//	public RestServerResource(Environment env, StubEnvironmentResourceProvider resourceProvider) {
//    	sdp = new StubDataProvider(env, resourceProvider);
//    }
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_NUMBER_SIRH_EVENTS)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Retourne, pour l'utilisateur spécifié, le nombre d'évènements en attente de traitement issus du SIRH."),
//		@Description(target=DocTarget.RETURN, value="Le nombre d'évènements.")
//	})
//    public Long getNumberSirhEvents(@Description("Identifiant de l'utilisateur") @PathParam("userId") String userId) {
//    	return sdp.getNumberSirhEvents(userId);
//    }

//
        @GetMapping(RestDataProvider.RESTURL_GET_NUMBER_SIRH_EVENTS)
        @ApiOperation("Retourne, pour l'utilisateur spécifié, le nombre d'évènements en attente de traitement issus du SIRH.")
        public Long getNumberSirhEvents(@ApiParam("Identifiant de l'utilisateur") @PathVariable("userId") String userId) {
        	return sdp.getNumberSirhEvents(userId);
        }

//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_BUSINESS_OFFERS)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Recherche les offres de service pour un individu."),
//		@Description(target=DocTarget.RETURN, value="Une liste d'offres de service.")
//	})
//    @XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}BusinessOffer")
//	public List<BusinessOffer> getBusinessOffers(
//			@Description("Clé de l'individu") @PathParam(RestDataProvider.PATHPARAM_BENEFICIARYID) String individualId) {
//
//		return sdp.getBusinessOffers(individualId);
//	}
    @GetMapping(RestDataProvider.RESTURL_GET_BUSINESS_OFFERS)
    @ApiOperation("Recherche les offres de service pour un individu.")
    public List<BusinessOffer> getBusinessOffers(
            @PathVariable(RestDataProvider.PATHPARAM_BENEFICIARYID) String individualId) {

        return sdp.getBusinessOffers(individualId);
    }

//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Recherche les message à afficher sur la page d'authentification."),
//		@Description(target=DocTarget.RETURN, value="Une liste de messages.")
//	})
//    @XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}LoginHomepageMessage")
//	public List<LoginHomepageMessage> getAllLoginHomepageMessages() {
//		return sdp.getAllLoginHomepageMessages();
//	}

    @GetMapping(RestDataProvider.RESTURL_GET_ALL_LOGIN_HOMEPAGE_MESSAGES)
    @ApiOperation("Recherche les message à afficher sur la page d'authentification.")
    	public List<LoginHomepageMessage> getAllLoginHomepageMessages() {
    		return sdp.getAllLoginHomepageMessages();
    	}
//
//	@Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_MODULE_IDENTIFIER)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupère la référence du dossier."),
//		@Description(target=DocTarget.RETURN, value="Référence du dossier.")
//	})
//	public StringWrapperDTO getModuleIdentifier(
//			@Description("Id du user portail à l'origine de l'appel") @HeaderParam(RestDataProvider.HEADERNAME_USERID) String userId,
//			@Description("SocialModule concerné.") @PathParam(RestDataProvider.PATHPARAM_SOCIALMODULE) SocialModule socialModule,
//			@Description("Type d'identifiant.") @QueryParam(RestDataProvider.QUERYPARAM_MODULEIDTYPE) ModuleIdentifierType moduleIdType) {
//
//		return new StringWrapperDTO(sdp.getModuleIdentifier(socialModule, moduleIdType, userId));
//	}

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

        return new StringWrapperDTO(sdp.getModuleIdentifier(socialModule, moduleIdType, userId));
    }
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_GET_FILE_RECORD)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Retourne le dossier d'un bénéficiaire."),
//		@Description(target=DocTarget.RETURN, value="aaa Un objet socialExtBeneficiary contenant le détail du bénéficiaire.")
//	})
//	public SocialExtBeneficiary getFileRecord(
//			@HeaderParam(RestDataProvider.HEADERNAME_USERID) @Description("Id de l'utilisateur du portail à l'origine de cet appel (pour habilitation ?)") String userId,
//			@PathParam(RestDataProvider.PATHPARAM_BENEFICIARYID) @Description("Id du bénéficiaire recherché.") String index)
//	throws SocialExtException {
//
//		LOGGER.debug("GetFileRecord : userId=" + userId + ", index=" + index);
//
//		SocialExtUser seu = new SocialExtUser("User" + userId);
//
//		return sdp.getFileRecord(seu, index);
//	}

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
        return sdp.getFileRecord(new SocialExtUser("User" + userId), index);
    }
//
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_GET_INDIVIDUAL_SYNTHESIS)
//	@Descriptions({
//			@Description(target = DocTarget.METHOD, value = "Récupère la synthèse d'un individu. Il s'agit probablement d'un doublon avec getFileRecord."),
//			@Description(target = DocTarget.RETURN, value = "Un SocialExtBeneficiary, contenant le détail du bénéficiare.") })
//	public SocialExtBeneficiary getIndividualSynthesis(
//			@HeaderParam(RestDataProvider.HEADERNAME_USERID) @Description("Id de l'utilisateur du portail à l'origine de cet appel (pour habilitation ?)") String userId,
//			@PathParam(RestDataProvider.PATHPARAM_BENEFICIARYID) @Description("Id du bénéficiaire recherché") String index) {
//
//		LOGGER.debug("GetIndividualSynthesis : userId=" + userId + ", index=" + index);
//
//		SocialExtUser seu = new SocialExtUser("User" + userId);
//
//		return sdp.getIndividualSynthesis(seu, index);
//	}

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
        return sdp.getIndividualSynthesis(new SocialExtUser("User" + userId), index);
    }
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_GET_REFERENTIAL)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupération des valeurs d'un référentiel (nomenclature)."),
//		@Description(target=DocTarget.RETURN, value="Un objet ReferentialDTO qui contient les valeurs du référentiel. Ce DTO contient une liste de ReferentialEntryDTO."
//		+" Rq : la liste de parentEntries dans ces DTO correspond à des entrées 'parentes' dans d'autres référentiels, ce qui permet de créer des liens entre référentiels."
//		+ " Exemple : un thème est lié à un domaine.")
//	})
//	public ReferentialDTO getReferential(
//			@Description("Enum correspondant au type de référentiel voulu.") @PathParam(RestDataProvider.PATHPARAM_REFERENTIAL) String referential,
//			@Description("Id du user à l'origine de l'appel (pour habilitation ?)") @HeaderParam(RestDataProvider.HEADERNAME_USERID) String userId)
//			throws SocialExtException {
//
//		LOGGER.debug("Header reçu : " + userId + ", ref reçu : " + referential);
//
//		ReferentialDTO rdto = new ReferentialDTO();
//		rdto.setId(Referential.valueOf(referential));
//		rdto.setName(referential);
//		ReferentialEntryDTO redto = new ReferentialEntryDTO();
//		rdto.getEntries().add(redto);
//		redto.setId("1");
//		redto.setParentRef(rdto.getId());
//		redto.setValue(referential + "1");
//		// pas de parentEntries pour l'instant
//
//		return rdto;
//	}

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
        return sdp.getReferential(referential, userId);
    }
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_GET_LINK)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Retourne un lien de débranchement vers un écran SOLIS indépendant d'un module social."),
//		@Description(target=DocTarget.RETURN, value="Le lien.")
//	})
//	public StringWrapperDTO getLink(
//			@Description("Token d'authentification") @HeaderParam(RestDataProvider.HEADERNAME_AUTH_TOKEN) String token,
//			@Description("Type de lien pour débranchement") @PathParam(RestDataProvider.PATHPARAM_LINKTYPE) String linkType) throws SocialExtException {
//
//		String link = sdp.getLink(SolisLinkType.valueOf(linkType), token, null);
//		return new StringWrapperDTO(link);
//	}

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
        return new StringWrapperDTO(sdp.getLink(SolisLinkType.valueOf(linkType), token, null));
    }
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_GET_SOCIAL_FILE_MEASURES)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer les aides liées à un bénéficiaire."),
//		@Description(target=DocTarget.RETURN, value="Un objet SocialExtBeneficiary contenant le détail des aides.")
//	})
//	public SocialExtBeneficiary getSocialFileMeasures(
//			@Description("Id du SocialExtUser à l'origine de l'appel (habilitations ?)") @HeaderParam(RestDataProvider.HEADERNAME_USERID) String userId,
//			@Description("Id du bénéficiaire.") @PathParam(RestDataProvider.PATHPARAM_BENEFICIARYID) String beneficiaryId) {
//
//		LOGGER.debug("Récupération aides, paramètres reçus : userId=" + userId + ", beneficiaryId=" + beneficiaryId);
//
//		return sdp.getSocialFileMeasures(createMockSocialExtUser(userId), beneficiaryId);
//	}

    /**
     * Récupérer les aides liées à un bénéficiaire.
     *
     * @param userId Id du SocialExtUser à l'origine de l'appel
     * @param beneficiaryId Id du bénéficiaire.
     * @return Un objet SocialExtBeneficiary contenant le détail des aides.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_SOCIAL_FILE_MEASURES)
    @ApiOperation("Récupérer les aides liées à un bénéficiaire.")
    public SocialExtBeneficiary getSocialFileMeasures(
            @RequestHeader(RestDataProvider.HEADERNAME_USERID) String userId,
            @PathVariable(RestDataProvider.PATHPARAM_BENEFICIARYID) String beneficiaryId) {
        return sdp.getSocialFileMeasures(createMockSocialExtUser(userId), beneficiaryId);
    }
//
//
//    @Override
//    @POST
//    @Path(RestDataProvider.RESTURL_CREATE_INDIVIDUAL)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Crée un individu."),
//		@Description(target=DocTarget.RETURN, value="L'id de l'individu créé.")
//	})
//    public StringWrapperDTO createIndividuals(
//    		@Description("Paramètres de l'individu à créer.") SocialExtBeneficiary beneficiary) throws SocialExtException {
//
//    	LOGGER.debug("Individu à créer : " + beneficiary);
//
//        return new StringWrapperDTO(sdp.createIndividuals(beneficiary));
//        // TODO voir dans le stub ce qu'on peut mettre
//    }

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
        return new StringWrapperDTO(sdp.createIndividuals(beneficiary));
    }
//
//    @Override
//    @PUT
//    @Path(RestDataProvider.RESTURL_UPDATE_INDIVIDUAL)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Modifie un individu."),
//		@Description(target=DocTarget.RETURN, value="Vide.")
//	})
//    public void updateIndividual(@Description("Paramètres de l'individu à modifier.") SocialExtBeneficiary beneficiary) throws SocialExtException {
//
//    	LOGGER.debug("Individu à modifier : " + beneficiary);
//
//        sdp.updateIndividual(beneficiary);
//        // TODO voir dans le stub ce qu'on peut mettre
//    }

    /**
     * Modifier un individu.
     *
     * @param beneficiary Paramètres de l'individu à modifier.
     */
    @PutMapping(RestDataProvider.RESTURL_UPDATE_INDIVIDUAL)
    @ApiOperation("Modifier un individu.")
    public void updateIndividual(@RequestBody SocialExtBeneficiary beneficiary) {
        sdp.updateIndividual(beneficiary);
    }
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_PROFILES)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Retourne les profils d'un utilisateur."),
//		@Description(target=DocTarget.RETURN, value="Un Set de String correspondant aux profils utilisateur.")
//	})
//    public Set<String> getProfiles(
//    		@Description("Id de l'utilisateur.") @QueryParam(RestDataProvider.QUERYPARAM_USERID) String userId) throws SocialExtException {
//
//    	// Si pas de param => getAvailableProfiles
//    	if (userId == null) {
//			return sdp.getAvailableProfiles();
//		}
//
//    	// Sinon => getProfiles
//    	SocialExtUser seu = createMockSocialExtUser(userId);
//
//        return sdp.getProfiles(seu);
//    }

    /**
     * Retourner les profils d'un utilisateur.
     *
     * @param userId Id de l'utilisateur.
     * @return Un Set de String correspondant aux profils utilisateur.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_PROFILES)
    @ApiOperation("Retourner les profils d'un utilisateur.")
    public Set<String> getProfiles(@RequestParam(value = RestDataProvider.QUERYPARAM_USERID, required = false) String userId) {

        // Si pas de param => getAvailableProfiles
        if (userId == null) {
            return sdp.getAvailableProfiles();
        }

        // Sinon => getProfiles
        SocialExtUser seu = createMockSocialExtUser(userId);
        return sdp.getProfiles(seu);
    }
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_PLACES_BY_TYPE)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Retourne un ensemble de lieux en fonction d'un type donné."),
//		@Description(target=DocTarget.RETURN, value="Les lieux correspondant au type de lieu donné.")
//	})
//    @XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}SocialExtPlace")
//    public Set<SocialExtPlace> getPlacesByType(
//    		@Description("Type de lieu") @QueryParam(RestDataProvider.QUERYPARAM_PLACETYPE) SocialExtPlaceType type) throws SocialExtException {
//
//        return sdp.getPlacesByType(type);
//    }

    /**
     * Retourner un ensemble de lieux en fonction d'un type donné.
     * @param type Type de lieu
     * @return Les lieux correspondant au type de lieu donné.
     * @see SocialExtPlaceType
     */
    @GetMapping(RestDataProvider.RESTURL_GET_PLACES_BY_TYPE)
    @ApiOperation("Retourner un ensemble de lieux en fonction d'un type donné.")
    public Set<SocialExtPlace> getPlacesByType(
            @RequestParam(RestDataProvider.QUERYPARAM_PLACETYPE) SocialExtPlaceType type) {
        return sdp.getPlacesByType(type);
    }

//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_CIRCO)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Retourne la circonscription liée à un lieu."),
//		@Description(target=DocTarget.RETURN, value="Un wrapper de String, contenant la circonscription.")
//	})
//    public StringWrapperDTO getCirco(
//    		@Description("Identifiant du lieu.") @PathParam(RestDataProvider.PATHPARAM_PLACEID) String placeId) throws SocialExtException {
//
//    	return new StringWrapperDTO(sdp.getCirco(placeId));
//    }

    /**
     * Retourner la circonscription liée à un lieu.
     *
     * @param placeId Identifiant du lieu.
     * @return Un wrapper de String, contenant la circonscription.
     */
    @GetMapping(RestDataProvider.RESTURL_GET_CIRCO)
    @ApiOperation("Retourner la circonscription liée à un lieu.")
    public StringWrapperDTO getCirco(@PathVariable(RestDataProvider.PATHPARAM_PLACEID) String placeId) {
        return new StringWrapperDTO(sdp.getCirco(placeId));
    }
//
//	@Override
//    @GET
//    @Path(RestDataProvider.RESTURL_SUGGEST_PLACES)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Retourne une liste de lieux correspondant à une portion de nom donnée."),
//		@Description(target=DocTarget.RETURN, value="Liste de lieux dont le nom contient la portion donnée.")
//	})
//	@XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}SocialExtPlace")
//	public List<SocialExtPlace> suggestPlaces(
//			@Description("Id de la commune.") @PathParam(RestDataProvider.PATHPARAM_MUNICIPALITYID) String municipalityId,
//			@Description("Portion du nom du lieu.") @QueryParam(RestDataProvider.QUERYPARAM_SUGGESTTOKEN) String token)
//			throws SocialExtException {
//
//		return sdp.suggestPlaces(token, municipalityId);
//	}

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
        return sdp.suggestPlaces(token, municipalityId);
    }
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_SUGGEST_MUNICIPALITIES)
//	@Descriptions({
//			@Description(target = DocTarget.METHOD, value = "Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités."),
//			@Description(target = DocTarget.RETURN, value = "Liste de SocialExtMunicipalities.") })
//	@XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}SocialExtMunicipality")
//	public List<SocialExtMunicipality> suggestMunicipalities(
//			@QueryParam(RestDataProvider.QUERYPARAM_SUGGESTTOKEN) @Description("Contient les premiers caractères de la municipalité.") String token)
//			throws SocialExtException {
//
//		return sdp.suggestMunicipalities(token);
//	}
    //@GetMapping()
//    @ApiOperation()
//
//	@Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_LINKS)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer les liens de débranchement vers les écrans de Solis."),
//		@Description(target=DocTarget.RETURN, value="Une Map avec en clé une enum correspondant aux écrans et en valeur une String contenant le lien.")
//	})
//	public Map<SocialModuleScreen, String> getLinks(
//			@Description("Token d'authentification.") @HeaderParam(RestDataProvider.HEADERNAME_AUTH_TOKEN) String token,
//			@Description("Ensemble d'écrans.")  @QueryParam(RestDataProvider.QUERYPARAM_SCREEN) Set<SocialModuleScreen> screens,
//			@Description("Id de l'utilisateur du portail.") @QueryParam(RestDataProvider.QUERYPARAM_USERID) String userId,
//			@Description("Id de l'individu concerné.") @QueryParam(RestDataProvider.QUERYPARAM_INDIVIDUALID) String individualId)
//			throws SocialExtException {
//
//		SocialExtUser seu = createMockSocialExtUser(userId);
//		return sdp.getLinks(screens, seu, individualId, token);
//	}
    //@GetMapping()
//    @ApiOperation()
//
//	@Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_HOME_PAGES)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer les liens vers les pages d'accueil des modules sociaux."),
//		@Description(target=DocTarget.RETURN, value="Une Map avec en clé une enum correspondant aux modules et en valeur une String contenant le lien.")
//	})
//	public Map<SocialModule, String> getHomePages(
//			@Description("Token d'authentification.") @HeaderParam(RestDataProvider.HEADERNAME_AUTH_TOKEN) String token,
//			@Description("Id de l'utilisateur du portail.") @QueryParam(RestDataProvider.QUERYPARAM_USERID) String userId,
//			@Description("Ensemble de modules.")  @QueryParam(RestDataProvider.QUERYPARAM_SOCIALMODULE) Set<SocialModule> modules)
//		throws SocialExtException {
//
//		return sdp.getHomePages(modules, createMockSocialExtUser(userId), token);
//	}
    //@GetMapping()
//    @ApiOperation()
//
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_FIND_BENEFICIARY )
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer un bénéficiaire à partir de son id."),
//		@Description(target=DocTarget.RETURN, value="Un objet SocialExtBeneficiary.")
//	})
//    public SocialExtBeneficiary findBeneficiary(
//    		@Description("Identifiant du bénéficiaire.") @PathParam(RestDataProvider.PATHPARAM_BENEFICIARYID) String externalId) {
//
//        return sdp.findBeneficiary(externalId);
//    }
    //@GetMapping()
//    @ApiOperation()
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_FIND_SOCIAL_EXT_USER)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer un utilisateur à partir de son id."),
//		@Description(target=DocTarget.RETURN, value="Un objet SocialExtUser correspondant à l'utilisateur recherché.")
//	})
//    public SocialExtUser findSocialExtUser(
//    		@PathParam(RestDataProvider.PATHPARAM_USERID) @Description("Id de l'utilisateur.") String externalId) {
//
//        return sdp.findSocialExtUser(externalId);
//    }
    //@GetMapping()
//    @ApiOperation()
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_FIND_SOCIAL_WORKER)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer un intervenant social à partir de son id."),
//		@Description(target=DocTarget.RETURN, value="Un objet SocialExtWorker correspondant à l'intervenant social recherché.")
//	})
//    public SocialExtWorker findSocialWorker(
//    		@PathParam(RestDataProvider.PATHPARAM_SOCIALWORKERID) @Description("Id de l'intervenant social.") String externalId) {
//
//        return sdp.findSocialWorker(externalId);
//    }
    //@GetMapping()
//    @ApiOperation()
//
//
//	@Override
//    @POST
//    @Path(RestDataProvider.RESTURL_AUTHENTICATE)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Authentifie un utilisateur."),
//		@Description(target=DocTarget.RETURN, value="Résultat de l'authentification (enum correspondant aux différents statuts possibles).")
//	})
//	public AuthenticationResult authenticate(@Description("DTO contenant le login (String) et le mot de passe (String).") UserAndPwdDTO updto)
//			throws SocialExtException {
//
//		return sdp.authenticate(updto.getUser(), updto.getPassword());
//	} // TODO : utilisation de l'enum de spi-portail => à ré-écrire ?
    //@GetMapping()
//    @ApiOperation()
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_SOCIAL_MODULES_FOR_LIFE_LINE)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie."),
//		@Description(target=DocTarget.RETURN, value="Un Set de SocialModule.")
//	})
//    @XMLName("{http://www.infodb.fr/solis/portail/portalconfig}SocialModule")
//    public Set<SocialModule> getAvailableSocialModulesForLifeLine() {
//
//        return sdp.getAvailableSocialModulesForLifeLine();
//    } // TODO : écrire un dto pour le retour ?
    //@GetMapping()
//    @ApiOperation()
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_FIND_ALL_MUNICIPALITIES)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer toutes les communes. ***A priori cette méthode n'est pas utilisée.***"),
//		@Description(target=DocTarget.RETURN, value="Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.")
//	})
//	@XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}SocialExtMunicipality")
//	public MunicipalitySearchResultDTO findAllMunicipalities(
//			@Description("Taille de la page de résultats (=nombre de résultats retournés par cette requête).") @QueryParam(RestDataProvider.QUERYPARAM_PAGESIZE) int pageSize,
//			@Description("Numéro de la page de résultats demandée (commençant à 1).") @QueryParam(RestDataProvider.QUERYPARAM_PAGENUMBER) int pageNumber) {
//
//		Iterator<SocialExtMunicipality> it = sdp.findAllMunicipalities().getItems();
//
//		LOGGER.debug("Paramètres reçus : pageSize=" + pageSize + ", pageNumber=" + pageNumber);
//
//		List<SocialExtMunicipality> municipalities = new ArrayList<SocialExtMunicipality>();
//		while (it.hasNext()) {
//			municipalities.add(it.next());
//		}
//
//		MunicipalitySearchResultDTO municipalitiesDTO = new MunicipalitySearchResultDTO();
//		municipalitiesDTO.setPageNumber(pageNumber);
//		municipalitiesDTO.setPageSize(pageSize);
//		municipalitiesDTO.setTotalNumber(10);
//
//		for (int i=0; i<pageSize; i++) {
//			// Condition d'arrêt : nb total d'enregistrement atteint
//			if ((pageNumber-1)*pageSize + i >= municipalitiesDTO.getTotalNumber()) {
//				break;
//			}
//			municipalitiesDTO.getMunicipalities().add(municipalities.get((pageNumber*pageSize + i) % municipalities.size()));
//		}
//
//		return municipalitiesDTO;
//	}
    //@GetMapping()
//    @ApiOperation()
//
//    @Override
//	@GET
//	@Path(RestDataProvider.RESTURL_FIND_ALL_PLACES)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupération de tous les lieux. ***A priori cette méthode n'est pas utilisée.***"),
//		@Description(target=DocTarget.RETURN, value="Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.")
//	})
//    @XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}SocialWorker")
//    public PlaceSearchResultDTO findAllPlaces(
//    		@Description("Taille de la page de résultats (=nombre de résultats retournés par cette requête).") @QueryParam(RestDataProvider.QUERYPARAM_PAGESIZE) int pageSize,
//    		@Description("Numéro de la page de résultats demandée (commençant à 1).") @QueryParam(RestDataProvider.QUERYPARAM_PAGENUMBER) int pageNumber) {
//
//		Iterator<SocialExtPlace> it = sdp.findAllPlaces().getItems();
//
//		LOGGER.debug("Paramètres reçus : pageSize=" + pageSize + ", pageNumber=" + pageNumber);
//
//		List<SocialExtPlace> places = new ArrayList<SocialExtPlace>();
//		SocialExtPlace sep = new SocialExtPlace("NomLieu", "DetailLieu", null, "codePlace", 35000, 35, "Rennes", "35000", null);
//		places.add(sep);
//
//		PlaceSearchResultDTO placesDTO = new PlaceSearchResultDTO();
//		placesDTO.setPageNumber(pageNumber);
//		placesDTO.setPageSize(pageSize);
//		placesDTO.setTotalNumber(10);
//
//		for (int i=0; i<pageSize; i++) {
//			// Condition d'arrêt : nb total d'enregistrement atteint
//			if ((pageNumber-1)*pageSize + i >= placesDTO.getTotalNumber()) {
//				break;
//			}
//			placesDTO.getPlaces().add(places.get((pageNumber*pageSize + i) % places.size()));
//		}
//
//		return placesDTO;
//    }
    //@GetMapping()
//    @ApiOperation()
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_FIND_ALL_SOCIAL_WORKERS)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer tous les travailleurs sociaux. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale."),
//		@Description(target=DocTarget.RETURN, value="Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.")
//	})
//	@XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}SocialExtPlace")
//	public SocialWorkerSearchResultDTO findAllSocialWorkers(
//			@Description("Taille de la page de résultats (=nombre de résultats retournés par cette requête).") @QueryParam(RestDataProvider.QUERYPARAM_PAGESIZE) int pageSize,
//			@Description("Numéro de la page de résultats demandée (commençant à 1).") @QueryParam(RestDataProvider.QUERYPARAM_PAGENUMBER) int pageNumber) {
//
//		Iterator<SocialExtWorker> it = sdp.findAllSocialWorkers().getItems();
//
//		LOGGER.debug("Paramètres reçus : pageSize=" + pageSize + ", pageNumber=" + pageNumber);
//
//		List<SocialExtWorker> workers = new ArrayList<SocialExtWorker>();
//		while (it.hasNext()) {
//			workers.add(it.next());
//		}
//
//		SocialWorkerSearchResultDTO workersDTO = new SocialWorkerSearchResultDTO();
//		workersDTO.setPageNumber(pageNumber);
//		workersDTO.setPageSize(pageSize);
//		workersDTO.setTotalNumber(10);
//
//		for (int i=0; i<pageSize; i++) {
//			// Condition d'arrêt : nb total d'enregistrement atteint
//			if ((pageNumber-1)*pageSize + i >= workersDTO.getTotalNumber()) {
//				break;
//			}
//			workersDTO.getWorkers().add(workers.get((pageNumber*pageSize + i) % workers.size()));
//		}
//
//		return workersDTO;
//	}
    //@GetMapping()
//    @ApiOperation()
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_FIND_ALL_USER)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer tous les utilisateurs. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale."),
//		@Description(target=DocTarget.RETURN, value="Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.")
//	})
//	@XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}User")
//	public UserSearchResultDTO findAllUser(
//			@Description("Taille de la page de résultats (=nombre de résultats retournés par cette requête).") @QueryParam(RestDataProvider.QUERYPARAM_PAGESIZE) int pageSize,
//			@Description("Numéro de la page de résultats demandée (commençant à 1).") @QueryParam(RestDataProvider.QUERYPARAM_PAGENUMBER) int pageNumber) {
//
//		LOGGER.debug("Paramètres reçus : pageSize=" + pageSize + ", pageNumber=" + pageNumber);
//
//		Iterator<SocialExtUser> it = sdp.findAllUser().getItems();
//		List<SocialExtUser> users = new ArrayList<SocialExtUser>();
//		while (it.hasNext()) {
//			users.add(it.next());
//		}
//
//		UserSearchResultDTO usersDTO = new UserSearchResultDTO();
//		usersDTO.setPageNumber(pageNumber);
//		usersDTO.setPageSize(pageSize);
//		usersDTO.setTotalNumber(10);
//
//		for (int i=0; i<pageSize; i++) {
//			// Condition d'arrêt : nb total d'enregistrement atteint
//			if ((pageNumber-1)*pageSize + i >= usersDTO.getTotalNumber()) {
//				break;
//			}
//			usersDTO.getUsers().add(users.get((pageNumber*pageSize + i) % users.size()));
//		}
//
//		return usersDTO;
//	}
    //@GetMapping()
//    @ApiOperation()
//
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_FIND_ALL_INDIVIDUALS)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer tous les individus. Cette méthode est utilisée uniquement dans le cadre de la reprise de données initiale."),
//		@Description(target=DocTarget.RETURN, value="Un DTO contenant le nombre total de résultats de la recherche, la taille de la page, le numéro de la page, et la liste des résultats de recherche de la page demandée.")
//	})
//	@XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}Beneficiary")
//	public BeneficiarySearchResultDTO findAllIndividuals(
//			@Description("Taille de la page de résultats (=nombre de résultats retournés par cette requête).") @QueryParam(RestDataProvider.QUERYPARAM_PAGESIZE) int pageSize,
//			@Description("Numéro de la page de résultats demandée (commençant à 1).") @QueryParam(RestDataProvider.QUERYPARAM_PAGENUMBER) int pageNumber) {
//
//		LOGGER.debug("Paramètres reçus : pageSize=" + pageSize + ", pageNumber=" + pageNumber);
//
//		Iterator<SocialExtBeneficiary> it = sdp.findAllIndividuals().getItems();
//		List<SocialExtBeneficiary> beneficiaries = new ArrayList<SocialExtBeneficiary>();
//
//		while (it.hasNext()) {
//			beneficiaries.add(it.next());
//		}
//
//		BeneficiarySearchResultDTO bsrdto = new BeneficiarySearchResultDTO();
//		bsrdto.setTotalNumber(10);
//
//		for (int i=0; i<pageSize; i++) {
//			// Condition d'arrêt : nb total d'enregistrement atteint
//			if ((pageNumber-1)*pageSize + i >= bsrdto.getTotalNumber()) {
//				break;
//			}
//			bsrdto.getBeneficiaries().add(beneficiaries.get((pageNumber*pageSize + i) % beneficiaries.size()));
//		}
//
//		bsrdto.setPageNumber(pageNumber);
//		bsrdto.setPageSize(pageSize);
//
//		return bsrdto;
//	} // TODO : s'appuie encore sur des objets du spi-portail, on pourrait tout ré-écrire ...
    //@GetMapping()
//    @ApiOperation()
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_NEWS)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer les news relatives à un travailleur social."),
//		@Description(target=DocTarget.RETURN, value="Un objet NewsList, qui contient une liste de News. L'objet News contient une date et une liste de lignes de contenu (type String).")
//	})
//    public NewsList getNews(
//    		@Description("Id du travailleur social concerné.") @QueryParam(RestDataProvider.QUERYPARAM_SWUSERID) String userId) throws SocialExtException {
//
//    	LOGGER.debug("\nSWUser id reçu : " + userId);
//
//    	SocialWorkerUser user = new SocialWorkerUser();
//    	user.setId(userId);
//        return sdp.getNews(user);
//    } // TODO : voir si on ré-écrit le dto newslist et news
    //@GetMapping()
//    @ApiOperation()
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_SOCIAL_MODULES)
//    @XMLName("{http://www.infodb.fr/solis/portail/portalconfig}SocialModule")
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Retourne les modules sociaux disponibles dans l'environnement courant."),
//		@Description(target=DocTarget.RETURN, value="Un Set de SocialModule.")
//	})
//    public Set<SocialModule> getAvailableSocialModules() {
//
//    	return sdp.getAvailableSocialModules();
//    } // TODO : on pourrait écrire un wrapper List de socialModules
    //@GetMapping()
//    @ApiOperation()
//
//	@Override
//	@POST
//	@Path(RestDataProvider.RESTURL_GET_REDIRECTION_TOKEN)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Récupérer un token de redirection."),
//		@Description(target=DocTarget.RETURN, value="Wrapper de String, token de redirection.")
//	})
//	public StringWrapperDTO getRedirectionToken(
//			@Description("Wrapper autour d'un SocialExtUSer (habilitation) et une map de paramètres.") UserAndParamsDTO updto) {
//
//		return new StringWrapperDTO(sdp.getRedirectionToken(updto.getUser(), updto.getParams()));
//	} // TODO : rien de changé, voir si on utilise des query param plutôt que le dto ?
//    @PostMapping()
//    @ApiOperation()
//
//    @Override
//    @POST
//    @Path(RestDataProvider.RESTURL_SEARCH_INDIVIDUALS)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Recherche dans les individus."),
//		@Description(target=DocTarget.RETURN, value="Une liste d'individus correspondant aux critères.")
//	})
//    @XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}Beneficiary")
//    public List<SocialExtBeneficiary> searchIndividuals(
//    		@Description("Set de critères de recherche. Chaque critère contient un type, une classe et une valeur.") Set<SearchCriterionDTO> searchCriteria)  {
//
//    	String firstName = null;
//    	String lastName = null;
//    	if(searchCriteria!=null){
//    		for(SearchCriterionDTO criterionDTO : searchCriteria){
//    			if("USAGE_NAME".equals(criterionDTO.getCriterionType())){
//    				lastName = (String) criterionDTO.getValue();
//    			}else if("FIRST_NAME".equals(criterionDTO.getCriterionType())){
//    				firstName = (String) criterionDTO.getValue();
//    			}
//    		}
//    	}
//    	if(firstName!=null && firstName.contains("%")){
//    		firstName = firstName.replaceAll("%", "");
//    	}
//    	if(lastName!=null && lastName.contains("%")){
//    		lastName = lastName.replaceAll("%", "");
//    	}
//
//		Iterator<SocialExtBeneficiary> it = sdp.findAllIndividuals().getItems();
//		List<SocialExtBeneficiary> beneficiaries = new ArrayList<SocialExtBeneficiary>();
//		while (it.hasNext()) {
//			SocialExtBeneficiary next = it.next();
//			if (firstName!=null && firstName.equals(next.getFirstName()) && lastName==null) {
//				beneficiaries.add(next);
//
//			}else if(lastName!=null && lastName.equals(next.getLastName()) && firstName==null){
//				beneficiaries.add(next);
//
//			}else if(firstName!=null && firstName.equals(next.getFirstName()) && lastName!=null && lastName.equals(next.getLastName())){
//				beneficiaries.add(next);
//			}
//		}
//		SocialExtBeneficiaries seb = new SocialExtBeneficiaries();
//		seb.setBeneficiaries(beneficiaries);
//		return seb.getBeneficiaries();
//    } // TODO : rien de changé, voir si on passe les critères de recherche en query param ?
//    @PostMapping(RestDataProvider.RESTURL_SEARCH_INDIVIDUALS)
//    @ApiOperation("Recherche dans les individus.")
//
//    @Override
//    @GET
//    @Path(RestDataProvider.RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS)
//    @Descriptions({
//		@Description(target=DocTarget.METHOD, value="Recherche dans les rendez-vous des individus."),
//		@Description(target=DocTarget.RETURN, value="Une List de SocialExtRendezVous.")
//	})
//    @XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}SocialExtRendezVous")
//    public List<SocialExtRendezVous> getIndividualRendezVous(
//    		@Description("Clé de l'individu") @PathParam(RestDataProvider.PATHPARAM_BENEFICIARYID) String externalId) throws SocialExtException {
//
//        return sdp.getIndividualRendezVous(externalId);
//    }
//    @GetMapping(RestDataProvider.RESTURL_GET_INDIVIDUAL_RENDEZ_VOUS)
//    @ApiOperation("Recherche dans les rendez-vous des individus.")
//
//	@Override
//	@GET
//	@Path(RestDataProvider.RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS)
//	@Descriptions({
//		@Description(target=DocTarget.METHOD, value="Recherche dans les rendez-vous des travailleurs sociaux."),
//		@Description(target=DocTarget.RETURN, value="Un Set de SocialExtRendezVous.")
//	})
//	@XMLName("{http://www.infodb.fr/solis/portail/extsocialbusiness}SocialExtRendezVous")
//	public Set<SocialExtRendezVous> getSocialWorkerRendezVous(
//			@Description("Id de l'utilisateur portail à l'origine de l'appel (pour habilitation ?).") @HeaderParam(RestDataProvider.HEADERNAME_USERID) String userId,
//			@Description("Id du travailleur social") @PathParam(RestDataProvider.PATHPARAM_SOCIALWORKERID) String socialWorkerId,
//			@Description("Date de début de la période de recherche, format yyyy-MM-dd'T'HH:mm:ss") @QueryParam(RestDataProvider.QUERYPARAM_DATEDEBUT) String startDate,
//			@Description("Date de fin de la période de recherche, format yyyy-MM-dd'T'HH:mm:ss") @QueryParam(RestDataProvider.QUERYPARAM_DATEFIN) String endDate)
//		throws SocialExtException {
//
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//		Date start;
//		Date end;
//
//		try {
//			start = df.parse(startDate);
//			end = df.parse(endDate);
//		} catch (ParseException e) {
//			throw new SocialExtException("Erreur de parsing de date", e);
//		}
//
//		return sdp.getSocialWorkerRendezVous(createMockSocialExtUser(userId), socialWorkerId, start, end);
//	}
//    @GetMapping(RestDataProvider.RESTURL_GET_SOCIAL_WORKER_RENDEZ_VOUS)
//    @ApiOperation("Recherche dans les rendez-vous des travailleurs sociaux.")
//
//	@Override
//	@POST
//	@Path(RestDataProvider.RESTURL_CREATE_SOCIAL_WORKER_RENDEZ_VOUS)
//	@Descriptions({
//			@Description(target = DocTarget.METHOD, value = "Crée un rendez-vous."),
//			@Description(target = DocTarget.RETURN, value = "L'id du rendez-vous créé.") })
//	public StringWrapperDTO createSocialWorkerRendezVous(
//			@Description("Paramètres du rendez-vous (date, travailleurs sociaux, etc.)") SocialExtRendezVous rendezVous)
//			throws SocialExtException {
//
//		final TypeAndIdRendezvous typeAndIdRendezvous = sdp.createSocialWorkerRendezVous(rendezVous);
//		return new StringWrapperDTO(typeAndIdRendezvous.getId() + ":" + typeAndIdRendezvous.getType().name());
//	}
//    @PostMapping(RestDataProvider.RESTURL_CREATE_SOCIAL_WORKER_RENDEZ_VOUS)
//    @ApiOperation("Crée un rendez-vous.")
//


    	private SocialExtUser createMockSocialExtUser(String userId) {
    		SocialExtUser seu = new SocialExtUser("login" + userId);
        	seu.setId(userId);
    		return seu;
    	}

}
