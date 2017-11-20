package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 01/10/13
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
public enum ModuleIdentifierType {
    CLASSOTHEQUE_ASE,
    CLASSOTHEQUE_ASG,
    CLASSOTHEQUE_AST,
    CLASSOTHEQUE_CIVI,
    CLASSOTHEQUE_FSL,
    CLASSOTHEQUE_MDPH,
    CLASSOTHEQUE_RSA,
    NUMERO_DOSSIER,
    NUMERO_FRATRIE,
    NUMERO_INDIVIDU
    ;
}
