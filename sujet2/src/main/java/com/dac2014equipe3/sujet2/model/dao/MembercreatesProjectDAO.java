package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.MembercreatesProject;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProjectPK;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by chambon on 20/12/14.
 */
public class MembercreatesProjectDAO implements IDAO<MembercreatesProject> {

    private static MembercreatesProjectDAO instance;

    public static synchronized MembercreatesProjectDAO getInstance() {
        if (instance == null) {
            instance = new MembercreatesProjectDAO();
        }
        return instance;
    }

    @Override
    public void persist(MembercreatesProject entity, EntityManager em)  {
        em.persist(entity);
    }

    @Override
    public MembercreatesProject find(Object idA, EntityManager em) {
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
}
