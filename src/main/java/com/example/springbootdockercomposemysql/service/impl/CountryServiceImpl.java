package com.example.springbootdockercomposemysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootdockercomposemysql.entity.Country;
import com.example.springbootdockercomposemysql.repository.CountryRepository;
import com.example.springbootdockercomposemysql.service.CountryService;

@Component
@Transactional
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country getCountry(Long id) {
		// TODO Auto-generated method stub
		return countryRepository.findById(id).get();
	}

}
