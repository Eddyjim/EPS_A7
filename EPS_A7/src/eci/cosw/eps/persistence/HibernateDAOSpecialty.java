package eci.cosw.eps.persistence;

import org.springframework.stereotype.Service;

import eci.cosw.eps.model.Specialty;

/**
 * 
 * @author Eddy
 *
 */

@Service
public  class HibernateDAOSpecialty extends HibernateGenericDAO<Specialty, Integer> implements
		DAOSpecialty {

	public HibernateDAOSpecialty() {
		super(Specialty.class);
	}

}
