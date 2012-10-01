
package eci.cosw.eps.integration.fosyga;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eci.cosw.eps.integration.fosyga package. 
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

    private final static QName _RegistrarSolicitudPago_QNAME = new QName("http://services.persistencia.eci.edu/", "registrarSolicitudPago");
    private final static QName _ServicesException_QNAME = new QName("http://services.persistencia.eci.edu/", "ServicesException");
    private final static QName _RegistrarSolicitudPagoResponse_QNAME = new QName("http://services.persistencia.eci.edu/", "registrarSolicitudPagoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eci.cosw.eps.integration.fosyga
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistrarSolicitudPagoResponse }
     * 
     */
    public RegistrarSolicitudPagoResponse createRegistrarSolicitudPagoResponse() {
        return new RegistrarSolicitudPagoResponse();
    }

    /**
     * Create an instance of {@link ServicesException }
     * 
     */
    public ServicesException createServicesException() {
        return new ServicesException();
    }

    /**
     * Create an instance of {@link RegistrarSolicitudPago }
     * 
     */
    public RegistrarSolicitudPago createRegistrarSolicitudPago() {
        return new RegistrarSolicitudPago();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarSolicitudPago }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.persistencia.eci.edu/", name = "registrarSolicitudPago")
    public JAXBElement<RegistrarSolicitudPago> createRegistrarSolicitudPago(RegistrarSolicitudPago value) {
        return new JAXBElement<RegistrarSolicitudPago>(_RegistrarSolicitudPago_QNAME, RegistrarSolicitudPago.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServicesException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.persistencia.eci.edu/", name = "ServicesException")
    public JAXBElement<ServicesException> createServicesException(ServicesException value) {
        return new JAXBElement<ServicesException>(_ServicesException_QNAME, ServicesException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarSolicitudPagoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.persistencia.eci.edu/", name = "registrarSolicitudPagoResponse")
    public JAXBElement<RegistrarSolicitudPagoResponse> createRegistrarSolicitudPagoResponse(RegistrarSolicitudPagoResponse value) {
        return new JAXBElement<RegistrarSolicitudPagoResponse>(_RegistrarSolicitudPagoResponse_QNAME, RegistrarSolicitudPagoResponse.class, null, value);
    }

}
