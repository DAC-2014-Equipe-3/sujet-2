package com.dac2014equipe3.sujet2.businesslogic.facade;

import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.businesslogic.service.MemberbacksProjectService;
import com.dac2014equipe3.sujet2.vo.MemberbacksProjectVo;

import java.util.List;

/**
 * Created by Monssef on 03/01/15.
 */
public class MemberbacksProjectFacade extends Facade<MemberbacksProjectVo>{

    public MemberbacksProjectFacade(String PUName, IService service) {
        super(PUName, service);
    }

    public List<MemberbacksProjectVo> getListForProject(Object idProject) {
        try {
            return ((MemberbacksProjectService)service).getListForProject(idProject, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
}
