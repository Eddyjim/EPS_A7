
package eci.cosw.eps.integration.fosyga;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServicesEpsService", targetNamespace = "http://services.persistencia.eci.edu/")
public class WebServicesEpsService
    extends Service
{

    private final static URL WEBSERVICESEPSSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICESEPSSERVICE_EXCEPTION;
    private final static QName WEBSERVICESEPSSERVICE_QNAME = new QName("http://services.persistencia.eci.edu/", "WebServicesEpsService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            URL baseUrl;
            baseUrl = WebServicesEpsService.class.getResource(".");
            URL u=WebServicesEpsService.class.getResource("serviciosFosygaEps.xml");
            url = new URL(baseUrl, u.toString());
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICESEPSSERVICE_WSDL_LOCATION = url;
        WEBSERVICESEPSSERVICE_EXCEPTION = e;
    }

    public WebServicesEpsService() {
        super(__getWsdlLocation(), WEBSERVICESEPSSERVICE_QNAME);
    }

    public WebServicesEpsService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICESEPSSERVICE_QNAME);
    }

    public WebServicesEpsService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICESEPSSERVICE_QNAME);
    }

    public WebServicesEpsService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICESEPSSERVICE_QNAME);
    }

    public WebServicesEpsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicesEpsService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns WebServicesEps
     */
    @WebEndpoint(name = "WebServicesEpsPort")
    public WebServicesEps getWebServicesEpsPort() {
        return super.getPort(new QName("http://services.persistencia.eci.edu/", "WebServicesEpsPort"), WebServicesEps.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServicesEps
     */
    @WebEndpoint(name = "WebServicesEpsPort")
    public WebServicesEps getWebServicesEpsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.persistencia.eci.edu/", "WebServicesEpsPort"), WebServicesEps.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICESEPSSERVICE_EXCEPTION!= null) {
            throw WEBSERVICESEPSSERVICE_EXCEPTION;
        }
        return WEBSERVICESEPSSERVICE_WSDL_LOCATION;
    }

}