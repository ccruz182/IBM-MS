package com.microservice.training.countriesdemo.service.api;

import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.entity.CountryDocument;
import java.util.List;

public interface ICountriesService {

  List<CountryDocument> findCountriesByContinentName(String continentName);
  
  List<Country> findCountriesByContinentId(Integer continentId);
  
  boolean insertCountry(CountryDocument newCountry);
  
}
