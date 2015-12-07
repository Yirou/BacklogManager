/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.dao;

import com.logical.backlog.iDao.EntryDaoLocal;
import com.logical.backlog.model.Backlog;
import com.logical.backlog.model.Entries;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yirou
 */
@Stateful
public class EntryDao implements EntryDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Entries entry) {
        System.out.println("etrie "+entry);
        em.persist(entry);
    }

    @Override
    public Entries get(int id) {
       return em.find(Entries.class, id);
    }

    @Override
    public List<Entries> getAll() {
        return em.createQuery("SELECT e FROM Entries e").getResultList();
    }

    @Override
    public void update(Entries entry) {
        em.merge(entry);
    }

    @Override
    public void detele(Entries entry) {
        em.remove(entry);
    }

    @Override
    public List<Entries> getAll(Backlog backlog) {
        return em.createQuery("SELECT e FROM Entries e WHERE e.backlog.id=:idb")
                .setParameter("idb", backlog.getId())
                .getResultList();
    }

}
