/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.model.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author juanmanuelmartinezromero
 */
public interface IDAO<E> {
    void persist(E entity, EntityManager em);

    E find(Object id, EntityManager em);

    void update(E entity, EntityManager em);

    void delete(Object id, EntityManager em);

    List<E> getList(EntityManager em);
}
