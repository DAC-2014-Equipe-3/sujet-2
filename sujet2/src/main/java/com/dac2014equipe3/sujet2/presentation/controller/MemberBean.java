/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberFacade;
import com.dac2014equipe3.sujet2.vo.MemberVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

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
	private boolean isAdmin;
	private Date joiningDate;
	private String lastName;
	private String firstName;
	private Date birthday;
	private String nationality;
	private String sex;
	private String profession;
	private boolean isSuppressed;

	// private list<Project> createdProjects;
	// private list<Project> boughtProjects;

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
    public void inscrire() {
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
		memberFacade.inscrire(memberVo);

	}

}
