
package com.gratex.perconik.iactivitysvc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfActivityDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfActivityDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActivityDto" type="{http://www.gratex.com/PerConIk/IActivitySvc}ActivityDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfActivityDto", propOrder = {
    "activityDto"
})
public class ArrayOfActivityDto {

    @XmlElement(name = "ActivityDto", nillable = true)
    protected List<ActivityDto> activityDto;

    /**
     * Gets the value of the activityDto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activityDto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityDto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityDto }
     * 
     * 
     */
    public List<ActivityDto> getActivityDto() {
        if (activityDto == null) {
            activityDto = new ArrayList<ActivityDto>();
        }
        return this.activityDto;
    }

}
