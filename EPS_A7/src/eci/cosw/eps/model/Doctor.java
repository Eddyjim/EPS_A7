package eci.cosw.eps.model;
// Generated Feb 18, 2012 10:07:45 PM by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Doctor generated by hbm2java
 */
@Entity
@Table(name="DOCTORS"
)
public class Doctor  implements java.io.Serializable {

	private int id;
     private String name;
     private Set<Specialty> specialties = new HashSet<Specialty>(0);
     private Set<Schedule> schedules = new HashSet<Schedule>(0);

    public Doctor() {
    }

    public Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Doctor(int id, String name, Set<Specialty> specialties, Set<Appointment> appointments, Set<Schedule> schedules) {
       this.id = id;
       this.name = name;
       this.specialties = specialties;
       this.schedules = schedules;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="DOCTORS_has_SPECIALTIES", joinColumns = { 
        @JoinColumn(name="DOCTORS_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="SPECIALITIES_id", nullable=false, updatable=false) })
    public Set<Specialty> getSpecialties() {
        return this.specialties;
    }
    
    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="DOCTORS_has_SCHEDULES", joinColumns = { 
        @JoinColumn(name="DOCTORS_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="SCHEDULES_day", nullable=false, updatable=false),
        @JoinColumn(name="SCHEDULES_timeEND", nullable=false, updatable=false),
        @JoinColumn(name="SCHEDULES_timeSTART", nullable=false, updatable=false)})
    public Set<Schedule> getSchedules() {
        return this.schedules;
    }
    
    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }




}


