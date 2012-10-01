package eci.cosw.eps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eci.cosw.eps.model.Doctor;
import eci.cosw.eps.model.Specialty;
import eci.cosw.eps.persistence.DAODoctor;
import eci.cosw.eps.persistence.PersistenceException;
import eci.cosw.eps.webservices.BeanDoctorIPS;
import eci.cosw.eps.webservices.RemoteSystemExcpetion;

@Service
public class DoctorService {
	
	DAODoctor daodoctor ;
	
	private BeanDoctorIPS doctorIPS;
	
	/**
	 * 
	 * @param doctorIPS to set doctorIPS
	 */
	@Autowired
	public void setDoctorIPS(BeanDoctorIPS doctorIPS) {
		this.doctorIPS = doctorIPS;
	}

	private static DoctorService instance;
	
	/**
	 * 
	 * @param daodoctor to set daodoctor
	 */
	@Autowired
	public void setDaodoctor(DAODoctor daodoctor) {
		this.daodoctor = daodoctor;
	}

	/**
	 * 
	 * @return a new instance of DoctorService
	 */
	public static DoctorService getInstance(){
		if (instance==null){
			ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{
					"applicationContext.xml",
					"services.xml",
					"daos.xml"});
			instance=ac.getBean(DoctorService.class);			
		}
		return instance;
	}
	
	public List<Doctor> getIPSDoctors() throws ServiceException{
		
		try {
			return doctorIPS.getIPSDoctors();
		} catch (RemoteSystemExcpetion e) {
			throw new ServiceException("Something Wrong");
		}
	}
	
	/**
	 * 
	 * @param speciality is the id of the specialty
	 * @return a List of all the specialist
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public List<Doctor> getSpecialists(int speciality) throws ServiceException{
		List<Doctor> doctores;
		try {
			doctores = daodoctor.loadSpecialist( speciality);
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loading the Specialists ");
		}
		return doctores;
	
	}
		
	/**
	 * 
	 * @return a List that contains all the existent doctors
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public List<Doctor> getDoctors() throws ServiceException {
		try {
			return daodoctor.loadAll();
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loading All the Doctors");
		}
	}
	
	/**
	 * 
	 * @return a List that contains all the general doctors registered
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public List<Doctor> getGeneralDoctors() throws ServiceException {
		try {
			return daodoctor.loadGeneralDoctors();
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loading the General Doctors");
		}
	}
	
	/**
	 * 
	 * @param id is the id of the doctor selected
	 * @return the Object of the doctor that contains all the information
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public Doctor getDoctor(int id) throws ServiceException{
		Doctor d;
		try {
			d = daodoctor.load(id);
		} catch (PersistenceException e) {
			throw new ServiceException("Error loading the doctor");
		}
		return d;
	}
}
