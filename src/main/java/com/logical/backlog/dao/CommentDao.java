/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.dao;

import com.logical.backlog.iDao.CommentDaoLocal;
import com.logical.backlog.model.Comment;
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
public class CommentDao implements CommentDaoLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void add(Comment comment) {
        em.persist(comment);
    }
    
    @Override
    public Comment get(int id) {
        return em.find(Comment.class, id);
    }
    
    @Override
    public List<Comment> getAll() {
        return em.createQuery("SELECT c FROM Comment c").getResultList();
    }
    
    @Override
    public void update(Comment comment) {
        em.merge(comment);
    }
    
    @Override
    public void detele(Comment comment) {
        em.remove(comment);
    }

    @Override
    public List<Comment> getAll(Entries entry) {
        return em.createQuery("SELECT c FROM Comment c WHERE c.entry.id=:ide")
                .setParameter("ide", entry.getId())
                .getResultList();
    }
    
}
