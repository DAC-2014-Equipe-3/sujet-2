package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.DAOFactory;
import com.dac2014equipe3.sujet2.model.dao.MembercreatesProjectDAO;
import com.dac2014equipe3.sujet2.model.entity.Member;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProject;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.model.entity.Reward;
import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 01/01/15.
 */
public class MembercreatesProjectService implements IService<MembercreatesProjectVo> {

    private static MembercreatesProjectService instance;

    public static synchronized MembercreatesProjectService getInstance() {
        if (instance == null) {
            instance = new MembercreatesProjectService();
        }
        return instance;
    }

    @Override
    public void persist(MembercreatesProjectVo membercreatesProjectVo, EntityManager em) {
        MembercreatesProject entity = new MembercreatesProject();

        //Verify if all the fields are needed
        Member member = new Member();
        member.setMemberId(membercreatesProjectVo.getMember1().getMemberId());
        member.setMemberEmail(membercreatesProjectVo.getMember1().getMemberEmail());
        member.setMemberLogin(membercreatesProjectVo.getMember1().getMemberLogin());
        member.setMemberPassword(membercreatesProjectVo.getMember1().getMemberPassword());
        member.setMemberIsAdmin(membercreatesProjectVo.getMember1().getMemberIsAdmin());
        member.setMemberJoiningDate(membercreatesProjectVo.getMember1().getMemberJoiningDate());
        member.setMemberBirthday(membercreatesProjectVo.getMember1().getMemberBirthday());
        member.setMemberFirstname(membercreatesProjectVo.getMember1().getMemberFirstname());
        member.setMemberLastname(membercreatesProjectVo.getMember1().getMemberLastname());
        member.setMemberNationality(membercreatesProjectVo.getMember1().getMemberNationality());
        member.setMemberSex(membercreatesProjectVo.getMember1().getMemberSex());
        member.setMemberProfession(membercreatesProjectVo.getMember1().getMemberProfession());
        member.setMemberIsSuppressed(membercreatesProjectVo.getMember1().getMemberIsSuppressed());

        //Verify if all the fields are needed
        Project project = new Project();
        List<Reward> rewardList = new ArrayList<Reward>();
        int i=0;
        for(Reward reward : rewardList){
            rewardList.add(new Reward((membercreatesProjectVo.getProject().getListReward().get(i++))));
        }

        project.setMediaList(membercreatesProjectVo.getProject().getMediaList());
        project.setMemberList(membercreatesProjectVo.getProject().getMemberList());
        project.setMemberbacksProjectList(membercreatesProjectVo.getProject().getMemberbacksProjectList());
        project.setProjectCategory(membercreatesProjectVo.getProject().getProjectCategory());
        project.setProjectCreationDate(membercreatesProjectVo.getProject().getProjectCreationDate());
        project.setProjectDescription(membercreatesProjectVo.getProject().getProjectDescription());
        project.setProjectEndDate(membercreatesProjectVo.getProject().getProjectEndDate());
        project.setProjectFundingGoal(membercreatesProjectVo.getProject().getProjectFundingGoal());
        project.setProjectId(membercreatesProjectVo.getProject().getProjectId());
        project.setProjectIsSuppressed(membercreatesProjectVo.getProject().getProjectIsSuppressed());
        project.setProjectTitle(membercreatesProjectVo.getProject().getProjectTitle());
        project.setReward(rewardList);

        entity.setMember1(member);
        entity.setProject(project);
        entity.setMembercreatesProjectPK(membercreatesProjectVo.getMembercreatesProjectPK());

        DAOFactory.getInstance().getMembercreatesProjectDAO().persist(entity, em);
    }

    @Override
    public MembercreatesProjectVo find(Object id, EntityManager em) {
        MembercreatesProjectDAO dao = DAOFactory.getInstance().getMembercreatesProjectDAO();
        MembercreatesProjectVo membercreatesProjectVo = dao.find(id, em).toVo();
        return membercreatesProjectVo;
    }

    @Override
    public void update(MembercreatesProjectVo membercreatesProjectVo, EntityManager em) {

    }

    @Override
    public void delete(Object id, EntityManager em) {

    }

    @Override
    public List<MembercreatesProjectVo> getList(EntityManager em) {
        return null;
    }

    public List<MembercreatesProjectVo> getListForCreator(Object idCreator, EntityManager em) {
        List<MembercreatesProjectVo> list = new ArrayList<MembercreatesProjectVo>();
        for (MembercreatesProject McP : DAOFactory.getInstance().getMembercreatesProjectDAO().getListForCreator(idCreator, em)) {
            list.add((McP).toVo());
        }
        return list;
    }

    public List<ProjectVo> getListCreatorProject(Integer memberId, EntityManager em) {
        List<ProjectVo> list = new ArrayList<ProjectVo>();
        for (Project project : DAOFactory.getInstance().getMembercreatesProjectDAO().getListCreatorProject(memberId, em)) {
            list.add((project).toVo());
        }
        return list;
    }
}
