package eci.cosw.eps.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.services.AppointmentServices;
import eci.cosw.eps.services.ServiceException;

public class BeanWeekRequest {
	
	private int doctorID;
	
	private List<Appointment>[] weekAppointments;
	
	private static final int MILISONADAY = 1000*60*60*24;

	@SuppressWarnings("unchecked")
	public BeanWeekRequest() {
		weekAppointments = new ArrayList[7];
		getWeek();
	}
	
	/**
	 * 
	 */
	public void getWeek(){
		Date day = new Date();
		
		for (int i = 0; i < 7; i++) {
			try {
				weekAppointments[i] = AppointmentServices.getInstance().reviewSchedule(doctorID, day);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
			day.setTime(day.getTime() + MILISONADAY);
		}
	}
	
	/**
	 * Log Out 
	 * @param ae
	 * @throws IOException
	 */
	public void logout(ActionEvent ae) throws IOException {

		FacesContext.getCurrentInstance().getExternalContext().redirect(
				"j_spring_security_logout");

	}

}
