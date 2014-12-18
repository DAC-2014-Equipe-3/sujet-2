/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.Member;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Jummartinezro
 */
public class MemberDAO implements IDAO<Member> {

    private static MemberDAO instance;
    private static final String JPQL_SELECT_PAR_LOGIN_AND_PASS
            = "SELECT m FROM Member m WHERE m.memberLogin LIKE :username AND m.memberPassword LIKE :password";
    private static final String PARAM_LOGIN = "username";
    private static final String PARAM_PASS = "password";

    public static synchronized MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }

    @Override
    public void persist(Member entity, EntityManager em) {
        em.persist(entity);
    }

    @Override
    public Member find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        Query query = em.createNamedQuery("User.findByIdUser")
                .setParameter("idUser", id);
        return (Member) query.getSingleResult();
    }

    @Override
    public void update(Member entity, EntityManager em) {
        em.merge(entity);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        Member member = find(id, em);
        em.remove(member);
    }

    @Override
    public List<Member> getList(EntityManager em) {
        Query query = em.createNamedQuery("Member.findAll");
        List<Member> listMembers = query.getResultList();
        return listMembers;
    }

    // Recherche d'un utilisateur à partir de son surname
    public Member login(Member entity, EntityManager em) {
        Member member;
        Query q = em.createQuery(JPQL_SELECT_PAR_LOGIN_AND_PASS);
        q.setParameter(PARAM_LOGIN, entity.getMemberLogin());
        q.setParameter(PARAM_PASS, entity.getMemberPassword());

        try {
            member = (Member) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            member = (Member) q.getResultList().get(0);
        } catch (NoResultException e) {
            member = null;
        }
        return member;
    }
}
