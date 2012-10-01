/**
 * 
 */
package eci.cosw.eps.webservices.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import eci.cosw.eps.integration.ips.WebServices;
import eci.cosw.eps.integration.ips.WebServicesException_Exception;
import eci.cosw.eps.integration.ips.WebServicesService;
import eci.cosw.eps.webservices.BeanRegisterAppointmentIPS;
import eci.cosw.eps.webservices.RemoteSystemExcpetion;

/**
 * @author chevy
 *
 */
@Service
public class RemoteIPSAppointment implements BeanRegisterAppointmentIPS {

	/* (non-Javadoc)
	 * @see eci.cosw.eps.webservices.BeanRegisterAppointmentIPS#registerAppointment(java.util.Date, int, int)
	 */
	@Override
	public void registerAppointment(Date date, int doctorID, int afiliateID) throws RemoteSystemExcpetion {
		WebServicesService service = new WebServicesService();
		WebServices sproxy = service.getWebServicesPort();
		try {
			sproxy.registerAppointment(""+doctorID, ""+afiliateID, date.toString());
		} catch (WebServicesException_Exception e) {
			throw new RemoteSystemExcpetion("Error registering appointment");
		}
	}

}
