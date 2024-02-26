package com.campusdual.cd2023bfs2g2.model.core.service;

import com.campusdual.cd2023bfs2g2.api.core.service.IUsersProjectService;
import com.campusdual.cd2023bfs2g2.model.core.dao.UsersProjectDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.postgresql.util.PGInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Lazy
@Service("UsersProjectService")
public class UsersProjectService implements IUsersProjectService {
    @Autowired
    private UsersProjectDao usersProjectDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;


    @Override
    public EntityResult usersProjectQuery(Map<?, ?> keyMap, List<?> attrList) {
        return this.daoHelper.query(this.usersProjectDao, keyMap, attrList);
    }

    @Override
    public EntityResult usersProjectInsert(Map<?, ?> attrMap) {
        EntityResult res;
        try {
            res = this.daoHelper.insert(this.usersProjectDao, attrMap);
        } catch (DuplicateKeyException ex) {
            ex.printStackTrace();
            res = new EntityResultMapImpl();
            res.setCode(EntityResult.OPERATION_WRONG);
            res.setMessage("ERROR_USER_INSERT_MSG");
        }
        return res;
    }

    @Override
    public EntityResult usersProjectUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap) {
        return this.daoHelper.update(this.usersProjectDao, attrMap, keyMap);
    }

    @Override
    public EntityResult usersProjectDelete(Map<?, ?> keyMap) {
        return this.daoHelper.delete(this.usersProjectDao, keyMap);
    }

    @Override
    public EntityResult usersProjectsNamesQuery(Map<?, ?> keyMap, List<?> attrList) {
        return this.daoHelper.query(this.usersProjectDao, keyMap, attrList, "usersProjectsNames");
    }

    @Override
    public EntityResult usersProjectsNamesDelete(Map<?, ?> keyMap) {
        return this.daoHelper.delete(this.usersProjectDao, keyMap);
    }

    @Override
    public EntityResult usersProjectTimeTableQuery(Map<?, ?> keyMap, List<?> attrList) {
        List<Long> minuteTimes = new ArrayList<>();
        EntityResult res= this.daoHelper.query(this.usersProjectDao, keyMap, attrList,"usersProjectTime");
        if (res.containsKey(usersProjectDao.USER_PROJECT_TIME)) {
            for (int i = 0; i < res.calculateRecordNumber(); i++) {
                Map<String, Object> recValues = res.getRecordValues(i);
                if (recValues.containsKey(usersProjectDao.USER_PROJECT_TIME)) {
                    PGInterval value = (PGInterval) recValues.get(usersProjectDao.USER_PROJECT_TIME);
                    minuteTimes.add(TaskService.intervalToMinutes(value));
                } else {
                    minuteTimes.add(0L);
                }
            }
            res.put(usersProjectDao.USER_PROJECT_TIME, minuteTimes);
        }
        return res;
    }

    @Override
    public EntityResult usersProjectTimeGraphQuery(Map<String, Object> keyMap, List<String> attrList) {
        List<Long> minuteTimes = new ArrayList<>();
        EntityResult res= this.daoHelper.query(this.usersProjectDao, keyMap, attrList,"usersProjectTime");
        if (res.containsKey(usersProjectDao.USER_PROJECT_TIME)) {
            for (int i = 0; i < res.calculateRecordNumber(); i++) {
                Map<String, Object> recValues = res.getRecordValues(i);
                if (recValues.containsKey(usersProjectDao.USER_PROJECT_TIME)) {
                    PGInterval value = (PGInterval) recValues.get(usersProjectDao.USER_PROJECT_TIME);
                    minuteTimes.add(TaskService.intervalToMinutes(value));
                }else{
                    minuteTimes.add(0L);
                }
            }
            res.put(usersProjectDao.USER_PROJECT_TIME, minuteTimes);
        }
        return res;
    }
}
