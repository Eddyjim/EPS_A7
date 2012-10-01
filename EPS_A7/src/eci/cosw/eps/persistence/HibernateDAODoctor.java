package eci.cosw.eps.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import eci.cosw.eps.model.Doctor;

/**
 * @author chevy
 *
 */
@Service
public class HibernateDAODoctor extends HibernateGenericDAO<Doctor, Integer> implements
		DAODoctor {

	public HibernateDAODoctor( ) {
		super(Doctor.class);
	}

	@Override
	public List<Doctor> loadSpecialist(int specialityID) throws PersistenceException {
		ArrayList<Doctor> especialistas;
		try{
		Session s = super.getSessionFactory().getCurrentSession();
		Query q = s.createQuery("from Doctor where specialties.id = :speciality");
		q.setInteger("speciality", specialityID);
		especialistas = (ArrayList<Doctor>)q.list();
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading Doctors with SpecialtyID: " + specialityID);
		}
		return especialistas;
	}

	@Override
	public List<Doctor> loadGeneralDoctors() throws PersistenceException {
		List<Doctor> doctors;
		try{
		Session s = super.getSessionFactory().getCurrentSession();
		Query q = s.createQuery("from Doctor d where d.specialties is empty");
		doctors = q.list();
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading General Doctors");
		}
		return doctors;
	}

}
