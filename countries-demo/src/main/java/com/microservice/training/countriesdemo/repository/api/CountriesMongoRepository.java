package com.microservice.training.countriesdemo.repository.api;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.training.countriesdemo.model.entity.CountryDocument;
import java.util.List;

@Repository
public interface CountriesMongoRepository extends CrudRepository<CountryDocument, String> {

	Optional<CountryDocument> findByName(String name);
  
  List<CountryDocument> findByContinent(String continent);
	
}
