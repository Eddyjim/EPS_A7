/**
 * 
 */
package eci.cosw.eps.webservices.dummies;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import eci.cosw.eps.model.Doctor;
import eci.cosw.eps.webservices.BeanDoctorIPS;
import eci.cosw.eps.webservices.RemoteSystemExcpetion;

/**
 * @author dookie
 *
 */
//@Service
public class DummieIPSDoctor implements BeanDoctorIPS {

	/* (non-Javadoc)
	 * @see eci.cosw.eps.webservices.BeanDoctorIPS#getIPSDoctors()
	 */
	@Override
	public List<Doctor> getIPSDoctors() {
		String[] names = {"Chuck", "Dali"};
		int[] ids = {123, 12345};
		List<Doctor> doctorProbe = new LinkedList<Doctor>();
		for (int i =0; i < names.length; i++ )
			doctorProbe.add(new Doctor(ids[i], names[i]) );
		return doctorProbe;	
	}

	@Override
	public List<String> getIPSDoctorAvailability(int doctorID, Date date)
			throws RemoteSystemExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

}