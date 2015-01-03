package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by lepeteil on 19/12/14.
 */
public class ProjectDAO implements IDAO<Project>  {
    private static ProjectDAO instance;

    public static synchronized ProjectDAO getInstance() {
        if (instance == null) {
            instance = new ProjectDAO();
        }
        return instance;
    }

    @Override
    public void persist(Project entity, EntityManager em) {
        em.persist(entity);
    }

    @Override
    public Project find(Object id, EntityManager em) {
        Integer idA = (Integer) id;
        Query query = em.createNamedQuery("Project.findByProjectId")
                .setParameter("projectId", idA);
        return (Project) query.getSingleResult();
    }

    @Override
    public void update(Project entity, EntityManager em) {
        em.merge(entity);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        Project project = find(id,em);
        em.remove(project);
    }

    @Override
    public List<Project> getList(EntityManager em) {
        Query query = em.createNamedQuery("Project.findAll");
        List<Project> listProjects = query.getResultList();
        return listProjects;
    }

    public List<Project> getProjectsNotDeleted(EntityManager em){
        Query query = em.createNamedQuery("Project.findByProjectIsSuppressed");
        query.setParameter("projectIsSuppressed",false);
        List<Project> listProjects = query.getResultList();
        return listProjects;
    }

}
