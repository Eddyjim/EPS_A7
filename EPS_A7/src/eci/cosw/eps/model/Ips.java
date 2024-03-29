package eci.cosw.eps.model;
// Generated Feb 18, 2012 10:07:45 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Ips generated by hbm2java
 */
@Entity
@Table(name="IPS"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Ips  implements java.io.Serializable {

	private int id;
     private String name;

    public Ips() {
    }

	
    public Ips(int id, String name) {
        this.id = id;
        this.name = name;
    }

   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", unique=true, nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}


