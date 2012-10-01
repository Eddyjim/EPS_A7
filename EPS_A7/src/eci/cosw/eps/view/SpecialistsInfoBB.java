package eci.cosw.eps.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.springframework.security.context.SecurityContextHolder;

import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.model.Doctor;

public class SpecialistsInfoBB {
	
	private ArrayList<Doctor> specialists;
	private Doctor selectedSpecialist;
	private Appointment selectedappointment;
	/**
	 * @return the specialists
	 */
	public ArrayList<Doctor> getSpecialists() {
		return specialists;
	}
	/**
	 * @param specialists the specialists to set
	 */
	public void setSpecialists(ArrayList<Doctor> specialists) {
		this.specialists = specialists;
	}
	/**
	 * @return the selectedSpecialist
	 */
	public Doctor getSelectedSpecialist() {
		return selectedSpecialist;
	}
	/**
	 * @param selectedSpecialist the selectedSpecialist to set
	 */
	public void setSelectedSpecialist(Doctor selectedSpecialist) {
		this.selectedSpecialist = selectedSpecialist;
	}
	/**
	 * @return the selectedappointment
	 */
	public Appointment getSelectedappointment() {
		return selectedappointment;
	}
	/**
	 * @param selectedappointment the selectedappointment to set
	 */
	public void setSelectedappointment(Appointment selectedappointment) {
		this.selectedappointment = selectedappointment;
	}

	/**
	 * Log Out 
	 * @param ae
	 * @throws IOException
	 */
	public void logout(ActionEvent ae) throws IOException {

		 // invalidate the session
	      ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
	      HttpSession s = (HttpSession)ectx.getSession(false);
	      s.invalidate(); 
	      // tell spring to invalidate the session
	      SecurityContextHolder.getContext().setAuthentication(null);
	      // forward the user to the logout page
	      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "/faces/index.xhtml");      	
		

	}
	
	

}
