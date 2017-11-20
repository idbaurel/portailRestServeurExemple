package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 26/12/12
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "SocialExtModuleList", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtModuleList {
    @XmlElement(name = "Item")
    private List<SocialExtModule> modules = new ArrayList<SocialExtModule>();

    public List<SocialExtModule> getModules() {
        return modules;
    }

    public void setModules(List<SocialExtModule> modules) {
        this.modules = modules;
    }
}
