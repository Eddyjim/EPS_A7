/**
 * 
 */
package eci.cosw.eps.persistence;

import java.sql.Blob;
import eci.cosw.eps.model.Afiliate;

/**
 * @author chevy
 *
 */
public interface DAOAfiliate extends GenericDAO<Afiliate, Integer> {
	
	public Blob getAfiliateHistory(int afiliateid) throws PersistenceException;

}
