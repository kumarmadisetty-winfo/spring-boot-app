package com.example.springbootdockercomposemysql.service.impl;

import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootdockercomposemysql.service.WorkflowMgt;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class WorkflowMgtimpl implements WorkflowMgt {

	private RuntimeService runtimeService;
	private TaskService taskService;
	
	@Autowired
	public WorkflowMgtimpl(RuntimeService runtimeService,TaskService taskService) {
		this.runtimeService = runtimeService;
		this.taskService = taskService;
	}
	
	@Override
	public ProcessInstance createProcess(String processKey, String businessKey, Map<String, Object> variables) {
		log.info("Resuming Process Instance via message {} and business key {} variables {}", processKey, businessKey,variables);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
		log.info("Number of tasks after process start: "
                + taskService.createTaskQuery().taskAssignee(businessKey).list().size());
		return processInstance;
	}
}
