package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.Member;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProject;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProjectPK;
import com.dac2014equipe3.sujet2.model.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by chambon on 20/12/14.
 */
public class MembercreatesProjectDAO implements IDAO<MembercreatesProject> {

    private static MembercreatesProjectDAO instance;
    private static final String JPQL_SELECT_BY_CREATEDID_PROJECT  = " SELECT p FROM Project p , MembercreatesProject m " +
                    " WHERE ( p.projectIsSuppressed = :projectIsSuppressed ) " +
                    " AND (m.membercreatesProjectPK.creatorId = :creatorId AND m.membercreatesProjectPK.projectId = p.projectId ) " ;

    private static final String PARAM_PROJECTSUPPRESSED = "projectIsSuppressed";
    private static final String PARAM_CREATEDID = "creatorId";


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
        Query query = em.createNamedQuery("MembercreatesProject.findAll");
        List<MembercreatesProject> listMcP = query.getResultList();
        return listMcP;
    }

    public List<MembercreatesProject> getListForCreator(Object idCreator, EntityManager em) {
        Integer id = (Integer) idCreator;
        Query query = em.createNamedQuery("MembercreatesProject.findByCreatorId")
                .setParameter("creatorId", id);
        List<MembercreatesProject> listMcP = query.getResultList();
        return listMcP;
    }

    /**
     * recuperation des projets d'un utilisateur
     * @param memberId
     * @param em
     * @return
     */
    public List<Project> getListCreatorProject(Integer memberId, EntityManager em) {
        List<Project> project =null;
        Query q = em.createQuery(JPQL_SELECT_BY_CREATEDID_PROJECT);
        q.setParameter(PARAM_CREATEDID, (Integer)memberId);
        q.setParameter(PARAM_PROJECTSUPPRESSED, false);

        try {
            project = (List<Project>) q.getResultList();
        } catch (NonUniqueResultException e) {
        } catch (NoResultException e) {
        }

        return project;
    }

}
