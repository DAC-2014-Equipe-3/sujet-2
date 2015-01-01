package com.dac2014equipe3.sujet2.presentation.controller;
import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberFacade;
import com.dac2014equipe3.sujet2.businesslogic.facade.ProjectFacade;
import com.dac2014equipe3.sujet2.model.entity.Member;
import com.dac2014equipe3.sujet2.model.entity.ProjectCategory;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import com.dac2014equipe3.sujet2.vo.ProjectCategoryVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;

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
        //TODO A finir (penser à lier le projet avec le créateur connecté)

        ProjectVo projectVo = new ProjectVo();
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        /*MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
        MemberVo memberVo = memberFacade.find(id);
        List<MemberVo> creator = null;
        creator.add(memberVo);*/

        projectVo.setProjectTitle(getTitle());
        projectVo.setProjectFundingGoal(getFundingGoal());
        projectVo.setProjectCreationDate(new Date());
        projectVo.setProjectEndDate(getEndDate());
        projectVo.setProjectDescription(getDescription());
        projectVo.setProjectIsSuppressed(false);
        projectVo.setMemberList(null);
        projectVo.setProjectCategory(getCategory());
        projectVo.setMediaList(null); //TODO
        projectVo.setReward(null);//TODO
        //projectFacade.addProject(projectVo);
        return "success";
    }

    public String deleteProject(){
        //TODO Supprimer projet en flagant isSuppressed
        //TODO verifier les conditions définies
        //TODO verifier membre connecté
        return "success";
    }

}
