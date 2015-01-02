package com.dac2014equipe3.sujet2.businesslogic.facade;

import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;

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
}
