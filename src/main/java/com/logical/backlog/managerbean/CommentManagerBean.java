/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.managerbean;

import com.logical.backlog.iDao.CommentDaoLocal;
import com.logical.backlog.model.Comment;
import com.logical.backlog.model.Entries;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yirou
 */
@ManagedBean(name = "commentbean")
@RequestScoped
public class CommentManagerBean {

    @EJB
    CommentDaoLocal commentDao;
    Comment comment;
    private HttpSession sessionBean = SessionBean.getSession();

    public CommentManagerBean() {
        comment = new Comment();
    }

    public String addComment() {
        comment.setCreationDate(new Date());
        System.out.println(SessionBean.getEntry());
        comment.setEntry(SessionBean.getEntry());
        comment.setUser(SessionBean.getUser());
        commentDao.add(comment);
        System.out.println("TOCTOC");
        return entry();
    }

    public void setSessionBean(HttpSession sessionBean) {
        this.sessionBean = sessionBean;
    }

    public HttpSession getSessionBean() {
        return sessionBean;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    private String entry() {
        return "entry";
    }

    public Comment getComment() {
        return comment;
    }

    public List<Comment> getAllComments() {
        Entries en = (Entries) SessionBean.getSession().getAttribute("entry");
//        System.out.println("entry "+en);
        if (en != null) {
            return commentDao.getAll(en);
        }
        return new ArrayList<>();
    }
}
