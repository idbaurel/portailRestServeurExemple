package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 15/01/13
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialModuleDesc {
    @XmlAttribute(name = "Module", required = true)
    private SocialModule module;
    @XmlElement(name = "MeasureNatureList")
    private MeasureNatureList measureNatureList;

    public SocialModuleDesc() {
    }

    public SocialModule getModule() {
        return module;
    }

    public void setModule(SocialModule module) {
        this.module = module;
    }

    public MeasureNatureList getMeasureNatureList() {
        return measureNatureList;
    }

    public void setMeasureNatureList(MeasureNatureList measureNatureList) {
        this.measureNatureList = measureNatureList;
    }
}
