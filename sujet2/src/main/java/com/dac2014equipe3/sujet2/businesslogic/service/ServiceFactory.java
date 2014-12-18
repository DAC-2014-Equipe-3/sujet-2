/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.businesslogic.service;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ServiceFactory {

    private static ServiceFactory instance;

    public static synchronized ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public MemberService getMemberService() {
        return MemberService.getInstance();
    }
}
