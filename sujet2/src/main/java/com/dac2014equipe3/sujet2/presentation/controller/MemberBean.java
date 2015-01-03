/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberFacade;
import com.dac2014equipe3.sujet2.model.entity.MemberbacksProject;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.vo.MemberVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jummartinezro
 */

@ManagedBean(name = "memberBean")
@SessionScoped
public class MemberBean {

	private int id;
	private boolean loggedIn;
	private String email;
	private String login;
	private String password;
    private String oldPassword;
    private String passwordBis;
    private boolean isAdmin;
	private Date joiningDate;
	private String lastName;
	private String firstName;
	private Date birthday;
	private String nationality;
	private String sex;
	private String profession;
	private boolean isSuppressed;
    private List<Project> projectList;
    private List<MemberbacksProject> memberbacksProjectList;

    public String getPasswordBis() {
        return passwordBis;
    }

    public void setPasswordBis(String passwordBis) {
        this.passwordBis = passwordBis;
    }

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
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
	 * @param loggedIn
	 *            the loggedIn to set
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 *
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 *
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 *
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	/**
	 *
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 *
	 * @return
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 *
	 * @param isAdmin
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 *
	 * @return
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 *
	 * @param joiningDate
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 *
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 *
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 *
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 *
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 *
	 * @return
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 *
	 * @param nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 *
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 *
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 *
	 * @return
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 *
	 * @param profession
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 *
	 * @return
	 */
	public boolean isSuppressed() {
		return isSuppressed;
	}

	/**
	 *
	 * @param isSuppressed
	 */
	public void setSuppressed(boolean isSuppressed) {
		this.isSuppressed = isSuppressed;
	}

	/**
	 *
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     *
     * @return
     */
    public List<MemberbacksProject> getMemberbacksProjectList() {
        return memberbacksProjectList;
    }

    /**
     *
     * @param memberbacksProjectList
     */
    public void setMemberbacksProjectList(List<MemberbacksProject> memberbacksProjectList) {
        this.memberbacksProjectList = memberbacksProjectList;
    }

    /**
     *
     * @return
     */
    public List<Project> getProjectList() {
        return projectList;
    }

    /**
     *
     * @param projectList
     */
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

	/**
	 * Cree un nouveau membre
	 */
    public String addNewMember() {
    //TODO Valider côté serveur la validité des champs !
    //TODO Ouvrir session membre

        if (!isLoggedIn()){
            return "failure";
        }else{
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
            memberFacade.addMember(memberVo);
            return "success";
        }

	}

    /**
     * Recuperer les infos personnelles du membre connecté
     */
    public void getDataMember(){
        //loggedIn = true;
        if (isLoggedIn()) {

                MemberFacade memberFacade = FacadeFactory.getInstance()
                        .getMemberFacade();
                //TODO recuperer session membre pour recuperer l'utilisateur courant
                MemberVo memberVo = memberFacade.find(2);

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
                setPassword(memberVo.getMemberPassword());

        }
    }

    /**
     * Mettre à jour les informations de l'utilisateur
     */
    public String updateAccount(){
    //TODO Valider côté serveur la validité des champs !
           loggedIn = false;
        if (isLoggedIn()) {
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance()
                    .getMemberFacade();

            MemberVo memberVo = new MemberVo();

            //TODO Recuperation de l'id  membre dans la session
            memberVo.setMemberId(2);
            memberVo.setMemberLogin(getLogin());
            memberVo.setMemberEmail(getEmail());
            memberVo.setMemberPassword(getPassword());
            memberVo.setMemberNationality(getNationality());
            memberVo.setMemberBirthday(getBirthday());
            memberVo.setMemberFirstname(getFirstName());
            memberVo.setMemberLastname(getLastName());
            memberVo.setMemberSex(getSex());
            memberVo.setMemberProfession(getProfession());
            memberVo.setMemberJoiningDate(new Date());
            if(memberFacade.updateMember(memberVo)){
                return "success";
            }
            return "failure";
        }
    }

    /**
     * Mettre à jour le mot de passe de l'utilisateur
     */
    public String updatePassword(){
        //TODO Valider côté serveur la validité des champs !
         loggedIn= true;
        if (!isLoggedIn()) {
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
            //TODO Recuperation de l'id  membre dans la session
            MemberVo memberVo =memberFacade.find(2);

            if (verifyPassword(memberVo, getOldPassword())) {
                memberVo.setMemberPassword(getPassword());
                memberFacade = FacadeFactory.getInstance().getMemberFacade();
                if (memberFacade.updateMember(memberVo)) {
                    return "success";
                }
                return "failure";
            } else {
                // envoyer message signant l'erreur
                return "failure";
            }
        }
    }

public boolean verifyPassword(MemberVo memberVo, String oldPassword){
    //Todo appel de la fonction de hashage qui sera utilisé sur formPassword
    String dbPassword = memberVo.getMemberPassword();
    if(getPasswordBis().equals(getPassword())) {
        if (dbPassword.equals(oldPassword)) {
            return true;
        }
    }
    return false;
}

    /**
     * Supprimer compte membre
     * @return
     */
    public String deleteAccount(){

        if (!isLoggedIn()) {
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance()
                    .getMemberFacade();
            MemberVo memberVo = memberFacade.find(id);
            if(memberVo.getProjectList().size() > 0){
                return "failure";
            }
            memberVo.setMemberId(id);
            memberVo.setMemberIsSuppressed(true);
            memberFacade.update(memberVo);
            return "success";
        }
    }

    /**
     * Deconnecter membre
     * @return
     */
    public String disconnect(){
        //TODO Gerer session ??
        setLoggedIn(false);
        return "success";
    }

    private boolean checkDataMember(MemberVo mVo){
    //TODO a completer

        if(mVo != null){
            return true;
        }

        return false;
    }

	public MemberVo getMemberVo(){
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

}
