
package org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCodeEntityChangesetsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCodeEntityChangesetsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Changesets" type="{http://schemas.datacontract.org/2004/07/Gratex.PerConIK.AstRcs.Svc.Interfaces}ArrayOfChangesetDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCodeEntityChangesetsResponse", propOrder = {
    "changesets"
})
public class GetCodeEntityChangesetsResponse {

    @XmlElementRef(name = "Changesets", namespace = "http://schemas.datacontract.org/2004/07/Gratex.PerConIK.AstRcs.Svc.Interfaces", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfChangesetDto> changesets;

    /**
     * Gets the value of the changesets property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfChangesetDto }{@code >}
     *     
     */
    public JAXBElement<ArrayOfChangesetDto> getChangesets() {
        return changesets;
    }

    /**
     * Sets the value of the changesets property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfChangesetDto }{@code >}
     *     
     */
    public void setChangesets(JAXBElement<ArrayOfChangesetDto> value) {
        this.changesets = value;
    }

}
