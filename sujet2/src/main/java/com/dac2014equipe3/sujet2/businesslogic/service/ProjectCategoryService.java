package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.DAOFactory;
import com.dac2014equipe3.sujet2.model.entity.ProjectCategory;
import com.dac2014equipe3.sujet2.vo.ProjectCategoryVo;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 30/12/14.
 */
public class ProjectCategoryService implements IService<ProjectCategoryVo> {

    private static ProjectCategoryService instance;

    public static synchronized ProjectCategoryService getInstance() {

        if (instance == null) {
            instance = new ProjectCategoryService();
        }
        return instance;
    }

    @Override
    public void persist(ProjectCategoryVo projectCategoryVo, EntityManager em) {

    }

    @Override
    public ProjectCategoryVo find(Object id, EntityManager em) {
        return null;
    }

    @Override
    public void update(ProjectCategoryVo projectCategoryVo, EntityManager em) {

    }

    @Override
    public void delete(Object id, EntityManager em) {

    }

    @Override
    public List<ProjectCategoryVo> getList(EntityManager em) {
        List<ProjectCategoryVo> list = new ArrayList<ProjectCategoryVo>();
        for(ProjectCategory projectCategory : DAOFactory.getInstance().getProjectCategoryDAO().getList(em)){
            list.add(projectCategory.toVo());
        }
        return list;
    }
}
