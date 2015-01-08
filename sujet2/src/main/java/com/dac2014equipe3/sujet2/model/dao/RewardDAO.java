package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.Reward;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 * Created by chambon on 20/12/14.
 */
public class RewardDAO implements IDAO<Reward> {

    private static RewardDAO instance;
    private static final String JPQL_SELECT_BY_PROJECT_REWARD  = " SELECT r FROM Reward r " +
            " WHERE ( r.project.projectId = :Project_projectId ) " ;

    private static final String PARAM_PROJECTID= "Project_projectId";

    public static synchronized RewardDAO getInstance() {
        if (instance == null) {
            instance = new RewardDAO();
        }
        return instance;
    }

    @Override
    public void persist(Reward entity, EntityManager em)   {
        em.persist(entity);
    }

    @Override
    public Reward find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        Query query = em.createNamedQuery("Reward.findByRewardId")
                .setParameter("rewardId", id);
        return (Reward) query.getSingleResult();
    }

    @Override
    public void update(Reward entity, EntityManager em)   {
        em.merge(entity);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        Reward reward = find(id, em);
        em.remove(reward);
    }

    @Override
    public List<Reward> getList(EntityManager em) {
        Query query = em.createNamedQuery("Reward.findAll");
        List<Reward> listReward = query.getResultList();
        return listReward;
    }

    /**
     * Recuperation de la liste des rewards d'un projet
     * @param em
     * @return
     */
    public List<Reward> getListProjectReward(Integer projectId,EntityManager em) {
        Query query = em.createQuery(JPQL_SELECT_BY_PROJECT_REWARD);
        query.setParameter(PARAM_PROJECTID,projectId);
        List<Reward> listReward = query.getResultList();
        return listReward;
    }
}
