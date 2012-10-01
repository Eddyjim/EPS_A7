package eci.cosw.eps.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import eci.cosw.eps.model.Bill;

/**
 * 
 * @author Dookie
 *
 */

@Service
public class HibernateDAOBill extends HibernateGenericDAO<Bill, Integer> implements
		DAOBill {

	public HibernateDAOBill() {
		super(Bill.class);
	}

	@Override
	public List<Bill> getrecentBills() throws PersistenceException {
		try{
			Session s = super.getSessionFactory().getCurrentSession();
			Query q = s.createQuery("from Bill where aprobationCode is null");
			List<Bill> recentBills = q.list();
			return recentBills;
		}catch (HibernateException e) {
			throw new PersistenceException("Error loading the new bills");
		}
	}
	
}
