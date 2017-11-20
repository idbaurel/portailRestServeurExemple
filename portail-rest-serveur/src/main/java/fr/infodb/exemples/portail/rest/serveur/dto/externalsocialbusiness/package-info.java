@javax.xml.bind.annotation.XmlSchema (
        xmlns = {
                @javax.xml.bind.annotation.XmlNs( prefix = "xsi",
                        namespaceURI="http://www.w3.org/2001/XMLSchema-instance"),

                @javax.xml.bind.annotation.XmlNs( prefix = "extsocial",
                        namespaceURI="http://www.infodb.fr/solis/portail/extsocial")
        },
        location = "http://www.infodb.fr/solis/portail/extsocialbusiness extsocialbusiness.xsd",
        elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED
)
package fr.infodb.exemples.portail.rest.serveur.dto.externalsocialbusiness;