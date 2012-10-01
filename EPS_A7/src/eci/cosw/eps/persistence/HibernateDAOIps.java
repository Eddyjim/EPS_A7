package eci.cosw.eps.persistence;

import org.springframework.stereotype.Service;

import eci.cosw.eps.model.Ips;
@Service
public class HibernateDAOIps extends HibernateGenericDAO<Ips, Integer> implements
		DAOIps {

	public HibernateDAOIps() {
		super(Ips.class);
	}
}
