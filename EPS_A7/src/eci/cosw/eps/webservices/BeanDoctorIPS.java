/**
 * 
 */
package eci.cosw.eps.webservices;

import java.util.Date;
import java.util.List;

import eci.cosw.eps.model.Doctor;

/**
 * @author dookie
 *
 */
public interface BeanDoctorIPS {
	public List<Doctor> getIPSDoctors() throws RemoteSystemExcpetion;
	public List<String> getIPSDoctorAvailability(int doctorID, Date date) throws RemoteSystemExcpetion;
}
