package com.codingdojo.DojosAndNinjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class NinjasModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Must not be blank")
	@Size(min = 3, max = 100, message = "First name must be at least 3 characters")
	private String firstName;
	
	@NotNull(message="Must not be blank")
	@Size(min = 3, max = 100, message = "Last name must be at least 3 characters")
	private String lastName;
	
	@NotNull(message="Must not be blank")
	@Min(value=18, message="You must be 18 years old or over")
	private Integer age;
	
//----------------------------------------------------------------------
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
 //----------------------------------------------------------------------

	//MANY-TO-ONE RELATIONSHIP: MANY NINJAS CAN ONLY STUDY AT ONE DOJO SCHOOL
	@ManyToOne(fetch = FetchType.LAZY)
	
	//JOIN-COLUMN: JOING 2 TABLES TOGETHER WITH dojo_id WHICH IS A FOREIGN KEY
	@JoinColumn(name="dojo_id")
	
	private DojosModel dojo;
		
//----------------------------------------------------------------------
	
	public NinjasModel() {
	}
	
	
	
	public NinjasModel(Long id, String firstName, String lastName, int age, Date createdAt, Date updatedAt, DojosModel dojo) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.dojo = dojo;
	}

	
//----------------------------------------------------------------------
		
	//GETTERS & SETTERS
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public DojosModel getDojo() {
		return dojo;
	}



	public void setDojo(DojosModel dojo) {
		this.dojo = dojo;
	}

//----------------------------------------------------------------------
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
