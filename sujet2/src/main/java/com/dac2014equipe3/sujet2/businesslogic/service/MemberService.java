/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.DAOFactory;
import com.dac2014equipe3.sujet2.model.dao.MemberDAO;
import com.dac2014equipe3.sujet2.model.entity.Member;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Jummartinezro
 */
public class MemberService implements IService<MemberVo> {

    private static MemberService instance;

    public static synchronized MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();
        }
        return instance;
    }

    @Override
    public void persist(MemberVo vo, EntityManager em) {
        Member entity = new Member();

        entity.setMemberId(vo.getMemberId());
        entity.setMemberEmail(vo.getMemberEmail());
        entity.setMemberLogin(vo.getMemberLogin());
        entity.setMemberPassword(vo.getMemberPassword());
        entity.setMemberIsAdmin(vo.getMemberIsAdmin());
        entity.setMemberJoiningDate(vo.getMemberJoiningDate());
        entity.setMemberBirthday(vo.getMemberBirthday());
        entity.setMemberFirstname(vo.getMemberFirstname());
        entity.setMemberLastname(vo.getMemberLastname());
        entity.setMemberNationality(vo.getMemberNationality());
        entity.setMemberSex(vo.getMemberSex());
        entity.setMemberProfession(vo.getMemberProfession());
        entity.setMemberIsSuppressed(vo.getMemberIsSuppressed());

        DAOFactory.getInstance().getMemberDAO().persist(entity, em);
    }

    @Override
    public MemberVo find(Object id, EntityManager em) {
        MemberDAO dao = DAOFactory.getInstance().getMemberDAO();
        MemberVo memberVo = dao.find(id, em).toVo();
        return memberVo;
    }

    @Override
    public void update(MemberVo vo, EntityManager em) {
        Member entity = new Member();
        MemberDAO dao = DAOFactory.getInstance().getMemberDAO();

        entity.setMemberId(vo.getMemberId());
        entity.setMemberEmail(vo.getMemberEmail());
        entity.setMemberLogin(vo.getMemberLogin());
        entity.setMemberPassword(vo.getMemberPassword());
        entity.setMemberIsAdmin(vo.getMemberIsAdmin());
        entity.setMemberJoiningDate(vo.getMemberJoiningDate());
        entity.setMemberBirthday(vo.getMemberBirthday());
        entity.setMemberFirstname(vo.getMemberFirstname());
        entity.setMemberLastname(vo.getMemberLastname());
        entity.setMemberNationality(vo.getMemberNationality());
        entity.setMemberSex(vo.getMemberSex());
        entity.setMemberProfession(vo.getMemberProfession());
        entity.setMemberIsSuppressed(vo.getMemberIsSuppressed());

        dao.update(entity, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        MemberDAO dao = DAOFactory.getInstance().getMemberDAO();
        dao.delete(id, em);
    }

    @Override
    public List<MemberVo> getList(EntityManager em) {
        List<MemberVo> list = new ArrayList<MemberVo>();
        for (Member member : DAOFactory.getInstance().getMemberDAO().getList(em)) {
            list.add((member).toVo());
        }
        return list;
    }

    public MemberVo login(MemberVo userVo, EntityManager em) {
        Member entity = new Member();
        //TODO: encrypt passwd
        entity.setMemberLogin(userVo.getMemberLogin());
        entity.setMemberPassword(userVo.getMemberPassword());

        Member member = DAOFactory.getInstance().getMemberDAO().login(entity, em);
        return member != null ? member.toVo() : null;
    }

}
