package eci.cosw.eps.model;
// Generated Feb 18, 2012 10:07:45 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Appointment generated by hbm2java
 */
@Entity
@Table(name="APPOINTMENTS")
public class Appointment  implements java.io.Serializable {

	public static final int DURATION = 30*60*1000;
	
	private static final long serialVersionUID = 2083949385157735661L;
	
	/*
	 * Posibles estados de una cita.
	 *
	public final static int INCUMPLIDA = 0;
	public final static int REALIZADA = 1;
	public final static int PROGRAMADA = 2;
	public final static int CANCELADA = 3;
	public final static int LIBRE = 4;
	*/
	
	private AppointmentId id;
     private Afiliate afiliate;
     private Doctor doctor;
     private String state;

    public Appointment() {
    }

    public Appointment(AppointmentId id, Afiliate afiliate, Doctor doctor, String state) {
       this.id = id;
       this.afiliate = afiliate;
       this.doctor = doctor;
       this.state = state; 
       /*switch (state) {
			case INCUMPLIDA:
				this.state = "INCUMPLIDA";
			break;
			case REALIZADA:
				this.state = "REALIZADA";
			break;
			case PROGRAMADA:
				this.state = "PROGRAMADA";
			break;
			case CANCELADA:
				this.state = "CANCELADA";
			break;
			case LIBRE:
				this.state = "LIBRE";
			break;
			*/
       
    }
   
     @EmbeddedId
    @AttributeOverrides( {
        @AttributeOverride(name="date", column=@Column(name="date", nullable=false, length=19) ), 
        @AttributeOverride(name="afiliateId", column=@Column(name="afiliate_id", nullable=false) ) } )
    public AppointmentId getId() {
        return this.id;
    }
    
    public void setId(AppointmentId id) {
        this.id = id;
    }
    
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="afiliate_id", nullable=false, insertable=false, updatable=false)
    public Afiliate getAfiliate() {
        return this.afiliate;
    }
    
    public void setAfiliate(Afiliate afiliate) {
        this.afiliate = afiliate;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="doctor_id", nullable=false)
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    
    @Column(name="state", nullable=false, length=45)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
    	this.state = state;
    	/*
    	switch (state) {
		case INCUMPLIDA:
			this.state = "INCUMPLIDA";
		break;
		case REALIZADA:
			this.state = "REALIZADA";
		break;
		case PROGRAMADA:
			this.state = "PROGRAMADA";
		break;
		case CANCELADA:
			this.state = "CANCELADA";
		break;
		case LIBRE:
			this.state = "LIBRE";
		break;
		}
		*/
   }
}


