package eci.cosw.eps.persistence;

import java.util.Date;
import java.util.List;

import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.model.AppointmentId;
import eci.cosw.eps.model.Schedule;

/**
 * @author chevy
 *
 */
public interface DAOAppointment extends GenericDAO<Appointment, AppointmentId> {

	/**
	 * 
	 * @param appointmentId
	 * @return
	 * @throws PersistenceException
	 */
	List<Appointment> loadAfiliateDay(AppointmentId appointmentId) throws PersistenceException;
	
	/**
	 * 
	 * @param doctor
	 * @return
	 * @throws PersistenceException
	 */
	List<Schedule> loadDoctorAvailability(int doctor) throws PersistenceException;
	
	/**
	 * 
	 * @param Doctor
	 * @param Day
	 * @return
	 * @throws PersistenceException
	 */
	List<Schedule> loadDoctorAvailability(int Doctor, int Day) throws PersistenceException;
	
	/**
	 * 
	 * @param doctorId
	 * @return
	 * @throws PersistenceException 
	 */
	List<Appointment> loadDoctorAppointments(int doctorId) throws PersistenceException;

	/**
	 * 
	 * @param doctor
	 * @param today
	 * @return
	 * @throws PersistenceException 
	 */
	List<Appointment> loadDoctorOcupped(int doctor, Date today) throws PersistenceException;
	
}
