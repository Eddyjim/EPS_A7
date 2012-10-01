package eci.cosw.eps.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import eci.cosw.eps.persistence.PersistenceException;
import eci.cosw.eps.services.BillRegistryService;
import eci.cosw.eps.services.ServiceException;

@WebService
public class RegisterBillPaymentWS {
	
	@WebMethod
	public void registerPayment(int billID, int billValue, int IPSID) throws PersistenceException{
		try {
			BillRegistryService.getInstance().registerIPSBill(billID, billValue, IPSID);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
