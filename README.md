# portailRestServeurExemple

Exemple de serveur web exposant des web services REST utilisables par le Portail Agent


Ce projet utilise:
* java 8
* Spring Boot 1.5.10
* maven 3.3.9
 
**Les contrats des web services sont en cours de modification**

url ws (http://\<host\>:\<port\>/portail/spi/ + …) | verbe http | nom méthode | thème | état | à implémenter par le CD64 | description
-----|-----|-----|-----|-----|-----|-----|
beneficiary/{beneficiaryId} | GET | findBeneficiary | données |  |  | Récupérer un individu à partir de son id
beneficiary/{beneficiaryId}/fileRecord | GET | getFileRecord | données |  |  | Retourner le dossier d’un individu
beneficiary/{beneficiaryId}/individualSynthesis | GET | getIndividualSynthesis | données |  |  | Récupérer la synthèse d'un individu
beneficiary/{beneficiaryId}/socialFileMeasures | GET | getSocialFileMeasures | données |  |  | Récupérer les aides liées à un individu
individuals | GET | findAllIndividuals | reprise données | fait |  | Récupérer tous les individus. Cette méthode est utilisée dans le cadre de la reprise de données
individuals | POST | createIndividuals | données |  | non | Créer un individu
individuals | PUT | updateIndividual | modification données |  | ? | Modifier un individu
individuals/search | POST | searchIndividuals | recherche | fait |  | Rechercher des individus sur critères simples (pas de recherche avancée)
individuals/{beneficiaryId}/businessOffers | GET | getBusinessOffers | données |  | ? | Rechercher les offres de service pour un individu
individuals/{beneficiaryId}/rendezVous | GET | getIndividualRendezVous | données | fait |  | Récupérer tous les rendez-vous d'individu
links | GET | getLinks | débranchement |  | non | Récupérer les liens de débranchement vers les écrans de l'application externe
links/homePages | GET | getHomePages | débranchement |  | non | Récupérer les liens vers les pages d'accueil des modules sociaux
links/{userId} | GET | getLinks | débranchement |  | non | Retourner un lien de débranchement vers un écran d'une application externe indépendant d'un module social
loginHomepageMessages | GET | getAllLoginHomepageMessages | données | fait |  | Rechercher les message à afficher sur la page d'authentification
municipalities/suggest | GET | suggestMunicipalities | données |  | ? | Récupérer des valeurs à suggérer à l'utilisateur pour la complétion des municipalités
municipalities/{municipalityId}/places/suggest | GET | suggestPlaces | données |  | ? | Retourner pour une commune une liste de lieux correspondant à une portion de nom donnée
news | GET | getNews | données | fait |  | Récupérer les news relatives à un travailleur social
places/search | GET | getPlacesByType | données |  | ? | Retourner un ensemble de lieux en fonction d'un type donné
places/{placeId}/circo | GET | getCirco | données |  | ? | Retourner la circonscription liée à un lieu
referentials/{referential} | GET | getReferential | données |  | ? | Récupérer les données d'un référentiel (nomenclature)
security/authenticate | POST | authenticate | sécurité | fait |  | Authentifier un utilisateur
security/profiles | GET | getProfiles | reprise données | fait |  | Retourner tous les profils utilisateurs
security/profiles/{userId} | GET | getProfiles | sécurité | fait |  | Retourner les profils d'un utilisateur
security/redirectionToken/generate | POST | getRedirectionToken | débranchement |  |  | Obtenir un token de sécurité pour les redirections (débranchement)
socialExtUser | GET | findAllUser | reprise données | fait |  | Récupérer tous les utilisateurs. Cette méthode est utilisée dans le cadre de la reprise de données
socialExtUser/{userId} | GET | findSocialExtUser | données |  |  | Récupérer un utilisateur à partir de son id
socialExtUser/{userId}/numberSirhEvents | GET | getNumberSirhEvents | données |  | non | Retourner, pour l'utilisateur spécifié, le nombre d'évènements en attente de traitement issus du SIRH
socialModules | GET | getAvailableSocialModules | données | fait |  | Retourner les modules métiers disponibles sur l'application
socialModules/forLifeLine | GET | getAvailableSocialModulesForLifeLine | données | fait |  | Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie
socialModules/{socialModule}/moduleIdentifier | GET | getModuleIdentifier | données |  |  | Récupérer la référence du dossier
socialWorkers | GET | findAllSocialWorkers | reprise données | fait |  | Récupérer tous les travailleurs sociaux. Cette méthode est utilisée dans le cadre de la reprise de données
socialWorkers/rendezVous | POST | createSocialWorkerRendezVous | création données |  | ? | Créer un rendez-vous pour un intervenant social
socialWorkers/{socialWorkerId} | GET | findSocialWorker | données | fait |  | Récupérer un intervenant social à partir de son id
socialWorkers/{socialWorkerId}/rendezVous | GET | getSocialWorkerRendezVous | données | fait |  | Rechercher dans les rendez-vous des travailleurs sociaux
