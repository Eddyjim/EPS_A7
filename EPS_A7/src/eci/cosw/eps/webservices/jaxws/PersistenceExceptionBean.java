
package eci.cosw.eps.webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2.4
 * 
 */
@XmlRootElement(name = "PersistenceException", namespace = "http://webservices.eps.cosw.eci/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersistenceException", namespace = "http://webservices.eps.cosw.eci/")
public class PersistenceExceptionBean {

    private String message;

    /**
     * 
     * @return
     *     returns String
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 
     * @param message
     *     the value for the message property
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
