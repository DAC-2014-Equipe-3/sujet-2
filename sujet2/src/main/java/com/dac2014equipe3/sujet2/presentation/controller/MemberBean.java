/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberFacade;
import com.dac2014equipe3.sujet2.businesslogic.facade.MembercreatesProjectFacade;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.util.Utilities;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

/**
 * @author Jummartinezro
 */

@ManagedBean(name = "memberBean")
@SessionScoped
public class MemberBean {

    private int id;
    private boolean loggedIn;
    private boolean isAdmin;
    private boolean isSuppressed;
    private String email;
    private String login;
    private String password;
    private String oldPassword;
    private String passwordBis;
    private Date joiningDate;
    private String lastName;
    private String firstName;
    private Date birthday;
    private String nationality;
    private String sex;
    private String profession;
    private List<Project> createdProjectList;
    private List<Project> investedProjectList;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * @param oldPassword
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return
     */
    public Date getJoiningDate() {
        return joiningDate;
    }

    /**
     * @param joiningDate
     */
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return
     */
    public boolean isSuppressed() {
        return isSuppressed;
    }

    /**
     * @param isSuppressed
     */
    public void setSuppressed(boolean isSuppressed) {
        this.isSuppressed = isSuppressed;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public List<Project> getInvestedProjectList() {
        return investedProjectList;
    }

    /**
     * @param investedProjectList
     */
    public void setInvestedProjectList(List<Project> investedProjectList) {
        this.investedProjectList = investedProjectList;
    }

    /**
     * @return
     */
    public List<Project> getCreatedProjectList() {
        return createdProjectList;
    }

    /**
     * @param createdProjectList
     */
    public void setCreatedProjectList(List<Project> createdProjectList) {
        this.createdProjectList = createdProjectList;
    }


    /**
     * @return
     */
    public String getPasswordBis() {
        return passwordBis;
    }

    /**
     * @param passwordBis
     */
    public void setPasswordBis(String passwordBis) {
        this.passwordBis = passwordBis;
    }

/**************************************METHODES AJOUTEES******************************/

    /**
     * Cree un nouveau membre
     */
    public String addNewMember() {
        //TODO Valider côté serveur la validité des champs !
        //TODO Ouvrir session membre

        MemberVo memberVo = new MemberVo();
        MemberFacade memberFacade = FacadeFactory.getInstance()
                .getMemberFacade();
        memberVo.setMemberLogin(getLogin());
        memberVo.setMemberPassword(getPassword());
        memberVo.setMemberEmail(getEmail());
        memberVo.setMemberNationality(getNationality());
        memberVo.setMemberBirthday(getBirthday());
        memberVo.setMemberFirstname(getFirstName());
        memberVo.setMemberLastname(getLastName());
        memberVo.setMemberSex(getSex());
        memberVo.setMemberProfession(getProfession());
        memberVo.setMemberJoiningDate(new Date());
        memberVo.setMemberIsAdmin(false);
        memberVo.setMemberIsSuppressed(false);
        memberFacade.addMember(memberVo);
        return "success";
    }

    /**
     * Recuperer les infos personnelles du membre connecté
     */
    public Boolean getDataMember() {
        setId(Utilities.getSessionMemberId());
        setLoggedIn(Utilities.getSessionMemberLoggedIn());
        if (isLoggedIn()) {

            MemberFacade memberFacade = FacadeFactory.getInstance()
                    .getMemberFacade();
            //TODO recuperer session membre pour recuperer l'utilisateur courant

            setId(getId());
            MemberVo memberVo = memberFacade.find(getId());
            setLogin(memberVo.getMemberLogin());
            setBirthday(memberVo.getMemberBirthday());
            setEmail(memberVo.getMemberEmail());
            setFirstName(memberVo.getMemberFirstname());
            setLastName(memberVo.getMemberLastname());
            setId(memberVo.getMemberId());
            setJoiningDate(memberVo.getMemberJoiningDate());
            setNationality(memberVo.getMemberNationality());
            setSex(memberVo.getMemberSex());
            setProfession(memberVo.getMemberProfession());
            setAdmin(memberVo.getMemberIsAdmin());
            setSuppressed(memberVo.getMemberIsSuppressed());
            setPassword(memberVo.getMemberPassword());
            return true;
        }
        return false;
    }

    /**
     * Mettre à jour les informations de l'utilisateur
     */
    public String updateAccount() {
        setId(Utilities.getSessionMemberId());
        setLoggedIn(Utilities.getSessionMemberLoggedIn());
        if (! isLoggedIn()) {
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance()
                    .getMemberFacade();

            MemberVo memberVo = new MemberVo();

            memberFacade = FacadeFactory.getInstance()
                    .getMemberFacade();

            memberVo.setMemberId(getId());
            memberVo.setMemberLogin(getLogin());
            memberVo.setMemberEmail(getEmail());
            memberVo.setMemberPassword(getPassword());
            memberVo.setMemberNationality(getNationality());
            memberVo.setMemberBirthday(getBirthday());
            memberVo.setMemberFirstname(getFirstName());
            memberVo.setMemberLastname(getLastName());
            memberVo.setMemberSex(getSex());
            memberVo.setMemberIsSuppressed(isSuppressed());
            memberVo.setMemberIsAdmin(isAdmin());
            memberVo.setMemberProfession(getProfession());
            memberVo.setMemberJoiningDate(new Date());
            if (memberFacade.updateMember(memberVo)) {
               Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, " Mis à jour effectué avec succès ") ;
                return "success";
            }
           Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, " Echec de mise à jour  ");
            return "failure";
        }
    }

    /**
     * Mettre à jour le mot de passe de l'utilisateur
     */
    public String updatePassword() {
        /*recuperation des infos sur l'utilisateur courant */

        setId(Utilities.getSessionMemberId());
        setLoggedIn(Utilities.getSessionMemberLoggedIn());

        if (! isLoggedIn()) {
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();

            MemberVo memberVo =memberFacade.find(getId());

            if (verifyPassword(memberVo.getMemberPassword(), getOldPassword()) && verifyPasswordBisForm(getPasswordBis(),getPassword())) {
                memberVo.setMemberPassword(getPassword());
                memberFacade = FacadeFactory.getInstance().getMemberFacade();
                if (memberFacade.updateMember(memberVo)) {
                    Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, " Mot de passe mis à jour effectué avec succès ") ;
                    return "success";
                }
                Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, " Echec de mis à jour du mot de passe ") ;
                return "failure";
            } else {
                Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, " Echec de mis à jour du mot de passe ") ;
                return "failure";
            }
        }
    }

    /**
     * @param dbPassword
     * @param oldPassword
     * @return
     */
    public boolean verifyPassword( String dbPassword , String oldPassword) {


            if (dbPassword.equals(oldPassword)) {
                return true;

        }
        return false;
    }

    /**
     * Verification du mot de passe bis du formulaire
     * @param password
     * @param passwordBis
     * @return
     */

    public boolean verifyPasswordBisForm( String password , String passwordBis) {

        if (getPasswordBis().equals(getPassword())) {

                return true;

        }
        return false;
    }
    /**
     * Supprimer compte membre
     *
     * @return
     */
    public String deleteAccount() {
        setId(Utilities.getSessionMemberId());
        setLoggedIn(Utilities.getSessionMemberLoggedIn());
        if (!isLoggedIn()) {
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance()
                    .getMemberFacade();
            MemberVo memberVo = memberFacade.find(getId());

            MembercreatesProjectFacade membercreatesProjectFacade = FacadeFactory.getInstance()
                    .getMembercreatesProjectFacade();

            List<ProjectVo> listMemberProjects = membercreatesProjectFacade.getListCreatorProject(getId());
            if (listMemberProjects.size() > 0) {
                Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, " Impossible de supprimer le compte" +
                        " Veuillez contacter l'adminnistrateur : admin@dac.imag ") ;
                return "failure";
            }
            memberVo.setMemberIsSuppressed(true);
            memberFacade = FacadeFactory.getInstance().getMemberFacade();
            memberFacade.updateMember(memberVo);
            Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, " Compte supprimé avec succès ") ;
            //deconnexion
            disconnect();
            return "success";
        }
    }
    /**
     * Deconnecter membre
     *
     * @return
     */
    public String disconnect() {
        setLoggedIn(false);
        Utilities.setSessionMemberLoggedIn(false);
        return "success";
    }

    /**
     * Convertir le membre en vo
     * @return
     */
    public MemberVo getMemberVo() {
        MemberVo vo = new MemberVo();

        vo.setMemberId(id);
        vo.setMemberEmail(email);
        vo.setMemberLogin(login);
        vo.setMemberPassword(password);
        vo.setMemberIsAdmin(isAdmin);
        vo.setMemberJoiningDate(joiningDate);
        vo.setMemberBirthday(birthday);
        vo.setMemberFirstname(firstName);
        vo.setMemberLastname(lastName);
        vo.setMemberNationality(nationality);
        vo.setMemberSex(sex);
        vo.setMemberProfession(profession);
        vo.setMemberIsSuppressed(isSuppressed);

        return vo;
    }

    /**
     * Recuperer les projets créés par le membre
     */
    public void allProjectsCreated() {
        /*if (isLoggedIn()) {
            MembercreatesProjectFacade membercreatesProjectFacade = FacadeFactory.getInstance().getMembercreatesProjectFacade();
            List<MembercreatesProjectVo> projectsCreated = membercreatesProjectFacade.getListForCreator(getId());
            ListIterator<MembercreatesProjectVo> iter = projectsCreated.listIterator();
            Project proj = new Project();
            ProjectVo projTmp;

            while (iter.hasNext()) {
                projTmp = iter.next().getProject();
                proj.setProjectTitle(projTmp.getProjectTitle());
                proj.setProjectCategory(projTmp.getProjectCategory());
                proj.setProjectDescription(projTmp.getProjectDescription());
                createdProjectList.add(proj);
            }
        }*/
    }

    /**
     * Recuperer les projets créés par le membre
     */
    public void allProjectsInvested() {
        /*if (isLoggedIn()) {
            MemberbacksProjectFacade memberbacksProjectFacade = FacadeFactory.getInstance().getMemberbacksProjectFacade();
            List<MemberbacksProjectVo> projectsInvested = memberbacksProjectFacade.getListForProject(getId());
            ListIterator<MemberbacksProjectVo> iter = projectsInvested.listIterator();
            Project proj = new Project();
            ProjectVo projTmp;

            while (iter.hasNext()) {
                projTmp = iter.next().getProject();
                proj.setProjectTitle(projTmp.getProjectTitle());
                proj.setProjectCategory(projTmp.getProjectCategory());
                proj.setProjectDescription(projTmp.getProjectDescription());
                investedProjectList.add(proj);
            }
        }*/
    }

    public void showDialogDeleteAccount() {

        RequestContext.getCurrentInstance().openDialog("form_deleteaccount");

    }
}
