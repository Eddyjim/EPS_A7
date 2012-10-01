/**
 * 
 */
package eci.cosw.eps.services.tets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import eci.cosw.eps.model.Afiliate;
import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.model.AppointmentId;
import eci.cosw.eps.model.Doctor;
import eci.cosw.eps.persistence.DAOAfiliate;
import eci.cosw.eps.persistence.DAOAppointment;
import eci.cosw.eps.persistence.DAODoctor;
import eci.cosw.eps.persistence.PersistenceException;
import eci.cosw.eps.services.AfiliateServices;
import eci.cosw.eps.services.AppointmentServices;
import eci.cosw.eps.services.DoctorService;
import eci.cosw.eps.services.ServiceException;

/**
 * @author dookie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:daos.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class AppointmentServicesTests extends AbstractTransactionalJUnit4SpringContextTests {

	private AppointmentServices ap = AppointmentServices.getInstance();
	private DAOAfiliate af;
	private DAODoctor doc;
	private DAOAppointment app;
	
	Afiliate afiliate;
	Doctor doctor;
	Timestamp time;
	AppointmentId id;
	
	@Autowired
	public void setDAOAppintment(DAOAppointment d){
		this.app = d;
		System.out.println(app.toString());
	}
	
	@Autowired
	public void setDAOAfiliate(DAOAfiliate d){
		this.af = d;
		System.out.println(af.toString());
	}
	
	@Autowired
	public void setDAODoctor(DAODoctor d){
		this.doc = d;
		System.out.println(doc.toString());
	}

	@Before
	public void init() throws PersistenceException, ServiceException {
		GregorianCalendar gr = new GregorianCalendar(2012, Calendar.MARCH, 05);
		time = new Timestamp(gr.getTimeInMillis());
		doctor =  doc.load(123456);
		afiliate = af.load(234);
		id = new AppointmentId(time, afiliate.getId());
		ap.registerAppointment(afiliate, doctor, time);
	}
	
	@After
	public void clean() throws PersistenceException{
		app.makeTransient(app.load(id));
		}
		


	/**
	 * Test method for {@link eci.cosw.eps.services.AppointmentServices#doctorAvaibilityDay(int, java.util.Date)}.
	 * @throws PersistenceException 
	 * @throws ServiceException 
	 */
	@Test
	public void testdoctorAvaibilityDay() throws ServiceException {
		GregorianCalendar gr = new GregorianCalendar(2012, Calendar.FEBRUARY, 29);
		List<java.util.Date> disponibility = AppointmentServices.getInstance().doctorAvaibilityDay(123456, new Timestamp(gr.getTimeInMillis() ) );
		Assert.assertEquals(10, disponibility.size());
	}
	
	
	/**
	 * Test method for {@link eci.cosw.eps.services.AppointmentServices#reviewSchedule(int, java.util.Date)}.
	 * @throws PersistenceException 
	 * @throws ServiceException 
	 */
	@Test
	public void testReviewSchedule() throws ServiceException {
		java.util.List<Appointment> appointments = AppointmentServices.getInstance().reviewSchedule(123456, Date.valueOf("2012-02-29"));
		assertEquals(2, appointments.size());
	}

	/**
	 * Test method for {@link eci.cosw.eps.services.AppointmentServices#updateAppointmentState(java.util.Date, int, int)}.
	 */
	@Test
	public void testUpdateAppointmentState() throws ServiceException, PersistenceException {
		ap.updateAppointmentState( id, "CANCELADA");
		Assert.assertEquals("CANCELADA", app.load(id).getState());
	}

	/**
	 * Test method for {@link eci.cosw.eps.services.AppointmentServices#reviewSpecialistSchedule()}.
	 * @throws ServiceException 
	 */
	@Test
	public void testReviewSpecialistSchedule() throws ServiceException {
		java.util.List<Appointment> appointments = AppointmentServices.getInstance().reviewSpecialistSchedule(123456, Date.valueOf("2012-02-29"));
		assertEquals( 2, appointments.size());
	}

}
