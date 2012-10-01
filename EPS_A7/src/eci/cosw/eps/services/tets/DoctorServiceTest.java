package eci.cosw.eps.services.tets;

import junit.framework.Assert;

import org.junit.Test;

import eci.cosw.eps.model.Doctor;
import eci.cosw.eps.services.DoctorService;
import eci.cosw.eps.services.ServiceException;

public class DoctorServiceTest {

	@Test
	public void testGetSpecialists() throws ServiceException {
		java.util.List<Doctor> specialists = DoctorService.getInstance().getSpecialists(2);   
		Assert.assertEquals(specialists.size(), 1);
	}

	@Test
	public void testGetIPSDoctors() throws ServiceException {
		java.util.List<Doctor> doctorsIPS = DoctorService.getInstance().getIPSDoctors();
		Assert.assertEquals(doctorsIPS.size(), 2);
	}

}
