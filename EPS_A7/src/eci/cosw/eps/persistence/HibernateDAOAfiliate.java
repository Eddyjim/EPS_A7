package eci.cosw.eps.persistence;

import java.sql.Blob;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import eci.cosw.eps.model.Afiliate;

@Service
public class HibernateDAOAfiliate extends HibernateGenericDAO<Afiliate, Integer> implements
		DAOAfiliate {

	public HibernateDAOAfiliate( ) {
		super(Afiliate.class);
	}

	@Override
	public Blob getAfiliateHistory(int afiliateid) throws PersistenceException {
		Blob resultado;
		try
		{
			Session s = super.getSessionFactory().getCurrentSession();
			Query q = s.createQuery("select history from Afiliate where id = :val");
			q.setInteger("val", afiliateid);
			resultado= (Blob) q.uniqueResult();
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading hostory from afiliate with id "+ afiliateid);
		}
		return resultado;
	}

	

}
