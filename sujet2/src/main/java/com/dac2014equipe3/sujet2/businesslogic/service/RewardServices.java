package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.DAOFactory;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.model.entity.Reward;
import com.dac2014equipe3.sujet2.vo.RewardVo;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 05/01/15.
 */
public class RewardServices implements IService<RewardVo>{
    private static RewardServices instance;

    public static synchronized RewardServices getInstance() {
        if (instance == null) {
            instance = new RewardServices();
        }
        return instance;
    }

    @Override
    public void persist(RewardVo rewardVo, EntityManager em) {
        Reward entity = new Reward();

        entity.setRewardId(rewardVo.getRewardId());
        entity.setRewardName(rewardVo.getRewardName());
        entity.setRewardDescription(rewardVo.getRewardDescription());
        entity.setRewardMinPrice(rewardVo.getRewardMinPrice());
        entity.setProject(rewardVo.getProject());

        DAOFactory.getInstance().getRewardDAO().persist(entity, em);
    }

    @Override
    public RewardVo find(Object id, EntityManager em) {
        return null;
    }

    @Override
    public void update(RewardVo rewardVo, EntityManager em) {

    }

    @Override
    public void delete(Object id, EntityManager em) {

    }

    @Override
    public List<RewardVo> getList(EntityManager em) {
        return null;
    }


    public List<RewardVo> getListProjectReward(Integer projectId,EntityManager em) {
        List<RewardVo> list = new ArrayList<RewardVo>();
        for (Reward reward: DAOFactory.getInstance().getRewardDAO().getListProjectReward(projectId, em)) {
            list.add((reward.toVo()));
        }
        return list;

    }
}
