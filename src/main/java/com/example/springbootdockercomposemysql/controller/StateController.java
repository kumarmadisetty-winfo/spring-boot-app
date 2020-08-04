package com.example.springbootdockercomposemysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdockercomposemysql.entity.Country;
import com.example.springbootdockercomposemysql.entity.State;
import com.example.springbootdockercomposemysql.repository.StateRepository;
import com.example.springbootdockercomposemysql.service.CountryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="*", allowedHeaders="*")
public class StateController {

    @Autowired
    private StateRepository stateRepository;
    
   
    
    @Autowired
	private CountryService countryService;

    @PostMapping("/states")
    public State create(@RequestBody State state)
    {
        return stateRepository.save(state);
    }
    
    @RequestMapping(value = "/states", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<State>> findAll(@RequestParam(value = "countryId", required=false) String countryId)
    {
    	List<State> listOfStates = new ArrayList<>();
    	List<State> states = null;
    	if(StringUtils.isNoneBlank(countryId)) {
    		Country country = new Country(Long.valueOf(countryId));
    		states = stateRepository.findByCountry(country);
    	}else {
    		states = stateRepository.findAllByOrderByIdAsc();
    	}
    	   	
		listOfStates = states.stream().map(e -> {
			Country country = countryService.getCountry(e.getCountry().getId());
			e.setCountry(country);
			return e;
		}).collect(Collectors.toList());

		return ResponseEntity.ok(listOfStates);
    	
    }

    @PutMapping("/states/{state_id}")
    public State update(@PathVariable("state_id") Long stateId, @RequestBody State stateObject)
    {
        State state = stateRepository.findById(stateId).get();
        state.setName(stateObject.getName());
        state.setCountry(stateObject.getCountry());
        return stateRepository.save(state);
    }

    @DeleteMapping("/states/{state_id}")
    public List<State> delete(@PathVariable("state_id") Long stateId)
    {
        stateRepository.deleteById(stateId);
        return stateRepository.findAll();
    }

    @GetMapping("/states/{state_id}")
    @ResponseBody
    public State findByStateId(@PathVariable("user_id") Long stateId)
    {
        return stateRepository.findById(stateId).get();
    }
}
