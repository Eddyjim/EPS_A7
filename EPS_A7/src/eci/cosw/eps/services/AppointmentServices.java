
package eci.cosw.eps.services;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eci.cosw.eps.model.Afiliate;
import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.model.AppointmentId;
import eci.cosw.eps.model.Doctor;
import eci.cosw.eps.model.Schedule;
import eci.cosw.eps.persistence.DAOAppointment;
import eci.cosw.eps.persistence.PersistenceException;
import eci.cosw.eps.webservices.BeanRegisterAppointmentIPS;
import eci.cosw.eps.webservices.RemoteSystemExcpetion;

/**
 * @author chevy
 *
 */
@Service
public class AppointmentServices {
	
	private DAOAppointment daoappoinnment = null;
	private BeanRegisterAppointmentIPS IPSRemoteSystem = null;
	
	private static AppointmentServices instance = null;
	
	private static int MILLIS_IN_A_DAY = 1000*60*60*24; 
	
	/**
	 * 
	 * @param daoAppointment is the daoAppointment to set
	 */
	@Autowired
	public void setDaoAppointment(DAOAppointment daoAppointment) {
		this.daoappoinnment = daoAppointment;
	}
	
	/**
	 * @param IPSRemoteSystem the IPSRemoteSystem to set
	 */
	@Autowired
	public void setIPSRemoteSystem(BeanRegisterAppointmentIPS sistemaRemotoIPS) {
		this.IPSRemoteSystem = sistemaRemotoIPS;
	}
	
	/**
	 * 
	 * @return an instance of the services available to manage Appointments
	 */
	public static AppointmentServices getInstance(){
		if (instance==null){
			ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{
					"applicationContext.xml",
					"services.xml",
					"daos.xml"});
			instance=ac.getBean(AppointmentServices.class);			
		}
		return instance;
	}

	/**
	 * This method allows to register a remote appointment on the ips
	 * @param date is the date of the remote appointment
	 * @param afiliateID is the id of the affiliate of the appointment
	 * @param docotrID is the id of the doctor for the appointment
	 * @throws ServiceException 
	 */
	public void registerRemoteAppointment(Date date, int afiliateID, int docotrID) throws ServiceException{
		try {
			IPSRemoteSystem.registerAppointment(date, docotrID, afiliateID);
		} catch (RemoteSystemExcpetion e) {
			throw new ServiceException("Something wrong");
		}
	}
	
	/**
	 * This method allows to register an appointment on the system
	 * @param afiliate is the Object that contains all the information of the affiliate
	 * @param doctor is the Object that contains all the information of the doctor
	 * @param date is the date for the appointment
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public void registerAppointment(Afiliate afiliate, Doctor doctor, Date date) throws ServiceException{
		Appointment appointment = new Appointment(new AppointmentId(date, afiliate.getId()),afiliate,doctor,"SCHEDULED");
		try {
			daoappoinnment.save(appointment);
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Saving an Appointment ");
		}
	}
	
	/**
	 * This method allows to check all the appointments registered on a day for this doctor
	 * @param doctorID is the id of the doctor
	 * @param today is the date of the day to check the schedule
	 * @return List of all the appointments of the doctor for the selected day
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public List<Appointment> reviewSchedule(int doctorID, Date day) throws ServiceException{
		ArrayList<Appointment> todayAppointments;
		try {
			todayAppointments = (ArrayList<Appointment>) daoappoinnment.loadDoctorOcupped(doctorID, day);
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loadding the Appointments of a Doctor in a specific Day ");
		}
		return todayAppointments; 
	}
	
	/**
	 * This method allows to check the availability of a doctor to create an appointment
	 * @param doctorID is the Id of the doctor requested
	 * @param day is the date when the doctor availability is requested
	 * @return A list with the Availability of the doctor on the day requested
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class) 
	public List<Date> doctorAvaibilityDay(int doctorID, Date day) throws ServiceException{
		
		ArrayList<Appointment> todayAppointments;
		ArrayList<Date> todayAvailable = new ArrayList<Date>();
		ArrayList<Schedule> todayAvaibility;
		
//		Calendar start = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
//		Calendar finish = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
//		
//		start.setTime(day);
//		finish.setTime(day);

		Date start = (Date) day.clone();
		Date finish = (Date) day.clone();
//		finish.setTime(finish.getTime()+(MILLIS_IN_A_DAY));
		try {
			todayAppointments = (ArrayList<Appointment>) reviewSchedule(doctorID, day);
		} catch (ServiceException e) {
			throw new ServiceException("Error refering to Loadding the Appointments of a Doctor in a specific Day Using a previous Service ");
		}
		try {
			todayAvaibility = (ArrayList<Schedule>) daoappoinnment.loadDoctorAvailability(doctorID, start.getDay());
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loadding the Aviability of a Doctor in a specific Day ");
		}
		
		for(int i = 0; i < todayAvaibility.size(); i++)
		{
			Point begin = todayAvaibility.get(i).timeStart();
			Point end = todayAvaibility.get(i).timeEnd();
			
//			start.set(Calendar.HOUR, begin.x);
//			start.set(Calendar.MINUTE, begin.y);
//			start.set(Calendar.SECOND, 0);
//			start.set(Calendar.MILLISECOND, 0);
//			finish.set(Calendar.HOUR, end.x);
//			finish.set(Calendar.MINUTE, end.y);
//			finish.set(Calendar.SECOND, 0);
//			finish.set(Calendar.MILLISECOND, 0);
			
			start.setHours(begin.x);
			start.setMinutes(begin.y);
			start.setSeconds(0);
			
			finish.setHours(end.x);
			finish.setMinutes(end.y);
			finish.setSeconds(0);
			
			
			System.err.println("El día "+day.toLocaleString());
			System.err.println("El Appointment "+todayAvaibility.get(i).getId().getDay()+" de Hora: "+todayAvaibility.get(i).getId().getTimeStart()+" - "+todayAvaibility.get(i).getId().getTimeEnd());
			System.err.println("Va de "+start.toLocaleString()+" hasta las "+finish.toLocaleString());
												
			while(start.before(finish)){
				
				Date aux = (Date) start.clone();
				todayAvailable.add(aux);
				start.setTime(start.getTime()+Appointment.DURATION);
//				start.add(Calendar.MINUTE, Appointment.DURATION);
				
			}
			
		}
		
		System.err.println("Cantidad de Citas: "+todayAppointments.size());
		
		for(int i=0; i<todayAppointments.size(); i++){
			Date aux1 = todayAppointments.get(i).getId().getDate();
			System.err.println("Cita el : "+aux1.toLocaleString());
			for(int j=0; j<todayAvailable.size();j++){
				Date aux2 = todayAvailable.get(j);
				if( aux2.getTime()  < ( aux1.getTime() + Appointment.DURATION/2) &&  aux2.getTime()  > ( aux1.getTime() - Appointment.DURATION/2) ){
					System.err.println("Removerá :"+aux2.toLocaleString());
					todayAvailable.remove(aux2);
				}
			}
			
		}
		
		for(int i=0; i<todayAvailable.size(); i++)
			System.err.println("Disponible "+todayAvailable.get(i).toLocaleString());	
				
		return todayAvailable;
	}
	
	/**
	 * 
	 * @param doctorID is the id of the doctor that is requested
	 * @return List of possible dates to set a new appointment
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public List<Schedule> doctorAvailability(int doctorID) throws ServiceException{
		try {
			return (daoappoinnment.loadDoctorAvailability(doctorID));
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loading the Doctor's Aviability ");
		}
	}
	
	/**
	 * This method allows to update the state of an appointment
	 * @param date is the date that identifies the appointment
	 * @param state is the new state to be assigned for the appointment
	 * @param afiliateID is the affiliate id that has registered the appointment
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public void updateAppointmentState(AppointmentId id, String state ) throws ServiceException {
		Appointment app;
		try{
		app = daoappoinnment.load(id);
		app.setState(state);
		}catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loading an Appointment");
		}
		try {
			daoappoinnment.save(app);
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Saving an Appointment");
		}
	}
	
	/**
	 * This method allows to check the schedule of a specialist
	 * @param doctorID is the id of the specialist
	 * @param today is the date of the day to check the schedule
	 * @return List of all the appointments of the specialist for the selected day
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=Exception.class)
	public List<Appointment> reviewSpecialistSchedule(int doctorID, Date today) throws ServiceException{		
		
		try {
			return (daoappoinnment.loadDoctorOcupped(doctorID, today));
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loading The Appointments of the Specialist with Id: "+ doctorID);
		} 
		
	}
		
}
