/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.businesslogic.facade;

import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.businesslogic.service.MemberService;
import com.dac2014equipe3.sujet2.vo.MemberVo;

/**
 *
 * @author Jummartinezro
 */
public class MemberFacade extends Facade<MemberVo> {

    public MemberFacade(String PUName, IService service) {
        super(PUName, service);
    }

    public MemberVo login(MemberVo memberVo) {

        try {
            em = emf.createEntityManager();
            return ((MemberService) service).login(memberVo, em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    public void inscrire(MemberVo memberVo){
        em = emf.createEntityManager();
        MemberService.getInstance().persist(memberVo, em);
        if (em != null) {
            em.clear();
            em.close();
        }
    }

}
