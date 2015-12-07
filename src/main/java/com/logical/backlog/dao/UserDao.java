/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.dao;

import com.logical.backlog.iDao.UserDaoLocal;
import com.logical.backlog.model.User;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author yirou
 */
@Stateful
public class UserDao implements UserDaoLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void add(User user) {
        em.persist(user);
    }
    
    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }
    
    @Override
    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    
    @Override
    public void update(User user) {
        em.merge(user);
    }
    
    @Override
    public void detele(User user) {
        em.remove(user);
    }
    
    @Override
    public boolean login(User user) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.name=:n AND u.password=:p", User.class)
                .setParameter("n", user.getName())
                .setParameter("p", user.getPassword());
        return query.getResultList().size() == 1;
    }
    
    @Override
    public User get(User user) {
        return em.createQuery("SELECT u FROM User u WHERE u.name=:n", User.class)
                .setParameter("n", user.getName()).getResultList().get(0);
        
    }
    
}
