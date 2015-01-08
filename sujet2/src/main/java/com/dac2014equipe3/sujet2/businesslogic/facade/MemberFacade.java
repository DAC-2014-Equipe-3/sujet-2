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

    /**
     * Register the member in the database
     * @param memberVo
     */
    public void addMember(MemberVo memberVo){
        persist(memberVo);
    }

    /**
     * update the member in the database
     * @param memberVo
     */
    public boolean updateMember (MemberVo memberVo){
        return update(memberVo);
    }

    /**
     * Log the member
     * @param memberVo
     * @return
     */
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

    /**
     * Recherche si le login est déjà utilisé
     * @param login
     * @return
     */
    public boolean findMemberByLogin(String login){
        try {
            em = emf.createEntityManager();
            return ((MemberService) service).findMemberByLogin(login,em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

}
