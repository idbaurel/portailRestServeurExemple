package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Enumération pour les écrans des modules sociaux
 *
 * @author Jerome Catric
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlEnum
public enum SocialModuleScreen {
	// AST
	AST_SYNTHESE_USAGER("Synthèse", SocialModule.AST, 2, false, true),
	AST_INDIVIDU("Individu", SocialModule.AST, 3),
	AST_ACCUEIL("Accueil", SocialModule.AST, 4) ,
	AST_INTERVENTION("Intervention", SocialModule.AST, 5),
	AST_HOME("", SocialModule.AST, 1, true, false),
	AST_OFFRE_SERVICE("Offre de service", SocialModule.AST, 6),
	AST_ACTION_COLLECTIVE("Action collective / ISIC", SocialModule.AST, 7),
	AST_AIDE_FINANCIERE("Aide financière", SocialModule.AST, 8),

	// MASP
	MASP_SYNTHESE_USAGER("Synthèse", SocialModule.MASP, 2, false, true),
	MASP_INDIVIDU("Individu", SocialModule.MASP, 3),
	MASP_HOME("MASP", SocialModule.MASP, 1, true, false),
	MASP_DEMANDE("MASP", SocialModule.MASP, 4),

	// ASE
	ASE_SYNTHESE_USAGER("Synthèse", SocialModule.ASE, 2, false, true),
	ASE_INDIVIDU("Individu", SocialModule.ASE, 3),
	ASE_ENFANT("Enfant", SocialModule.ASE, 4),
	ASE_MESURE("Mesure", SocialModule.ASE, 5),
	ASE_PLACEMENT("Placement", SocialModule.ASE, 6),
	ASE_HOME("ASE", SocialModule.ASE, 1, true, false) ,

	// FMMI (Femme Enceinte / Mere Isolée)
	FEMI_SYNTHESE_USAGER("Synthèse", SocialModule.FEMENC, 1, true, true),
	FEMI_INDIVIDU("Individu", SocialModule.FEMENC, 2),
	FEMI_FEMME("Femme", SocialModule.FEMENC, 3),
	FEMI_MESURE("Mesure", SocialModule.FEMENC, 4),
	FEMI_PLACEMENT("Placement", SocialModule.FEMENC, 5),
	FEMI_HOME("FEMI", SocialModule.FEMENC, 6, true, false),

	// IP
//	IP_SYNTHESE_USAGER("Synthèse", SocialModule.ASE, 12),
//	IP_INDIVIDU("Individu", SocialModule.ASE, 13),
//	IP_INFO_PREOCC("Information Préoccupante", SocialModule.ASE, 14),
//	IP_HOME("ASE", SocialModule.ASE, 15, true),
    IP_SYNTHESE_USAGER("Synthèse", SocialModule.IPR, 2, false, true),
    IP_INDIVIDU("Individu", SocialModule.IPR, 3),
    IP_INFO_PREOCC(SocialModule.IPR.getName(), SocialModule.IPR, 4),
    IP_HOME(SocialModule.IPR.getReduceName(), SocialModule.IPR, 1, true, false),

	// AFI
	AFI_SYNTHESE_USAGER("Synthèse", SocialModule.AFI, 2, false, true),
	AFI_INDIVIDU("Individu", SocialModule.AFI, 3),
	AFI_AIDE("Aide financière", SocialModule.AFI, 4),
	AFI_HOME("Aide financière", SocialModule.AFI, 1, true, false),

	// ADOM
	ADOM_SYNTHESE_USAGER("Synthèse", SocialModule.ADOM, 2, false, true),
	ADOM_INDIVIDU("Individu", SocialModule.ADOM, 3) ,
	ADOM_AIDE("Aide domicile", SocialModule.ADOM, 4) ,
	ADOM_HOME("Aide domicile", SocialModule.ADOM, 1 ,true, false),

	// ENFANT_PMI
	PMI_ENFANT_SYNTHESE_USAGER("Synthèse", SocialModule.PMI_ENFANT, 2, false, true),
	PMI_ENFANT_INDIVIDU("Individu", SocialModule.PMI_ENFANT, 3),
	PMI_ENFANT_CERT_SANTE("Certificat santé",SocialModule.PMI_ENFANT, 4),
	PMI_ENFANT_BEM("Bilan école maternelle", SocialModule.PMI_ENFANT, 5),
	PMI_ENFANT_SUIVI("Suivi", SocialModule.PMI_ENFANT, 6),
	PMI_HOME("PMI", SocialModule.PMI_ENFANT, 1, true, false),

	// MERE_PMI
	PMI_MERE_SYNTHESE_USAGER("Synthèse", SocialModule.PMI_MERE, 1, true, true),
	PMI_MERE_INDIVIDU("Individu", SocialModule.PMI_MERE, 2),
	PMI_MERE_AVIS_GROSSESSE("Avis grossesse", SocialModule.PMI_MERE, 3),
	PMI_MERE_SUIVI("Suivi", SocialModule.PMI_MERE, 4),

	// CPEF
	CPEF_SYNTHESE_USAGER("Synthèse", SocialModule.PMI_CPEF, 1, true, true),
	CPEF_INDIVIDU("Individu", SocialModule.PMI_CPEF, 2),
	CPEF_ENTRETIEN("Entretien", SocialModule.PMI_CPEF, 3),
	CPEF_PATIENT("Patient", SocialModule.PMI_CPEF, 4),
	CPEF_CONSULTATION("Consultation", SocialModule.PMI_CPEF, 5),

	// FSL
	FSL_SYNTHESE_USAGER("Synthèse", SocialModule.FSL, 2, false, true),
	FSL_INDIVIDU("Individu",SocialModule.FSL, 3),
	FSL_DONNEES_FSL("Données FSL",SocialModule.FSL, 4),
	FSL_AIDE("Aide",SocialModule.FSL, 5),
	FSL_HOME("FSL", SocialModule.FSL, 1, true, false) ,

	// RSA
	RSA_SYNTHESE_USAGER("Synthèse", SocialModule.RSA, 2, false, true),
	RSA_INDIVIDU("Individu", SocialModule.RSA, 3),
	RSA_MENAGE("Ménage", SocialModule.RSA, 4),
	RSA_PRESENCE("Présence", SocialModule.RSA, 5),
	RSA_PARCOURS_INSERTION("Parcours insertion", SocialModule.RSA, 6),
	RSA_HOME("RSA", SocialModule.RSA, 1, true, false) ,

	// ASG
	ASG_SYNTHESE_USAGER("Synthèse",SocialModule.ASG, 2, false, true),
	ASG_INDIVIDU("Individu",SocialModule.ASG, 3),
	ASG_DEMANDEUR("Demandeur",SocialModule.ASG, 4),
	ASG_AIDE("Aide",SocialModule.ASG, 5),
	ASG_HOME("ASG",SocialModule.ASG, 1, true, false),

	// MDPH
	MDPH_SYNTHESE_USAGER("Synthèse", SocialModule.MDPH, 2, false, true),
	MDPH_INDIVIDU("Individu", SocialModule.MDPH, 3),
	MDPH_DEMANDEUR("Demandeur", SocialModule.MDPH, 4),
	MDPH_AIDE("Aide", SocialModule.MDPH, 5),
	MDPH_FDC("FDC", SocialModule.MDPH, 6),
	MDPH_HOME("MDPH", SocialModule.MDPH, 1, true, false),

	// ACFA
	ACFA_SYNTHESE_USAGER("Synthèse", SocialModule.ACFA, 1, false, true),
	ACFA_INDIVIDU("Individu", SocialModule.ACFA, 2) ,
	ACFA_DEMANDEUR("Accueilli", SocialModule.ACFA, 3),
	ACFA_AIDE("Accueil", SocialModule.ACFA, 4),
	ACFA_HOME("ACFA", SocialModule.ACFA, 5, true, false),

	// EC
	EC_HOME("Etat-Civil", SocialModule.EC, 1, true, false),

	// TRANS
	TRANS_HOME("Environnement", SocialModule.TRANS, 1, true, false),

	//ASSMA/ASSFAM
	ASSMA_SYNTHESE("Synthèse", SocialModule.ASSFAM, 1, false, true);

	/**
	 * Le libellé
	 */
    private final String name;

    /**
     * Indique si c'est la page d'accueil
     */
	private boolean homePage;

	/**
	 * Le module social
	 */
	private final SocialModule module;

	/**
	 * Ordre d'affichage
	 */
	private final Integer order;

	/**
	 * indique si c'est la page de synthese
	 */
	private boolean synthesePage;

    /**
     * Constructeur
     *
     * @param name : le libellé
     * @param module : le {@link SocialModule}
     * @param order : ordre
     * @param homePage : true si c'est la page d'accueil
     * @param synthesePage : true si c'est une page de synthese
     */
	private SocialModuleScreen(final String name, SocialModule module, Integer order, boolean homePage, boolean synthesePage){
		this(name,module, order) ;
		this.homePage = homePage;
		this.synthesePage = synthesePage;
	}

	/**
	 * Constructeur
	 *
	 * @param name : le libellé
	 * @param module : {@link SocialModule}
	 * @param order : ordre
	 */
	private SocialModuleScreen(final String name, SocialModule module, Integer order){
		this.name= name ;
		this.module = module ;
		this.homePage = false ;
        this.order = order;
	}

	/**
	 * Récupère la liste des {@link SocialModuleScreen} pour un {@link SocialModule} donné
	 *
	 * @param module : un {@link SocialModule}
	 * @param isHomePage : true pour la page d'accueil, false sinon.
	 *
	 * @return un set de {@link SocialModuleScreen}
	 */
    public static Set<SocialModuleScreen> getScreensForModule(SocialModule module, boolean isHomePage) {
        Set<SocialModuleScreen> res = new HashSet<SocialModuleScreen>();

        for(SocialModuleScreen s:SocialModuleScreen.values()) {
            if(s.isHomePage() ^ !isHomePage) {
                if(s.getSocialModule().equals(module)) {
                    res.add(s);
                }
            }
        }

        return res;
    }

    /**
     * Récupère l'écran de synthese associé au module recherché
     *
     * @param module le module social recherché
     * @return l'ecran s'il existe, {@code null} sinon
     */
    public static SocialModuleScreen getSyntheseScreen(SocialModule module){
        for(SocialModuleScreen sms :SocialModuleScreen.values()) {
        	if(sms.getSocialModule().equals(module) && sms.isSynthesePage()){
        		return sms;
        	}
        }
        return null;
    }

	public String getName(){
		return this.name == null || this.name.isEmpty() ? name() : this.name ;
	}

	public SocialModule getSocialModule(){
		return this.module ;
	}

	public boolean isHomePage(){
		return this.homePage ;
	}

    public Integer getOrder() {
        return order;
    }

	public boolean isSynthesePage(){
		return this.synthesePage ;
	}
}
