package eci.cosw.eps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eci.cosw.eps.model.Bill;
import eci.cosw.eps.model.Ips;
import eci.cosw.eps.persistence.HibernateDAOBill;
import eci.cosw.eps.persistence.HibernateDAOIps;
import eci.cosw.eps.persistence.PersistenceException;
import eci.cosw.eps.webservices.BeanRegisterBillFOSYGA;
import eci.cosw.eps.webservices.BeanUpdateBillIPS;
import eci.cosw.eps.webservices.RemoteSystemExcpetion;
@Service
public class BillRegistryService {
	
	private HibernateDAOBill daobill;
	private HibernateDAOIps daoips;
	
	private BeanRegisterBillFOSYGA systemRemoteFOSYGA;
	private BeanUpdateBillIPS systemRemoteIPS;
	
	
	private static BillRegistryService instance;
	
	public static BillRegistryService getInstance(){ 
		if (instance==null){
			ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{
					"applicationContext.xml",
					"services.xml",
					"daos.xml"});
			instance=ac.getBean(BillRegistryService.class);			
		}
		return instance;
	}
	
	
	
	/**
	 * @param daobill the daobill to set
	 */
	@Autowired
	public void setDaobill(HibernateDAOBill daobill) {
		this.daobill = daobill;
	}

	/**
	 * @param daoips the daoips to set
	 */
	@Autowired
	public void setDaoips(HibernateDAOIps daoips) {
		this.daoips = daoips;
	}

	/**
	 * @param sistemaRemoto the sistemaRemoto to set
	 */
	@Autowired
	public void setSistemaRemotoFOSYGA(BeanRegisterBillFOSYGA sistemaRemoto) {
		this.systemRemoteFOSYGA = sistemaRemoto;
	}

	/**
	 * @param sistemaRemotoIPS the sistemaRemotoIPS to set
	 */
	@Autowired
	public void setSistemaRemotoIPS(BeanUpdateBillIPS sistemaRemotoIPS) {
		this.systemRemoteIPS = sistemaRemotoIPS;
	}

	/**
	 * 
	 * @param billID is the bill id to register
	 * @param billValue the value for the bill to register
	 * @param IPSid is the id of the IPS
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public void registerIPSBill(int billID, int billValue, int IPSid) throws ServiceException {
		Ips ips;
		try {
			ips = daoips.load(IPSid);
			daobill.save(new Bill(billID, ips, billValue, null));
			
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Saving a Bill");
		}
		
	}
	/**
	 * This method sends the requested bill to a remote system
	 * @param billID the identification of the bill to dispatch
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public void sendBillforAprobal(int billID) throws ServiceException{
		Bill b;
		try{
			b = daobill.load(billID);
			systemRemoteFOSYGA.registerBill(b.getId(), b.getValue(), b.getIps().getId());
		}catch (PersistenceException e) {
			throw new ServiceException("Error getting bill to dispatch");
		} catch (RemoteSystemExcpetion e) {
			throw new ServiceException("Error registering bill");
		}
		
	}
	
	/**
	 * 
	 * @param id is the bill id
	 * @param state is the state that is going to be assigned
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor=PersistenceException.class)
	public void updateBill(int id, String state) throws ServiceException {
		Bill bill = null;
		try{
		bill = daobill.load(id);
		bill.setAprobationCode(state);
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Loading a Bill");
		}
		
		try {
			daobill.save(bill);
		} catch (PersistenceException e) {
			throw new ServiceException("Error refering to Saving a Bill");
		}
		systemRemoteIPS.updateBill(id, state);
	}
	
	@Transactional(rollbackFor=PersistenceException.class)
	public List<Bill> getRecentBills() throws ServiceException{
		List<Bill> bills;
		try{
			bills = daobill.getrecentBills();
		}catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		return bills;
	}
	
}
