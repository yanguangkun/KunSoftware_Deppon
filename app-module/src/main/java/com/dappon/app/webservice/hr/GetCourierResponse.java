
package com.dappon.app.webservice.hr;

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
 *         &lt;element name="out1" type="{http://app.deppon.com}Courier" minOccurs="0"/>
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
    "out1"
})
@XmlRootElement(name = "getCourierResponse")
public class GetCourierResponse {

    @XmlElementRef(name = "out1", namespace = "http://www.primeton.com/AppService", type = JAXBElement.class)
    protected JAXBElement<Courier> out1;

    /**
     * Gets the value of the out1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Courier }{@code >}
     *     
     */
    public JAXBElement<Courier> getOut1() {
        return out1;
    }

    /**
     * Sets the value of the out1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Courier }{@code >}
     *     
     */
    public void setOut1(JAXBElement<Courier> value) {
        this.out1 = value;
    }

}
