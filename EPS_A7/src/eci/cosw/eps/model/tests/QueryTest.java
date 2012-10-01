/**
 * 
 */
package eci.cosw.eps.model.tests;

import java.sql.Blob;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import eci.cosw.eps.model.Afiliate;
import eci.cosw.eps.model.Appointment;
import eci.cosw.eps.model.Bill;

/**
 * @author chevy
 *
 */
public class QueryTest {
	private final  static SessionFactory  sf = (
			new AnnotationConfiguration().configure("hibernate.cfg.xml")).buildSessionFactory();
	
	/**
	 * Consultar las citas de un medico entre dos rangos de fechas.
	 */
	@Test
	public void testCitaseEntreFechas() {
		Session s = sf.openSession();
		int parametro1 = 1, parametro2 = 5, parametro3 = 123456;
		Query q = s.createQuery("from Appointment a where a.doctor.id = 123456 ");
		System.out.println("hola");
		List<Appointment> resultado = q.list();
		for (Appointment appointment : resultado) {
			System.out.println(appointment.getDoctor()+ "  " +appointment.getState());
		}
		s.close();
	}
	
	/**
	 * Consultar los beneficiarios de un afiliado
	 */
	@Test
	public void testBeneficiarios() {
		Session s = sf.openSession();
		int parametro = 234;
		Query q = s.createQuery("FROM Afiliate where afiliate.id = 234");
		List<Afiliate> resultado = q.list();
		for (Afiliate afiliate : resultado) {
			System.out.println(afiliate.getName()+ "  " +afiliate.getId());
		}
		s.close();
	}
	
	/**
	 * Consultar la historia de un paciente/beneficiario
	 */
	@Test
	public void testHistoriaAfiliado() {
		Session s = sf.openSession();
		int parametro = 233;
		Query q = s.createQuery("select history from Afiliate where id = 123");
		Blob resultado= (Blob) q.uniqueResult();
		System.out.println("Es un blob");
		s.close();
	}
	
	/**
	 * Consultar las cuentas de cobro de servicios prestados a IPS.
	 */
	@Test
	public void testCobros() {
		Session s = sf.openSession();
		int parametro = 11111;
		Query q = s.createQuery("FROM Bill b where b.ips=11111");
		List<Bill> resultado = q.list();
		for (Bill bill : resultado) {
			System.out.println(bill.getAprobationCode()+ "  " + bill.getValue()+ "  " + bill.getId());
		}
		s.close();
	}
	
}
