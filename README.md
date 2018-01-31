# portailRestServeurExemple

Exemple de serveur web exposant des web services REST utilisables par le Portail Agent


Ce projet utilise:
* java 8
* Spring Boot 1.5.8
* maven 3.3.9
 
**Les contrats des web services sont en cours de modification**
 
Contrats modifiés:

méthode controller | description
------- | -----------
getAllLoginHomepageMessages | Message de la homepage
getAvailableSocialModules | Modules métiers disponibles
getProfiles | Profiles utilisateurs
findAllUser | Liste des utilisateurs pour reprise de données
findAllIndividuals | Liste des individus/bénéficiaires pour reprise de données