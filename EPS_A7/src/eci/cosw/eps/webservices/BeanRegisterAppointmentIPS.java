package eci.cosw.eps.webservices;

import java.util.Date;

public interface BeanRegisterAppointmentIPS {
	public void registerAppointment(Date date, int doctorID, int afiliateID) throws RemoteSystemExcpetion;
}
