package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.service.CountryService;
import com.example.demo.model.*;

@Controller
public class FatiController {
	
@Autowired	
CountryService name;

@RequestMapping	("/")
public String training(Model model) {
	return "training";
}
@RequestMapping	("/allC")	
public String countries2(Model model) {	
		List<Country> list = name.getCountriesList();
		model.addAttribute("names", list);
		return "select_Country";	
}
@RequestMapping	("/allcountries")
public String countries(Model model) {
	
	List<Country> list = name.getCountriesList();
	model.addAttribute("names", list);
	return "countries";	
}
@RequestMapping	("/delete/{country_Id}")
public String deleteCountry(@PathVariable(name="country_Id") Integer country_Id) {
	name.delete(country_Id);
	return "redirect:/allcountries";
}
@RequestMapping	("/edit/{country_Id}")
public ModelAndView showEditCountryPage(@PathVariable(name="country_Id") Integer country_Id) {
	ModelAndView derr = new ModelAndView("edit_country");
	Country ct= name.get(country_Id);
	derr.addObject("countries", ct);
	return derr;
			
}
@RequestMapping	(value="/save", method= RequestMethod.POST)
public String saveCountry(@ModelAttribute("countries") Country ct, BindingResult br, Model model ) {
	if(br.hasErrors()) {
		return "/";
	}
	else {
			name.saveCt(ct);
	     	return "redirect:/allcountries";
	}
}

@RequestMapping ("/addCountry") 
public String addCountry(Model model) {
	Country newCountry= new Country();
     model.addAttribute("countries", newCountry);
  return "add"; 
  }
@RequestMapping ("/countryInfo/{country_Name}") 
public String countryInfo(@PathVariable(name= "country_Name") String country_Name, Model model) {
	Country ct= name.getByName(country_Name);
	model.addAttribute("country", ct);
  return "countryInformation"; 
}
}
