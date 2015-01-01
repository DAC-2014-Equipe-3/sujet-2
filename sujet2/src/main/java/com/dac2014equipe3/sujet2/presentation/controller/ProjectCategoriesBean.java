package com.dac2014equipe3.sujet2.presentation.controller;
import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.ProjectCategoryFacade;
import com.dac2014equipe3.sujet2.vo.ProjectCategoryVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "projectCategoriesBean")
@ViewScoped
public class ProjectCategoriesBean {

    private List<ProjectCategoryVo> listProjectCategories = new ArrayList<ProjectCategoryVo>();

    public ProjectCategoriesBean() {
    }

    public List<ProjectCategoryVo> getListProjectCategories() {
        return listProjectCategories;
    }

    public void setListProjectCategories(List<ProjectCategoryVo> listProjectCategories) {
        this.listProjectCategories = listProjectCategories;
    }
    /**
     * Recupere tous les categories
     */
    public void getAllProjectCategories(){
        ProjectCategoryFacade projectCategoryFacade = FacadeFactory.getInstance().getProjectCategoryFacade();
        //Clear list
        listProjectCategories.clear();
        listProjectCategories.addAll(projectCategoryFacade.getAllProjectCategories());
    }

    public ProjectCategoryVo findCountryById(String id){
        for(ProjectCategoryVo object : listProjectCategories) {
            if(object.getCategoryId() == Integer.valueOf(id).intValue()) {
                return object;
            }
        }
        return null;
    }
}
