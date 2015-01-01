package com.dac2014equipe3.sujet2.businesslogic.service;

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
}
