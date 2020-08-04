package com.example.springbootdockercomposemysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootdockercomposemysql.entity.Country;
import com.example.springbootdockercomposemysql.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {
	public List<State> findAllByOrderByIdAsc();
	public List<State> findByCountry(Country country);
}
