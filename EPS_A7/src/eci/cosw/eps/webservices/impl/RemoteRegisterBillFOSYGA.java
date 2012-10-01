/**
 * 
 */
package eci.cosw.eps.webservices.impl;

import org.springframework.stereotype.Service;

import eci.cosw.eps.integration.fosyga.ServicesException_Exception;
import eci.cosw.eps.integration.fosyga.WebServicesEps;
import eci.cosw.eps.integration.fosyga.WebServicesEpsService;
import eci.cosw.eps.webservices.BeanRegisterBillFOSYGA;
import eci.cosw.eps.webservices.RemoteSystemExcpetion;

/**
 * @author chevy
 *
 */
@Service
public class RemoteRegisterBillFOSYGA implements BeanRegisterBillFOSYGA {

	/* (non-Javadoc)
	 * @see eci.cosw.eps.webservices.BeanRegisterBillFOSYGA#registerBill(int, int, int)
	 */
	@Override
	public void registerBill(int billid, int billValue, int IPSid) throws RemoteSystemExcpetion {
		WebServicesEpsService service = new WebServicesEpsService();
		WebServicesEps sproxy = service.getWebServicesEpsPort();
		try {
			sproxy.registrarSolicitudPago(11111, IPSid, billValue, billid);
		} catch (ServicesException_Exception e) {
			throw new RemoteSystemExcpetion("Problem with remote system");
		}
	}

}
