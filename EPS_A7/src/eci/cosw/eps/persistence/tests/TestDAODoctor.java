/**
 * 
 */
package eci.cosw.eps.persistence.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;



import eci.cosw.eps.model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import eci.cosw.eps.persistence.DAODoctor;
import eci.cosw.eps.persistence.PersistenceException;

/**
 * @author chevy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:daos.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestDAODoctor extends AbstractTransactionalJUnit4SpringContextTests {

	private DAODoctor daodo;
	
	
	@Autowired
	public void setDaodo(DAODoctor daodo) {
		this.daodo = daodo;
	}

/**
	
	@Before
	public void init() {
		System.out.println("inicializando la base de datos.");
		System.out.println("Creamos un Doctor :D.");
		Set<Specialty> use = new HashSet<Specialty>();
		try {
			Specialty spe1 = daospe.load(2); 
			System.out.println(spe1.getName());
			use.add(spe1);
			Doctor aux = new Doctor(7, "Lalo Landa ", use , new HashSet<Appointment>() , new HashSet<Schedule>() );
			daodo.save(aux);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		
	}

	@After
	public void clean() {
		
		try {
			Doctor o = daodo.load(7);
			daodo.makeTransient(o);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		System.out.println("limpiando la base de datos.");
	}
	
**/
	
	@Test
	public void specialistsProbe() throws PersistenceException{
	/**	Specialty spe1;
		try {
			spe1 = daospe.load(2);
			System.out.println(spe1.getName());
		} catch (PersistenceException e) {
			System.out.println("Falla Cargar Especialidad :O");
		}
	**/ 
		java.util.List<Doctor> specialists = daodo.loadSpecialist(2);   
		Assert.assertEquals(specialists.size(), 1);
	}
	
	@Test
	public void generalDoctorsProbe() throws PersistenceException{
		ArrayList<Doctor> generalDoctors = (ArrayList<Doctor>) daodo.loadGeneralDoctors();
		System.err.println(generalDoctors.size());
		Assert.assertEquals(1, generalDoctors.size());
	}

}
