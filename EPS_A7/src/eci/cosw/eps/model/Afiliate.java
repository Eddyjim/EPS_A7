package eci.cosw.eps.model;
// Generated Feb 18, 2012 10:07:45 PM by Hibernate Tools 3.4.0.CR1


import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Afiliate generated by hbm2java
 */
@Entity
@Table(name="AFILIATES"
)
public class Afiliate  implements Serializable {

	
	private int id;
     private Afiliate afiliate;
     private String name;
     private byte active;
     private Blob history;
     private Set<Afiliate> beneficiaries = new HashSet<Afiliate>(0);

    public Afiliate() {
    }

	
    public Afiliate(int id, String name, byte active, Blob history) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.history = history;
    }
    public Afiliate(int id, Afiliate afiliate, String name, byte active, Blob history, Set<Afiliate> benef) {
       this.id = id;
       //this.afiliate = afiliate;
       this.name = name;
       this.active = active;
       this.history = history;
       this.beneficiaries = benef;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="affiliate_id")
    public Afiliate getAfiliate() {
        return this.afiliate;
    }
    
    public void setAfiliate(Afiliate afiliate) {
        this.afiliate = afiliate;
    }
    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="active", nullable=false)
    public byte getActive() {
        return this.active;
    }
    
    public void setActive(byte active) {
        this.active = active;
    }

    
    @Column(name="history", nullable=false)
    public Blob getHistory() {
        return this.history;
    }
    
    public void setHistory(Blob history) {
        this.history = history;
    }

@OneToMany(fetch=FetchType.LAZY)
    public Set<Afiliate> getBeneficiaries() {
        return this.beneficiaries;
    }
    
    public void setBeneficiaries(Set<Afiliate> afiliateses) {
        this.beneficiaries = afiliateses;
    }
    
    @Override
    public boolean equals(Object obj) {
    	boolean b = false;
    	if(obj instanceof Afiliate){
    		b = this.id == ((Afiliate)obj).getId();
    	}
    	return b;
    }
    
    @Override
	public String toString() {
		return "Appointment [id=" + id + ", afiliate=" + afiliate  + "]";
	}
    
}