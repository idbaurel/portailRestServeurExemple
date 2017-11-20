package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Type de news
 *
 * @author asi
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public enum NewsType {
	COMMISSION,
	PROCESSUS_RSA,
	PROCESSUS_ASG,
	PROCESSUS_ASMA,
        PROCESSUS_AFI,
        PROCESSUS_ASE,
        PROCESSUS_FSL,
        PROCESSUS_IP,
        PROCESSUS_MDPH,
    PROCESSUS_AST,
	PROCESSUS;
	//PROCESSUS est utilisé par la SOLIS2SNCF pour PROCESUS AFI actuellement
}
