package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO représentant un référentiel, avec sa liste d'entrées.
 *
 * @author asi
 */
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ReferentialEntryDTO.class)
public class ReferentialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id du référentiel.
     */
    @XmlAttribute(name = "Id", required = true)
    private Referential id;
    /**
     * Nom du référentiel (question : à quoi il sert ?).
     */
    @XmlAttribute(name = "Name", required = true)
    private String name;
    /**
     * Liste des éléments du référentiel.
     */
    @XmlElement(name = "Entry")
    private List<ReferentialEntryDTO> entries = new ArrayList<ReferentialEntryDTO>();

    public Referential getId() {
        return id;
    }

    public void setId(Referential id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReferentialEntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(List<ReferentialEntryDTO> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "ReferentialDTO [id=" + id + ", name=" + name + ", entries="
                + entries + "]";
    }
}
