package com.example.springbootdockercomposemysql.service;

import java.util.Map;

import org.flowable.engine.runtime.ProcessInstance;

public interface WorkflowMgt {

	
	public ProcessInstance createProcess(String processKey,String businessKey,Map<String, Object> variables);
}
