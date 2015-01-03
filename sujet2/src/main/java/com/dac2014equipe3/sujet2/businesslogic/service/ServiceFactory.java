/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.businesslogic.service;

import com.dac2014equipe3.sujet2.model.dao.MembercreatesProjectDAO;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProject;

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

    public ProjectService getProjectService() {
        return ProjectService.getInstance();
    }

    public ProjectCategoryService getProjectCategoryServices() {
        return ProjectCategoryService.getInstance();
    }

    public MembercreatesProjectService getMembercreateProjectServices() {
        return MembercreatesProjectService.getInstance();
    }

    public MemberbacksProjectService getMemberbacksProjectServices() {
        return MemberbacksProjectService.getInstance();
    }
}
