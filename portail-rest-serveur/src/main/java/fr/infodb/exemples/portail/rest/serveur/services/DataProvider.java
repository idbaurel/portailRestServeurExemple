package fr.infodb.exemples.portail.rest.serveur.services;

import fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness.*;
import fr.infodb.exemples.portail.rest.serveur.dto.ws.*;
import fr.infodb.exemples.portail.rest.serveur.exceptions.SocialExtException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author aurelien
 * créé le 22/11/17.
 */
public interface DataProvider {

    Long getNumberSirhEvents(String userId);

    List<BusinessOffer> getBusinessOffers(String individualId);

    String getModuleIdentifier(SocialModule module, ModuleIdentifierType type, String externalId);

    SocialExtBeneficiary getSocialFileMeasures(String userId, String index);

    String createIndividuals(SocialExtBeneficiary beneficiary);

    void updateIndividual(SocialExtBeneficiary beneficiary);

    Set<String> getProfiles(String user);

    Set<String> getAvailableProfiles();

    Set<SocialExtPlace> getPlacesByType(SocialExtPlaceType type);

    String getCirco(String placeId);


    SocialExtBeneficiary getFileRecord(SocialExtUser user, String index);


    SocialExtBeneficiary getIndividualSynthesis(SocialExtUser user, String index);

    UserSearchResultDTO findAllUser(int pageSize, int pageNumber);

    SocialWorkerSearchResultDTO findAllSocialWorkers(int pageSize, int pageNumber);

    BeneficiarySearchResultDTO findAllIndividuals(int pageSize, int pageNumber);

    SocialExtUser findSocialExtUser(String externalId);

    SocialExtBeneficiary findBeneficiary(String externalId);

    Set<SocialModule> getAvailableSocialModules();

    NewsList getNews(String userId);

    Map<SocialModuleScreen, String> getLinks(Set<SocialModuleScreen> screens, String user, String indexIndividual, String token);

    Map<SocialModule, String> getHomePages(Set<SocialModule> modules, String user, String token);


    String getLink(SolisLinkType linkType, String token, SocialExtUser user) throws SocialExtException;

    List<SocialExtMunicipality> suggestMunicipalities(String token);

    List<SocialExtPlace> suggestPlaces(String token, String municipalityId);

    Set<SocialModule> getAvailableSocialModulesForLifeLine();

    AuthenticationResult authenticate(UserAndPwdDTO updto);

    List<LoginHomepageMessage> getAllLoginHomepageMessages();

    List<SocialExtRendezVous> getIndividualRendezVous(String externalId);

    Set<SocialExtRendezVous> getSocialWorkerRendezVous(String userId, String socialWorkerId, String startDate, String endDate);


    String createSocialWorkerRendezVous(SocialExtRendezVous rendezVous);

    String getRedirectionToken(UserAndParamsDTO updto);

    SocialExtWorker findSocialWorker(String socialWorkerId);

    ReferentialDTO getReferential(String referential, String userId);

    List<SocialExtBeneficiary> findAllIndividuals(Set<SearchCriterionDTO> searchCriteria);
}
