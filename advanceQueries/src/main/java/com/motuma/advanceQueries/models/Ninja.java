package com.motuma.advanceQueries.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ninja {
	@Id
    @GeneratedValue
    private Long id;
 
    @Size(min = 2, max = 200)
    private String firstName;
    
    @Size(min = 2, max = 200)
    private String lastName;
    
    @NotNull(message="Rating must be present")
    private int age;
    
    @Column(updatable=false)
    private Date createdAt;
    
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    
    @JoinColumn(name="dojo_id")
    
    private Dojo dojo;
    
    public Ninja() {
        
    }
    
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
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


	public Dojo getDojo() {
		return dojo;
	}


	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}


	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	void updatedAt() {
		this.updatedAt = new Date();
	}
}

