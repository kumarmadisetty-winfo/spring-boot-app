package com.example.springbootdockercomposemysql.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootdockercomposemysql.service.UserService;
import com.example.springbootdockercomposemysql.service.WorkflowMgt;

import lombok.extern.slf4j.Slf4j;

@Service(value = "userService")
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
	
	public UserServiceImpl(WorkflowMgt workflowMgt) {
		super();
		this.workflowMgt = workflowMgt;
	}

	private WorkflowMgt workflowMgt;
	
	
	
	@Override
	public void getExecutionService(int complete) {
		log.info("complete =="+complete);
	}

	@Override
	public void startProcess() {
		// TODO Auto-generated method stub
		log.info("process started...");
		Map<String, Object> variables= new HashMap<>();
		variables.put("userId", "4");
		workflowMgt.createProcess("myprocess", variables.get("userId").toString(), variables);
	}

}
