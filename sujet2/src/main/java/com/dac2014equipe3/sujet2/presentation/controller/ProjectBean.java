package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.*;
import com.dac2014equipe3.sujet2.model.entity.*;
import com.dac2014equipe3.sujet2.vo.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.lang.reflect.Field;
import java.util.*;

@ManagedBean(name = "projectBean")
@SessionScoped
public class ProjectBean {

    private int id;
    private String title;
    private int fundingGoal;
    private Date creationDate;
    private Date endDate;
    private String description;
    private ProjectCategory category;
    private boolean isSuppressed;
    private ProjectCategoryVo categoryVo;

    private Integer rewardId;
    private String rewardName;
    private String rewardDescription;
    private String rewardMinPrice;
    private List<RewardVo> rewardList;

    public String getRewardMinPrice() {
        return rewardMinPrice;
    }

    public void setRewardMinPrice(String rewardMinPrice) {
        this.rewardMinPrice = rewardMinPrice;
    }

    public Integer getRewardId() {
        return rewardId;
    }

    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }

    public void addReward(){
        this.rewardList.add(new RewardVo(
                0,
                this.rewardName,
                this.rewardDescription,
                this.rewardMinPrice));

        this.rewardName = "";
        this.rewardDescription = "";
        this.rewardMinPrice = "";
    }

    public void removeReward(RewardVo rewardVo){
        this.rewardList.remove(rewardVo);
    }

    public List<RewardVo> getRewardList() {
        return rewardList;
    }

    public void setRewardList(List<RewardVo> rewardList) {
        this.rewardList = rewardList;
    }



    public ProjectBean() {
        rewardList = new ArrayList<RewardVo>();
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

    public ProjectCategoryVo getCategoryVo() {
        return categoryVo;
    }

    public void setCategoryVo(ProjectCategoryVo categoryVo) {
        this.categoryVo = categoryVo;
    }

    /***********************************METHODES AJOUTEES*********************************/

    /**
     * Cree un nouveau projet
     *
     * @return
     */
    public String addProject() {
        //TODO Vérification que l'utilisateur est loggé

        ProjectVo projectVo = new ProjectVo();
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        projectVo.setProjectId(getId());
        projectVo.setProjectTitle(getTitle());
        projectVo.setProjectFundingGoal(getFundingGoal());
        projectVo.setProjectCreationDate(new Date());
        projectVo.setProjectEndDate(getEndDate());
        projectVo.setProjectDescription(getDescription());
        projectVo.setProjectIsSuppressed(false);
        projectVo.setMemberList(null); //TODO
        projectVo.setProjectCategory(new ProjectCategory(getCategoryVo()));
        projectVo.setMediaList(null); //TODO
        projectVo.setMemberbacksProjectList(null); //TODO
        projectVo.setListReward(getRewardList());//TODO
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


        List<Reward> rewards = new ArrayList<Reward>();
        int i=0;
        for(RewardVo reward : rewardList){
            rewards.add(new Reward(projectVo.getListReward().get(i++)));
        }

        Project project = new Project(projectVo);
        project.setReward(rewards);
        for(RewardVo r : rewardList){
            r.setProject(project);
        }



        //Register the rewards
        RewardFacade rewardFacade = FacadeFactory.getInstance().getRewardFacade();
        rewardFacade.addRewardList(rewardList);


        return "success";
    }

    /**
     * Supprimer un projet
     *
     * @return
     */
    public String deleteProject() {

        MemberBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class);

        if(controller.isLoggedIn()){
            int idUser = controller.getId();
            boolean isProjectCreator = false;

            Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
            ProjectVo projectVo = null;
            ProjectFacade projectFacade = null;
            List<MemberbacksProjectVo> listProjectBacks = null;
            MembercreatesProjectFacade membercreatesProjectFacade = FacadeFactory.getInstance().getMembercreatesProjectFacade();
            MemberbacksProjectFacade memberbacksProjectFacade = FacadeFactory.getInstance().getMemberbacksProjectFacade();
            MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
            MemberVo memberVo = memberFacade.find(idUser);
            List<MembercreatesProjectVo> listMemberProjects = membercreatesProjectFacade.getListForCreator(idUser);

            try {
                id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProject"));
            } catch (NumberFormatException e) {
                id = 0;
            }

            if (id > 0) {
                projectFacade = FacadeFactory.getInstance().getProjectFacade();
                projectVo = projectFacade.find(id);
                for (MembercreatesProjectVo McP : listMemberProjects) {
                    if (McP.getMembercreatesProjectPK().getCreatorId() == idUser) {
                        isProjectCreator = true;
                    }
                }
                if (isProjectCreator || memberVo.getMemberIsAdmin()) {
                    listProjectBacks = memberbacksProjectFacade.getListForProject(id);
                    if (listProjectBacks.isEmpty() && currentDate.compareTo(projectVo.getProjectEndDate()) != 1) {
                        projectFacade = FacadeFactory.getInstance().getProjectFacade();
                        projectVo.setProjectIsSuppressed(true);
                        if(projectFacade.updateProject(projectVo)){
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Projet supprimé avec succés."));
                            return "success";
                        }else{
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Projet non supprimé."));
                            return "failure";
                        }
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Projet non supprimé."));
                        return "failure";
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Projet non supprimé."));
                    return "failure";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Projet non supprimé."));
                return "failure";
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Projet non supprimé."));
            return "failure";
        }


    }

    /**
     * Recuperer les données d'un projet
     *
     * @param idProject
     */
    public void getDataProject(String idProject) {

        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        try {
            id = Integer.parseInt(idProject);
        } catch (NumberFormatException e) {
            id = 0;
        }

        if (id > 0) {
            ProjectVo projectVo = projectFacade.find(id);
            setId(projectVo.getProjectId());
            setTitle(projectVo.getProjectTitle());
            setFundingGoal(projectVo.getProjectFundingGoal());
            setCreationDate(projectVo.getProjectCreationDate());
            setEndDate(projectVo.getProjectEndDate());
            setDescription(projectVo.getProjectDescription());
            setCategory(projectVo.getProjectCategory());
        }

    }

}
