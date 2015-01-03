package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.MemberbacksProject;
import com.dac2014equipe3.sujet2.model.entity.MemberbacksProjectPK;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProject;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by chambon on 19/12/14.
 */
public class MemberbacksProjectDAO implements IDAO<MemberbacksProject> {

    private static MemberbacksProjectDAO instance;

    public static synchronized MemberbacksProjectDAO getInstance() {
        if (instance == null) {
            instance = new MemberbacksProjectDAO();
        }
        return instance;
    }

    @Override
    public void persist(MemberbacksProject entity, EntityManager em)  {
        em.persist(entity);
    }

    @Override
    public MemberbacksProject find(Object idA, EntityManager em) {
        MemberbacksProjectPK id = ((MemberbacksProject)idA).getMemberbacksProjectPK();
        Query query = em.createNamedQuery("MemberbacksProject.findByMemberbacksProjectPK")
                .setParameter("backerId", id.getBackerId())
                .setParameter("projectId", id.getProjectId());
        return (MemberbacksProject) query.getSingleResult();
    }

    @Override
    public void update(MemberbacksProject entity, EntityManager em)  { em.merge(entity); }

    @Override
    public void delete(Object id, EntityManager em) {
        MemberbacksProject mbp = find(id, em);
        em.remove(mbp);
    }

    @Override
    public List<MemberbacksProject> getList(EntityManager em) {
        Query query = em.createNamedQuery("MemberbacksProject.findAll");
        List<MemberbacksProject> listMbP = query.getResultList();
        return listMbP;
    }

    public List<MemberbacksProject> getListForProject(Object idProject, EntityManager em) {
        Integer id = (Integer) idProject;
        Query query = em.createNamedQuery("MemberbacksProject.findByProjectId")
                .setParameter("projectId", id);
        List<MemberbacksProject> listMbP = query.getResultList();
        return listMbP;
    }
}
