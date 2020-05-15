package com.example.activitidemo.controller;

import com.example.activitidemo.service.ActivitiConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/activiti")
public class ActivitiController {
    @Resource
    private ActivitiConsumerService activitiConsumerService;

    /**
     * 部署流程
     * http://127.0.0.1:8088/activiti/createDeployment?resource=test01.bpmn
     * @return
     */
    @GetMapping("/createDeployment")
    public Boolean createDeployment(String resource){
        System.out.println("resource:"+resource);
        return activitiConsumerService.createDeployment(resource);//"test01.bpmn"
    }

    /**
     * 发起流程(启动流程) 如果没有部署，则会报异常
     * http://127.0.0.1:8088/activiti/startActivityDemo?key=myProcess_1
     * @return
     */
    @GetMapping("/startActivityDemo")
    public Boolean startActivityDemo(String key){
        System.out.println("key:"+key);
        return activitiConsumerService.startActivityDemo(key);//"myProcess_1"
    }

    /**
     * 查询所有已部署的流程
     * http://127.0.0.1:8088/activiti/queryProcdef
     * @return
     */
    @RequestMapping("/queryProcdef")
    public Boolean queryProcdef(){
        return activitiConsumerService.queryProcdef();
    }


    /**
     * 获取待办，根据用户获取该用户的代办任务
     * http://127.0.0.1:8088/activiti/getTaskList?assignee=user1
     * @return
     */
    @GetMapping("/getTaskList")
    public boolean getTaskList(String assignee){
        System.out.println(assignee);
        return activitiConsumerService.getTaskList(assignee);
    }

    /**
     * 提交，流程图中有判断条件，添加判断参数
     * http://127.0.0.1:8088/activiti/complete?taskId=51c98606-9690-11ea-8e3d-90784129e942&message=Y
     * @param taskId
     * @return
     */
    @GetMapping("/complete")
    public boolean complete(String taskId,String message){
        System.out.println("taskId:"+taskId+",message:"+message);
        return activitiConsumerService.complete(taskId,message);
    }

    /**
     * 根据流程id直接结束流程
     * http://127.0.0.1:8088/activiti/deleteProcessInstance?runId=myProcess_1
     * @paramru
     * @return
     */
    @GetMapping("/deleteProcessInstance")
    public boolean deleteProcessInstance(String runId){
        System.out.println("runId:"+runId);
        return activitiConsumerService.deleteProcessInstance(runId);
    }

}
