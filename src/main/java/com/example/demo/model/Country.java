package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")
public class Country {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)    
	@Column(unique=true)
	Integer country_Id;
	Long population;	
	String country_Name;
	String capital;

	public Country() {
		
	}
	public Country(String country_Name, String capital, Long population) {
		this.country_Name= country_Name;
		this.capital= capital;
		this.population= population;
	}
	public Integer getCountry_Id() {
		return country_Id;
	}
	public void setCountry_Id(Integer country_Id) {
		this.country_Id = country_Id;
	}
	public String getCountry_Name() {
		return country_Name;
	}
	public void setCountry_Name(String country_Name) {
		this.country_Name = country_Name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "Country [country_Id=" + country_Id + ", population=" + population + ", country_Name=" + country_Name
				+ ", capital=" + capital + "]";
	}

}
