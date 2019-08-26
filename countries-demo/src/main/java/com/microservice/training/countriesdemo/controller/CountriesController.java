package com.microservice.training.countriesdemo.controller;

import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.model.entity.CountryDocument;
import com.microservice.training.countriesdemo.service.api.ICountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CountriesController {

  @Autowired
  ICountriesService countriesService;

  @GetMapping(path = "/api/countries/continent/name/{continentName}")
  public ResponseEntity<List<CountryDocument>> findCountryByContinent(@PathVariable String continentName) {
    return new ResponseEntity<List<CountryDocument>>(
        countriesService.findCountriesByContinentName(continentName), HttpStatus.OK);
  }
  
  @GetMapping(path = "/api/countries/continent/id/{continentId}")
  public ResponseEntity<List<Country>> findCountryByContinent(@PathVariable Integer continentId) {
    return new ResponseEntity<List<Country>>(
        countriesService.findCountriesByContinentId(continentId), HttpStatus.OK);
  }
  
  @PostMapping("/api/countries")
  public Object insertNewCountry(@RequestBody CountryDocument pais) {
    Object respuesta = null;
    boolean retorno = countriesService.insertCountry(pais);
    
    if (retorno) {
      respuesta = new ResponseEntity<String>("Country inserted", HttpStatus.CREATED);
    } else {
      respuesta = new ResponseEntity<String>("Ooops... something went wrong",
              HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return respuesta;
  }

}
