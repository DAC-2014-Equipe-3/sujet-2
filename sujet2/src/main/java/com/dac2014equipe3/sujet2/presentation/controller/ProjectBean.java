package com.dac2014equipe3.sujet2.presentation.controller;
import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.ProjectFacade;
import com.dac2014equipe3.sujet2.model.entity.ProjectCategory;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import java.util.Date;

public class ProjectBean {

    private int id;
    private String title;
    private int fundingGoal;
    private Date creationDate;
    private Date endDate;
    private String description;
    private ProjectCategory category;
    private boolean isSuppressed;

    public ProjectBean() {
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFundingGoal() {
        return fundingGoal;
    }

    public void setFundingGoal(int fundingGoal) {
        this.fundingGoal = fundingGoal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectCategory getCategory() {
        return category;
    }

    public void setCategory(ProjectCategory category) {
        this.category = category;
    }

    public boolean isSuppressed() {
        return isSuppressed;
    }

    public void setSuppressed(boolean isSuppressed) {
        this.isSuppressed = isSuppressed;
    }

    /**
     * Cree un nouveau projet
     * @return
     */
    public String addProject() {
        ProjectVo projectVo = new ProjectVo();
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        //TODO A finir (penser à lier le projet avec le créateur)
        return "success";
    }

    public String deleteProject(){
        //TODO Supprimer projet en flagant isSuppressed
        return "success";
    }

}
