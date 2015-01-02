package com.dac2014equipe3.sujet2.presentation.controller;
import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MembercreatesProjectFacade;
import com.dac2014equipe3.sujet2.businesslogic.facade.ProjectFacade;
import com.dac2014equipe3.sujet2.model.entity.MemberbacksProjectPK;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProject;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProjectPK;
import com.dac2014equipe3.sujet2.model.entity.ProjectCategory;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectCategoryVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.Calendar;

@ManagedBean(name = "projectBean")
@RequestScoped
public class ProjectBean {

    private int id;
    private String title;
    private int fundingGoal;
    private Date creationDate;
    private Date endDate;
    private String description;
    private ProjectCategory category;
    private boolean isSuppressed;

    public ProjectCategoryVo getCategoryVo() {
        return categoryVo;
    }

    public void setCategoryVo(ProjectCategoryVo categoryVo) {
        this.categoryVo = categoryVo;
    }

    private ProjectCategoryVo categoryVo;

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
        //TODO Vérification que l'utilisateur est loggé

        ProjectVo projectVo = new ProjectVo();
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());

        projectVo.setProjectId(getId());
        projectVo.setProjectTitle(getTitle());
        projectVo.setProjectFundingGoal(getFundingGoal());
        projectVo.setProjectCreationDate(timeNow);
        projectVo.setProjectEndDate(getEndDate());
        projectVo.setProjectDescription(getDescription());
        projectVo.setProjectIsSuppressed(false);
        projectVo.setMemberList(null); //TODO
        projectVo.setProjectCategory(new ProjectCategory(getCategoryVo()));
        projectVo.setMediaList(null); //TODO
        projectVo.setMemberbacksProjectList(null); //TODO
        projectVo.setReward(null);//TODO

        projectFacade.addProject(projectVo);

        //Get the new project id

        //TODO A finir (penser à lier le projet avec le créateur)
        MemberBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class);

        //Register the project creator
        MembercreatesProjectFacade membercreatesProjectFacade = FacadeFactory.getInstance().getMembercreatesProjectFacade();

        MemberVo memberVo = controller.getMemberVo();
        MembercreatesProjectPK membercreatesProjectPK = new MembercreatesProjectPK(memberVo.getMemberId(), projectVo.getProjectId());
        MembercreatesProjectVo membercreatesProjectVo = new MembercreatesProjectVo(membercreatesProjectPK, memberVo, projectVo);

        membercreatesProjectFacade.addMembercreatesProject(membercreatesProjectVo);

        return "success";
    }

    public String deleteProject(){
        //TODO Supprimer projet en flagant isSuppressed
        return "success";
    }

}
