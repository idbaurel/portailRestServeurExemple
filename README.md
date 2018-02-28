# portailRestServeurExemple

Exemple de serveur web exposant des web services REST utilisables par le Portail Agent


Ce projet utilise:
* java 8
* Spring Boot 1.5.10
* maven 3.3.9
 
**Les contrats des web services sont en cours de modification**

url ws (http://\<host\>:\<port\>/portail/spi/ + …) | verbe http | nom méthode | thème | description |
-----|-----|-----|-----|-----|
beneficiary/{beneficiaryId} | GET | findBeneficiary | données | Récupérer un individu à partir de son id
beneficiary/{beneficiaryId}/fileRecord | GET | getFileRecord | données | Retourner le dossier d’un individu
beneficiary/{beneficiaryId}/socialFileMeasures | GET | getSocialFileMeasures | données | Récupérer les aides liées à un individu
individuals | GET | findAllIndividuals | reprise données | Récupérer tous les individus. Cette méthode est utilisée dans le cadre de la reprise de données
individuals/search | POST | searchIndividuals | recherche | Rechercher des individus sur critères simples (pas de recherche avancée)
individuals/{beneficiaryId}/rendezVous | GET | getIndividualRendezVous | données |  Récupérer tous les rendez-vous d'individu
loginHomepageMessages | GET | getAllLoginHomepageMessages | données |  Rechercher les message à afficher sur la page d'authentification
news | GET | getNews | données |  Récupérer les news relatives à un travailleur social
referentials/{referential} | GET | getReferential | données | Récupérer les données d'un référentiel (nomenclature)
security/authenticate | POST | authenticate | sécurité |  Authentifier un utilisateur
security/profiles | GET | getProfiles | reprise données |  Retourner tous les profils utilisateurs
security/profiles/{userId} | GET | getProfiles | sécurité |  Retourner les profils d'un utilisateur
socialExtUser | GET | findAllUser | reprise données |  Récupérer tous les utilisateurs. Cette méthode est utilisée dans le cadre de la reprise de données
socialExtUser/{userId} | GET | findSocialExtUser | données | Récupérer un utilisateur à partir de son id
socialModules | GET | getAvailableSocialModules | données |  Retourner les modules métiers disponibles sur l'application
socialModules/forLifeLine | GET | getAvailableSocialModulesForLifeLine | données |  Récupérer les modules sociaux disponibles pour affichage dans une ligne de vie
socialModules/{socialModule}/moduleIdentifier | GET | getModuleIdentifier | données | Récupérer la référence du dossier
socialWorkers | GET | findAllSocialWorkers | reprise données |  Récupérer tous les travailleurs sociaux. Cette méthode est utilisée dans le cadre de la reprise de données
socialWorkers/{socialWorkerId} | GET | findSocialWorker | données |  Récupérer un intervenant social à partir de son id
socialWorkers/{socialWorkerId}/rendezVous | GET | getSocialWorkerRendezVous | données |  Rechercher dans les rendez-vous des travailleurs sociaux
