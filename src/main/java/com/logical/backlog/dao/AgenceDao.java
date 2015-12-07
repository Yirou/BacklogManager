/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.dao;

import com.logical.backlog.iDao.AgenceDaoLocal;
import com.logical.backlog.model.Agence;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yirou
 */
@Stateful
public class AgenceDao implements AgenceDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Agence agence) {
        em.persist(agence);
    }

    @Override
    public Agence get(int id) {
        return em.find(Agence.class, id);
    }

    @Override
    public List<Agence> getAll() {
        return em.createQuery("SELECT a FROM Agence a").getResultList();
    }

    @Override
    public void update(Agence agence) {
        em.merge(agence);
    }

    @Override
    public void detele(Agence agence) {
        System.out.println("delete " + agence);
        update(agence);
        em.remove(agence);
    }

    @Override
    public Agence get(Agence agence) {
        return em.createQuery("SELECT a FROM Agence a WHERE a.name=:n", Agence.class)
                .setParameter("n", agence.getName()).getResultList().get(0);
    }

}
