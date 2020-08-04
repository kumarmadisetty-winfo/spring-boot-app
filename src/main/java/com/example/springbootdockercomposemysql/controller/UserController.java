package com.example.springbootdockercomposemysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdockercomposemysql.entity.Country;
import com.example.springbootdockercomposemysql.entity.User;
import com.example.springbootdockercomposemysql.repository.UserRepository;
import com.example.springbootdockercomposemysql.service.CountryService;
import com.example.springbootdockercomposemysql.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private CountryService countryService;

	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll() {
		List<User> listOfUsers = new ArrayList<>();
		// userService.startProcess();
		List<User> users = userRepository.findAllByOrderByIdAsc();

		listOfUsers = users.stream().map(e -> {
			Country country = countryService.getCountry(e.getCountry().getId());
			e.setCountry(country);
			return e;
		}).collect(Collectors.toList());

		// List<Resource<User>> resourceUser =
		// users.stream().map(ResourceUtilities::getUserResource).collect(Collectors.toList());
		return ResponseEntity.ok(listOfUsers);
	}

	@PutMapping("/users/{user_id}")
	public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject) {
		User user = userRepository.findById(userId).get();
		user.setName(userObject.getName());
		user.setCountry(userObject.getCountry());
		return userRepository.save(user);
	}

	@DeleteMapping("/users/{user_id}")
	public List<User> delete(@PathVariable("user_id") Long userId) {
		userRepository.deleteById(userId);
		return userRepository.findAll();
	}

	@GetMapping("/users/{user_id}")
	@ResponseBody
	public User findByUserId(@PathVariable("user_id") Long userId) {
		User user = userRepository.findById(userId).get();
		Country country = countryService.getCountry(user.getCountry().getId());
		user.setCountry(country);
		return user;
	}
}
