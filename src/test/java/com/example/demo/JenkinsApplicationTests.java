package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

	import java.util.List;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

	import com.example.demo.model.Country;
	import com.example.demo.repo.CountryRepo;
	import com.example.demo.service.CountryService;

	@SpringBootTest
	class JenkinsApplicationTests {
		
	@Autowired
	      CountryService cs;
	@Autowired
	   CountryRepo D;
	@Test
		void testCountryService() {
		List<Country> list = cs.getCountriesList();
			System.out.println(list);
		}
	@Test
	 void testRepo() {
	    D.save(new Country("Morocco","Rabat",	37037908L));
	    D.save(new Country("USA","Washington D.C",	332278200L));
	    D.save(new Country("Germany","Berlin",	83149300L));
	    D.save(new Country("China","Beijing",	1442965000L));
	    D.save(new Country("Spain","Madrid",	47431256L));
	    D.save(new Country("Canada","Ottawa",	37894799L));
	    D.save(new Country("India","New Delhi",	1326093247L));
	    D.save(new Country("Russia","Moscow",	145975300L));
	    D.save(new Country("Turkey","Ankara",	83614362L));
	    D.save(new Country("Japan","Tokyo",	125961625L));
	}
	/*
	 * @Test void getByName() { System.out.println(cs.getByName("USA")); }
	 */
	}
