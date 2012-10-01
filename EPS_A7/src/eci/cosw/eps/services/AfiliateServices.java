/**
 * 
 */
package eci.cosw.eps.services;

import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eci.cosw.eps.model.Afiliate;
import eci.cosw.eps.persistence.DAOAfiliate;
import eci.cosw.eps.persistence.PersistenceException;

/**
 * @author dookie
 *
 */

@Service
public class AfiliateServices {
	
	
	private DAOAfiliate daoaf;
	
	private static AfiliateServices instance;
	
	/**
	 * 
	 * @return an instance of the services to manage affiliates
	 */
	public static AfiliateServices getInstance(){
		if (instance==null){
			ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{
					"applicationContext.xml",
					"services.xml",
					"daos.xml"});
			instance=ac.getBean(AfiliateServices.class);			
		}
		return instance;
	}
	
	/**
	 * 
	 * @param daoaf to set the daoaffiliate
	 */
	@Autowired
	public void setDaoaf(DAOAfiliate daoaf) {
		this.daoaf = daoaf;
	}

	/**
	 * 
	 * @param patientID is the id of the patient requested
	 * @return a String with the clinical history of the patient
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public String reviewPatientHistory(int patientID) throws ServiceException{
		byte[] bdata = null;
		try{
			Blob b = daoaf.getAfiliateHistory(patientID);
			bdata = b.getBytes(1, (int)b.length());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (PersistenceException e1) {
			throw new ServiceException("Error refering to Geting the Afiliate's History");
		}
		return new String(bdata);
	}
	
	/**
	 * 
	 * @param id is the identification code of the affiliate requested
	 * @return an Object with all the information of the affiliate
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public Afiliate getAfiliate(int id) throws ServiceException{
		Afiliate a;
		try {
			a = daoaf.load(id);
		} catch (PersistenceException e) {
			throw new ServiceException("Error loading the patient");
		}
		return a;
	}

}
 