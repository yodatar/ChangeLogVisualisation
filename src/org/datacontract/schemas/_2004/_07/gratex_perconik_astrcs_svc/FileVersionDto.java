
package org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import java.util.Comparator;


/**
 * <p>Java class for FileVersionDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileVersionDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Gratex.PerConIK.AstRcs.Svc.Interfaces}EntityVersionDto">
 *       &lt;sequence>
 *         &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileVersionDto", propOrder = {
    "url"
})
public class FileVersionDto extends EntityVersionDto implements Comparable<FileVersionDto>
{

    @XmlElementRef(name = "Url", namespace = "http://schemas.datacontract.org/2004/07/Gratex.PerConIK.AstRcs.Svc.Interfaces", type = JAXBElement.class, required = false)
    protected JAXBElement<String> url;


    /////////////////////////
    // due to sorting FileVersionDto by its URL
    public int compareTo(FileVersionDto f) {
        return Comparators.URL.compare(this,f);
    }

    public static class Comparators {
        public static Comparator<FileVersionDto> URL = new Comparator<FileVersionDto>() {
            @Override
            public int compare(FileVersionDto o1, FileVersionDto o2) {
                return o1.getUrl().getValue().compareTo(o2.getUrl().getValue());
            }
        };
    }
    /////////////////////////

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */


    public JAXBElement<String> getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUrl(JAXBElement<String> value) {
        this.url = value;
    }

}
