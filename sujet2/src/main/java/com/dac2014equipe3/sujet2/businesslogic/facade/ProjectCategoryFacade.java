package com.dac2014equipe3.sujet2.businesslogic.facade;
import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.businesslogic.service.ProjectCategoryService;
import com.dac2014equipe3.sujet2.vo.ProjectCategoryVo;
import java.util.List;

public class ProjectCategoryFacade extends Facade<ProjectCategoryVo> {

    public ProjectCategoryFacade(String PUName, IService service){
        super(PUName, service);
    }

    public List<ProjectCategoryVo> getAllProjectCategories(){
        try {
            em = emf.createEntityManager();
            return ((ProjectCategoryService) service).getList(em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
}
