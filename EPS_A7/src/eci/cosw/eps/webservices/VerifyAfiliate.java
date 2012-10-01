/**
 * 
 */
package eci.cosw.eps.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import eci.cosw.eps.model.Afiliate;
import eci.cosw.eps.services.AfiliateServices;
import eci.cosw.eps.services.ServiceException;

/**
 * @author chevy
 *
 */

@WebService
public class VerifyAfiliate {
	@WebMethod
	public boolean verifiAfiliate(int id){
		Afiliate af = null;
		try{
			af = AfiliateServices.getInstance().getAfiliate(id);
		}catch (ServiceException e) {
			e.printStackTrace();
		}
		return af != null;
	}
}
