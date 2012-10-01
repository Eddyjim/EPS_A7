package eci.cosw.eps.webservices.dummies;

import org.springframework.stereotype.Service;

import eci.cosw.eps.webservices.BeanUpdateBillIPS;
//@Service
public class DummieUpdateBill implements BeanUpdateBillIPS {

	@Override
	public void updateBill(int id, String State) {
		System.out.println("Lo actualizo, actualizo :D");
	}

}
