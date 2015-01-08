package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.DAOFactory;
import com.dac2014equipe3.sujet2.model.entity.*;
import com.dac2014equipe3.sujet2.vo.MemberbacksProjectVo;
import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monssef on 03/01/15.
 */
public class MemberbacksProjectService implements IService<MemberbacksProjectVo>{

    private static MemberbacksProjectService instance;

    public static synchronized MemberbacksProjectService getInstance() {
        if (instance == null) {
            instance = new MemberbacksProjectService();
        }
        return instance;
    }

    @Override
    public void persist(MemberbacksProjectVo memberbacksProjectVo, EntityManager em) {
        MemberbacksProject entity = new MemberbacksProject();
        Project projectentity = new Project();
        Member memberentity = new Member();
        Reward rewardentity = new Reward();

        memberentity.setMemberId(memberbacksProjectVo.getMember1().getMemberId());
        projectentity.setProjectId(memberbacksProjectVo.getProject().getProjectId());
        rewardentity.setRewardId(memberbacksProjectVo.getReward().getRewardId());

        entity.setBackingDate(memberbacksProjectVo.getBackingDate());
        entity.setPledgedEuros(memberbacksProjectVo.getPledgedEuros());

        entity.setProject(projectentity);
        entity.setReward(rewardentity);
        entity.setMemberbacksProjectPK(memberbacksProjectVo.getMemberbacksProjectPK());
        entity.setMember1(memberentity);

        DAOFactory.getInstance().getMemberbacksProjectDAO().persist(entity, em);
    }

    @Override
    public MemberbacksProjectVo find(Object id, EntityManager em) {
        return null;
    }

    @Override
    public void update(MemberbacksProjectVo membercreatesProjectVo, EntityManager em) {

    }

    @Override
    public void delete(Object id, EntityManager em) {

    }

    @Override
    public List<MemberbacksProjectVo> getList(EntityManager em) {
        return null;
    }

    public List<MemberbacksProjectVo> getListForProject(Object idProject, EntityManager em) {
        List<MemberbacksProjectVo> list = new ArrayList<MemberbacksProjectVo>();
        for (MemberbacksProject MbP : DAOFactory.getInstance().getMemberbacksProjectDAO().getListForProject(idProject, em)) {
            list.add((MbP).toVo());
        }
        return list;
    }

    public List<ProjectVo> getListProjectBacked(Integer memberId, EntityManager em) {
        List<ProjectVo> list = new ArrayList<ProjectVo>();
        for (Project project : DAOFactory.getInstance().getMemberbacksProjectDAO().getListProjectBacked(memberId, em)) {
            list.add((project).toVo());
        }
        return list;
    }
}
