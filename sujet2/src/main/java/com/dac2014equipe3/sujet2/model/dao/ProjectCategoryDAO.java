package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.ProjectCategory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 * Created by chambon on 20/12/14.
 */
public class ProjectCategoryDAO implements IDAO<ProjectCategory> {

    private static ProjectCategoryDAO instance;

    public static synchronized ProjectCategoryDAO getInstance() {
        if (instance == null) {
            instance = new ProjectCategoryDAO();
        }
        return instance;
    }

    @Override
    public void persist(ProjectCategory entity, EntityManager em)   {
        em.persist(entity);
    }

    @Override
    public ProjectCategory find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        Query query = em.createNamedQuery("ProjectCategory.findByCategoryId")
                .setParameter("categoryId", id);
        return (ProjectCategory) query.getSingleResult();
    }

    @Override
    public void update(ProjectCategory entity, EntityManager em)   {
        em.merge(entity);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        ProjectCategory category = find(id, em);
        em.remove(category);
    }

    @Override
    public List<ProjectCategory> getList(EntityManager em) {
        Query query = em.createNamedQuery("ProjectCategory.findAll");
        List<ProjectCategory> listCategory = query.getResultList();
        return listCategory;
    }
}
