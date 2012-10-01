package eci.cosw.eps.persistence;

import java.io.Serializable;
import java.util.List;



public interface GenericDAO<T,PK extends Serializable> {

	public void save(T o) throws PersistenceException;
	
	public T load(PK id) throws PersistenceException;
		
	public void makeTransient(T o) throws PersistenceException;
	
	public List<T> loadAll() throws PersistenceException;
	
	
	
}
