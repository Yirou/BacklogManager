/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.dao;

import com.logical.backlog.iDao.BacklogDaoLocal;
import com.logical.backlog.model.Agence;
import com.logical.backlog.model.Backlog;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yirou
 */
@Stateful
public class BacklogDao implements BacklogDaoLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Backlog backlog) {
        em.persist(backlog);
    }

    @Override
    public Backlog get(int id) {
        return em.find(Backlog.class, id);
    }

    @Override
    public List<Backlog> getAll(Agence agence) {
        return em.createQuery("SELECT b FROM Backlog b WHERE b.agence.id=:ids", Backlog.class)
                .setParameter("ids", agence.getId())
                .getResultList();
    }

    @Override
    public void update(Backlog backlog) {
        em.merge(backlog);
    }

    @Override
    public void detele(Backlog backlog) {
        em.remove(backlog);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Backlog get(Backlog backlog) {
        return em.createQuery("SELECT b FROM Backlog b WHERE b.name=:n", Backlog.class)
                .setParameter("n", backlog.getName()).getResultList().get(0);
    }
}
