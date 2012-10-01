package eci.cosw.eps.model;
// Generated Feb 18, 2012 10:07:45 PM by Hibernate Tools 3.4.0.CR1


import java.awt.Point;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Schedule generated by hbm2java
 */
@Entity
@Table(name="SCHEDULES"
)
public class Schedule  implements java.io.Serializable {


	private ScheduleId id;

    public Schedule() {
    }

	
    public Schedule(ScheduleId id) {
        this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="day", column=@Column(name="day", nullable=false) ), 
        @AttributeOverride(name="timeStart", column=@Column(name="timeSTART", nullable=false, length=15) ), 
        @AttributeOverride(name="timeEnd", column=@Column(name="timeEND", nullable=false, length=15) ) } )
    public ScheduleId getId() {
        return this.id;
    }
    
    public void setId(ScheduleId id) {
        this.id = id;
    }

    public Point timeStart(){
    	return new Point(Integer.parseInt(id.getTimeStart().split(":")[0]), 
    					Integer.parseInt(id.getTimeStart().split(":")[1]));
    }

    public Point timeEnd(){
    	return new Point(Integer.parseInt(id.getTimeEnd().split(":")[0]), 
				Integer.parseInt(id.getTimeEnd().split(":")[1]));
    }

}


