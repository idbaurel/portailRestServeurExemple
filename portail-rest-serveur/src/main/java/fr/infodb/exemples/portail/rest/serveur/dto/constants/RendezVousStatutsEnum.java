package fr.infodb.exemples.portail.rest.serveur.dto.constants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Statuts des rendez vous sur le parcours usager
 * PLANNED: planifié
 * PERFORMED: effectué
 * UNREALIZED: non effectué
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public enum RendezVousStatutsEnum {
    PLANNED, PERFORMED, UNREALIZED
}
