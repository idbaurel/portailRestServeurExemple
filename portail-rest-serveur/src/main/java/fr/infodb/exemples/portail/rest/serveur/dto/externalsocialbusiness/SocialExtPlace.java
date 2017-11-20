package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * An entry in the places referential managed by external social si.
 * @author thomas.limin
 */
@XmlRootElement(name = "SocialExtPlace", namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class SocialExtPlace {

    private String name;
	private String detail;
    private String secondaryPlace;
	private String placeCode;
	private Integer municipalityCode;
	private Integer departmentCode;
    private String municipality;
    private String zipCode;
    private String num;
    private Integer circoCode;

	public SocialExtPlace() {
		super();
	}

	public SocialExtPlace(String name, String detail, String secondaryPlace, String placeCode, Integer municipalityCode, Integer departmentCode, String municipality, String zipCode, String num) {
		super();
		this.name = name;
		this.detail = detail;
        this.secondaryPlace = secondaryPlace;
		this.placeCode = placeCode;
		this.municipalityCode = municipalityCode;
		this.departmentCode = departmentCode;
        this.municipality = municipality;
        this.zipCode = zipCode;
        this.num = num;
	}

	public String getName() {
		return this.name;
	}

	public String getDetail() {
		return this.detail;
	}

	public String getPlaceCode() {
		return this.placeCode;
	}

	public Integer getMunicipalityCode() {
		return this.municipalityCode;
	}

	public Integer getDepartmentCode() {
		return departmentCode;
	}

    public String getMunicipality() {
        return municipality;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getNum() {
        return num;
    }

    public String getSecondaryPlace() {
        return secondaryPlace;
    }

	public Integer getCircoCode() {
		return circoCode;
	}

	public void setCircoCode(Integer circoCode) {
		this.circoCode = circoCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setSecondaryPlace(String secondaryPlace) {
		this.secondaryPlace = secondaryPlace;
	}

	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}

	public void setMunicipalityCode(Integer municipalityCode) {
		this.municipalityCode = municipalityCode;
	}

	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setNum(String num) {
		this.num = num;
	}

    @Override
    public String toString() {
        return "SocialExtPlace{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", secondaryPlace='" + secondaryPlace + '\'' +
                ", placeCode='" + placeCode + '\'' +
                ", municipalityCode=" + municipalityCode +
                ", departmentCode=" + departmentCode +
                ", municipality='" + municipality + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
