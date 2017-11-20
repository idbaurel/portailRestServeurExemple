package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;


import fr.infodb.exemples.portail.rest.serveur.dto.ws.SocialLifeLinePicture;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 08/01/13
 * Time: 11:51
 *
 * Représente une nature de mesure pour un module (regroupement de mesure
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtNature {
    @XmlAttribute(name = "Id")
    private String id;
    @XmlAttribute(name = "Name")
    private String name;
    @XmlAttribute(name = "Picture")
    private SocialLifeLinePicture picture;
    @XmlAttribute(name = "BeginDateLabel")
    private String beginDateLabel;
    @XmlAttribute(name = "EndDateLabel")
    private String endDateLabel;
    @XmlAttribute(name = "ChangeDateLabel")
    private String changeDateLabel;
    @XmlAttribute(name = "FixedLabel")
    private String fixedLabel;
    @XmlAttribute(name = "VariableLabel")
    private String variableLabel;
    @XmlAttribute(name = "Hidden")
    private boolean hidden;

    @XmlElement(name = "Module")
    private SocialExtModule module;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getChangeDateLabel() {
        return changeDateLabel;
    }

    public void setChangeDateLabel(String changeDateLabel) {
        this.changeDateLabel = changeDateLabel;
    }

    public SocialExtModule getModule() {
        return module;
    }

    public void setModule(SocialExtModule module) {
        this.module = module;
    }

    public SocialLifeLinePicture getPicture() {
        return picture;
    }

    public void setPicture(SocialLifeLinePicture picture) {
        this.picture = picture;
    }

    public String getFixedLabel() {
        return fixedLabel;
    }
    public void setFixedLabel(String fixedLabel) {
        this.fixedLabel = fixedLabel;
    }

    public String getVariableLabel() {
        return variableLabel;
    }
    public void setVariableLabel(String variableLabel) {
        this.variableLabel = variableLabel;
    }

    public boolean isHidden() {
        return hidden;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialExtNature that = (SocialExtNature) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
