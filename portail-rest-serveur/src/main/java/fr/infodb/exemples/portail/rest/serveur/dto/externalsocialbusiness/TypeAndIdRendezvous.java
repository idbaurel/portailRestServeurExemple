package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author aurelien
 *         créé le 12/12/16.
 */
@XmlRootElement(name = "TypeAndIdRendezvous", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class TypeAndIdRendezvous implements Serializable {

    @XmlAttribute(name = "id")
    private int id;

    @XmlAttribute(name = "type")
    private TypeRendezVous type;

    public TypeAndIdRendezvous() {
        this.id = 0;
        this.type = TypeRendezVous.RENDEZ_VOUS_CENTRALISE;
    }

    public TypeAndIdRendezvous(int id, TypeRendezVous type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeRendezVous getType() {
        return type;
    }

    public void setType(TypeRendezVous type) {
        this.type = type;
    }

}
