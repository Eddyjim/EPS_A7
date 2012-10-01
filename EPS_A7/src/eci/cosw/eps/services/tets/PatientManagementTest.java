/**
 * 
 */
package eci.cosw.eps.services.tets;

import static org.junit.Assert.*;


import org.junit.Test;

import eci.cosw.eps.services.AfiliateServices;
import eci.cosw.eps.services.ServiceException;

/**
 * @author dookie
 *
 */
public class PatientManagementTest {

	/**
	 * Test method for {@link eci.cosw.eps.services.AfiliateServices#reviewPatientHistory(int)}.
	 * @throws ServiceException 
	 */
	@Test
	public void testReviewPatientHistory() throws ServiceException {
		String history = AfiliateServices.getInstance().reviewPatientHistory(123);
		assertEquals(history, "S");
	}

}
