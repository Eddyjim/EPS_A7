package eci.cosw.eps.persistence.tests;

import java.sql.Blob;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import eci.cosw.eps.persistence.DAOAfiliate;
import eci.cosw.eps.persistence.PersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml","classpath:daos.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class TestDAOAfiliate extends AbstractTransactionalJUnit4SpringContextTests{
	
	private DAOAfiliate daoaf;
	
	@Autowired
	public void setDAOAfiliate(DAOAfiliate d){
		this.daoaf = d;
		//System.out.println(daoaf.toString());
	}
	
	@Test
	public void testHistory() throws PersistenceException{
		Blob b = daoaf.getAfiliateHistory(123);
		String historia = null;
		try {
			historia = new String(b.getBytes(1, (int)b.length()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("S", historia);
	}
	
}