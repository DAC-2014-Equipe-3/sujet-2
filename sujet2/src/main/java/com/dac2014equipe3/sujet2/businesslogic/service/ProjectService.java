package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.DAOFactory;
import com.dac2014equipe3.sujet2.model.dao.ProjectDAO;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Created by lepeteil on 19/12/14.
 */
public class ProjectService implements IService<ProjectVo>{

    private static ProjectService instance;

    public static synchronized ProjectService getInstance() {
        if (instance == null) {
            instance = new ProjectService();
        }
        return instance;
    }

    @Override
    public void persist(ProjectVo projectVo, EntityManager em) {
        Project entity = new Project();

        //TODO manquant
        /*entity.setMediaList();
        entity.setMemberList();
        entity.setMemberbacksProjectList();
        entity.setProjectCategory();
        entity.setProjectCreationDate();
        entity.setProjectDescription();
        entity.setProjectEndDate();
        entity.setProjectFundingGoal();
        entity.setProjectId();
        entity.setProjectIsSuppressed();
        entity.setProjectTitle();
        entity.setReward();*/

        DAOFactory.getInstance().getProjectDAO().persist(entity, em);

    }

    @Override
    public ProjectVo find(Object id, EntityManager em) {
        ProjectDAO dao = DAOFactory.getInstance().getProjectDAO();
        ProjectVo projectVo = dao.find(id, em).toVo();
        return projectVo;
    }

    @Override
    public void update(ProjectVo projectVo, EntityManager em) {
        Project entity = new Project();
        ProjectDAO dao = DAOFactory.getInstance().getProjectDAO();

        //TODO manquant
        /*entity.setMediaList();
        entity.setMemberList();
        entity.setMemberbacksProjectList();
        entity.setProjectCategory();
        entity.setProjectCreationDate();
        entity.setProjectDescription();
        entity.setProjectEndDate();
        entity.setProjectFundingGoal();
        entity.setProjectId();
        entity.setProjectIsSuppressed();
        entity.setProjectTitle();
        entity.setReward();*/

        dao.update(entity, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        ProjectDAO dao = DAOFactory.getInstance().getProjectDAO();
        dao.delete(id,em);
    }

    @Override
    public List<ProjectVo> getList(EntityManager em) {
        List<ProjectVo> list = new ArrayList<ProjectVo>();
        for (Project project : DAOFactory.getInstance().getProjectDAO().getList(em)) {
            list.add((project).toVo());
        }
        return list;
    }
}
