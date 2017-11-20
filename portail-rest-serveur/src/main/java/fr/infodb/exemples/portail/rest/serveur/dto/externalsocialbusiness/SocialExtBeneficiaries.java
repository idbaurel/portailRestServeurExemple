package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aurelien
 * Date: 23/01/13
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "Beneficiaries", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtBeneficiaries {
    @XmlElement(name = "Beneficiary")
    private List<SocialExtBeneficiary> beneficiaries;

    public List<SocialExtBeneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<SocialExtBeneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }
}
