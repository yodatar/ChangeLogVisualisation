
package com.gratex.perconik.astrcs.ientityservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchUsersResult" type="{http://schemas.datacontract.org/2004/07/Gratex.PerConIK.AstRcs.Svc.Interfaces}SearchUsersResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "searchUsersResult"
})
@XmlRootElement(name = "SearchUsersResponse")
public class SearchUsersResponse {

    @XmlElementRef(name = "SearchUsersResult", namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", type = JAXBElement.class, required = false)
    protected JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse> searchUsersResult;

    /**
     * Gets the value of the searchUsersResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse }{@code >}
     *     
     */
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse> getSearchUsersResult() {
        return searchUsersResult;
    }

    /**
     * Sets the value of the searchUsersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse }{@code >}
     *     
     */
    public void setSearchUsersResult(JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse> value) {
        this.searchUsersResult = value;
    }

}
