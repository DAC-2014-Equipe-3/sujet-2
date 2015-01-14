package com.dac2014equipe3.sujet2.vo;

import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.model.entity.ProjectCategory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by guilherme on 30/12/14.
 */
public class ProjectCategoryVo implements IValueObject{

    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private List<Project> projectList;

    public ProjectCategoryVo() {}

    public ProjectCategoryVo(ProjectCategory projectCategory) {
        this.categoryId = projectCategory.getCategoryId();
        this.categoryName = projectCategory.getCategoryName();
        this.categoryDescription = projectCategory.getCategoryDescription();
        this.projectList = projectCategory.getProjectList();
    }

    public int getCategoryId() {
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

}
