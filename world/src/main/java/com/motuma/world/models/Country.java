package com.motuma.world.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Country {
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private String name;
	private String continent;
	private String region;
	private Double surfaceArea;
	private Short indepYear;
	private Integer population;
	private Double lifeExpectancy;
	private Double gnp;
	private Double gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private Integer capital;
	private String code2;
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getContinent() {
		return continent;
	}



	public void setContinent(String continent) {
		this.continent = continent;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public Double getSurfaceArea() {
		return surfaceArea;
	}



	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}



	public Short getIndepYear() {
		return indepYear;
	}



	public void setIndepYear(Short indepYear) {
		this.indepYear = indepYear;
	}



	public Integer getPopulation() {
		return population;
	}



	public void setPopulation(Integer population) {
		this.population = population;
	}



	public Double getLifeExpectancy() {
		return lifeExpectancy;
	}



	public void setLifeExpectancy(Double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}



	public Double getGnp() {
		return gnp;
	}



	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}



	public Double getGnpOld() {
		return gnpOld;
	}



	public void setGnpOld(Double gnpOld) {
		this.gnpOld = gnpOld;
	}



	public String getLocalName() {
		return localName;
	}



	public void setLocalName(String localName) {
		this.localName = localName;
	}



	public String getGovernmentForm() {
		return governmentForm;
	}



	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}



	public String getHeadOfState() {
		return headOfState;
	}



	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}



	public Integer getCapital() {
		return capital;
	}



	public void setCapital(Integer capital) {
		this.capital = capital;
	}



	public String getCode2() {
		return code2;
	}



	public void setCode2(String code2) {
		this.code2 = code2;
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



	public List<City> getCities() {
		return cities;
	}



	public void setCities(List<City> cities) {
		this.cities = cities;
	}



	public List<Language> getLanguages() {
		return languages;
	}



	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	private Date createdAt;
	private Date updatedAt;
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<City> cities;
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<Language> languages;
	
	public Country() {

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
