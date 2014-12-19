/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.model.dao;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class DAOFactory {

    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public MemberDAO getMemberDAO() {
        return MemberDAO.getInstance();
    }

    public ProjectDAO getProjectDAO(){ return ProjectDAO.getInstance(); }
}
