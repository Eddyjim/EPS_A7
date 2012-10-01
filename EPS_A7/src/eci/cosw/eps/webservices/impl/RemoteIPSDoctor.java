/**
 * 
 */
package eci.cosw.eps.webservices.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import eci.cosw.eps.integration.ips.EnumerateSpecialists;
import eci.cosw.eps.integration.ips.WebServices;
import eci.cosw.eps.integration.ips.WebServicesException_Exception;
import eci.cosw.eps.integration.ips.WebServicesService;
import eci.cosw.eps.model.Doctor;
import eci.cosw.eps.webservices.BeanDoctorIPS;
import eci.cosw.eps.webservices.RemoteSystemExcpetion;

/**
 * @author chevy
 *
 */
@Service
public class RemoteIPSDoctor implements BeanDoctorIPS {

	/* (non-Javadoc)
	 * @see eci.cosw.eps.webservices.BeanDoctorIPS#getIPSDoctors()
	 */
	@Override
	public List<Doctor> getIPSDoctors() throws RemoteSystemExcpetion {
		WebServicesService service = new WebServicesService();
		WebServices sproxy = service.getWebServicesPort();
		ArrayList<String> ipsSpecialists;
		try {
			ipsSpecialists = (ArrayList<String>) sproxy.enumerateSpecialists();
		} catch (WebServicesException_Exception e) {
			throw new RemoteSystemExcpetion("Problem getting IPS doctors");
		}
		ArrayList<Doctor> specialists = new ArrayList<Doctor>();
		for (String string : ipsSpecialists) {
			String[] temp = string.split(",");
			Doctor d = new Doctor(Integer.parseInt(temp[0]), temp[1]);
			specialists.add(d);
		}
		return specialists;
	}

	@Override
	public List<String> getIPSDoctorAvailability(int doctorID, Date date)
			throws RemoteSystemExcpetion {
		WebServicesService service = new WebServicesService();
		WebServices sproxy = service.getWebServicesPort();
		ArrayList<String> availability;
		try {
			availability = (ArrayList<String>) sproxy.availableSchedule(""+doctorID, date.toString());
		} catch (WebServicesException_Exception e) {
			throw new RemoteSystemExcpetion();
		}
		return availability;
	}

}
