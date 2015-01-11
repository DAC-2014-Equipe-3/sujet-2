package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.DAOFactory;
import com.dac2014equipe3.sujet2.model.dao.ProjectDAO;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.model.entity.Reward;
import com.dac2014equipe3.sujet2.vo.MemberbacksProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Created by lepeteil on 19/12/14.
 */
public class ProjectService implements IService<ProjectVo>{

    private static ProjectService instance;

    public static synchronized ProjectService getInstance() {
        if (instance == null) {
            instance = new ProjectService();
        }
        return instance;
    }

    @Override
    public void persist(ProjectVo vo, EntityManager em) {
        Project entity = new Project();

        List<Reward> rewardList = new ArrayList<Reward>();
        int i=0;
        for(Reward reward : rewardList){
            rewardList.add(new Reward(vo.getListReward().get(i++)));
        }

        entity.setMediaList(vo.getMediaList());
        entity.setMemberList(vo.getMemberList());
        entity.setMemberbacksProjectList(vo.getMemberbacksProjectList());
        entity.setProjectCategory(vo.getProjectCategory());
        entity.setProjectCreationDate(vo.getProjectCreationDate());
        entity.setProjectDescription(vo.getProjectDescription());
        entity.setProjectEndDate(vo.getProjectEndDate());
        entity.setProjectFundingGoal(vo.getProjectFundingGoal());
        entity.setProjectId(vo.getProjectId());
        entity.setProjectIsClosed(vo.isProjectIsClosed());
        entity.setProjectIsSuppressed(vo.getProjectIsSuppressed());
        entity.setProjectTitle(vo.getProjectTitle());
        entity.setReward(rewardList);

        DAOFactory.getInstance().getProjectDAO().persist(entity, em);
        vo.setProjectId(entity.getProjectId());
    }

    @Override
    public ProjectVo find(Object id, EntityManager em) {
        ProjectDAO dao = DAOFactory.getInstance().getProjectDAO();
        ProjectVo projectVo = dao.find(id, em).toVo();
        return projectVo;
    }

    @Override
    public void update(ProjectVo vo, EntityManager em) {
        Project entity = new Project();
        ProjectDAO dao = DAOFactory.getInstance().getProjectDAO();

        List<Reward> rewardList = new ArrayList<Reward>();
        int i=0;
        for(Reward reward : rewardList){
            rewardList.add(new Reward(vo.getListReward().get(i++)));
        }

        entity.setMediaList(vo.getMediaList());
        entity.setMemberList(vo.getMemberList());
        entity.setMemberbacksProjectList(vo.getMemberbacksProjectList());
        entity.setProjectCategory(vo.getProjectCategory());
        entity.setProjectCreationDate(vo.getProjectCreationDate());
        entity.setProjectDescription(vo.getProjectDescription());
        entity.setProjectEndDate(vo.getProjectEndDate());
        entity.setProjectFundingGoal(vo.getProjectFundingGoal());
        entity.setProjectId(vo.getProjectId());
        entity.setProjectIsSuppressed(vo.getProjectIsSuppressed());
        entity.setProjectTitle(vo.getProjectTitle());
        entity.setReward(rewardList);

        dao.update(entity, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        ProjectDAO dao = DAOFactory.getInstance().getProjectDAO();
        dao.delete(id,em);
    }

    @Override
    public List<ProjectVo> getList(EntityManager em) {
        List<ProjectVo> list = new ArrayList<ProjectVo>();
        for (Project project : DAOFactory.getInstance().getProjectDAO().getList(em)) {
            list.add((project).toVo());
        }
        return list;
    }

    /**
     * Recuperer tous les projets non supprimés
     * @param em
     * @return
     */
    public List<ProjectVo> getProjectsNotDeleted(EntityManager em){
        List<ProjectVo> list = new ArrayList<ProjectVo>();
        for (Project project : DAOFactory.getInstance().getProjectDAO().getProjectsNotDeleted(em)) {
            list.add((project).toVo());
        }
        return list;
    }

    /**
     * Recuperer tous les projets non supprimés et non clôturés
     * @param em
     * @return
     */
    public List<ProjectVo> getProjectsNotDeletedNotClosed(EntityManager em){
        List<ProjectVo> list = new ArrayList<ProjectVo>();
        for (Project project : DAOFactory.getInstance().getProjectDAO().getProjectsNotDeletedNotClosed(em)) {
            list.add((project).toVo());
        }
        return list;
    }

    /**
     * Recuperer tous les projets supprimés
     * @param em
     * @return
     */
    public List<ProjectVo> getProjectsDeleted(EntityManager em){
        List<ProjectVo> list = new ArrayList<ProjectVo>();
        for (Project project : DAOFactory.getInstance().getProjectDAO().getProjectsDeleted(em)) {
            list.add((project).toVo());
        }
        return list;
    }

    /**
     * Recuperer tous les projets cloturés
     * @param em
     * @return
     */
    public List<ProjectVo> getProjectsClosed(EntityManager em){
        List<ProjectVo> list = new ArrayList<ProjectVo>();
        for (Project project : DAOFactory.getInstance().getProjectDAO().getProjectsClosed(em)) {
            list.add((project).toVo());
        }
        return list;
    }
}
