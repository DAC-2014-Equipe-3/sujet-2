/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.Member;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jummartinezro
 */
@Stateless
public class MemberDAO {

    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT m FROM Member m WHERE m.memberSurname = :memberSurname";
    private static final String PARAM_LOGIN           = "memberSurname";

    // Injection du manager, qui s'occupe de la connexion avec la BD
    @PersistenceContext( unitName = "bd_PU" )
    private EntityManager em;

    // Enregistrement d'un nouvel utilisateur
    public void addMember( Member member ) throws DAOException {
        try {
            em.persist( member );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    // Recherche d'un utilisateur à partir de son surname
    public Member login( Member memberIn) throws DAOException {
        Member member = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter(PARAM_LOGIN, memberIn.getMemberSurname());
        try {
            member = (Member) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return member;
    }

    private class DAOException extends Throwable {
        public DAOException(Exception e) {
            //TODO
            System.out.println("DAO Exception");
        }
    }
}
