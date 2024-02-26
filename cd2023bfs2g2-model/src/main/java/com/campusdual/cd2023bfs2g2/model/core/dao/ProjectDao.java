package com.campusdual.cd2023bfs2g2.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Lazy
@Repository(value = "ProjectDao")
@ConfigurationFile(
        configurationFile = "dao/ProjectDao.xml",
        configurationFilePlaceholder = "dao/placeholders.properties")
public class ProjectDao extends OntimizeJdbcDaoSupport {

        public static final String P_ID = "P_ID";
        public static final String P_NAME = "P_NAME";
        public static final String P_DESCRIPTION = "P_DESCRIPTION";
        public static final String USER_ = "USER_";
        public static final String P_TIME = "P_TIME";
        public static final String P_DATE = "P_DATE";
        public static final String P_FINISHED = "P_FINISHED";
        public static final String PROJECT_TOTAL_TIME = "PROJECT_TOTAL_TIME";
        public static final String PROJECT_TOTAL_TIME_DECIMAL = "PROJECT_TOTAL_TIME_DECIMAL";
        public static final String P_MAX_HOURS = "P_MAX_HOURS";
}
