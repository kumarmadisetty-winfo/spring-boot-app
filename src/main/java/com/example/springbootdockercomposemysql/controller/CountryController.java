package com.example.springbootdockercomposemysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdockercomposemysql.entity.Country;
import com.example.springbootdockercomposemysql.repository.CountryRepository;
import com.example.springbootdockercomposemysql.service.CountryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="*", allowedHeaders="*")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;
    
    @Autowired
    private CountryService countryService;


    @PostMapping("/countries")
    public Country create(@RequestBody Country country)
    {
        return countryRepository.save(country);
    }
    
    @GetMapping("/countries")
    public List<Country> findAll()
    {
        return countryRepository.findAll();
    }

    @PutMapping("/countries/{country_id}")
    public Country update(@PathVariable("country_id") Long countryId, @RequestBody Country countryObject)
    {
        Country country = countryRepository.findById(countryId).get();
        country.setName(countryObject.getName());
        return countryRepository.save(country);
    }

    @DeleteMapping("/countries/{country_id}")
    public List<Country> delete(@PathVariable("country_id") Long countryId)
    {
        countryRepository.deleteById(countryId);
        return countryRepository.findAll();
    }

    @GetMapping("/countries/{country_id}")
    @ResponseBody
    public Country findByCountryId(@PathVariable("user_id") Long countryId)
    {
        return countryService.getCountry(countryId);
    }
}
