package com.example.springbootdockercomposemysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootdockercomposemysql.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>
{

}
