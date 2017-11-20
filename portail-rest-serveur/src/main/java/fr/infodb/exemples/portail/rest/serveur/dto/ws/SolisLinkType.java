package fr.infodb.exemples.portail.rest.serveur.dto.ws;

/**
 * Représente un type de lien de débranchement vers un écran SOLIS indépendant d'un module social.
 *
 * @author ASI
 */
public enum SolisLinkType {

    /**
     * Type du lien débranchant vers l'écran de présentation des événements du SIRH
     */
    HOMEPAGE_EVENTS,

    /**
     * Type du lien débranchant vers l'écran de création des individus
     */
    INDIVIDUAL_FORM_CREATE,

    /**
     * Type du lien debranchant vers l'ecran de changement de mot passe
     **/
    CHANGE_PASSWORD;

}
