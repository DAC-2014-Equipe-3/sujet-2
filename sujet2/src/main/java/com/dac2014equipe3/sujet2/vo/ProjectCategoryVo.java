package com.dac2014equipe3.sujet2.vo;

import com.dac2014equipe3.sujet2.model.entity.Project;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by guilherme on 30/12/14.
 */
public class ProjectCategoryVo implements IValueObject{

    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
    private List<Project> projectList;

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

    public String toString(){
        return this.categoryId.toString();
    }
}
