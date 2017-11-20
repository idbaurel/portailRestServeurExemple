package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;

import fr.infodb.exemples.portail.rest.serveur.dto.ws.SocialModule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Created with IntelliJ IDEA. User: aurelien Date: 26/12/12 Time: 11:14
 *
 * Représente une actualité à afficher sur la page d'accueil
 *
 */
@XmlType(namespace = "http://www.infodb.fr/solis/portail/extsocialbusiness")
@XmlAccessorType(XmlAccessType.FIELD)
public class News implements Comparable<News> {

	@XmlAttribute(name = "Index")
	private String index;

	@XmlAttribute(name = "Date")
	private Date date;

	@XmlElement(name = "ContentLine")
	private List<String> content = new ArrayList<String>();

	@XmlAttribute(name = "NewsType")
	private NewsType newsType;

	@XmlAttribute(name = "SocialModule")
	private SocialModule socialModule;

	@XmlAttribute(name = "IndividualFirstName")
	private String individualFirstName;

	@XmlAttribute(name = "IndividualLastName")
	private String individualLastName;

	@XmlAttribute(name = "IndividualExternalId")
	private String individualExternalId;

	@XmlAttribute(name = "IndividualGenre")
	private String individualGenre;

	public News() {
	}

	public News(Date date, String firstLine) {
		this.date = date;
		this.content.add(firstLine);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	public SocialModule getSocialModule() {
		return socialModule;
	}

	public void setSocialModule(SocialModule socialModule) {
		this.socialModule = socialModule;
	}

	public String getIndividualFirstName() {
		return individualFirstName;
	}

	public void setIndividualFirstName(String individualFirstName) {
		this.individualFirstName = individualFirstName;
	}

	public String getIndividualLastName() {
		return individualLastName;
	}

	public void setIndividualLastName(String individualLastName) {
		this.individualLastName = individualLastName;
	}

	public String getIndividualExternalId() {
		return individualExternalId;
	}

	public void setIndividualExternalId(String individualExternalId) {
		this.individualExternalId = individualExternalId;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIndividualGenre() {
		return individualGenre;
	}

	public void setIndividualGenre(String individualGenre) {
		this.individualGenre = individualGenre;
	}

	@Override
	public int compareTo(News o) {
		if (getDate() == null && o.getDate() == null) {
			return 0;
		} else if (getDate() == null) {
			return 1;
		} else if (o.getDate() == null) {
			return -1;
		} else {
			return getDate().compareTo(o.getDate());
		}
	}
}
