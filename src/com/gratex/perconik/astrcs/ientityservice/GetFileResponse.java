
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
 *         &lt;element name="GetFileResult" type="{http://schemas.datacontract.org/2004/07/Gratex.PerConIK.AstRcs.Svc.Interfaces}GetFileResponse" minOccurs="0"/>
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
    "getFileResult"
})
@XmlRootElement(name = "GetFileResponse")
public class GetFileResponse {

    @XmlElementRef(name = "GetFileResult", namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", type = JAXBElement.class, required = false)
    protected JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse> getFileResult;

    /**
     * Gets the value of the getFileResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse }{@code >}
     *     
     */
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse> getGetFileResult() {
        return getFileResult;
    }

    /**
     * Sets the value of the getFileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse }{@code >}
     *     
     */
    public void setGetFileResult(JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse> value) {
        this.getFileResult = value;
    }

}
