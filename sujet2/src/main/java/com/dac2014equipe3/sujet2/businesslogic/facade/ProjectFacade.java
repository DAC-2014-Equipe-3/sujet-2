package com.dac2014equipe3.sujet2.businesslogic.facade;

import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.businesslogic.service.ProjectService;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import java.util.List;

/**
 * Created by lepeteil on 23/12/14.
 */
public class ProjectFacade extends Facade<ProjectVo> {

    public ProjectFacade(String PUName, IService service) {
        super(PUName, service);
    }

    public List<ProjectVo> getAllProjects(){
        try {
            em = emf.createEntityManager();
            return ((ProjectService) service).getList(em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
}