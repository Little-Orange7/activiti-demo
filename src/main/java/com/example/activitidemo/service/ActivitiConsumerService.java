package com.example.activitidemo.service;

public interface ActivitiConsumerService {
    boolean createDeployment(String resource);
    boolean queryProcdef();
    boolean startActivityDemo(String key);
    boolean getTaskList(String assignee);
    boolean  complete(String taskId,String message);
    boolean  deleteProcessInstance(String runId);
}
