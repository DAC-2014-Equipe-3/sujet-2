package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberFacade;
import com.dac2014equipe3.sujet2.businesslogic.facade.ProjectFacade;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lepeteil on 23/12/14.
 */
@ManagedBean(name = "projectsBean")
@RequestScoped
public class ProjectsBean {

    private List<ProjectVo> listProjects = new ArrayList<ProjectVo>();

    public ProjectsBean() {
    }

    /**
     *
     * @return
     */
    public List<ProjectVo> getListProjects() {
        return listProjects;
    }

    /**
     *
     * @param listProjects
     */
    public void setListProjects(ArrayList<ProjectVo> listProjects) {
        this.listProjects = listProjects;
    }

    /**
     * Recupere tous les projets
     */
    public void getAllProjectsNotDeleted(){
        //TODO seulement les projets non supprimés
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();
        listProjects.addAll(projectFacade.getAllProjects());
    }

    /**
     * Recupere tous les projets
     */
    public void getAllProjects(){
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();
        listProjects.addAll(projectFacade.getAllProjects());
    }

}
