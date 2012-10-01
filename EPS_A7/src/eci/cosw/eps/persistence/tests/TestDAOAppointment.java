/**
 * 
 */
package eci.cosw.eps.persistence.tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.model.AppointmentId;
import eci.cosw.eps.model.Schedule;
import eci.cosw.eps.persistence.DAOAppointment;
import eci.cosw.eps.persistence.PersistenceException;

/**
 * @author dookie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml","classpath:daos.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class TestDAOAppointment extends
		AbstractTransactionalJUnit4SpringContextTests {

	private DAOAppointment daoapp;
	
	@Autowired
	public void setDAOAfiliate(DAOAppointment d){
		this.daoapp = d;
		//System.out.println(daoaf.toString());
	}

	
	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateDAOAppointment#loadDay(eci.cosw.eps.model.AppointmentId)}.
	 * @throws PersistenceException 
	 */
	@Test
	public void testLoadDay() throws PersistenceException {
		GregorianCalendar gr = new GregorianCalendar(2012, Calendar.FEBRUARY, 20);
		List<Appointment> app = daoapp.loadAfiliateDay(new AppointmentId( new Timestamp(gr.getTimeInMillis() ), 123 ));
		Assert.assertEquals(1, app.size());
	}
	
	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateDAOAppointment#loadDoctorAvailability(int)}.
	 * @throws PersistenceException 
	 */
	@Test
	public void testLoadDoctorAvailability() throws PersistenceException {
		List<Schedule> sche = daoapp.loadDoctorAvailability(123456);
		Assert.assertEquals(7, sche.size());
	}
	
	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateDAOAppointment#loadDoctorAvailability(int, int)}.
	 * @throws PersistenceException 
	 */
	@Test
	public void testLoadDoctorAvailabilityDay() throws PersistenceException {
		List<Schedule> sche = daoapp.loadDoctorAvailability(123456, 1 );
		Assert.assertEquals(2, sche.size());
	}

	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateDAOAppointment#loadDoctorOcupped(int, java.util.Date)}.
	 * @throws PersistenceException 
	 */
	@Test
	public void testLoadDoctorOcupped() throws PersistenceException {
		GregorianCalendar gr = new GregorianCalendar(2012, Calendar.FEBRUARY, 15);
		List<Appointment> app = daoapp.loadDoctorOcupped(345678, new Timestamp(gr.getTimeInMillis() ));
		Assert.assertEquals(1, app.size());
	}

	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateDAOAppointment#loadDoctorAppointments(int)}.
	 * @throws PersistenceException 
	 */
	@Test
	public void testLoadDoctorAppointments() throws PersistenceException {
		List<Appointment> app = daoapp.loadDoctorAppointments(345678);
		Assert.assertEquals(2, app.size());
	}

}
