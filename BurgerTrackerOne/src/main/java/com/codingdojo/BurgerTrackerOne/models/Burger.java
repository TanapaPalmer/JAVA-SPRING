package com.codingdojo.BurgerTrackerOne.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burger")
public class Burger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Must not be blank.")
	@Size(min = 3, max = 100, message="Burger Name must be at least 3 characters.")
	private String burger_name;
	@NotNull(message="Must not be blank.")
	@Size(min = 3, max = 100, message="Restaurant Name must be at least 3 characters.")
	private String restaurant_name;
	@NotNull(message="Must not be blank.")
	@Min(value=1, message="Rating should be greater than 0.")
	@Max(value=5, message="Rating should be less than 5.")
	private Integer rating;
	@NotNull(message="Must not be blank.")
	@Size(min = 5, max = 200, message="Notes must be at least 5 characters.")
	private String notes;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    public Burger() {
    }
    
    
    public Burger(String burger_name, String restaurant_name, Integer rating, String notes) {
    	this.burger_name = burger_name;
    	this.restaurant_name = restaurant_name;
    	this.rating = rating;
    	this.notes = notes;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    //GETTER & SETTER
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBurger_name() {
		return burger_name;
	}


	public void setBurger_name(String burger_name) {
		this.burger_name = burger_name;
	}


	public String getRestaurant_name() {
		return restaurant_name;
	}


	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
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
    

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
}
