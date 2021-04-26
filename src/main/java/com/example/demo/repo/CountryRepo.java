package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
	
@Transactional
@Modifying
@Query(nativeQuery= true, value="insert into countries(country_Id, country_Name,capital,population) values (:country_Id,:country_Name,:capital,:population)")
	public Object add(@Param("country_Id") Integer country_Id,@Param("country_Name") String country_Name,@Param("capital") String capital,@Param("population") Long population);

 @Query(nativeQuery= true, value="select * from countries where country_name= ?1")
  	public Country findByName(String country_Name);
   
}
