package eci.cosw.eps.persistence;

import java.util.List;

import eci.cosw.eps.model.Bill;

public interface DAOBill extends GenericDAO<Bill, Integer> {
	
	public List<Bill> getrecentBills() throws PersistenceException;

}
