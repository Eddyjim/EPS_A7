package eci.cosw.eps.view;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.jws.WebService;
import javax.servlet.http.HttpSession;

import org.springframework.security.context.SecurityContextHolder;

import eci.cosw.eps.model.Afiliate;
import eci.cosw.eps.model.Doctor;
import eci.cosw.eps.model.Specialty;
import eci.cosw.eps.services.AfiliateServices;
import eci.cosw.eps.services.AppointmentServices;
import eci.cosw.eps.services.DoctorService;
import eci.cosw.eps.services.ServiceException;
import eci.cosw.eps.services.SpecialtyService;
import eci.cosw.eps.webservices.BeanDoctorIPS;
import eci.cosw.eps.webservices.RemoteSystemExcpetion;
import eci.cosw.eps.webservices.impl.RemoteIPSAppointment;
import eci.cosw.eps.webservices.impl.RemoteIPSDoctor;

public class ReferingToSpecialistBB {
	
	/**
	 * 
	 */
	private int patient;
	private int doctor;
	private Afiliate patientObject;
	private Doctor doctorObject;
	
	private ArrayList<Date> day1;
	private ArrayList<Date> day2;
	private ArrayList<Date> day3;
	private ArrayList<Date> day4;
	private ArrayList<Date> day5;
	private ArrayList<Date> day6;
	private ArrayList<Date> day7;
	
	private String header1;
	private String header2;
	private String header3;
	private String header4;
	private String header5;
	private String header6;
	private String header7;

	
	private ArrayList<Specialty> specialties;
	private ArrayList<Doctor> specialists;
	
	private Doctor selectedDoctor;
	private boolean selected;
	private int progress;
	
	private Date selectedAppointment;
	private Specialty selectedSpecialty;
	private boolean eps = true;
	
	static final long MILLIS_IN_A_DAY = 1000*60*60*24;
	
	public ReferingToSpecialistBB() {
		selected = false;
		selectedDoctor = null;
		try{
			specialties = (ArrayList<Specialty>) SpecialtyService.getInstance().getSpecialties();
		}
		catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"Nobody knows what the hell is going run :S"));
			
		}
		
		
		String id = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		this.setDoctor(Integer.parseInt(id));
		
		
		HttpSession s =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HomeDoctorBB bb=(HomeDoctorBB)s.getAttribute("homeDoctorBB");
					
		setPatient(bb.getAfiliateInformation().getId());
		
		setHeader1("Day 1");
		setHeader2("Day 2");
		setHeader3("Day 3");
		setHeader4("Day 4");
		setHeader5("Day 5");
		setHeader6("Day 6");
		setHeader7("Day 7");
	}

	public ArrayList<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(ArrayList<Specialty> specialties) {
		this.specialties = specialties;
	}

	public ArrayList<Doctor> getSpecialists() {
		return specialists;
	}

	public void setSpecialists(ArrayList<Doctor> specialists) {
		this.specialists = specialists;
	}

	public void setSelectedSpecialty(Specialty selectedSpecialty) {
		this.selectedSpecialty = selectedSpecialty;
	}

	
	public Specialty getSelectedSpecialty() {
		return selectedSpecialty;
	}

	public void setSelectedSpecialty(int specialty) {
		try {
			this.selectedSpecialty = SpecialtyService.getInstance().getSpecialty(specialty);
		} catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"Problem Trying to Load Specialty"));
		}
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

	/**
	 * @return the selectedAppointment
	 */
	public Date getSelectedAppointment() {
		return selectedAppointment;
	}

	/**
	 * @param selectedAppointment the selectedAppointment to set
	 */
	public void setSelectedAppointment(Date selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	/**
	 * @return the selectedDoctor
	 */
	public Doctor getSelectedDoctor() {
		return selectedDoctor;
	}

	/**
	 * @param selectedDoctor the selectedDoctor to set
	 */
	public void setSelectedDoctor(Doctor selectedDoctor) {
		setSelected(true);
		this.selectedDoctor = selectedDoctor;
	}
	
	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}



	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Doctor getDoctorObject() {
		return doctorObject;
	}
	
	public void setDoctorObject(Doctor doctorObject){
		this.doctorObject = doctorObject;
	}

	public int getDoctor(){
		return this.doctor;
	}
	
	/**
	 * 
	 */
	public void setDoctor(int doctor) {
		this.doctor = doctor;
		try {
			doctorObject = DoctorService.getInstance().getDoctor(doctor);
		} catch (ServiceException e1) {
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"Problem Trying to Load your profile"));
		}
	}

	/**
	 * @return the patient
	 */
	public int getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(int patient) {
		this.patient = patient;
		try {
			patientObject = AfiliateServices.getInstance().getAfiliate(patient);
		} catch (ServiceException e1) {
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"Problem Trying to Load your profile"));
		}
	}

	
	
	/**
	 * @return the patientObject
	 */
	public Afiliate getPatientObject() {
		return patientObject;
	}



	/**
	 * @param patientObject the patientObject to set
	 */
	public void setPatientObject(Afiliate patientObject) {
		this.patientObject = patientObject;
	}



	/**
	 * @return the day1
	 */
	public ArrayList<Date> getDay1() {
		return day1;
	}



	/**
	 * @return the day2
	 */
	public ArrayList<Date> getDay2() {
		return day2;
	}



	/**
	 * @return the day3
	 */
	public ArrayList<Date> getDay3() {
		return day3;
	}



	/**
	 * @return the day4
	 */
	public ArrayList<Date> getDay4() {
		return day4;
	}



	/**
	 * @return the day5
	 */
	public ArrayList<Date> getDay5() {
		return day5;
	}



	/**
	 * @return the day6
	 */
	public ArrayList<Date> getDay6() {
		return day6;
	}



	/**
	 * @return the day7
	 */
	public ArrayList<Date> getDay7() {
		return day7;
	}



	/**
	 * @return the specialist
	 */
	public ArrayList<Doctor> getSpecialist() {
		return specialists;
	}
	
	public void toEps(ActionEvent actionEvent){
		eps = true;
	}

	public void toIps(ActionEvent actionEvent){
		eps = false;
	}
	
	public void registerAppointment(ActionEvent actionEvent){
		if(eps){
			try {
				AppointmentServices.getInstance().registerAppointment(patientObject,selectedDoctor,selectedAppointment);
			} catch (ServiceException e) {
				FacesContext context = FacesContext.getCurrentInstance();  
		        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
		        		"Problem Trying to register appointments"));
			}
		}
		else{
		 
			RemoteIPSAppointment remote = new RemoteIPSAppointment();
		
			try {
				remote.registerAppointment(selectedAppointment,patientObject.getId(),selectedDoctor.getId());
			} catch (RemoteSystemExcpetion e) {
				e.printStackTrace();
			}
		}
		FacesContext context = FacesContext.getCurrentInstance();
		try {
		       context.addMessage(null, new FacesMessage("Houston, We've Got a New Appointment",
		       		"You Have Register a New Appointment with "+selectedDoctor.getName()+" The :"
		       		+selectedAppointment.toLocaleString()));
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
		       		"Nobody knows what the hell is going run :S"));
			progress = 100;
		}
		
		
	}
	
	public void loadSpecialists(ActionEvent actionEvent) throws ServiceException{
		if(eps){
			if(this.selectedSpecialty == null){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null,new FacesMessage("Houston, We've Got a Problem",
						"No Specialty has been selected"));			
			}
			else{
				try {
					specialists = (ArrayList<Doctor>) DoctorService.getInstance().getSpecialists(selectedSpecialty.getId());
					progress = 100;
					Thread.sleep(100);
				} catch (ServiceException e) {
					FacesContext context = FacesContext.getCurrentInstance();  
			        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
			        		"Problem Trying to register appointments"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else{
//			if(this.selectedSpecialty == null){
//				FacesContext context = FacesContext.getCurrentInstance();
//				context.addMessage(null,new FacesMessage("Houston, We've Got a Problem",
//						"No Specialty has been selected"));			
//			}
//			else{
				try {
					RemoteIPSDoctor remote = new RemoteIPSDoctor();
					specialists = (ArrayList<Doctor>) remote.getIPSDoctors();
					progress = 100;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}catch (RemoteSystemExcpetion e) {
					e.printStackTrace();
				}
//			}
		}
	}
	
	public void loadSchedules(ActionEvent actionEvent) {
		if(this.selectedDoctor == null){
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		"No has seleccionado un doctor"));
		}
		AppointmentServices service = AppointmentServices.getInstance();
		Date aux = new Date();
		aux.setHours(0);
		aux.setMinutes(0);
		aux.setSeconds(0);
		
//		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
//		cal.setTime(aux);
//		cal.set(Calendar.HOUR, 0);
//		cal.set(Calendar.MINUTE, 0);
//		cal.set(Calendar.SECOND, 0);
//		cal.set(Calendar.MILLISECOND, 0);aux = cal.getTime();
		try{
			progress = 0;
			Thread.sleep(100);
			day1 = (ArrayList<Date>) service.doctorAvaibilityDay(selectedDoctor.getId(), aux);
			aux.setTime(aux.getTime()+MILLIS_IN_A_DAY);
			setHeader1(aux.toLocaleString());
			progress = 100 / 7 ;
			Thread.sleep(100);
			day2 = (ArrayList<Date>) service.doctorAvaibilityDay(selectedDoctor.getId(), aux);
			aux.setTime(aux.getTime()+MILLIS_IN_A_DAY);
			setHeader2(aux.toLocaleString());
			progress = (100 / 7) * 2 ;
			Thread.sleep(100);
			day3 = (ArrayList<Date>) service.doctorAvaibilityDay(selectedDoctor.getId(), aux);
			aux.setTime(aux.getTime()+MILLIS_IN_A_DAY);
			setHeader3(aux.toLocaleString());
			progress = (100 / 7) * 3 ;
			Thread.sleep(100);
			day4 = (ArrayList<Date>) service.doctorAvaibilityDay(selectedDoctor.getId(), aux);
			aux.setTime(aux.getTime()+MILLIS_IN_A_DAY);
			setHeader4(aux.toLocaleString());
			progress = (100 / 7) * 4 ;
			Thread.sleep(100);
			day5 = (ArrayList<Date>) service.doctorAvaibilityDay(selectedDoctor.getId(), aux);
			aux.setTime(aux.getTime()+MILLIS_IN_A_DAY);
			setHeader5(aux.toLocaleString());
			progress = (100 / 7) * 5 ;
			Thread.sleep(100);
			day6 = (ArrayList<Date>) service.doctorAvaibilityDay(selectedDoctor.getId(), aux);
			aux.setTime(aux.getTime()+MILLIS_IN_A_DAY);
			setHeader6(aux.toLocaleString());
			progress = (100 / 7) * 6 ;
			Thread.sleep(100);
			day7 = (ArrayList<Date>) service.doctorAvaibilityDay(selectedDoctor.getId(), aux);
			aux.setTime(aux.getTime()+MILLIS_IN_A_DAY);
			setHeader7(aux.toLocaleString());
			progress = 100 ;
			Thread.sleep(100);
		} catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();  
		    context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
		        		"Problem Trying to load the doctor availability"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
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

	/**
	 * @return the header1
	 */
	public String getHeader1() {
		return header1;
	}



	/**
	 * @param header1 the header1 to set
	 */
	public void setHeader1(String header1) {
		this.header1 = header1;
	}



	/**
	 * @return the header2
	 */
	public String getHeader2() {
		return header2;
	}



	/**
	 * @param header2 the header2 to set
	 */
	public void setHeader2(String header2) {
		this.header2 = header2;
	}



	/**
	 * @return the header3
	 */
	public String getHeader3() {
		return header3;
	}



	/**
	 * @param header3 the header3 to set
	 */
	public void setHeader3(String header3) {
		this.header3 = header3;
	}



	/**
	 * @return the header4
	 */
	public String getHeader4() {
		return header4;
	}



	/**
	 * @param header4 the header4 to set
	 */
	public void setHeader4(String header4) {
		this.header4 = header4;
	}



	/**
	 * @return the header5
	 */
	public String getHeader5() {
		return header5;
	}



	/**
	 * @param header5 the header5 to set
	 */
	public void setHeader5(String header5) {
		this.header5 = header5;
	}



	/**
	 * @return the header6
	 */
	public String getHeader6() {
		return header6;
	}



	/**
	 * @param header6 the header6 to set
	 */
	public void setHeader6(String header6) {
		this.header6 = header6;
	}



	/**
	 * @return the header7
	 */
	public String getHeader7() {
		return header7;
	}



	/**
	 * @param header7 the header7 to set
	 */
	public void setHeader7(String header7) {
		this.header7 = header7;
	}
	
	public String getDoctorName(){
		return doctorObject.getName();
	}
}
