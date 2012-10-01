/**
 * 
 */
package eci.cosw.eps.webservices.impl;

import org.springframework.stereotype.Service;

import eci.cosw.eps.integration.ips.WebServices;
import eci.cosw.eps.integration.ips.WebServicesService;
import eci.cosw.eps.webservices.BeanUpdateBillIPS;

/**
 * @author chevy
 *
 */
@Service
public class RemoteUpdateBillFOSYGA implements BeanUpdateBillIPS {

	@Override
	public void updateBill(int id, String State) {
		WebServicesService service = new WebServicesService();
		WebServices sproxy = service.getWebServicesPort();
		// no tienen pa actualizarles el codigo de aprobaciónsproxy.
	}

	

}
