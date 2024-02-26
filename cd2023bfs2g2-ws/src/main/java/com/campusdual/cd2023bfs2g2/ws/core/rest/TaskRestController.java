package com.campusdual.cd2023bfs2g2.ws.core.rest;

import com.campusdual.cd2023bfs2g2.api.core.service.ITaskService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskRestController extends ORestController<ITaskService> {

  @Autowired
  private ITaskService taskService;


    @Override
    public ITaskService getService() {
        return this.taskService;
    }
}
