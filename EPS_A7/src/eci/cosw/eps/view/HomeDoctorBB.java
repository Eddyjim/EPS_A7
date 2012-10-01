/**
 * 
 */
package eci.cosw.eps.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.springframework.security.context.SecurityContextHolder;

import eci.cosw.eps.model.Afiliate;
import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.model.Doctor;
import eci.cosw.eps.services.AfiliateServices;
import eci.cosw.eps.services.AppointmentServices;
import eci.cosw.eps.services.DoctorService;
import eci.cosw.eps.services.ServiceException;

/**
 * @author chevy			
 *
 */
public class HomeDoctorBB {
	
	private ArrayList<Appointment> today;
	private int id;
	private Doctor doctorObject;
	private Appointment selectedAfiliate;
	private boolean selected;
	private int progress;
	private Afiliate afiliateInformation;
	private String clinicalHistory;
	private int state;
	
	public HomeDoctorBB() {
		
		String sid = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		this.setId(Integer.parseInt(sid));
		
		this.selected = false;
		this.state = 0;
		
		try {
			doctorObject = DoctorService.getInstance().getDoctor(id);
		} catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"Problem Trying to Load your profile"));
		}
		try {
			today = (ArrayList<Appointment>) AppointmentServices.getInstance().reviewSchedule(id, new Date());
			//System.err.println("Cantidad de Citas:"+today.size());
		} catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"Problem Trying to Load your schedule"));
		}
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	
	/**
	 * @return the clinicalHistory
	 */
	public String getClinicalHistory() {
		return clinicalHistory;
	}

	/**
	 * @param clinicalhistory the clinicalHistory to set
	 */
	public void setClinicalHistory(String clinicalhistory) {
		this.clinicalHistory = clinicalhistory;
	}
	
	/**
	 * @return the afiliateInformation
	 */
	public Afiliate getAfiliateInformation() {
		return afiliateInformation;
	}

	/**
	 * @param afiliateInformation the afiliateInformation to set
	 */
	public void setAfiliateInformation(Afiliate afiliateInformation) {
		this.afiliateInformation = afiliateInformation;
	}
	
	/**
	 * @return the selectedAfiliate
	 */
	public Appointment getSelectedAfiliate() {
		return selectedAfiliate;
	}



	/**
	 * @param selectedAfiliate the selectedAfiliate to set
	 */
	public void setSelectedAfiliate(Appointment selectedAfiliate) {
		this.selectedAfiliate = selectedAfiliate;
	}

	
	/**
	 * @return the selected
	 */
	public boolean getSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the today
	 */
	public List<Appointment> getToday() {
		return today;
	}
	
	/**
	 * @param today the today to set
	 */
	public void setToday(List<Appointment> today) {
		this.today = (ArrayList<Appointment>) today;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the doctorObject
	 */
	public Doctor getDoctorObject() {
		return doctorObject;
	}

	/**
	 * @param doctorObject the doctorObject to set
	 */
	public void setDoctorObject(Doctor doctorObject) {
		this.doctorObject = doctorObject;
	}

	/**
	 * @return the progress
	 */
	public int getProgress() {
		return progress;
	}

	/**
	 * @param progress the progress to set
	 */
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	public void loadInformation(ActionEvent actionEvent) {
		if(this.selectedAfiliate == null){
			FacesContext context = FacesContext.getCurrentInstance();
			progress = 0;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
		        		"Nobody knows what the hell is going run :S"));
				progress = 100;
			}
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"You haven't selectioned an Afiliated Yet"));
	        progress = 100;
		}else{
			AfiliateServices af = AfiliateServices.getInstance();
			setAfiliateInformation(selectedAfiliate.getAfiliate());
			try{
				progress = 0;
				Thread.sleep(100);
				setClinicalHistory(af.reviewPatientHistory(afiliateInformation.getId()));
				progress = 100;
				Thread.sleep(100);
			} catch (ServiceException e) {
				FacesContext context = FacesContext.getCurrentInstance();  
			    context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
			        		"Problem Trying to load the afiliate's clinical history"));
			    progress = 100;
			} catch (InterruptedException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
		        		"Nobody knows what the hell is going run :S"));
				progress = 100;
			}

		}
	}
	
	public void update(ActionEvent actionEvent){
		if(this.selectedAfiliate == null){
			FacesContext context = FacesContext.getCurrentInstance();
			progress = 0;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
		        		"Nobody knows what the hell is going run :S"));
				progress = 100;
			}
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"You haven't selectioned an Afiliated Yet"));
	        progress = 100;
		}else{
			if(this.state == 0){
				FacesContext context = FacesContext.getCurrentInstance();
				progress = 0;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
			        		"Nobody knows what the hell is going run :S"));
				}
		        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
		        		"You haven't selectioned the Appointment's State"));
		        progress = 100;
			}else{
				AppointmentServices ap = AppointmentServices.getInstance();
				String aux = " ";
				switch (state) {
				case 1: aux = "ACOMPLISHED";
						break;
				case 2: aux = "UNACOMPLISHED";
						break;
				case 3: aux = "CANCELED";
						break;		
				default:
						break;
				}
				
				try {
					ap.updateAppointmentState(selectedAfiliate.getId(), aux);
				} catch (ServiceException e) {
					
					FacesContext context = FacesContext.getCurrentInstance();  
				    context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
				        		"Problem Trying Update the Appointment's State"));
				    progress = 100;
				}	
				
				
			}
		}	
	}
	
	public void verifySelectedAffiliate(ActionEvent actionEvent){
		if(this.afiliateInformation== null){
			FacesContext context = FacesContext.getCurrentInstance();  
		    context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
		        		"No Affiliate has been selected"));
		}
	}
	
	/**
	 * Log Out 
	 * @param ae
	 * @throws IOException
	 */
	public void logout(ActionEvent ae) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				"/EPS_A7/j_spring_security_logout");
	}
	
	public String getDoctorName(){
		return doctorObject.getName();
	}

}
