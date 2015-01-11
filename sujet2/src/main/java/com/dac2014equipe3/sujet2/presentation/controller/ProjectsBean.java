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
    private List<ProjectVo> listProjectsDeleted = new ArrayList<ProjectVo>();
    private List<ProjectVo> listProjectsClosed = new ArrayList<ProjectVo>();
    private List<ProjectVo> listProjectsNotDeletedNotClosed = new ArrayList<ProjectVo>();
    private List<ProjectVo> listProjectsNotDeleted = new ArrayList<ProjectVo>();
    public List<ProjectVo> getListProjects() {
        return listProjects;
    }

    public void setListProjects(List<ProjectVo> listProjects) {
        this.listProjects = listProjects;
    }

    public List<ProjectVo> getListProjectsDeleted() {
        return listProjectsDeleted;
    }

    public void setListProjectsDeleted(List<ProjectVo> listProjectsDeleted) {
        this.listProjectsDeleted = listProjectsDeleted;
    }

    public List<ProjectVo> getListProjectsClosed() {
        return listProjectsClosed;
    }

    public void setListProjectsClosed(List<ProjectVo> listProjectsClosed) {
        this.listProjectsClosed = listProjectsClosed;
    }

    public List<ProjectVo> getListProjectsNotDeleted() {
        return listProjectsNotDeleted;
    }

    public void setListProjectsNotDeleted(List<ProjectVo> listProjectsNotDeleted) {
        this.listProjectsNotDeleted = listProjectsNotDeleted;
    }

    public List<ProjectVo> getListProjectsNotDeletedNotClosed() {
        return listProjectsNotDeletedNotClosed;
    }

    public void setListProjectsNotDeletedNotClosed(List<ProjectVo> listProjectsNotDeletedNotClosed) {
        this.listProjectsNotDeletedNotClosed = listProjectsNotDeletedNotClosed;
    }

    /**
     * Recupere tous les projets non supprimés
     */
    public void getAllProjectsNotDeleted() {
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();
        listProjectsNotDeleted.addAll(projectFacade.getProjectsNotDeleted());
    }

    /**
     * Recupere tous les projets non supprimés
     */
    public void getAllProjectsNotDeletedNotClosed() {
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();
        listProjectsNotDeletedNotClosed.addAll(projectFacade.getProjectsNotDeletedNotClosed());
    }

    /**
     * Recupere tous les projets
     */
    public void getAllProjects() {
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();
        listProjects.addAll(projectFacade.getAllProjects());
    }

    /**
     * Recupere tous les projets supprimés
     */
    public void getAllProjectsDeleted() {
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();
        listProjectsDeleted.addAll(projectFacade.getProjectsDeleted());
    }

    /**
     * Recupere tous les projets clôturés
     */
    public void getAllProjectsClosed() {
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();
        listProjectsClosed.addAll(projectFacade.getProjectsClosed());
    }

}
