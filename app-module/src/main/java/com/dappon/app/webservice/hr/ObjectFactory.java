
package com.dappon.app.webservice.hr;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dappon.app.webservice.hr package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CourierPhoto_QNAME = new QName("http://app.deppon.com", "photo");
    private final static QName _CourierPhone_QNAME = new QName("http://app.deppon.com", "phone");
    private final static QName _CourierPsnname_QNAME = new QName("http://app.deppon.com", "psnname");
    private final static QName _GetCourierResponseOut1_QNAME = new QName("http://www.primeton.com/AppService", "out1");
    private final static QName _GetCourierIn0_QNAME = new QName("http://www.primeton.com/AppService", "in0");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dappon.app.webservice.hr
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCourierResponse }
     * 
     */
    public GetCourierResponse createGetCourierResponse() {
        return new GetCourierResponse();
    }

    /**
     * Create an instance of {@link Courier }
     * 
     */
    public Courier createCourier() {
        return new Courier();
    }

    /**
     * Create an instance of {@link GetCourier }
     * 
     */
    public GetCourier createGetCourier() {
        return new GetCourier();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.deppon.com", name = "photo", scope = Courier.class)
    public JAXBElement<byte[]> createCourierPhoto(byte[] value) {
        return new JAXBElement<byte[]>(_CourierPhoto_QNAME, byte[].class, Courier.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.deppon.com", name = "phone", scope = Courier.class)
    public JAXBElement<String> createCourierPhone(String value) {
        return new JAXBElement<String>(_CourierPhone_QNAME, String.class, Courier.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.deppon.com", name = "psnname", scope = Courier.class)
    public JAXBElement<String> createCourierPsnname(String value) {
        return new JAXBElement<String>(_CourierPsnname_QNAME, String.class, Courier.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Courier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.primeton.com/AppService", name = "out1", scope = GetCourierResponse.class)
    public JAXBElement<Courier> createGetCourierResponseOut1(Courier value) {
        return new JAXBElement<Courier>(_GetCourierResponseOut1_QNAME, Courier.class, GetCourierResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.primeton.com/AppService", name = "in0", scope = GetCourier.class)
    public JAXBElement<String> createGetCourierIn0(String value) {
        return new JAXBElement<String>(_GetCourierIn0_QNAME, String.class, GetCourier.class, value);
    }

}
