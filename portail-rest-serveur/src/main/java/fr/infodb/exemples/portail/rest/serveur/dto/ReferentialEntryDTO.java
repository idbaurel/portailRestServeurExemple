package fr.infodb.exemples.portail.rest.serveur.dto;

import fr.infodb.exemples.portail.rest.serveur.dto.constants.Referential;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO représentant une entrée de référentiel.
 *
 * @author asi
 */
@XmlType(namespace = "http://www.infodb.fr/portail/rest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReferentialEntryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id de l'entrée de référentiel.
     */
    @XmlAttribute(name = "Id", required = true)
    private String id;
    /**
     * Valeur de l'entrée de référentiel.
     */
    @XmlAttribute(name = "Value", required = true)
    private String value;
    /**
     * Référentiel auquel appartient l'entrée courante.
     */
    @XmlAttribute
    private Referential parentRef;
    /**
     * Entrées parentes, potentiellement dans d'autres référentiels.
     * Permet de créer des liens entre éléments de référentiels différents (ex : themes -> domaines).
     * Contrainte : au maximum une entrée parente par référentiel.
     */
    @XmlElement(name = "ParentEntries")
    private List<ReferentialEntryDTO> parentEntries = new ArrayList<ReferentialEntryDTO>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Referential getParentRef() {
        return parentRef;
    }

    public void setParentRef(Referential parentRef) {
        this.parentRef = parentRef;
    }

    public List<ReferentialEntryDTO> getParentEntries() {
        return parentEntries;
    }

    public void setParentEntries(List<ReferentialEntryDTO> parentEntries) {
        this.parentEntries = parentEntries;
    }

    @Override
    public String toString() {
        return "ReferentialEntryDTO [id=" + id + ", value=" + value
                + ", parentRef=" + parentRef + ", parentEntries="
                + parentEntries + "]";
    }
}
