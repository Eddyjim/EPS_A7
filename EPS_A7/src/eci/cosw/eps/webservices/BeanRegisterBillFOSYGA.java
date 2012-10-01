/**
 * 
 */
package eci.cosw.eps.webservices;

/**
 * @author dookie
 *
 */
public interface BeanRegisterBillFOSYGA {

	public void registerBill(int billid, int billValue, int IPSid) throws RemoteSystemExcpetion;
}
