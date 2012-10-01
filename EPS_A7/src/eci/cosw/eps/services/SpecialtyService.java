package eci.cosw.eps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eci.cosw.eps.model.Specialty;
import eci.cosw.eps.persistence.DAOSpecialty;
import eci.cosw.eps.persistence.PersistenceException;

/**
 * 
 * @author Eddy
 *
 */

@Service
public class SpecialtyService {
	private DAOSpecialty daospe;
	
	private static SpecialtyService instance = null; 
	
	@Autowired
	public void setDaospe(DAOSpecialty daospe){
		this.daospe = daospe;
	}
	
	/**
	 * 
	 * @return an instance of the services to manage specialties
	 */
	public static SpecialtyService getInstance(){
		if (instance==null){
			ApplicationContext ac= new ClassPathXmlApplicationContext(new String[]{
					"applicationContext.xml",
					"services.xml",
					"daos.xml"});
			instance=ac.getBean(SpecialtyService.class);			
		}
		return instance;
	}
	
	/**
	 * 
	 * @return a List with all the specialties
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public List<Specialty> getSpecialties()throws ServiceException{
		try {
			return daospe.loadAll();
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loading All the Specialties");
		}
	}
	
	/**
	 * 
	 * @param id is the id of the specialty requested
	 * @return the specialty which is request
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public Specialty getSpecialty(int id) throws ServiceException{
		Specialty s;
		try {
			s =daospe.load(id);
		} catch (PersistenceException e) {
			throw new ServiceException("Error loading the Specialty");
		}
		return s;
	}
}
