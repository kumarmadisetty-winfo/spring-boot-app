package com.example.springbootdockercomposemysql.service;

import org.springframework.stereotype.Service;

import com.example.springbootdockercomposemysql.entity.Country;

@Service
public interface CountryService {
	Country getCountry(Long id);
}
