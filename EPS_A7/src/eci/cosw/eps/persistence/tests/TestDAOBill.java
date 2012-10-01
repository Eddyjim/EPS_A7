/**
 * 
 */
package eci.cosw.eps.persistence.tests;

import static org.junit.Assert.*;

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

import eci.cosw.eps.model.Bill;
import eci.cosw.eps.persistence.DAOBill;
import eci.cosw.eps.persistence.DAOIps;

import eci.cosw.eps.persistence.PersistenceException;

/**
 * @author dookie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:daos.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestDAOBill extends AbstractTransactionalJUnit4SpringContextTests {

	private DAOBill daobil;
	private DAOIps daoips;
	private Bill i;
	
	@Autowired
	public void setDAOBill(DAOBill d){
		this.daobil = d;
		//System.out.println(daoaf.toString());
	}
	
	@Autowired
	public void setDAOIps(DAOIps d){
		this.daoips = d;
		//System.out.println(daoaf.toString());
	}
	
	@Before
	public void init(){
		try {
			i = new Bill(8 ,daoips.load(11111), 150000, "7890123456");
			daobil.save(i);
		} catch (PersistenceException e) {
			System.err.println("Error Creando Bill");
		}
	}
	
	@After
	public void clean(){
		
		try {
			daobil.makeTransient(i);
			//System.err.println("IPS Bien Eliminada");
		} catch (PersistenceException e) {
			System.err.println("Error Eliminando la Bill");
		}
	}
	
	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateGenericDAO#save(java.lang.Object)}.
	 * @throws PersistenceException 
	 */
	@Test
	public void testSave() throws PersistenceException {
			i = new Bill(8 ,daoips.load(11111), 200000, "7890123456");
			daobil.save(i);
			System.err.println(daobil.load(8).getValue());
			Assert.assertEquals(200000, daobil.load(8).getValue());
			//System.err.println("IPS Bien Creada");
	}

	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateGenericDAO#loadAll()}.
	 * @throws PersistenceException 
	 */
	@Test
	public void testLoadAll() throws PersistenceException {
			List<Bill> bills = daobil.loadAll();
			Assert.assertEquals(7, bills.size());
		
	}

}
