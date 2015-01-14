package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.*;
import com.dac2014equipe3.sujet2.model.entity.*;
import com.dac2014equipe3.sujet2.util.Utilities;
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
    private String description;
    private int fundingGoal;
    private Date creationDate;
    private Date endDate;
    private boolean isSuppressed;
    private boolean isClosed;
    private ProjectCategoryVo categoryVo;
    private int sumPledge;
    private int nbMemberBacksProject;

    /******************************* GETTER / SETTER ***********************************/

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

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public int getSumPledge() {
        return sumPledge;
    }

    public void setSumPledge(int sumPledge) {
        this.sumPledge = sumPledge;
    }

    public int getNbMemberBacksProject() {
        return nbMemberBacksProject;
    }

    public void setNbMemberBacksProject(int nbMemberBacksProject) {
        this.nbMemberBacksProject = nbMemberBacksProject;
    }

    /***********************************METHODES AJOUTEES*********************************/

    /**
     *
     */
    public void clearInfos(){
        this.title = "";
        this.fundingGoal = 0;
        this.endDate = null;
        this.description = "";
        this.sumPledge = 0;
    }

    /**
     * Cree un nouveau projet
     *
     * @return
     */
    public String addProject() {

        if (!Utilities.getSessionMemberLoggedIn()) {
            return "failure";
        }
        ProjectVo projectVo = new ProjectVo();
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        projectVo.setProjectId(getId());
        projectVo.setProjectTitle(getTitle());
        projectVo.setProjectFundingGoal(getFundingGoal());
        projectVo.setProjectCreationDate(new Date());
        projectVo.setProjectEndDate(getEndDate());
        projectVo.setProjectDescription(getDescription());
        projectVo.setProjectIsSuppressed(false);
        projectVo.setProjectIsClosed(false);
        projectVo.setMemberList(null);
        projectVo.setProjectCategory(new ProjectCategory(getCategoryVo()));
        projectVo.setMediaList(null); //TODO
        projectVo.setMemberbacksProjectList(new ArrayList<MemberbacksProject>());

        if (!Utilities.isRewardListEmpty()) {
            projectFacade.addProject(projectVo);
        } else {
            // aucun reward, on l'oblige a ajouter un reward joker
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                    "Veuillez ajouter un reward au minimum. Merci");
            return "failure";
        }

        //Register the project creator
        MembercreatesProjectFacade membercreatesProjectFacade = FacadeFactory.getInstance().
                getMembercreatesProjectFacade();
        MemberVo memberVo = Utilities.getSessionMember();
        MembercreatesProjectPK membercreatesProjectPK = new MembercreatesProjectPK(
                memberVo.getMemberId(), projectVo.getProjectId());
        MembercreatesProjectVo membercreatesProjectVo = new MembercreatesProjectVo(
                membercreatesProjectPK, memberVo, projectVo);
        membercreatesProjectFacade.addMembercreatesProject(membercreatesProjectVo);

        //Register the rewards
        if(Utilities.persistRewardList(projectVo).contentEquals("success")){
            Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, "Projet ajouté avec succés.");
            return "success";
        }
        Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, "Problème avec l'ajout des Reward");
        //TODO Rollback d'ajout de projet?
        return "failure";
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

        if (controller.isLoggedIn()) {
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
                        if (projectFacade.updateProject(projectVo)) {
                            Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, "Projet supprimé avec succés.");
                            return "success";
                        } else {
                            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, "Projet non supprimé, problème à l'execution de la requête. ");
                            return "failure";
                        }
                    } else {
                        Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, "Projet non supprimé, projet a déjà des invesstisseurs ou date de fin n'est pas encore arrivée ");
                        return "failure";
                    }
                } else {
                    Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, "Projet non supprimé, soit vous ne possedez pas le projet soit vous n'êtes pas Administrateur.");
                    return "failure";
                }
            } else {
                Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, "Projet non supprimé, vous n'avez pas le droit de supprimer ce projet.");
                return "failure";
            }
        } else {
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, "Projet non supprimé, utilisateur non connecté");
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
            setCategoryVo(new ProjectCategoryVo(projectVo.getProjectCategory()));
            setClosed(projectVo.getProjectIsClosed());
            setSuppressed(projectVo.getProjectIsSuppressed());
            setSumPledge(projectVo.getSumPledge());
            setNbMemberBacksProject(projectVo.getNbMemberBacksProject());
        }

    }

    /**
     * Recuperation des infos d'un projet
     */
    public void getDataProject() {
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();
        setId(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().
                getRequestParameterMap().get("idProject")));

        ProjectVo projectVo = projectFacade.find(getId());
        setId(projectVo.getProjectId());
        setTitle(projectVo.getProjectTitle());
        setFundingGoal(projectVo.getProjectFundingGoal());
        setCreationDate(projectVo.getProjectCreationDate());
        setEndDate(projectVo.getProjectEndDate());
        setDescription(projectVo.getProjectDescription());
        setCategoryVo(new ProjectCategoryVo(projectVo.getProjectCategory()));
        setClosed(projectVo.getProjectIsClosed());
        setSuppressed(projectVo.getProjectIsSuppressed());
        setSumPledge(projectVo.getSumPledge());
        setNbMemberBacksProject(projectVo.getNbMemberBacksProject());
    }

    /**
     * Mettre a jour id du projet selectionné pour la modification ou la suppression
     *
     * @param idProject
     */
    public void setCurrentSelectedProject(Integer idProject) {
        setId(idProject);
    }

    /**
     * Mettre a jour le projet
     *
     * @return
     */
    public String updateProject() {
        if (!Utilities.getSessionMemberLoggedIn()) {
            return "failure";
        }

        ProjectVo projectVo = new ProjectVo();
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        projectVo.setProjectId(getId());
        projectVo.setProjectTitle(getTitle());
        projectVo.setProjectFundingGoal(getFundingGoal());
        projectVo.setProjectCreationDate(new Date());
        projectVo.setProjectEndDate(getEndDate());
        projectVo.setProjectDescription(getDescription());
        projectVo.setProjectIsSuppressed(false);
        projectVo.setProjectCategory(new ProjectCategory(getCategoryVo()));
        projectVo.setProjectIsClosed(false);
        projectFacade.updateProject(projectVo);


        //TODO Problèmes avec la mise à jour de la catégorie -> il retourne toujours la catégoire 1 de la base
        /*List<Reward> rewards = new ArrayList<Reward>();
        int i = 0;
        for (RewardVo reward : rewardList) {
            rewards.add(new Reward(projectVo.getListReward().get(i++)));
        }

        Project project = new Project(projectVo);
        project.setReward(rewards);
        for (RewardVo r : rewardList) {
            r.setProject(project);
        }*/

        //Register the rewards
        //RewardFacade rewardFacade = FacadeFactory.getInstance().getRewardFacade();
        //rewardFacade.addRewardList(rewardList);

        Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, "Projet mis à jour avec succés.");
        return "success";
    }

    /**
     * @return
     */
    public String endedProject() {

        if (!Utilities.getSessionMemberLoggedIn()) {
            return "failure";
        }

        ProjectVo projectVo = new ProjectVo();
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        projectVo.setProjectId(getId());
        projectVo.setProjectTitle(getTitle());
        projectVo.setProjectFundingGoal(getFundingGoal());
        projectVo.setProjectCreationDate(new Date());
        projectVo.setProjectEndDate(getEndDate());
        projectVo.setProjectDescription(getDescription());
        projectVo.setProjectIsSuppressed(false);

        projectVo.setProjectCategory(new ProjectCategory(getCategoryVo()));
        if(!projectFacade.updateProject(projectVo)){
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, "Echec de la fermeture du projet");
            return "failure";
        }

        Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, "Projet clôturé!");
        return "success";
    }

}
