package eci.cosw.eps.webservices.dummies;

import java.util.Date;

import org.springframework.stereotype.Service;

import eci.cosw.eps.webservices.BeanRegisterAppointmentIPS;

//@Service
public class DummieRegisterAppointment implements BeanRegisterAppointmentIPS {

	@Override
	public void registerAppointment(Date date, int doctorID, int afiliateID) {
		System.out.println("Registré una cita");	
	}

}
