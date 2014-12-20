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
        MembercreatesProjectPK id = ((MembercreatesProject)idA).getMembercreatesProjectPK();
        Query query = em.createNamedQuery("MembercreatesProject.findByMembercreatesProjectPK")
                .setParameter("creatorId", id.getCreatorId())
                .setParameter("projectId", id.getProjectId());
        return (MembercreatesProject) query.getSingleResult();
    }

    @Override
    public void update(MembercreatesProject entity, EntityManager em)  { em.merge(entity); }

    @Override
    public void delete(Object id, EntityManager em) {
        MembercreatesProject mcp = find(id, em);
        em.remove(mcp);
    }

    @Override
    public List<MembercreatesProject> getList(EntityManager em) {
        Query query = em.createNamedQuery("MemberbacksProject.findAll");
        List<MembercreatesProject> listMcP = query.getResultList();
        return listMcP;
    }
}
