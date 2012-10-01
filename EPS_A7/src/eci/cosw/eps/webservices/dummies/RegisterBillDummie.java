/**
 * 
 */
package eci.cosw.eps.webservices.dummies;

import org.springframework.stereotype.Service;

import eci.cosw.eps.webservices.BeanRegisterBillFOSYGA;



/**
 * @author Alex
 *
 */
//@Service
public class RegisterBillDummie implements BeanRegisterBillFOSYGA {

	/* (non-Javadoc)
	 * @see eci.cosw.eps.webservices.BeanRegisterBillFOSYGA#registerBill()
	 */

	@Override
	public void registerBill(int billid, int billValue, int IPSid) {
		System.out.println("Registro registro :D"); 
	}

}
