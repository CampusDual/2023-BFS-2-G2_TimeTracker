package com.campusdual.cd2023bfs2g2.ws.core.rest;

import com.campusdual.cd2023bfs2g2.api.core.service.IProjectService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectRestController extends ORestController<IProjectService> {

    @Autowired
    private IProjectService projectService;
    @Override
    public IProjectService getService() {
        return this.projectService;
    }
}
