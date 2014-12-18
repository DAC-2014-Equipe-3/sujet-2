/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jummartinezro
 */
@Entity
@Table(name = "ProjectCategory", catalog = "sujet2", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectCategory.findAll", query = "SELECT p FROM ProjectCategory p"),
    @NamedQuery(name = "ProjectCategory.findByCategoryId", query = "SELECT p FROM ProjectCategory p WHERE p.categoryId = :categoryId"),
    @NamedQuery(name = "ProjectCategory.findByCategoryName", query = "SELECT p FROM ProjectCategory p WHERE p.categoryName = :categoryName"),
    @NamedQuery(name = "ProjectCategory.findByCategoryDescription", query = "SELECT p FROM ProjectCategory p WHERE p.categoryDescription = :categoryDescription")})
public class ProjectCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categoryId")
    private Integer categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "categoryName")
    private String categoryName;
    @Size(max = 45)
    @Column(name = "categoryDescription")
    private String categoryDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectCategory")
    private List<Project> projectList;

    public ProjectCategory() {
    }

    public ProjectCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public ProjectCategory(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectCategory)) {
            return false;
        }
        ProjectCategory other = (ProjectCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.ProjectCategory[ categoryId=" + categoryId + " ]";
    }

}
