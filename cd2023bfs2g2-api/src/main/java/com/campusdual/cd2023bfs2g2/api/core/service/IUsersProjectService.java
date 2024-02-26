package com.campusdual.cd2023bfs2g2.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;

import java.util.List;
import java.util.Map;

public interface IUsersProjectService {
    public EntityResult usersProjectQuery(Map<?, ?> keyMap, List<?> attrList);
    public EntityResult usersProjectInsert(Map<?, ?> attrMap);
    public EntityResult usersProjectUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap);
    public EntityResult usersProjectDelete(Map<?, ?> keyMap);
    public EntityResult usersProjectsNamesQuery(Map<?, ?> keyMap, List<?> attrList);
    public EntityResult usersProjectsNamesDelete(Map<?, ?> keyMap);
    public EntityResult usersProjectTimeTableQuery(Map<?, ?> keyMap, List<?> attrList);
    public EntityResult usersProjectTimeGraphQuery(Map<String, Object> keyMap, List<String> attrList);
}
