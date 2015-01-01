package com.dac2014equipe3.sujet2.businesslogic.facade;
import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.businesslogic.service.MemberService;
import com.dac2014equipe3.sujet2.vo.MemberVo;

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

    /**
     * Enregistre le membre en base
     * @param memberVo
     */
    public void addMember(MemberVo memberVo){
        persist(memberVo);
    }

    /**
     * Met a jour le membre
     * @param memberVo
     */
    public boolean updateMember (MemberVo memberVo){
        return update(memberVo);
    }

}
