package com.dac2014equipe3.sujet2.converter;

import com.dac2014equipe3.sujet2.presentation.controller.ProjectCategoriesBean;
import com.dac2014equipe3.sujet2.vo.ProjectCategoryVo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by guilherme on 31/12/14.
 */
@FacesConverter("projectCategoriesConverter")
public class ProjectCategoryConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
                              String value) {
        if (value == null) {
            return null;
        }
        ProjectCategoriesBean controller = context.getApplication()
                .evaluateExpressionGet(context, "#{projectCategoriesBean}",
                        ProjectCategoriesBean.class);
        ProjectCategoryVo categoryVo = controller.findCountryById(value);
        return categoryVo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
                              Object value) {
        String string = null;
        if (value instanceof ProjectCategoryVo) {
            string = ((ProjectCategoryVo) value).getCategoryId().toString();
        }
        return string;
    }
}
