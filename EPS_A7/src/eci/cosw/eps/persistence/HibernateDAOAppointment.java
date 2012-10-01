package eci.cosw.eps.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.model.AppointmentId;
import eci.cosw.eps.model.Schedule;

@Service
public class HibernateDAOAppointment extends HibernateGenericDAO<Appointment, AppointmentId>
		implements DAOAppointment {

	public HibernateDAOAppointment( ) {
		super(Appointment.class);
	}
	
	static final long MILLIS_IN_A_DAY = 1000*60*60*24;
	
	/*
	 * (non-Javadoc)
	 * @see eci.cosw.eps.persistence.DAOAppointment#loadAfiliateDay(eci.cosw.eps.model.AppointmentId)
	 */
	@Override
	public List<Appointment> loadAfiliateDay(AppointmentId appointmentId) throws PersistenceException {
		List<Appointment> citas;
		try{
			Session s = super.getSessionFactory().getCurrentSession();
			Date today = appointmentId.getDate();
			Date tomorrow = new Date(today.getTime()+MILLIS_IN_A_DAY);
			Query q = s.createQuery("from Appointment where id.afiliateId = :af "+
									"and date >= :today and date <= :tomorrow");
			q.setDate("today", today);
			q.setDate("tomorrow", tomorrow);
			q.setInteger("af", appointmentId.getAfiliateId());
			citas = q.list();
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading appointments of afiliate "+ 
					appointmentId.getAfiliateId()+" in the date "+
					appointmentId.getDate().toLocaleString());
		}
		return citas;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eci.cosw.eps.persistence.DAOAppointment#loadDoctorAvailability(int)
	 */
	@Override
	public List<Schedule> loadDoctorAvailability(int doctor) throws PersistenceException {
		List<Schedule> schedules;
		try{
			Session s = super.getSessionFactory().getCurrentSession();
			Query q = s.createQuery("select schedules from Doctor where id = :val");
			q.setInteger("val", doctor);
			schedules = q.list();
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading schedules for doctor with: " + doctor);
		}
		return schedules;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eci.cosw.eps.persistence.DAOAppointment#loadDoctorAvailability(int, int)
	 */
	@Override
	public List<Schedule> loadDoctorAvailability(int doctor, int day) throws PersistenceException {
		List<Schedule> schedules;
		try{
			Session s = super.getSessionFactory().getCurrentSession();
			Query q = s.createQuery("select schedules from Doctor where id = :val and day = :d");
			q.setInteger("val", doctor);
			q.setInteger("d", day);
			schedules = q.list();
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading schedules for doctor with: " + doctor+ " in The Day: "+ day);
		}
		return schedules;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eci.cosw.eps.persistence.DAOAppointment#loadDoctorOcupped(int, java.util.Date)
	 */
	@Override
	public List<Appointment> loadDoctorOcupped(int doctor, Date today) throws PersistenceException{
		List<Appointment> appointments;
		try{
//			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
//			cal.setTime(today);
//			cal.set(Calendar.HOUR, 0);
//			cal.set(Calendar.MINUTE, 0);
//			cal.set(Calendar.SECOND, 0);
//			cal.set(Calendar.MILLISECOND, 0);
//			
			Session s = super.getSessionFactory().getCurrentSession();
			Date tomorrow =  new Date(today.getTime( )+MILLIS_IN_A_DAY);
			Query q = s.createQuery("from Appointment where doctor.id = :val and date >= :start and date < :end ");
			q.setInteger("val", doctor);
			q.setDate("start", today);
			q.setDate("end", tomorrow);
			appointments = q.list();
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading Appoinments in a specific day for doctor  whit id: " + doctor);
		}
		return appointments;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eci.cosw.eps.persistence.DAOAppointment#loadDoctorAppointments(int)
	 */
	@Override
	public List<Appointment> loadDoctorAppointments(int doctorId) throws PersistenceException {
		List<Appointment> appointments;
		try{
			Session s = super.getSessionFactory().getCurrentSession();
			Query q = s.createQuery("from Appointment where doctor.id = :val");
			q.setInteger("val", doctorId);
			appointments = q.list();
			
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading Appoinments for doctor  whit id: " + doctorId);
		}
		return appointments;
	}
	
}
