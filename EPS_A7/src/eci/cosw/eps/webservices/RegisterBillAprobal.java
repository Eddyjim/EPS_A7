package eci.cosw.eps.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import eci.cosw.eps.services.BillRegistryService;
import eci.cosw.eps.services.ServiceException;

@WebService
public class RegisterBillAprobal {
	@WebMethod
	public void registerAprobal(int id, String state){
		BillRegistryService b = BillRegistryService.getInstance();
		try {
			b.updateBill(id, state);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}
	