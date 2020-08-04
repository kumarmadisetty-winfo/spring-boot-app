package com.example.springbootdockercomposemysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootdockercomposemysql.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findAllByOrderByIdAsc();
}
