package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 09/01/13
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "SocialModule", namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlEnum
public enum SocialModule {
    AST("Action Sociale de Terrain", "AST", "acces-ast", "ast", false),
    AFI("Aide Financière", "AFI", "acces-aides-financieres", "afi", false),
    ADOM("Aide à Domicile", "AID-DOM", "acces-aide-domicile", "adom", false),
    IPR("Information Préoccupante", "IP", "acces-infos-preoccupantes", "ip", false),
    ASE("Aide Sociale à l'Enfance", "ASE", "acces-ase", "ase", false),
    FEMENC("Femme enceinte et/ou isolé", "FEM ENC / MERE ISO", "acces-femencmereisol", "femencmereisol", false),
    PMI_ENFANT("Protection Maternelle Infantile pour l'Enfant", "ENFANT PMI", "acces-pmi", "pmienfant", false),
    PMI_MERE("Protection Maternelle Infantile pour la mère", "MERE PMI", "acces-pmimere", "pmimere", false),
    PMI_CPEF("Centre de Planification et d'Education Familiale", "CPEF", "acces-pmicpef", "pmicpef", false),
    MASP("Mesure d'Accompagnement Social Personnalisé", "MASP", "acces-masp", "masp", false),
    FSL("Fond de Solidarité Logement", "FSL", "acces-fsl", "fsl", false),
    RSA("Revenu de Solidarité Active", "RSA", "acces-rsa", "rsa", false),
    ACFA("Accueil Familial", "ACFA", "acces-acfaaccueilli", "acfaaccueilli", false),
    MDPH("Maison Départementale Personnes Handicapées", "MDPH", "acces-mdph", "mdph", false),
    ASG("Aide Sociale Générale", "ASG", "acces-asg", "asg", false),

    TRANS("Transversalite", "TRANS", "acces-transversalite", "trans", true),
    EC("Etat Civil", "ETAT-CIVIL", "acces-etat-civil", "civi", true),
    CPTA("Comptabilite", "COMPTA", "acces-comptabilite", "cpta", true),
    GED("Gestion Electronique de Document", "GED", "acces-ged", "ged", true),
    ARCH("Archivage", "ARCH", "acces-archivage", "arch", true),

    ADOP("Adoption","ADOP", "acces-adoption", "adop", false),
    ASSFAM("Assistant Maternel / Familial","ASSMAT-ASSFAM", "acces-assfam", "assmat", false),
    IAS("Gestionnaire", "GESTIONNAIRE", "acces-gestionnaire", "", false),
    OS("Offre de Service", "OS", "acces-offre-service", "ofse", false),
    PAIE("Paiement ASE", "PAIE", "acces-paie", "paie", false),
    
    DECLGRO("Declaration de grossesse", "DECLGRO", "acces-declgro", "acces", false);
//    RMI("Revenu minimum d'insertion", "RMI", "acces-rmi", "", false);


    private final String name;
    private final String reduceName;
    private final String cssClass;
    private final String favoriteCssClass;
    private final boolean transversal;

    SocialModule(String name, String reduceName, String cssClass, String favoriteCssClass, boolean transversal) {
        this.name = name;
        this.reduceName = reduceName;
        this.cssClass = cssClass;
        this.favoriteCssClass = favoriteCssClass;
        this.transversal = transversal;
    }

    public String getName() {
        return name;
    }

    public String getReduceName() {
        return reduceName;
    }

    public String getCssClass() {
        return cssClass;
    }

    public String getFavoriteCssClass() {
        return favoriteCssClass;
    }

    public boolean isTransversal() {
        return transversal;
    }

}
