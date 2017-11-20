package fr.infodb.exemples.portail.rest.serveur.dto.ws;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 21/03/13
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/portalconfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasureNature {
    @XmlAttribute(name="Id")
    private String id;
    @XmlAttribute(name="NatureType")
    private SocialMeasureNatureType natureType;
    @XmlTransient
    private SocialModule module;
    @XmlAttribute(name="Label")
    private String label;
    @XmlAttribute(name="BeginDateLabel")
    private String beginDateLabel;
    @XmlAttribute(name="EndDateLabel")
    private String endDateLabel;
    @XmlAttribute(name = "Sequence")
    private Integer sequence;

    public MeasureNature() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SocialMeasureNatureType getNatureType() {
        return natureType;
    }

    public void setNatureType(SocialMeasureNatureType natureType) {
        this.natureType = natureType;
    }

    public SocialModule getModule() {
        return module;
    }

    public void setModule(SocialModule module) {
        this.module = module;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBeginDateLabel() {
        return beginDateLabel;
    }

    public void setBeginDateLabel(String beginDateLabel) {
        this.beginDateLabel = beginDateLabel;
    }

    public String getEndDateLabel() {
        return endDateLabel;
    }

    public void setEndDateLabel(String endDateLabel) {
        this.endDateLabel = endDateLabel;
    }

    public Integer getSequence() {
        return sequence;
    }
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
