/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.managerbean;

import com.logical.backlog.iDao.AgenceDaoLocal;
import com.logical.backlog.iDao.BacklogDaoLocal;
import com.logical.backlog.iDao.EntryDaoLocal;
import com.logical.backlog.iDao.UserDaoLocal;
import com.logical.backlog.model.Agence;
import com.logical.backlog.model.Backlog;
import com.logical.backlog.model.Entries;
import com.logical.backlog.model.User;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author yirou
 */
@ManagedBean(name = "backlogbean")
@SessionScoped
public class BacklogManagerBean {

    @EJB
    BacklogDaoLocal backlogDao;
    @EJB
    AgenceDaoLocal agenceDao;
    @EJB
    EntryDaoLocal entryDao;
    @EJB
    UserDaoLocal userDao;
    private Backlog backlog;

    public BacklogManagerBean() {
        super();
        backlog = new Backlog();
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public String access(Backlog backlog) {
        SessionBean.getSession().setAttribute("backlog", backlog);
        return "entry";
    }

    public String delete(Backlog backlog) {
        backlogDao.detele(backlog);
        return "backlog";

    }

    public List<Backlog> getAllBacklogs() {
        Agence agence = (Agence) SessionBean.getSession().getAttribute("agence");
        return backlogDao.getAll(agence);
    }

    public void save() {
        Agence agence = (Agence) SessionBean.getSession().getAttribute("agence");
        agence = agenceDao.get(agence);
        User user = SessionBean.getUser();
        user = userDao.get(user);
        backlog.setCreationDate(new Date());
        backlogDao.add(backlog);
        backlog = backlogDao.get(backlog);

//        if (agence.getBacklogs() == null) {
//            System.out.println("agence " + agence.getBacklogs());
//            agence.setBacklogs(new ArrayList<Backlog>());
//
//        }
        agence.getBacklogs().add(backlog);
        agenceDao.update(agence);
        backlog.setAgence(agence);
        backlog.setUser(user);
        backlogDao.update(backlog);
    }

}
