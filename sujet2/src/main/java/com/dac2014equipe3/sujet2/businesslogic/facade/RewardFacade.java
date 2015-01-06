package com.dac2014equipe3.sujet2.businesslogic.facade;

import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.vo.RewardVo;

import java.util.List;

/**
 * Created by guilherme on 05/01/15.
 */
public class RewardFacade extends Facade<RewardVo>{

    public RewardFacade(String PUName, IService service) {
        super(PUName, service);
    }

    public void addRewardList(List<RewardVo> list){
        for(RewardVo r : list){
            persist(r);
        }
    }
}
