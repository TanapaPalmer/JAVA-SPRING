package com.codingdojo.DojosAndNinjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class DojosModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Must not be blank")
	private String name;
	
//----------------------------------------------------------------------

    //ONE-TO-MANY: ONE DOJO CAN HAVE MANY NINJAS
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<NinjasModel> ninjas;
	
//----------------------------------------------------------------------

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

//----------------------------------------------------------------------
    
    public DojosModel() {
    }

    
    public DojosModel(String name, Date createdAt, Date updatedAt, List<NinjasModel> ninjas) {
    	this.name = name;
    	this.createdAt = createdAt;
    	this.updatedAt = updatedAt;
    	this.ninjas = ninjas;
    }
    
//----------------------------------------------------------------------
    
	//GETTERS & SETTERS
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<NinjasModel> getNinjas() {
		return ninjas;
	}


	public void setNinjas(List<NinjasModel> ninjas) {
		this.ninjas = ninjas;
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

//----------------------------------------------------------------------
		
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
		
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}
