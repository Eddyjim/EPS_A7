/**
 * 
 */
package eci.cosw.eps.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import eci.cosw.eps.model.Bill;
import eci.cosw.eps.services.BillRegistryService;
import eci.cosw.eps.services.ServiceException;

/**
 * @author chevy
 *
 */
public class HomeManagerBB {
	
	private int managerID;
	private ArrayList<Bill> recentBills;
	private Bill selectedBill;
	
	public HomeManagerBB() {
		String id = FacesContext.getCurrentInstance().
							getExternalContext().getRemoteUser();
		managerID = Integer.parseInt(id);
		System.out.println("El manager es: " + managerID);
		try {
			recentBills = (ArrayList<Bill>) 
					BillRegistryService.getInstance().getRecentBills();
		} catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		e.getMessage()));
		}
	}

	/**
	 * @return the managerID
	 */
	public int getManagerID() {
		return managerID;
	}

	/**
	 * @param managerID the managerID to set
	 */
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	/**
	 * @return the recentBills
	 */
	public ArrayList<Bill> getRecentBills() {
		return recentBills;
	}

	/**
	 * @param recentBills the recentBills to set
	 */
	public void setRecentBills(ArrayList<Bill> recentBills) {
		this.recentBills = recentBills;
	}

	/**
	 * @return the selectedBill
	 */
	public Bill getSelectedBill() {
		return selectedBill;
	}

	/**
	 * @param selectedBill the selectedBill to set
	 */
	public void setSelectedBill(Bill selectedBill) {
		this.selectedBill = selectedBill;
	}
	/**
	 * Send to the remote system the selected Bill for aprobal
	 * @param ae
	 */
	public void sendBill(ActionEvent ae){
		try{
			BillRegistryService.getInstance().
				sendBillforAprobal(selectedBill.getId());
		}catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Houston, We've Got a Problem",
	        		e.getMessage()));
		}
	}
	
	public void logout(ActionEvent ae) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				"/EPS_A7/j_spring_security_logout");
	}

}
