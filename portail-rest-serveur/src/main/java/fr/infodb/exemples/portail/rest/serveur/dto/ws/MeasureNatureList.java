package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 21/03/13
 * Time: 13:22
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasureNatureList {
    @XmlElement(name = "MeasureNature")
    private List<MeasureNature> measureNatures;

    public MeasureNatureList() {
    }

    public List<MeasureNature> getMeasureNatures() {
        return measureNatures;
    }

    public void setMeasureNatures(List<MeasureNature> measureNatures) {
        this.measureNatures = measureNatures;
    }
}
