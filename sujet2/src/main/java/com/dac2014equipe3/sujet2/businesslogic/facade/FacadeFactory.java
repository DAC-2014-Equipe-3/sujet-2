/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.businesslogic.facade;

import com.dac2014equipe3.sujet2.businesslogic.service.ServiceFactory;


/**
 *
 * @author juanmanuelmartinezromero
 */
public class FacadeFactory {

    private final String PU = "com.DAC-2014-Equipe-3_sujet2_war_1.0-SNAPSHOTPU";
    private static FacadeFactory instance;

    public static synchronized FacadeFactory getInstance() {
        if (instance == null) {
            instance = new FacadeFactory();
        }
        return instance;
    }

    public MemberFacade getMemberFacade() {
        return new MemberFacade(PU, ServiceFactory.getInstance().getMemberService());
    }
}