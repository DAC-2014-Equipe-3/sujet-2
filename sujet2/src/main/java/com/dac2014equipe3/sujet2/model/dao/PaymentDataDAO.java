package com.dac2014equipe3.sujet2.model.dao;

import com.dac2014equipe3.sujet2.model.entity.PaymentData;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 * Created by chambon on 20/12/14.
 */
public class PaymentDataDAO implements IDAO<PaymentData> {

    private static PaymentDataDAO instance;

    public static synchronized PaymentDataDAO getInstance() {
        if (instance == null) {
            instance = new PaymentDataDAO();
        }
        return instance;
    }

    @Override
    public void persist(PaymentData entity, EntityManager em)   {
        em.persist(entity);
    }

    @Override
    public PaymentData find(Object idA, EntityManager em) {
        Integer id = (Integer) idA;
        Query query = em.createNamedQuery("PaymentData.findByPaymentDataID")
                .setParameter("paymentDataID", id);
        return (PaymentData) query.getSingleResult();
    }

    @Override
    public void update(PaymentData entity, EntityManager em)   { em.merge(entity); }

    @Override
    public void delete(Object id, EntityManager em) {
        PaymentData paymentData = find(id, em);
        em.remove(paymentData);
    }

    @Override
    public List<PaymentData> getList(EntityManager em) {
        Query query = em.createNamedQuery("PaymentData.findAll");
        List<PaymentData> listPaymentData = query.getResultList();
        return listPaymentData;
    }
}
