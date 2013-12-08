
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
 *         &lt;element name="QueueChangesetForImportResult" type="{http://schemas.datacontract.org/2004/07/Gratex.PerConIK.AstRcs.Svc.Interfaces}QueueChangesetForImportResponse" minOccurs="0"/>
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
    "queueChangesetForImportResult"
})
@XmlRootElement(name = "QueueChangesetForImportResponse")
public class QueueChangesetForImportResponse {

    @XmlElementRef(name = "QueueChangesetForImportResult", namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", type = JAXBElement.class, required = false)
    protected JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse> queueChangesetForImportResult;

    /**
     * Gets the value of the queueChangesetForImportResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse }{@code >}
     *     
     */
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse> getQueueChangesetForImportResult() {
        return queueChangesetForImportResult;
    }

    /**
     * Sets the value of the queueChangesetForImportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse }{@code >}
     *     
     */
    public void setQueueChangesetForImportResult(JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse> value) {
        this.queueChangesetForImportResult = value;
    }

}
