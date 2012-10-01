/**
 * 
 */
package eci.cosw.eps.persistence;

import java.util.List;

import eci.cosw.eps.model.Doctor;

/**
 * @author chevy
 *
 */
public interface DAODoctor extends GenericDAO<Doctor, Integer> {
	
	public List<Doctor> loadSpecialist(int specialityID) throws PersistenceException;
	
	public List<Doctor> loadGeneralDoctors() throws PersistenceException;

}
