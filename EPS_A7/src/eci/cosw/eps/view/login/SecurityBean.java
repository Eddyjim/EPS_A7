package eci.cosw.eps.view.login;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class SecurityBean {

	String userId;

	String password;

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}

	public void login(ActionEvent e) throws java.io.IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				"j_spring_security_check?j_username=" + userId + "&j_password="
						+ password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void logout(ActionEvent ae) throws IOException {

		FacesContext.getCurrentInstance().getExternalContext().redirect(
				"j_spring_security_logout");

	}

}
