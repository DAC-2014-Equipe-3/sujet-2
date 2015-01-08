package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.DAOFactory;
import com.dac2014equipe3.sujet2.model.entity.MemberbacksProject;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProject;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.vo.MemberbacksProjectVo;
import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monssef on 03/01/15.
 */
public class MemberbacksProjectService implements IService<MembercreatesProjectVo>{

    private static MemberbacksProjectService instance;

    public static synchronized MemberbacksProjectService getInstance() {
        if (instance == null) {
            instance = new MemberbacksProjectService();
        }
        return instance;
    }

    @Override
    public void persist(MembercreatesProjectVo membercreatesProjectVo, EntityManager em) {

    }

    @Override
    public MembercreatesProjectVo find(Object id, EntityManager em) {
        return null;
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
