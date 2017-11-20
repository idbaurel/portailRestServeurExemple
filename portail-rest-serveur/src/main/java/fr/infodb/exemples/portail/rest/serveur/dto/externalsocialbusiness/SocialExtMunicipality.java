package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * An entry in the municipalities referential managed by external social si.
 *
 * @author thomas.limin
 */
@XmlRootElement(name = "SocialExtMunicipality", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtMunicipality {

	/**
	 * code de la municipalité
	 */
    @XmlAttribute(name = "MunicipalityCode")
	private Integer municipalityCode;

    /**
     * code du département
     */
    @XmlAttribute(name = "DepartmentCode")
	private Integer departmentCode;

    /**
     * nom de la municipalité
     */
    @XmlAttribute(name = "Name")
	private String name;

    /**
     * code postal de la municipalité
     */
    @XmlAttribute(name = "ZipCode")
	private String zipcode;

    /**
     * Constructeur
     */
	public SocialExtMunicipality() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param municipalityCode code de la municipalité
	 * @param departmentCode code du département
	 * @param name nom de la municipalité
	 * @param zipcode code postal de la municipalité
	 */
	public SocialExtMunicipality(Integer municipalityCode, Integer departmentCode, String name, String zipcode) {
		super();
		this.municipalityCode = municipalityCode;
		this.departmentCode = departmentCode;
		this.name = name;

        if (zipcode != null) {
            zipcode = zipcode.trim();
            while (zipcode.length() < 5) {
                zipcode = "0" + zipcode;
            }
        }

		this.zipcode = zipcode;
	}

	public String getName() {
		return this.name;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public Integer getMunicipalityCode() {
		return this.municipalityCode;
	}

	public Integer getDepartmentCode() {
		return this.departmentCode;
	}

    public void setMunicipalityCode(Integer municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getId() {
        return (departmentCode != null ? departmentCode.toString() : "") + "-" + (municipalityCode != null ? municipalityCode.toString() : "");
    }
}
