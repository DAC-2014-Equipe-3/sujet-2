package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.Media;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 * Created by chambon on 20/12/14.
 */
public class MediaDAO implements IDAO<Media> {

    private static MemberbacksProjectDAO instance;

    public static synchronized MemberbacksProjectDAO getInstance() {
        if (instance == null) {
            instance = new MemberbacksProjectDAO();
        }
        return instance;
    }

    @Override
    public void persist(Media entity, EntityManager em)   {
        em.persist(entity);
    }

    @Override
    public Media find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        Query query = em.createNamedQuery("Media.findByMediaId")
                .setParameter("mediaId", id);
        return (Media) query.getSingleResult();
    }

    @Override
    public void update(Media entity, EntityManager em)   {
        em.persist(entity);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        Media media = find(id, em);
        em.remove(media);
    }

    @Override
    public List<Media> getList(EntityManager em) {
        Query query = em.createNamedQuery("Media.findAll");
        List<Media> listMedia = query.getResultList();
        return listMedia;
    }
}
