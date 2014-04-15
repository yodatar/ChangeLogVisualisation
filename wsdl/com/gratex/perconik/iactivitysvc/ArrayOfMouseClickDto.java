
package com.gratex.perconik.iactivitysvc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMouseClickDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMouseClickDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MouseClickDto" type="{http://www.gratex.com/PerConIk/IActivitySvc}MouseClickDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMouseClickDto", propOrder = {
    "mouseClickDto"
})
public class ArrayOfMouseClickDto {

    @XmlElement(name = "MouseClickDto", nillable = true)
    protected List<MouseClickDto> mouseClickDto;

    /**
     * Gets the value of the mouseClickDto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mouseClickDto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMouseClickDto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MouseClickDto }
     * 
     * 
     */
    public List<MouseClickDto> getMouseClickDto() {
        if (mouseClickDto == null) {
            mouseClickDto = new ArrayList<MouseClickDto>();
        }
        return this.mouseClickDto;
    }

}
