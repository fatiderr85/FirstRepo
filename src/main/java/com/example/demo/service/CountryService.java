package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.*;
import com.example.demo.repo.CountryRepo;
@Service
public class CountryService {

@Autowired
CountryRepo countryRepo;
 
 public List<Country> getCountriesList(){
	
	return countryRepo.findAll();
}
 public void delete(Integer country_Id) {
	 countryRepo.deleteById(country_Id);
 }
 public Country get(Integer country_Id) {
	 return countryRepo.findById(country_Id).get();
 }
public void saveCt(Country A) { 
	countryRepo.save(A); 
	}
public void add(Integer country_Id, String country_Name, String capital, Long population) {
	
	 countryRepo.add(country_Id, country_Name, capital, population);
	
}
public Country getByName(String country_Name) {
   
	return countryRepo.findByName(country_Name);
	
}	
}
