package com.dac2014equipe3.sujet2.businesslogic.facade;

import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.businesslogic.service.MembercreatesProjectService;
import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import java.util.List;

/**
 * Created by guilherme on 01/01/15.
 */
public class MembercreatesProjectFacade extends Facade<MembercreatesProjectVo> {

    public MembercreatesProjectFacade(String PUName, IService service) {
        super(PUName, service);
    }

    /**
     * Register the creator of the project in the database
     * @param membercreatesProjectVo
     */
    public void addMembercreatesProject(MembercreatesProjectVo membercreatesProjectVo){
        persist(membercreatesProjectVo);
    }

    public List<MembercreatesProjectVo> getListForCreator(Object idCreator) {
        try {
            return ((MembercreatesProjectService)service).getListForCreator(idCreator, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
    public List<ProjectVo> getListCreatorProject(Integer memberId) {
        try {
            return ((MembercreatesProjectService)service).getListCreatorProject(memberId, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

}
