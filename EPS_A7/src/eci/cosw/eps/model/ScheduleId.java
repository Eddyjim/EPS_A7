package eci.cosw.eps.model;
// Generated Feb 18, 2012 10:07:45 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ScheduleId generated by hbm2java
 */
@Embeddable
public class ScheduleId  implements java.io.Serializable {

	private int day;
     private String timeStart;
     private String timeEnd;

    public ScheduleId() {
    }

    public ScheduleId(int day, String timeStart, String timeEnd) {
       this.day = day;
       this.timeStart = timeStart;
       this.timeEnd = timeEnd;
    }
   


    @Column(name="day", nullable=false)
    public int getDay() {
        return this.day;
    }
    
    public void setDay(int day) {
        this.day = day;
    }


    @Column(name="timeSTART", nullable=false, length=15)
    public String getTimeStart() {
        return this.timeStart;
    }
    
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }


    @Column(name="timeEND", nullable=false, length=15)
    public String getTimeEnd() {
        return this.timeEnd;
    }
    
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ScheduleId) ) return false;
		 ScheduleId castOther = ( ScheduleId ) other; 
         
		 return (this.getDay()==castOther.getDay())
 && ( (this.getTimeStart()==castOther.getTimeStart()) || ( this.getTimeStart()!=null && castOther.getTimeStart()!=null && this.getTimeStart().equals(castOther.getTimeStart()) ) )
 && ( (this.getTimeEnd()==castOther.getTimeEnd()) || ( this.getTimeEnd()!=null && castOther.getTimeEnd()!=null && this.getTimeEnd().equals(castOther.getTimeEnd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getDay();
         result = 37 * result + ( getTimeStart() == null ? 0 : this.getTimeStart().hashCode() );
         result = 37 * result + ( getTimeEnd() == null ? 0 : this.getTimeEnd().hashCode() );
         return result;
   }   


}


