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
import org.springframework.dao.support.DaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import eci.cosw.eps.model.Ips;
import eci.cosw.eps.persistence.DAOIps;
import eci.cosw.eps.persistence.PersistenceException;

/**
 * @author dookie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:daos.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestDAOIps extends AbstractTransactionalJUnit4SpringContextTests {

	private DAOIps daoips;
	private Ips i;
	
	@Autowired
	public void setDAOIps(DAOIps d){
		this.daoips = d;
		//System.out.println(daoaf.toString());
	}
	
	@Before
	public void init(){
		i = new Ips(15, "Charlosa :D");
		try {
			daoips.save(i);
			//System.err.println("IPS Bien Creada");
		} catch (PersistenceException e) {
			System.err.println("Error Creando IPS");
		}
	}
	
	@After
	public void clean(){
		
		try {
			daoips.makeTransient(i);
			//System.err.println("IPS Bien Eliminada");
		} catch (PersistenceException e) {
			System.err.println("Error Eliminando la IPS");
		}
	}
	
	
	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateGenericDAO#save(java.lang.Object)}.
	 */
	@Test
	public void testSave() throws PersistenceException {
		Ips aux = new Ips(15, "AguadoFlow :D");
			daoips.save(aux);
			System.err.println(daoips.load(15).getName());
			Assert.assertEquals(daoips.load(15).getName(), "AguadoFlow :D");
	}

	/**
	 * Test method for {@link eci.cosw.eps.persistence.HibernateGenericDAO#loadAll()}.
	 */
	@Test
	public void testLoadAll() throws PersistenceException{
			List<Ips> ips = daoips.loadAll();
			Assert.assertEquals(4, ips.size());
	}

}
