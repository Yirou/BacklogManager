/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.managerbean;

import com.logical.backlog.iDao.AgenceDaoLocal;
import com.logical.backlog.iDao.BacklogDaoLocal;
import com.logical.backlog.iDao.UserDaoLocal;
import com.logical.backlog.model.Agence;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author yirou
 */
@ManagedBean(name = "agencebean")
@RequestScoped
public class AgenceManagerBean {

    private Agence agence;
    @EJB
    private AgenceDaoLocal agenceDao;
    @EJB
    private BacklogDaoLocal backlogDao;
    @EJB
    private UserDaoLocal userDao;

    public AgenceManagerBean() {
        super();
        agence = new Agence();
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public String addAgence() {
        agenceDao.add(agence);
//        agence = agenceDao.get(agence);
//        Backlog backlog = new Backlog(agence.getName(), new Date());
//        backlog.setAgence(agence);
//        backlogDao.add(backlog);
//        List<Backlog> list = new ArrayList<>();
//        list.add(backlog);
//        agence.setBacklogs(list);
//        agenceDao.update(agence);
        return agencePage();

    }

    public String agencePage() {
        return "agence";
    }

    public String deleteAgence(Agence agence) {
        agenceDao.detele(agence);
        return agencePage();
    }

    public String access(Agence agence) {
        SessionBean.getSession().setAttribute("agence", agence);
        return "backlog";
    }

    public List<Agence> getAllAgence() {

        return agenceDao.getAll();
    }
}
