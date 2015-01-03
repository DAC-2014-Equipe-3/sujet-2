package com.dac2014equipe3.sujet2.businesslogic.facade;

import com.dac2014equipe3.sujet2.businesslogic.service.IService;
import com.dac2014equipe3.sujet2.businesslogic.service.ProjectService;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import java.util.List;

/**
 * Created by lepeteil on 23/12/14.
 */
public class ProjectFacade extends Facade<ProjectVo> {

    public ProjectFacade(String PUName, IService service) {
        super(PUName, service);
    }

    /**
     * Register the project in the database
     * @param project
     */
    public void addProject(ProjectVo project){
        persist(project);
    }

    /**
     * Update the project in the database
     * @param projectVo
     */
    public boolean updateProject(ProjectVo projectVo){
        return update(projectVo);
    }

    /**
     * Recuperer tous les projets existants
     * @return
     */
    public List<ProjectVo> getAllProjects(){
        try {
            em = emf.createEntityManager();
            return ((ProjectService) service).getList(em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }

    /**
     * Recuperer les projets non supprimés
     * @return
     */
    public List<ProjectVo> getProjectsNotDeleted(){
        try {
            em = emf.createEntityManager();
            return ((ProjectService) service).getProjectsNotDeleted(em);
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
}
