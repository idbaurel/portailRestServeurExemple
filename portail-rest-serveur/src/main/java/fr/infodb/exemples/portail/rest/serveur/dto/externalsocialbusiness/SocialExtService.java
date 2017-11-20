/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Represente un service
 * @author seb
 */
@XmlRootElement(name = "SocialExtAntenne", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtService {
    
    /**
     * Identifiant de l'antenne
     */
    @XmlAttribute(name = "Id", required = true)
    private Long id;
    
    /**
     * Libelle de l'antenne
     */
    @XmlAttribute(name = "Libelle", required = true)
    private String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
}
