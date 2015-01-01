package com.dac2014equipe3.sujet2.businesslogic.service;
import java.util.List;
import javax.persistence.EntityManager;

public interface IService<VO> {

    void persist(VO vo, EntityManager em);

    VO find(Object id, EntityManager em);

    void update(VO vo, EntityManager em);

    void delete(Object id, EntityManager em);

    List<VO> getList(EntityManager em);
}